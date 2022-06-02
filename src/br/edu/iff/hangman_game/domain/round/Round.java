package br.edu.iff.hangman_game.domain.round;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.iff.domain.ObjectDomainImplementation;
import br.edu.iff.hangman_game.domain.player.Player;
import br.edu.iff.hangman_game.domain.puppet.Puppet;
import br.edu.iff.hangman_game.domain.puppet.PuppetFactory;
import br.edu.iff.word_bank.domain.letter.Letter;
import br.edu.iff.word_bank.domain.letter.LetterFactory;
import br.edu.iff.word_bank.domain.theme.Theme;
import br.edu.iff.word_bank.domain.word.Word;

public class Round extends ObjectDomainImplementation {

  private static int maximumWord = 3;
  private static int maximumErrors = 10;
  private static int pointsWhenFiguringOutAllTheWords = 100;
  private static int pointsByCovertLetters = 15;

  private static PuppetFactory puppetFactory;
  private Player player;
  private Puppet puppet;

  private List<Item> items;

  private Set<Letter> rightLetters;
  private Set<Letter> wrongLetters;

  public static int getMaximumWord() {
    return maximumWord;
  }

  public static void setMaximumWord(int maximum) {
    maximumWord = maximum;
  }

  public static int getMaximumErrors() {
    return maximumErrors;
  }

  public static void setMaximumErrors(int maximum) {
    maximumErrors = maximum;
  }

  public static int getPointsWhenFiguringOutAllTheWords() {
    return pointsWhenFiguringOutAllTheWords;
  }

  public static void setPointsWhenFiguringOutAllTheWords(int maximum) {
    pointsWhenFiguringOutAllTheWords = maximum;
  }

  public static int getPointsByCovertLetters() {
    return pointsByCovertLetters;
  }

  public static void setPointsByCovertLetters(int maximum) {
    pointsByCovertLetters = maximum;
  }

  public static PuppetFactory getPuppetFactory() {
    return puppetFactory;
  }

  public static void setPuppetFactory(PuppetFactory puppet) {
    puppetFactory = puppet;
  }

  public static Round build(long id, List<Word> words, Player player) {
    return new Round(id, words, player);
  }

  public static Round rebuild(long id, List<Item> items, List<Letter> incorrectList, Player player) {
    return new Round(id, items, incorrectList, player);
  }

  private Round(long id, List<Word> words, Player player) {
    super(id);

    puppet = getPuppetFactory().getPuppet();

    this.player = player;
    this.rightLetters = new HashSet<Letter>();
    this.wrongLetters = new HashSet<Letter>();
    this.items = new ArrayList<Item>(words.size());

    for (int i = 0; i < words.size(); i++) {
      this.items.add(Item.build(i, words.get(i)));
    }

  }

  private Round(long id, List<Item> items, List<Letter> incorrectList, Player player) {
    super(id);

    puppet = getPuppetFactory().getPuppet();

    this.player = player;
    this.rightLetters = new HashSet<Letter>();
    this.wrongLetters = new HashSet<Letter>();
    this.items = new ArrayList<Item>(items.size());

    for (int i = 0; i < items.size(); i++) {
      this.items.add(items.get(i));

      for (Letter correct : this.items.get(i).getUncoveredLetters()) {
        this.rightLetters.add(correct);
      }
    }

    for (Letter incorrect : incorrectList) {
      this.wrongLetters.add(incorrect);
    }
  }

  public Player getPlayer() {
    Player player = this.player;
    return player;
  }

  public Theme getTheme() {
    Theme theme = this.items.get(0).getWord().getTheme();
    return theme;
  }

  public List<Word> getWords() {
    List<Word> words = new ArrayList<>();

    for (Item item : items) {
      words.add(item.getWord());
    }

    return words;
  }

  public int numberWords() {
    return items.size();
  }

  public void tryLetter(char code) {
    Map<Item, Boolean> rightItems = new HashMap<>();
    LetterFactory letterFactory = Word.getLetterFactory();

    for (Item item : items) {
      if (item.tryLetter(code)) {
        rightLetters.add(letterFactory.getLetter(code));
        rightItems.put(item, true);
      } else {
        rightItems.put(item, false);
      }
    }

    if (!rightItems.containsValue(true)) {
      wrongLetters.add(letterFactory.getLetter(code));
    }

    if (closed())
      this.player.setScore(calculateStore());
  }

  public void kick(List<String> words) {
    for (int i = 0; i < words.size(); i++) {
      items.get(i).takeRisk(words.get(i));
    }

    if (closed())
      this.player.setScore(calculateStore());
  }

  public void showItems(Object context) {
    for (Item item : items) {
      item.show(context);
      System.out.println();
    }
  }

  public void showPuppet(Object context) {
    puppet.show(context, getQuantityOfWrong());
  }

  public void showWords(Object context) {
    for (Word word : getWords()) {
      word.show(context);
      System.out.println();
    }
  }

  public void showWrongLetters(Object context) {
    for (Letter wrongLetter : getWrong()) {
      wrongLetter.show(context);
      System.out.println();
    }
  }

  public Set<Letter> getAttempts() {
    Set<Letter> attemptsLetters = new HashSet<>();

    attemptsLetters.addAll(rightLetters);
    attemptsLetters.addAll(wrongLetters);

    return attemptsLetters;
  }

  public Set<Letter> getRight() {
    return Collections.unmodifiableSet(rightLetters);
  }

  public Set<Letter> getWrong() {
    return Collections.unmodifiableSet(wrongLetters);
  }

  public int calculateStore() {
    if (!discovered())
      return 0;

    int score = getPointsWhenFiguringOutAllTheWords();

    for (Item item : items) {
      score += item.calculatePointsLettersFindings(getPointsByCovertLetters());
    }

    return score;
  }

  public boolean closed() {
    if (getQuantityOfRemainingAttempts() == 0 || discovered() || risked())
      return true;

    return false;
  }

  public boolean discovered() {
    for (Item item : items) {
      if (!item.discovered())
        return false;
    }
    return true;
  }

  public boolean risked() {
    for (Item item : items) {
      if (item.risked())
        return true;
    }
    return false;
  }

  public int getQuantityOfRemainingAttempts() {
    return getMaximumErrors() - wrongLetters.size();
  }

  public int getQuantityOfWrong() {
    return wrongLetters.size();
  }

  public int getQuantityOfRight() {
    return rightLetters.size();
  }

  public int getQuantityOfAttempts() {
    return getQuantityOfRight() + getQuantityOfWrong();
  }

}

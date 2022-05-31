package br.edu.iff.hangman_game.domain.round;

import java.util.List;
import java.util.Set;

import br.edu.iff.domain.ObjectDomainImplementation;
import br.edu.iff.hangman_game.domain.player.Player;
import br.edu.iff.hangman_game.domain.puppet.PuppetFactory;
import br.edu.iff.word_bank.domain.letter.Letter;
import br.edu.iff.word_bank.domain.theme.Theme;
import br.edu.iff.word_bank.domain.word.Word;

public class Round extends ObjectDomainImplementation {

  private static int maximumWord = 3;
  private static int maximumErrors = 10;
  private static int pointsWhenFiguringOutAllTheWords = 100;
  private static int pointsByCovertLetters = 15;

  private static PuppetFactory puppetFactory;
  private Player player;
  private Theme theme;

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

  public static Round rebuild(long id, List<Word> words, List<Letter> incorrect, Player player) {
    return new Round(id, words, incorrect, player);
  }

  private Round(long id, List<Word> words, Player player) {
    super(id);
  }

  private Round(long id, List<Word> words, List<Letter> incorrect, Player player) {
    super(id);
  }

  public Player getPlayer() {
    Player player = this.player;
    return player;
  }

  public Theme getTheme() {
    Theme theme = this.theme;
    return theme;
  }

  public List<Word> getWords() {
    return null;
  }

  public int numberWords() {
    return 0;
  }

  public void tryLetter() {
  }

  public void showItems(Object context) {

  }

  public void showPuppet(Object context) {

  }

  public void showWords(Object context) {

  }

  public void showWrongLetters(Object context) {

  }

  public Set<Letter> getAttempts() {
    return null;
  }

  public Set<Letter> getRight() {
    return null;
  }

  public Set<Letter> getWrong() {
    return null;
  }

  public int calculateStore() {
    return 1;
  }

  public boolean closed() {
    return false;
  }

  public boolean discovered() {
    return true;
  }

  public boolean risked() {
    return false;
  }

  public int getQuantityOfRemainingAttempts() {
    return 0;
  }

  public int getQuantityOfWrong() {
    return 0;
  }

  public int getQuantityOfRight() {
    return 0;
  }

  public int getQuantityOfAttempts() {
    return 0;
  }

}

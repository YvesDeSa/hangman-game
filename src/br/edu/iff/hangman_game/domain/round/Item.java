package br.edu.iff.hangman_game.domain.round;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.domain.ObjectDomainImplementation;
import br.edu.iff.word_bank.domain.letter.Letter;
import br.edu.iff.word_bank.domain.word.Word;

public class Item extends ObjectDomainImplementation {

  private List<Boolean> uncoveredPosition;
  private String riskWord = null;
  private Word word;

  static Item build(int id, Word word) {
    return new Item(id, word);
  }

  public static Item rebuild(int id, Word word, List<Boolean> uncoveredPosition, String riskWord) {
    return new Item(id, word, uncoveredPosition, riskWord);
  }

  private Item(int id, Word word) {
    super(Long.valueOf(id));

    this.word = word;
    this.uncoveredPosition = new ArrayList<Boolean>(word.getSize());

    for (int i = 0; i < word.getSize(); i++) {
      this.uncoveredPosition.add(i, false);
    }
  }

  private Item(int id, Word word, List<Boolean> uncoveredPosition, String riskWord) {
    super(Long.valueOf(id));

    this.word = word;
    this.riskWord = riskWord;
    this.uncoveredPosition = new ArrayList<Boolean>(word.getSize());

    for (int i = 0; i < word.getSize(); i++) {
      this.uncoveredPosition.add(i, true);
    }
  }

  public Word getWord() {
    Word word = this.word;
    return word;
  }

  public List<Letter> getCovertLetters() {
    List<Letter> covertLetters = new ArrayList<Letter>();

    for (int i = 0; i < uncoveredPosition.size(); i++) {
      if (uncoveredPosition.get(i)) {
        covertLetters.add(word.getLetter(i));
      }
    }

    return covertLetters;
  }

  public List<Letter> getUncoveredLetters() {
    List<Letter> uncoveredLetters = new ArrayList<Letter>();

    for (int i = 0; i < uncoveredPosition.size(); i++) {
      if (!uncoveredPosition.get(i)) {
        uncoveredLetters.add(word.getLetter(i));
      }
    }

    return uncoveredLetters;
  }

  public int getQuantityUncoveredLetters() {
    return getUncoveredLetters().size();
  }

  public int calculatePointsLettersFindings(int valueByLetterDiscovery) {
    return getQuantityUncoveredLetters() * valueByLetterDiscovery;
  }

  public boolean discovered() {
    return getQuantityUncoveredLetters() == 0 || gotItRight();
  }

  public void show(Object context) {
    word.show(context, uncoveredPosition);
  }

  boolean tryLetter(char code) {
    List<Integer> positions = word.tryLetter(code);

    if (positions.size() == 0)
      return false;

    for (Integer position : positions) {
      uncoveredPosition.set(position, true);
    }

    return true;
  }

  void takeRisk(String word) {
    this.riskWord = word;
  }

  public String getWordRisk() {
    return this.riskWord;
  }

  public boolean risked() {
    return riskWord != null;
  }

  public boolean gotItRight() {
    if (risked())
      return word.compare(riskWord);

    return false;
  }
}

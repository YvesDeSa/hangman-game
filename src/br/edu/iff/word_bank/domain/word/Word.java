package br.edu.iff.word_bank.domain.word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.iff.domain.ObjectDomainImplementation;
import br.edu.iff.word_bank.domain.letter.Letter;
import br.edu.iff.word_bank.domain.letter.LetterFactory;
import br.edu.iff.word_bank.domain.theme.Theme;

public class Word extends ObjectDomainImplementation {

  private static LetterFactory letterFactory;
  private List<Letter> words;
  private Theme theme;

  public void setLetterFactory(LetterFactory factory) {
    letterFactory = factory;
  }

  public LetterFactory getLetterFactory() {
    return letterFactory;
  }

  public Word build(long id, String word, Theme theme) {
    return new Word(id, word, theme);
  }

  public Word rebuild(long id, String word, Theme theme) {
    return new Word(id, word, theme);
  }

  private Word(long id, String word, Theme theme) {
    super(id);
    LetterFactory letterFactory = getLetterFactory();

    if (letterFactory == null) {
      throw new RuntimeException("Letter Factory not initialized");
    }

    this.theme = theme;
    this.words = new ArrayList<>();

    for (int i = 0; i < word.length(); i++) {
      this.words.add(letterFactory.getLetter(words.get(i).getCode()));
    }
  }

  public List<Letter> getLetters() {
    return Collections.unmodifiableList(this.words);
  }

  public Letter getLetter(int position) {
    return this.words.get(position);
  }

  public void show(Object context) {
    for (Letter letter : words) {
      letter.show(null);
    }
  }

  public void show(Object context, List<Boolean> positions) {
  }

  public List<Integer> tryLetter(char code) {
    List<Integer> positionFound = new ArrayList<>();

    for (int i = 0; i < words.size(); i++) {
      if (words.get(i).getCode() == code) {
        positionFound.add(i);
      }
    }
    return positionFound;
  }

  public Theme getTheme() {
    return this.theme;
  }

  public Boolean compare(String word) {
    for (int i = 0; i < this.words.size(); i++) {
      if (this.words.get(i).getCode() != word.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  public int getSize() {
    return this.words.size();
  }

  @Override
  public String toString() {
    return "Word: " + words + " - Theme: " + theme;
  }
}

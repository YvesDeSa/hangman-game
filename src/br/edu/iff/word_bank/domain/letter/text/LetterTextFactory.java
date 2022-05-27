package br.edu.iff.word_bank.domain.letter.text;

import br.edu.iff.word_bank.domain.letter.Letter;
import br.edu.iff.word_bank.domain.letter.LetterFactoryImplementation;

public class LetterTextFactory extends LetterFactoryImplementation {
  private static LetterTextFactory soleInstance = null;

  public static LetterTextFactory getSoleInstance() {
    if (soleInstance == null) {
      soleInstance = new LetterTextFactory();
    }

    return soleInstance;
  }

  private LetterTextFactory() {
  }

  @Override
  protected Letter createLetter(char code) {
    return new LetterText(code);
  }
}

package br.edu.iff.word_bank.domain.letter.image;

import br.edu.iff.word_bank.domain.letter.Letter;
import br.edu.iff.word_bank.domain.letter.LetterFactoryImplementation;

public class LetterImageFactory extends LetterFactoryImplementation {
  private static LetterImageFactory soleInstance = null;

  public static LetterImageFactory getSoleInstance() {
    if (soleInstance == null) {
      soleInstance = new LetterImageFactory();
    }

    return soleInstance;
  }

  private LetterImageFactory() {
  }

  @Override
  protected Letter createLetter(char code) {
    return new LetterImage(code);
  }
}

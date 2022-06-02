package br.edu.iff.word_bank.domain.letter.text;

import br.edu.iff.word_bank.domain.letter.Letter;

public class LetterText extends Letter {

  protected LetterText(char code) {
    super(code);
  }

  @Override
  public void show(Object context) {
    System.out.print(this.getCode());
  }

}

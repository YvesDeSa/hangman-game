package br.edu.iff.hangman_game.text;

import br.edu.iff.hangman_game.ElementGraphicFactory;
import br.edu.iff.hangman_game.domain.puppet.Puppet;
import br.edu.iff.hangman_game.domain.puppet.text.PuppetTextFactory;
import br.edu.iff.word_bank.domain.letter.Letter;
import br.edu.iff.word_bank.domain.letter.text.LetterTextFactory;

public class ElementGraphicTextFactory implements ElementGraphicFactory {

  private static ElementGraphicTextFactory soleInstance = null;

  private PuppetTextFactory puppetTextFactory;
  private LetterTextFactory letterTextFactory;

  public static ElementGraphicTextFactory getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new ElementGraphicTextFactory();

    return soleInstance;
  }

  private ElementGraphicTextFactory() {
    this.puppetTextFactory = PuppetTextFactory.getSoleInstance();
    this.letterTextFactory = LetterTextFactory.getSoleInstance();
  }

  @Override
  public Puppet getPuppet() {
    return puppetTextFactory.getPuppet();
  }

  @Override
  public Letter getLetter(char code) {
    return letterTextFactory.getLetter(code);
  }

  @Override
  public Letter getLetterFound() {
    return letterTextFactory.getLetterFound();
  }

}

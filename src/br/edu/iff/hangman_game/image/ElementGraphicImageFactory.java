package br.edu.iff.hangman_game.image;

import br.edu.iff.hangman_game.ElementGraphicFactory;
import br.edu.iff.hangman_game.domain.puppet.Puppet;
import br.edu.iff.hangman_game.domain.puppet.image.PuppetImageFactory;
import br.edu.iff.word_bank.domain.letter.Letter;
import br.edu.iff.word_bank.domain.letter.image.LetterImageFactory;

public class ElementGraphicImageFactory implements ElementGraphicFactory {
  private static ElementGraphicImageFactory soleInstance = null;

  private PuppetImageFactory puppetImageFactory;
  private LetterImageFactory letterImageFactory;

  public static ElementGraphicImageFactory getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new ElementGraphicImageFactory();

    return soleInstance;
  }

  private ElementGraphicImageFactory() {
    this.puppetImageFactory = PuppetImageFactory.getSoleInstance();
    this.letterImageFactory = LetterImageFactory.getSoleInstance();
  }

  @Override
  public Puppet getPuppet() {
    return puppetImageFactory.getPuppet();
  }

  @Override
  public Letter getLetter(char code) {
    return letterImageFactory.getLetter(code);
  }

  @Override
  public Letter getLetterFound() {
    return letterImageFactory.getLetterFound();
  }
}

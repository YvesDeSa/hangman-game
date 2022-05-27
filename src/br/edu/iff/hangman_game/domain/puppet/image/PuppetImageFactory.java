package br.edu.iff.hangman_game.domain.puppet.image;

import br.edu.iff.hangman_game.domain.puppet.Puppet;
import br.edu.iff.hangman_game.domain.puppet.PuppetFactory;

public class PuppetImageFactory implements PuppetFactory {
  private static PuppetImageFactory soleInstance = null;

  public static PuppetImageFactory getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new PuppetImageFactory();

    return soleInstance;

  }

  private PuppetImageFactory() {

  }

  @Override
  public Puppet getPuppet() {
    return PuppetImage.getSoleInstance();
  }
}

package br.edu.iff.hangman_game.domain.puppet.text;

import br.edu.iff.hangman_game.domain.puppet.Puppet;
import br.edu.iff.hangman_game.domain.puppet.PuppetFactory;

public class PuppetTextFactory implements PuppetFactory {

  private static PuppetTextFactory soleInstance = null;

  public static PuppetTextFactory getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new PuppetTextFactory();

    return soleInstance;

  }

  private PuppetTextFactory() {

  }

  @Override
  public Puppet getPuppet() {
    return PuppetText.getSoleInstance();
  }
}

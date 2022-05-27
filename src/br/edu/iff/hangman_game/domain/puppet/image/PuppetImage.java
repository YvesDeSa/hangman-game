package br.edu.iff.hangman_game.domain.puppet.image;

import br.edu.iff.hangman_game.domain.puppet.Puppet;

public class PuppetImage implements Puppet {
  private static PuppetImage soleInstance = null;

  public static PuppetImage getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new PuppetImage();

    return soleInstance;
  }

  private PuppetImage() {
  }

  @Override
  public void show(Object context, int components) {

  }
}

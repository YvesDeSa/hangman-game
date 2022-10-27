package br.edu.iff.hangman_game.domain.puppet.text;

import br.edu.iff.hangman_game.domain.puppet.Puppet;

public class PuppetText implements Puppet {

  private static PuppetText soleInstance = null;

  public static PuppetText getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new PuppetText();

    return soleInstance;
  }

  private PuppetText() {
  }

  @Override
  public void show(Object context, int components) {

    String[] body = {
        "cabeça",
        "olho esquerdo",
        "olho direito",
        "nariz",
        "boca",
        "tronco",
        "braço esquerdo",
        "braço direito",
        "perna esquerda",
        "perna direita"
    };

    for (int i = 0; i < components; i++) {
      System.out.println(body[i]);

      if (i != components - 1)
        System.out.println(" ");

    }
    System.out.println();
  }
}

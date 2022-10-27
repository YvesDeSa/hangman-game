package br.edu.iff.hangman_game;

public class PlayerNotFoundException extends Exception {

  private String player;

  public PlayerNotFoundException(String player) {
    super(player);
  }

  public String getPlayer() {
    return player;
  }
}

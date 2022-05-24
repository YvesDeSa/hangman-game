package br.edu.iff.hangman_game.domain.player;

public interface PlayerFactory {
  public Player getPlayer(String name);
}

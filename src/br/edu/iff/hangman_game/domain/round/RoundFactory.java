package br.edu.iff.hangman_game.domain.round;

import br.edu.iff.hangman_game.domain.player.Player;

public interface RoundFactory {
  public Round getRound(Player player);
}

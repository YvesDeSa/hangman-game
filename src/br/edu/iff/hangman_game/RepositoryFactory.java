package br.edu.iff.hangman_game;

import br.edu.iff.hangman_game.domain.player.PlayerRepository;
import br.edu.iff.hangman_game.domain.round.RoundRepository;
import br.edu.iff.word_bank.domain.theme.ThemeRepository;
import br.edu.iff.word_bank.domain.word.WordRepository;

public interface RepositoryFactory {
  public WordRepository getWordRepository();

  public ThemeRepository getThemeRepository();

  public RoundRepository getRoundRepository();

  public PlayerRepository getPlayerRepository();
}

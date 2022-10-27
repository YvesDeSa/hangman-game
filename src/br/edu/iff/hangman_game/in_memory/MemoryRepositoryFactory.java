package br.edu.iff.hangman_game.in_memory;

import br.edu.iff.hangman_game.RepositoryFactory;
import br.edu.iff.hangman_game.domain.player.PlayerRepository;
import br.edu.iff.hangman_game.domain.player.in_memory.MemoryPlayerRepository;
import br.edu.iff.hangman_game.domain.round.RoundRepository;
import br.edu.iff.hangman_game.domain.round.in_memory.MemoryRoundRepository;
import br.edu.iff.word_bank.domain.theme.ThemeRepository;
import br.edu.iff.word_bank.domain.theme.in_memory.MemoryThemeRepository;
import br.edu.iff.word_bank.domain.word.WordRepository;
import br.edu.iff.word_bank.domain.word.in_memory.MemoryWordRepository;

public class MemoryRepositoryFactory implements RepositoryFactory {
  private static MemoryRepositoryFactory soleInstance = null;

  public static MemoryRepositoryFactory getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new MemoryRepositoryFactory();

    return soleInstance;
  }

  private MemoryRepositoryFactory() {
  }

  @Override
  public WordRepository getWordRepository() {
    return MemoryWordRepository.getSoleInstance();
  }

  @Override
  public ThemeRepository getThemeRepository() {
    return MemoryThemeRepository.getSoleInstance();
  }

  @Override
  public RoundRepository getRoundRepository() {
    return MemoryRoundRepository.getSoleInstance();
  }

  @Override
  public PlayerRepository getPlayerRepository() {
    return MemoryPlayerRepository.getSoleInstance();
  }
}

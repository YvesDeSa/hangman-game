package br.edu.iff.hangman_game.in_relational_database;

import br.edu.iff.hangman_game.RepositoryFactory;
import br.edu.iff.hangman_game.domain.player.PlayerRepository;
import br.edu.iff.hangman_game.domain.player.in_relational_database.RelationalDatabasePlayerRepository;
import br.edu.iff.hangman_game.domain.round.RoundRepository;
import br.edu.iff.hangman_game.domain.round.in_relational_database.RelationalDatabaseRoundRepository;
import br.edu.iff.word_bank.domain.theme.ThemeRepository;
import br.edu.iff.word_bank.domain.theme.in_relational_database.RelationalDatabaseThemeRepository;
import br.edu.iff.word_bank.domain.word.WordRepository;
import br.edu.iff.word_bank.domain.word.in_relational_database.RelationalDatabaseWordRepository;

public class RelationalDatabaseRepositoryFactory implements RepositoryFactory {

  private static RelationalDatabaseRepositoryFactory soleInstance = null;

  public static RelationalDatabaseRepositoryFactory getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new RelationalDatabaseRepositoryFactory();

    return soleInstance;
  }

  private RelationalDatabaseRepositoryFactory() {
  }

  @Override
  public WordRepository getWordRepository() {
    return RelationalDatabaseWordRepository.getSoleInstance();
  }

  @Override
  public ThemeRepository getThemeRepository() {
    return RelationalDatabaseThemeRepository.getSoleInstance();
  }

  @Override
  public RoundRepository getRoundRepository() {
    return RelationalDatabaseRoundRepository.getSoleInstance();
  }

  @Override
  public PlayerRepository getPlayerRepository() {
    return RelationalDatabasePlayerRepository.getSoleInstance();
  }

}

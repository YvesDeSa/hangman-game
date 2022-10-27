package br.edu.iff.hangman_game.domain.round.in_relational_database;

import java.util.List;

import br.edu.iff.hangman_game.domain.player.Player;
import br.edu.iff.hangman_game.domain.round.Round;
import br.edu.iff.hangman_game.domain.round.RoundRepository;
import br.edu.iff.repository.RepositoryException;

public class RelationalDatabaseRoundRepository implements RoundRepository {

  private static RelationalDatabaseRoundRepository soleInstance = null;

  public static RelationalDatabaseRoundRepository getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new RelationalDatabaseRoundRepository();

    return soleInstance;
  }

  private RelationalDatabaseRoundRepository() {
  }

  @Override
  public long getNextId() {
    return 0;
  }

  @Override
  public Round getById(Long id) {
    return null;
  }

  @Override
  public List<Round> getByPlayer(Player player) {
    return null;
  }

  @Override
  public void insert(Round round) throws RepositoryException {

  }

  @Override
  public void update(Round round) throws RepositoryException {

  }

  @Override
  public void remove(Round round) throws RepositoryException {

  }

}

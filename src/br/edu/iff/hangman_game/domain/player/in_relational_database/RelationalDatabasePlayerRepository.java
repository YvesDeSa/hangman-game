package br.edu.iff.hangman_game.domain.player.in_relational_database;

import br.edu.iff.hangman_game.domain.player.Player;
import br.edu.iff.hangman_game.domain.player.PlayerRepository;
import br.edu.iff.repository.RepositoryException;

public class RelationalDatabasePlayerRepository implements PlayerRepository {

  private static RelationalDatabasePlayerRepository soleInstance = null;

  public static RelationalDatabasePlayerRepository getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new RelationalDatabasePlayerRepository();

    return soleInstance;
  }

  private RelationalDatabasePlayerRepository() {
  }

  @Override
  public long getNextId() {
    return 0;
  }

  @Override
  public Player getById(long id) {
    return null;
  }

  @Override
  public Player getByName(String name) {
    return null;
  }

  @Override
  public void insert(Player Player) throws RepositoryException {

  }

  @Override
  public void update(Player Player) throws RepositoryException {

  }

  @Override
  public void remove(Player Player) throws RepositoryException {

  }

}

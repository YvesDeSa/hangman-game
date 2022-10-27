package br.edu.iff.hangman_game.domain.player;

import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public interface PlayerRepository extends Repository {
  public Player getById(long id);

  public Player getByName(String name);

  public void insert(Player Player) throws RepositoryException;

  public void update(Player Player) throws RepositoryException;

  public void remove(Player Player) throws RepositoryException;
}

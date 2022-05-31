package br.edu.iff.hangman_game.domain.round;

import java.util.List;

import br.edu.iff.hangman_game.domain.player.Player;
import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public interface RoundRepository extends Repository {

  public Round getById(Long id);

  public List<Round> getByPlayer(Player player);

  public void insert(Round round) throws RepositoryException;

  public void update(Round round) throws RepositoryException;

  public void remove(Round round) throws RepositoryException;
}

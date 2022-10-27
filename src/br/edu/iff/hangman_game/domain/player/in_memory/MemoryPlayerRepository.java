package br.edu.iff.hangman_game.domain.player.in_memory;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.hangman_game.domain.player.Player;
import br.edu.iff.hangman_game.domain.player.PlayerRepository;
import br.edu.iff.repository.RepositoryException;

public class MemoryPlayerRepository implements PlayerRepository {

  private static MemoryPlayerRepository soleInstance = null;
  private List<Player> players;

  public static MemoryPlayerRepository getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new MemoryPlayerRepository();

    return soleInstance;
  }

  private MemoryPlayerRepository() {
    players = new ArrayList<Player>();
  }

  @Override
  public long getNextId() {
    return players.size() + 1;
  }

  @Override
  public Player getById(long id) {
    return (Player) players.stream().filter(player -> player.getId() == id);
  }

  @Override
  public Player getByName(String name) {
    return (Player) players.stream().filter(player -> player.getName().equalsIgnoreCase(name));
  }

  @Override
  public void insert(Player player) throws RepositoryException {
    if (players.contains(player))
      throw new RepositoryException("This player has already been inserted");

    players.add(player);
  }

  @Override
  public void update(Player player) throws RepositoryException {
    if (!players.contains(player))
      throw new RepositoryException("This player is not in the memo");

    players.remove(player);
    players.add(player);
  }

  @Override
  public void remove(Player player) throws RepositoryException {
    if (!players.contains(player))
      throw new RepositoryException("This player is not in the memo");

    players.remove(player);
  }

}

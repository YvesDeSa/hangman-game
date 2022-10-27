package br.edu.iff.hangman_game.domain.round.in_memory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.iff.hangman_game.domain.player.Player;
import br.edu.iff.hangman_game.domain.round.Round;
import br.edu.iff.hangman_game.domain.round.RoundRepository;
import br.edu.iff.repository.RepositoryException;

public class MemoryRoundRepository implements RoundRepository {

  private static MemoryRoundRepository soleInstance = null;
  private List<Round> rounds;

  public static MemoryRoundRepository getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new MemoryRoundRepository();

    return soleInstance;
  }

  private MemoryRoundRepository() {
    this.rounds = new ArrayList<Round>();
  }

  @Override
  public long getNextId() {
    return rounds.size() + 1;
  }

  @Override
  public Round getById(Long id) {
    return (Round) rounds.stream().filter(round -> round.getId() == id);
  }

  @Override
  public List<Round> getByPlayer(Player player) {
    return rounds.stream().filter(round -> round.getPlayer().equals(player)).collect(Collectors.toList());
  }

  @Override
  public void insert(Round round) throws RepositoryException {
    if (rounds.contains(round))
      throw new RepositoryException("This round has already been inserted");

    rounds.add(round);
  }

  @Override
  public void update(Round round) throws RepositoryException {
    if (!rounds.contains(round))
      throw new RepositoryException("This round is not in the memo");

    rounds.remove(round);
    rounds.add(round);
  }

  @Override
  public void remove(Round round) throws RepositoryException {
    if (!rounds.contains(round))
      throw new RepositoryException("This round is not in the memo");

    rounds.remove(round);
  }

}

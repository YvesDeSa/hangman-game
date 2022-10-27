package br.edu.iff.hangman_game.domain.round;

import br.edu.iff.hangman_game.PlayerNotFoundException;
import br.edu.iff.hangman_game.domain.player.Player;
import br.edu.iff.hangman_game.domain.player.PlayerRepository;
import br.edu.iff.repository.RepositoryException;

public class RoundAppService {

  private static RoundAppService soleInstance = null;

  private RoundRepository RoundRepository;
  private RoundFactory roundFactory;
  private PlayerRepository PlayerRepository;

  public static void createSoleInstance(
      RoundFactory roundFactory,
      RoundRepository roundRepository,
      PlayerRepository playerRepository) {

    soleInstance = new RoundAppService(roundFactory, roundRepository, playerRepository);

  }

  public static RoundAppService getSoleInstance() {
    if (soleInstance == null) {
      soleInstance = new RoundAppService(null, null, null);
    }
    return soleInstance;
  }

  private RoundAppService(RoundFactory roundFactory, RoundRepository roundRepository,
      PlayerRepository playerRepository) {
    this.RoundRepository = roundRepository;
    this.roundFactory = roundFactory;
    this.PlayerRepository = playerRepository;
  }

  public Round newRound(long id) throws PlayerNotFoundException {

    try {
      Player playerRepository = PlayerRepository.getById(id);
      return roundFactory.getRound(playerRepository);
    } catch (Exception e) {
      System.out.print(e.getMessage());
    }

    throw new PlayerNotFoundException("Could not find player");
  }

  public Round newRound(String namePlayer) throws PlayerNotFoundException {

    try {
      Player playerRepositor = PlayerRepository.getByName(namePlayer);
      return roundFactory.getRound(playerRepositor);
    } catch (Exception e) {
      System.out.print(e.getMessage());
    }

    throw new PlayerNotFoundException("Could not find player");
  }

  public Round newRound(Player player) {
    try {
      PlayerRepository.insert(player);
    } catch (Exception exception) {
      System.out.print(exception.getMessage());
    }

    return roundFactory.getRound(player);
  }

  public boolean salvarRound(Round Round) throws RepositoryException {
    try {
      RoundRepository.insert(Round);
      return true;
    } catch (RepositoryException exception) {
      System.out.print(exception.getMessage());
      return false;
    }
  }
}

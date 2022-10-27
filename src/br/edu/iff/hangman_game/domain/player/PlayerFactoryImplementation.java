package br.edu.iff.hangman_game.domain.player;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

public class PlayerFactoryImplementation extends EntityFactory implements PlayerFactory {
  private static PlayerFactoryImplementation soleInstance = null;

  public static void createSoleInstance(PlayerRepository repository) {
    soleInstance = new PlayerFactoryImplementation(repository);
  }

  public static PlayerFactoryImplementation getSoleInstance() {
    if (soleInstance == null)
      throw new RuntimeException("Player Factory not initialized");

    return soleInstance;
  }

  private PlayerFactoryImplementation(PlayerRepository repository) {
    super(repository);
  }

  private PlayerRepository getPlayerRepository() {
    return (PlayerRepository) getRepository();
  }

  public Player getPlayer(String name) {
    Player playerCreated = Player.build(getNextId(), name);

    try {
      getPlayerRepository().insert(playerCreated);
    } catch (RepositoryException exception) {
      throw new RuntimeException("Error saving Player");
    }

    return playerCreated;
  }
}

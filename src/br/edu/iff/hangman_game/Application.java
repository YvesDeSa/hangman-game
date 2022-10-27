package br.edu.iff.hangman_game;

import br.edu.iff.hangman_game.domain.player.PlayerFactory;
import br.edu.iff.hangman_game.domain.player.PlayerFactoryImplementation;
import br.edu.iff.hangman_game.domain.round.Round;
import br.edu.iff.hangman_game.domain.round.RoundFactory;
import br.edu.iff.hangman_game.domain.round.drawn.RoundDrawnFactory;
import br.edu.iff.hangman_game.image.ElementGraphicImageFactory;
import br.edu.iff.hangman_game.in_memory.MemoryRepositoryFactory;
import br.edu.iff.hangman_game.in_relational_database.RelationalDatabaseRepositoryFactory;
import br.edu.iff.hangman_game.text.ElementGraphicTextFactory;
import br.edu.iff.word_bank.domain.theme.ThemeFactory;
import br.edu.iff.word_bank.domain.theme.ThemeFactoryImplementation;
import br.edu.iff.word_bank.domain.word.Word;
import br.edu.iff.word_bank.domain.word.WordFactory;
import br.edu.iff.word_bank.domain.word.WordFactoryImplementation;

public class Application {
  private static final String[] FACTORY_REPOSITORY_TYPES = { "memoria", "relacional" };
  private static final String[] TYPES_GRAPHIC_ELEMENT_FACTORY = { "texto", "imagem" };
  private static final String[] ROUND_TYPE_FACTORY = { "sorteio" };
  private String typeRepositoryFactory = FACTORY_REPOSITORY_TYPES[0];
  private String typeElementGraphicFactory = TYPES_GRAPHIC_ELEMENT_FACTORY[0];
  private String typeRoundFactory = ROUND_TYPE_FACTORY[0];

  private RepositoryFactory repositoryFactory;
  private ElementGraphicFactory elementGraphicFactory;
  private RoundFactory roundFactory;

  private static Application soleInstance = null;

  public static Application getSoleInstance() {
    if (soleInstance == null) {
      soleInstance = new Application();
    }

    return soleInstance;
  }

  private Application() {
    setup();
  }

  public void setup() {
    if (typeRepositoryFactory.equalsIgnoreCase(FACTORY_REPOSITORY_TYPES[0])) {
      repositoryFactory = MemoryRepositoryFactory.getSoleInstance();
    } else if (typeRepositoryFactory.equalsIgnoreCase(FACTORY_REPOSITORY_TYPES[1])) {
      repositoryFactory = RelationalDatabaseRepositoryFactory.getSoleInstance();
    }

    // Retorna type de Elemento Gráfico
    if (typeElementGraphicFactory.equalsIgnoreCase(TYPES_GRAPHIC_ELEMENT_FACTORY[0])) {
      elementGraphicFactory = ElementGraphicTextFactory.getSoleInstance();
    } else if (typeElementGraphicFactory.equalsIgnoreCase(TYPES_GRAPHIC_ELEMENT_FACTORY[1])) {
      elementGraphicFactory = ElementGraphicImageFactory.getSoleInstance();
    }

    // Retorna type de Rodada Factory
    if (typeRoundFactory.equalsIgnoreCase(ROUND_TYPE_FACTORY[0])) {
      RoundDrawnFactory.createSoleInstance(
          repositoryFactory.getRoundRepository(),
          repositoryFactory.getThemeRepository(),
          repositoryFactory.getWordRepository());

      roundFactory = RoundDrawnFactory.getSoleInstance();
    }

    // Seta os factories e os elementos gráficos
    ThemeFactoryImplementation.createSoleInstance(repositoryFactory.getThemeRepository());
    WordFactoryImplementation.createSoleInstance(repositoryFactory.getWordRepository());
    PlayerFactoryImplementation.createSoleInstance(repositoryFactory.getPlayerRepository());
    Word.setLetterFactory(elementGraphicFactory);
    Round.setPuppetFactory(elementGraphicFactory);
  }

  public String[] getTypesRepositoryFactory() {
    return FACTORY_REPOSITORY_TYPES;
  }

  public void setTypeRepositoryFactory(String type) {
    typeRepositoryFactory = type;
    setup();
  }

  public RepositoryFactory getRepositoryFactory() {
    return repositoryFactory;
  }

  public String[] getTypesElementGraphicFactory() {
    return TYPES_GRAPHIC_ELEMENT_FACTORY;
  }

  public void setTypeElementGraphicFactory(String type) {
    typeElementGraphicFactory = type;
    setup();
  }

  public ElementGraphicFactory getElementGraphicFactory() {
    return elementGraphicFactory;
  }

  public String[] getTypesRoundFactory() {
    return ROUND_TYPE_FACTORY;
  }

  public void setTypeRoundFactory(String type) {
    typeRoundFactory = type;
    setup();
  }

  public RoundFactory getRoundFactory() {
    return roundFactory;
  }

  public ThemeFactory getThemeFactory() {
    return ThemeFactoryImplementation.getSoleInstance();
  }

  public WordFactory getWordFactory() {
    return WordFactoryImplementation.getSoleInstance();
  }

  public PlayerFactory getPlayerFactory() {
    return PlayerFactoryImplementation.getSoleInstance();
  }
}

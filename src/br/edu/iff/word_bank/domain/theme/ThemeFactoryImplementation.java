package br.edu.iff.word_bank.domain.theme;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

public class ThemeFactoryImplementation extends EntityFactory implements ThemeFactory {
  private static ThemeFactoryImplementation soleInstance = null;

  public static void createSoleInstance(ThemeRepository repository) {
    soleInstance = new ThemeFactoryImplementation(repository);
  }

  public static ThemeFactoryImplementation getSoleInstance() {
    if (soleInstance == null)
      throw new RuntimeException("Theme Factory not initialized");

    return soleInstance;
  }

  private ThemeFactoryImplementation(ThemeRepository repository) {
    super(repository);
  }

  private ThemeRepository getThemeRepository() {
    return (ThemeRepository) getRepository();
  }

  @Override
  public Theme getTheme(String name) {
    Theme theme = Theme.build(getNextId(), name);

    try {
      getThemeRepository().insert(theme);
    } catch (RepositoryException exception) {
      throw new RuntimeException("Error saving theme");
    }
    return theme;
  }
}

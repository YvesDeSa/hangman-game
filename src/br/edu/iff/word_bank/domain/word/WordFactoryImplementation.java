package br.edu.iff.word_bank.domain.word;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;
import br.edu.iff.word_bank.domain.theme.Theme;

public class WordFactoryImplementation extends EntityFactory implements WordFactory {

  private static WordFactoryImplementation soleInstance = null;

  public static void createSoleInstance(WordRepository repository) {
    soleInstance = new WordFactoryImplementation(repository);
  }

  public static WordFactoryImplementation getSoleInstance() {
    if (soleInstance == null)
      throw new RuntimeException("Word Factory not initialized");

    return soleInstance;
  }

  private WordFactoryImplementation(WordRepository repository) {
    super(repository);
  }

  private WordRepository getWordRepository() {
    return (WordRepository) getRepository();
  }

  @Override
  public Word getWord(String word, Theme theme) {
    Word wordCreate = Word.build(getNextId(), word, theme);

    try {
      getWordRepository().insert(wordCreate);
    } catch (RepositoryException exception) {
      throw new RuntimeException("Error saving Word");
    }
    return wordCreate;
  }

}

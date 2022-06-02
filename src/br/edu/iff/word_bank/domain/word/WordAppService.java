package br.edu.iff.word_bank.domain.word;

import br.edu.iff.hangman_game.Application;
import br.edu.iff.repository.RepositoryException;
import br.edu.iff.word_bank.domain.theme.Theme;
import br.edu.iff.word_bank.domain.theme.ThemeFactory;

public class WordAppService {
  private static WordAppService soleInstance;

  private WordRepository repository;
  private WordFactory factory;

  private WordAppService(WordRepository wordRepository, WordFactory WordFactory) {
    this.repository = wordRepository;
    this.factory = WordFactory;
  }

  public static void createSoleInstance(WordRepository wordRepository, WordFactory wordFactory) {
    soleInstance = new WordAppService(wordRepository, wordFactory);
  }

  public static WordAppService getSoleInstance() {
    if (soleInstance == null) {
      soleInstance = new WordAppService(null, null);
    }

    return soleInstance;
  }

  public boolean newWord(String word) throws RepositoryException {
    Word wordRepository = repository.getWord(word);
    Application app = Application.getSoleInstance();

    if (wordRepository == null) {
      ThemeFactory themeFactory = app.getThemeFactory();
      Theme theme = themeFactory.getTheme("");
      Word newWord = factory.getWord(word, theme);
      try {
        repository.insert(newWord);
        return true;
      } catch (RepositoryException re) {
        System.out.print(re.getMessage());
        return false;
      }
    }
    return true;
  }
}

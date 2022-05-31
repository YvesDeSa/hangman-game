package br.edu.iff.hangman_game.domain.round;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.word_bank.domain.theme.ThemeRepository;
import br.edu.iff.word_bank.domain.word.WordRepository;

public abstract class RoundFactoryImplementation extends EntityFactory implements RoundFactory {

  private ThemeRepository themeRepository;
  private WordRepository wordRepository;

  protected RoundFactoryImplementation(RoundRepository repository, ThemeRepository themeRepository,
      WordRepository wordRepository) {
    super(repository);
    this.themeRepository = themeRepository;
    this.wordRepository = wordRepository;
  }

  protected RoundRepository getRoundRepository() {
    return (RoundRepository) getRepository();
  }

  protected ThemeRepository getThemeRepository() {
    ThemeRepository themeRepository = this.themeRepository;
    return themeRepository;
  }

  protected WordRepository getWordRepository() {
    WordRepository wordRepository = this.wordRepository;
    return wordRepository;
  }

}

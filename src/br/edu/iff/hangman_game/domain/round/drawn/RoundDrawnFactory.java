package br.edu.iff.hangman_game.domain.round.drawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.iff.hangman_game.domain.player.Player;
import br.edu.iff.hangman_game.domain.round.Round;
import br.edu.iff.hangman_game.domain.round.RoundFactoryImplementation;
import br.edu.iff.hangman_game.domain.round.RoundRepository;
import br.edu.iff.repository.RepositoryException;
import br.edu.iff.word_bank.domain.theme.Theme;
import br.edu.iff.word_bank.domain.theme.ThemeRepository;
import br.edu.iff.word_bank.domain.word.Word;
import br.edu.iff.word_bank.domain.word.WordRepository;

public class RoundDrawnFactory extends RoundFactoryImplementation {
  private static RoundDrawnFactory soleInstance = null;

  public static void createSoleInstance(
      RoundRepository repository,
      ThemeRepository themeRepository,
      WordRepository WordRepository) {
    soleInstance = new RoundDrawnFactory(repository, themeRepository, WordRepository);
  }

  public static RoundDrawnFactory getSoleInstance() {
    if (soleInstance == null)
      throw new RuntimeException("A fábrica de sorteio da rodada não foi inicializada");

    return soleInstance;
  }

  private RoundDrawnFactory(RoundRepository repository, ThemeRepository themeRepository,
      WordRepository WordRepository) {
    super(repository, themeRepository, WordRepository);
  }

  @Override
  public Round getRound(Player player) {
    Random random = new Random();

    List<Theme> themesAll = getThemeRepository().getAll();
    Theme drawnTheme = themesAll.get(random.nextInt(themesAll.size()));

    List<Word> wordsOfTheme = getWordRepository().getByTheme(drawnTheme);
    List<Word> drawnWords = new ArrayList<Word>();

    int quantityWords = random.nextInt(Round.getMaximumWord() + 1);

    while (drawnWords.size() <= quantityWords) {
      Word drawnWord = wordsOfTheme.get(random.nextInt(wordsOfTheme.size()));

      if (!drawnWords.contains(drawnWord))
        drawnWords.add(drawnWord);
    }

    Round round = Round.build(getNextId(), drawnWords, player);

    try {
      getRoundRepository().insert(round);
    } catch (RepositoryException exception) {
      exception.printStackTrace();
    }

    return round;
  }

}

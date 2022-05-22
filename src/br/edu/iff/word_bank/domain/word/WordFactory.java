package br.edu.iff.word_bank.domain.word;

import br.edu.iff.word_bank.domain.theme.Theme;

public interface WordFactory {
  public Word getWord(String word, Theme theme);
}

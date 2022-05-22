package br.edu.iff.word_bank.domain.letter;

public interface LetterFactory {
  public Letter getLetter(char code);

  public Letter getLetterFound();
}

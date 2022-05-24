package br.edu.iff.word_bank.domain.letter;

public abstract class LetterFactoryImplementation implements LetterFactory {
  private Letter[] pool;
  private Letter encoberta;

  protected LetterFactoryImplementation() {
    this.pool = new Letter[26];
    this.encoberta = null;
  }

  public final Letter getLetter(char code) {
    int i = code - 'a';
    Letter result = this.pool[i];
    if (result == null) {
      result = this.createLetter(code);
      this.pool[i] = result;
    }
    return result;
  }

  protected abstract Letter createLetter(char code);

  public final Letter getLetterFound() {
    if (encoberta == null) {
      char code = '#';
      this.encoberta = createLetter(code);
    }
    return this.encoberta;
  }
}

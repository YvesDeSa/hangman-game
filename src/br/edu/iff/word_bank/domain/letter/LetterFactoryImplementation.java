package br.edu.iff.word_bank.domain.letter;

public abstract class LetterFactoryImplementation implements LetterFactory {
  private Letter[] pool;
  private Letter hidden;

  protected LetterFactoryImplementation() {
    this.pool = new Letter[26];
    this.hidden = null;
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
    if (hidden == null) {
      char code = '#';
      this.hidden = createLetter(code);
    }
    return this.hidden;
  }
}

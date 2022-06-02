package br.edu.iff.word_bank.domain.letter;

public abstract class Letter {

  private char code;

  protected Letter(char code) {
    this.code = code;
  }

  public char getCode() {
    return code;
  }

  public abstract void show(Object context);

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Letter)) {
      return false;
    }

    Letter outra = (Letter) o;

    return this.code == outra.code && this.getClass().equals(outra.getClass());
  }

  @Override
  public int hashCode() {
    return this.code + this.getClass().hashCode();
  }

  @Override
  public final String toString() {
    return "Letter: " + code;
  }
}

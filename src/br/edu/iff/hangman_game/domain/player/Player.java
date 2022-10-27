package br.edu.iff.hangman_game.domain.player;

import br.edu.iff.domain.ObjectDomainImplementation;

public class Player extends ObjectDomainImplementation {
  private String name;
  private int score;

  public static Player build(long id, String name) {
    return new Player(id, name);
  }

  public static Player rebuild(long id, String name, int score) {
    return new Player(id, name, score);
  }

  private Player(long id, String name) {
    super(id);
    this.name = name;
  }

  private Player(long id, String name, int score) {
    super(id);
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return this.score;
  }

  public void setScore(int score) {
    this.score = score;
  }

}

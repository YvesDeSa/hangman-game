package br.edu.iff.word_bank.domain.theme;

import br.edu.iff.domain.ObjectDomainImplementation;

public class Theme extends ObjectDomainImplementation {

  private String name;

  public static Theme build(long id, String name) {
    return new Theme(id, name);
  }

  public static Theme rebuild(long id, String name) {
    return new Theme(id, name);
  }

  private Theme(long id, String name) {
    super(id);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}

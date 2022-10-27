package br.edu.iff.domain;

public abstract class ObjectDomainImplementation implements ObjectDomain {

  private long id;

  public ObjectDomainImplementation(long id) {
    this.id = id;
  }

  @Override
  public long getId() {
    return this.id;
  }

}

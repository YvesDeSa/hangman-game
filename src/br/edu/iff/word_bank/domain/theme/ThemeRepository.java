package br.edu.iff.word_bank.domain.theme;

import java.util.List;

import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public interface ThemeRepository extends Repository {
  public Theme getById(long id);

  public List<Theme> getByName(String name);

  public List<Theme> getAll();

  public void insert(Theme theme) throws RepositoryException;

  public void update(Theme theme) throws RepositoryException;

  public void remove(Theme theme) throws RepositoryException;
}

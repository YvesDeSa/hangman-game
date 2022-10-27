package br.edu.iff.word_bank.domain.theme.in_relational_database;

import java.util.List;

import br.edu.iff.repository.RepositoryException;
import br.edu.iff.word_bank.domain.theme.Theme;
import br.edu.iff.word_bank.domain.theme.ThemeRepository;

public class RelationalDatabaseThemeRepository implements ThemeRepository {

  private static RelationalDatabaseThemeRepository soleInstance = null;

  public static RelationalDatabaseThemeRepository getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new RelationalDatabaseThemeRepository();

    return soleInstance;
  }

  private RelationalDatabaseThemeRepository() {
  }

  @Override
  public long getNextId() {
    return 0;
  }

  @Override
  public Theme getById(long id) {
    return null;
  }

  @Override
  public List<Theme> getByName(String name) {
    return null;
  }

  @Override
  public List<Theme> getAll() {
    return null;
  }

  @Override
  public void insert(Theme theme) throws RepositoryException {

  }

  @Override
  public void update(Theme theme) throws RepositoryException {

  }

  @Override
  public void remove(Theme theme) throws RepositoryException {

  }
}

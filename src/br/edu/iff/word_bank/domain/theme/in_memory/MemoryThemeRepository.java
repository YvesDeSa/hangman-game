package br.edu.iff.word_bank.domain.theme.in_memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.iff.repository.RepositoryException;
import br.edu.iff.word_bank.domain.theme.Theme;
import br.edu.iff.word_bank.domain.theme.ThemeRepository;

public class MemoryThemeRepository implements ThemeRepository {

  private static MemoryThemeRepository soleInstance = null;
  private List<Theme> themes;

  public static MemoryThemeRepository getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new MemoryThemeRepository();

    return soleInstance;
  }

  private MemoryThemeRepository() {
    themes = new ArrayList<Theme>();
  }

  @Override
  public long getNextId() {
    return themes.size() + 1;
  }

  @Override
  public Theme getById(long id) {
    return (Theme) themes.stream().filter(theme -> theme.getId() == id);
  }

  @Override
  public List<Theme> getByName(String name) {

    List<Theme> themesByName = themes.stream()
        .filter(theme -> theme.getName().equals(name))
        .collect(Collectors.toList());

    return themesByName;
  }

  @Override
  public List<Theme> getAll() {
    return Collections.unmodifiableList(themes);
  }

  @Override
  public void insert(Theme theme) throws RepositoryException {
    if (themes.contains(theme))
      throw new RepositoryException("This theme has already been inserted");

    themes.add(theme);
  }

  @Override
  public void update(Theme theme) throws RepositoryException {
    if (!themes.contains(theme))
      throw new RepositoryException("That theme is not in the memo");

    themes.remove(theme);
    themes.add(theme);
  }

  @Override
  public void remove(Theme theme) throws RepositoryException {
    if (!themes.contains(theme))
      throw new RepositoryException("That theme is not in the memo");

    themes.remove(theme);
  }

}

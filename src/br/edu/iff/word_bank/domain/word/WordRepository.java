package br.edu.iff.word_bank.domain.word;

import java.util.List;

import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;
import br.edu.iff.word_bank.domain.theme.Theme;

public interface WordRepository extends Repository {
  public Word getById(long id);

  public List<Word> getByTheme(Theme theme);

  public List<Word> getAll();

  public Word getWord(String word);

  public void insert(Word word) throws RepositoryException;

  public void update(Word word) throws RepositoryException;

  public void remove(Word word) throws RepositoryException;
}
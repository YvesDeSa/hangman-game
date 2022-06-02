package br.edu.iff.word_bank.domain.word.in_relational_database;

import java.util.List;

import br.edu.iff.repository.RepositoryException;
import br.edu.iff.word_bank.domain.theme.Theme;
import br.edu.iff.word_bank.domain.word.Word;
import br.edu.iff.word_bank.domain.word.WordRepository;

public class RelationalDatabaseWordRepository implements WordRepository {

  private static RelationalDatabaseWordRepository soleInstance = null;

  public static RelationalDatabaseWordRepository getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new RelationalDatabaseWordRepository();

    return soleInstance;
  }

  private RelationalDatabaseWordRepository() {
  }

  @Override
  public long getNextId() {
    return 0;
  }

  @Override
  public Word getById(long id) {
    return null;
  }

  @Override
  public List<Word> getByTheme(Theme theme) {
    return null;
  }

  @Override
  public List<Word> getAll() {
    return null;
  }

  @Override
  public Word getWord(String word) {
    return null;
  }

  @Override
  public void insert(Word word) throws RepositoryException {

  }

  @Override
  public void update(Word word) throws RepositoryException {

  }

  @Override
  public void remove(Word word) throws RepositoryException {

  }
}

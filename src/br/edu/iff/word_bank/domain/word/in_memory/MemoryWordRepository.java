package br.edu.iff.word_bank.domain.word.in_memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.iff.repository.RepositoryException;
import br.edu.iff.word_bank.domain.theme.Theme;
import br.edu.iff.word_bank.domain.word.Word;
import br.edu.iff.word_bank.domain.word.WordRepository;

public class MemoryWordRepository implements WordRepository {

  private static MemoryWordRepository soleInstance = null;
  private List<Word> words;

  public static MemoryWordRepository getSoleInstance() {
    if (soleInstance == null)
      soleInstance = new MemoryWordRepository();

    return soleInstance;
  }

  private MemoryWordRepository() {
    words = new ArrayList<Word>();
  }

  @Override
  public long getNextId() {
    return words.size() + 1;
  }

  @Override
  public Word getById(long id) {
    return (Word) words.stream().filter(word -> word.getId() == id);
  }

  @Override
  public List<Word> getByTheme(Theme theme) {
    List<Word> wordsByTheme = words.stream().filter(word -> word.getTheme() == theme).collect(Collectors.toList());

    return wordsByTheme;
  }

  @Override
  public List<Word> getAll() {
    return Collections.unmodifiableList(words);
  }

  @Override
  public Word getWord(String word) {
    return (Word) words.stream().filter(compareWord -> compareWord.compare(word));
  }

  @Override
  public void insert(Word word) throws RepositoryException {
    if (words.contains(word))
      throw new RepositoryException("This word has already been inserted");

    words.add(word);
  }

  @Override
  public void update(Word word) throws RepositoryException {
    if (!words.contains(word))
      throw new RepositoryException("That word is not in the memo");

    words.remove(word);
    words.add(word);
  }

  @Override
  public void remove(Word word) throws RepositoryException {
    if (!words.contains(word))
      throw new RepositoryException("That word is not in the memo");

    words.remove(word);
  }

}

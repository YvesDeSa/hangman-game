package hangman_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.iff.hangman_game.Application;
import br.edu.iff.hangman_game.domain.player.Player;
import br.edu.iff.hangman_game.domain.player.PlayerFactory;
import br.edu.iff.hangman_game.domain.round.Round;
import br.edu.iff.hangman_game.domain.round.RoundFactory;
import br.edu.iff.word_bank.domain.letter.Letter;
import br.edu.iff.word_bank.domain.theme.Theme;
import br.edu.iff.word_bank.domain.theme.ThemeFactory;
import br.edu.iff.word_bank.domain.word.WordFactory;

public class HangmanGame {
  static Scanner scanner = new Scanner(System.in);

  static String[] professions = {
      "perito",
      "apicultor",
      "medico"
  };

  static String[] fruits = {
      "kiwi",
      "pistache",
      "uva",
      "morango"
  };

  public static void main(String[] args) {

    Application app = Application.getSoleInstance();

    PlayerFactory playerFactory = app.getPlayerFactory();
    RoundFactory roundFactory = app.getRoundFactory();
    ThemeFactory themeFactory = app.getThemeFactory();
    WordFactory wordFactory = app.getWordFactory();

    Theme profession = themeFactory.getTheme("profession");
    for (String professionName : professions) {
      wordFactory.getWord(professionName, profession);
    }

    Theme fruit = themeFactory.getTheme("fruit");
    for (String fruitName : fruits) {
      wordFactory.getWord(fruitName, fruit);
    }

    boolean choice = true;

    while (choice) {
      System.out.println("----------------------");
      System.out.println("|        GAME        |");
      System.out.println("----------------------");
      System.out.println("(1) Jogar ");
      System.out.println("(0) Sair ");
      String choose = scanner.next();
      if (choose.equalsIgnoreCase("1")) {
        System.out.println("Digite seu nome: ");
        String name = scanner.next();
        Player player = playerFactory.getPlayer(name);
        Round round = roundFactory.getRound(player);
        start(player, round);
      } else {
        choice = false;
        scanner.close();
      }
    }
  }

  private static void start(Player player, Round round) {

    while (!round.closed()) {
      System.out.println("Jogador: " + player.getName());
      System.out.println("Tema: " + round.getTheme().getName());

      System.out.print("Tentativas: ");
      for (Letter tentativa : round.getAttempts()) {
        tentativa.show(null);
        System.out.print(" ");
      }
      System.out.println();

      System.out.println("Palavras:");
      round.showItems(null);
      System.out.println();
      System.out.println("Erros: " + round.getQuantityOfWrong() + "/" + Round.getMaximumErrors());
      System.out.println("Corpo: ");
      round.showPuppet(null);
      System.out.println();

      System.out.println("Selecione a opção desejada: ");
      System.out.println("(1) Digitar uma letra");
      System.out.println("(2) Já sabe todas as palavras? Arriscar");

      String escolha = scanner.next();

      if (escolha.equalsIgnoreCase("1")) {
        System.out.print("Digite uma letra: ");
        char code = scanner.next().charAt(0);

        if (code >= 'A' && code <= 'Z') {
          code = (char) (code + 32);
        }

        round.tryLetter(code);

        System.out.println("");
      } else if (escolha.equalsIgnoreCase("2")) {
        List<String> palavras = new ArrayList<>();

        for (int i = 1; i <= round.getWords().size(); i++) {
          System.out.println("Qual a " + i + "ª palavra? ");
          String palavra = scanner.next();
          palavras.add(palavra);
        }

        round.kick(palavras);
      }

    }

    if (round.discovered()) {
      System.out.println("Parabéns, você descobriu todas as palavras!");
      round.showWords(null);
    } else {
      System.out.println("ERROU!! Você não descobriu as palavras.");
    }
    System.out.println("Sua pontuação nessa rodada foi: " + round.calculateStore());
  }
}

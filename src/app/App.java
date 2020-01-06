package app;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Scanner object for user inputs
    static Scanner in = new Scanner(System.in);

    // check if the word is completed
    static String completed = "";

    // user input
    static String userGuess = "";

    // numbers of starting guesses
    static int guesses = 8;
    static boolean win = false;
    // List of words for the game
    static List<String> words = Arrays.asList("SALAD", "BREAD", "HOUSE", "BIIIIIIIIIIG", "BEER", "MONKEY", "PEPSI");

    // random number
    static int randomNumber = new Random().nextInt(words.size());

    // get a random word from List
    static String secretWord = words.get(randomNumber);

    // create the game
    static char[] game = new char[secretWord.length()];

    public static void main(String[] args) throws Exception {

        // print Game
        System.out.println("Welcome to Hangman!");

        // fill the word with dashes
        fillGame(game);

        // display the game
        displayGame(game);

        // Infinite loop for the game
        while (true) {
            isTheWordCompleted(game);

            // exit game if win or loose
            if (guesses == 0 || win == true) {
                break;

            }

            System.out.println("\nYou have " + guesses + " guesses left.");
            System.out.print("Your guess: ");
            // user plays
            userGuess = in.next().toUpperCase();
            isTheGuessCorrect(game);
            System.out.print("The word now looks like this: ");
            displayGame(game);
            System.out.println();

        } // end while loop

        // end game
        if (isTheWordCompleted(game)) {
            System.out.println("\nCongratulations you found the word!!");
        }

        else

        {
            System.out.println("\nSorry better luck next time");
        }

    }// end main

    // display the game
    public static void displayGame(char[] game) {

        for (int i = 0; i < game.length; i++) {
            System.out.print(game[i]);

        }

    }

    // fill game
    public static void fillGame(char[] game) {

        for (int i = 0; i < game.length; i++) {
            Arrays.fill(game, '-');

        }

    }

    // check if word is found<
    public static boolean isTheWordCompleted(char[] game) {
        String result = "";

        for (char c : game) {
            result += c;

        }

        if (result.equals(secretWord)) {
            win = true;
            return true;

        }

        return false;

    }

    // helper method for guessing
    public static void isTheGuessCorrect(char[] game) {
        // Decrements the guesses by 1
        guesses--;
        // convert the String into a Char
        char c = userGuess.charAt(0);

        // if user guess is wrong
        if (secretWord.indexOf(c) == -1) {
            System.out.println("The Letter " + c + " is not in the word.");

        }

        // Loop into each Char of the secret word and if the user enters the correct
        // Char replace it
        for (int i = 0; i < game.length; i++) {

            if (secretWord.charAt(i) == c) {
                game[i] = c;
                completed += c;

            }

        }

    }

}
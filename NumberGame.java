import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int totalAttempts = 0;
        int attemptsLimit = 5;
        int rounds = 0;
        int correctGuess = 0;
        boolean playAgain = true;

        while (playAgain) {
            int target = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            System.out.println("Round " + (rounds + 1));
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound + " : ");
            while (attempts < attemptsLimit) {
                int userGuess = sc.nextInt();
                attempts++;
                totalAttempts++;

                if (userGuess == target) {
                    System.out.println("Congratulations! You guessed the correct Number in " + attempts + " attempts.");
                    correctGuess++;
                    break;
                } else if (userGuess < target) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                if (attempts == attemptsLimit) {
                    System.out.println(
                            "Sorry, you've reached the maximum number of attempts. The correct number was:" + target);
                }
            }
            rounds++;
            System.out.println("Do you want to play again(yes/no)");
            String playAgainInput = sc.next().toLowerCase();

            if (!playAgainInput.equals("yes")) {
                playAgain = false;
                System.out.println("Game Over. Your total score: " + correctGuess + " correct Guesses in " + rounds
                        + " round/rounds in  " + totalAttempts + " attempts.");
            }
        }
        sc.close();
    }
}

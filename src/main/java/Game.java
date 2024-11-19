import entitiy.Actions;
import entitiy.Player;

import java.util.Scanner;

public class Game {
    private final Player playerA;
    private final Player playerB;

    public Game() {
        playerA = new Player("You");
        playerB = new Player("Bot");
    }

    public void playGame() {
        initGame();

        while (playerA.getScore() < 3 && playerB.getScore() < 3){
            drawHands();
            determineWinner();
            printScores();
        }

        endGame();
    }

    private void initGame() {
        playerA.setScore(0);
        playerB.setScore(0);

        System.out.println("Welcome to the Rock-Paper-Scissors game!\n");
    }

    private void endGame() {
        if(playerA.getScore() >= 3)
            System.out.println("Congratulation, you won the game !");
        else
            System.out.println("You lose. Try again.");

        System.out.println("Do you want to play again? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("Y"))
            playGame();
        else
            System.out.println("Goodbye!");
    }

    private void drawHands() {
        playerA.drawHand();
        playerB.drawRandomHand();
    }

    private void printScores(){
        playerA.printScore();
        playerB.printScore();
    }

    private void determineWinner() {
        Player winner = null;
        Actions playerAHand = playerA.getHand();
        Actions playerBHand = playerB.getHand();

        if (playerAHand == playerBHand)
            System.out.println("It's a tie!\n");
        else {
            switch (playerAHand) {
                case ROCK:
                    if (playerBHand == Actions.SCISSORS)
                        winner = playerA;
                    else
                        winner = playerB;
                    break;
                case PAPER:
                    if (playerBHand == Actions.ROCK)
                        winner = playerA;
                    else
                        winner = playerB;
                    break;
                case SCISSORS:
                    if (playerBHand == Actions.PAPER)
                        winner = playerA;
                    else
                        winner = playerB;
                    break;
            }

            if (winner != null) {
                System.out.println(winner.getName() + " won !\n");
                winner.setScore(winner.getScore() + 1);
            }
        }
    }
}

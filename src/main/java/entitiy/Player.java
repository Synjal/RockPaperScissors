package entitiy;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private final String name;
    private int score;
    private Actions hand;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = Actions.PAPER;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Actions getHand() {
        return hand;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setHand(Actions hand){
        this.hand = hand;
    }

    public void printScore() {
        System.out.println(getName() + " : " + getScore() + " points.");
    }

    public void printHand(Actions action) {
        setHand(action);
        System.out.println(getName() + " draw " + action);
    }

    public void drawRandomHand() {
        Random r = new Random();
        printHand(Actions.values()[(r.nextInt(Actions.values().length))]);
    }

    public void drawHand() {
        System.out.println("Pick an action : \n1. Paper\n2. Rock\n3. Scissors");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        for (int i = 0; i < 10; ++i) System.out.println();
        switch (choice) {
            case 1:
                printHand(Actions.PAPER);
                break;
            case 2:
                printHand(Actions.ROCK);
                break;
            case 3:
                printHand(Actions.SCISSORS);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}

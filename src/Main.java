import java.util.*;
import java.util.List;



public class Main {
    private static List<String> history = new ArrayList<>();
    private static int playerWon = 0;
    private static int playerLost = 0;
    private static int tie = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int roundCount = 0;
        String round = "No rounds played yet. ";
        System.out.println("Welcome to the Rock, Paper, Scissors game! ");

        System.out.println("Enter your choice (ROCK, PAPER, or SCISSORS) or " +
                "enter <Q> if you want to exit: ");

        while(true) {

            String userInput = sc.nextLine().toUpperCase();

            if(userInput.equals("Q")) {
                break;
            }

            try {

                Choice playerChoice = Choice.valueOf(userInput);
                Player computer = new Player(getRandomChoice());

                System.out.println("Player choice is: " + playerChoice);
                System.out.println("Computer choice is: " + computer.getChoice());

                int result = playerChoice.compare(computer.getChoice());

                if (result == 0) {
                    System.out.println("It's a Tie!");
                    tie++;
                }
                if (result == 1) {
                    System.out.println("You won!");
                    playerWon++;
                }else if(result == -1){
                    System.out.println("You lost! :( ");
                    playerLost++;
                }


                roundCount++;


                round = "Rounds: " + roundCount +" | " + " Player won: " + playerWon + " | "
                        + "Player lost: " + playerLost + " | " + "Tie: " + tie;



            }catch(IllegalArgumentException e) {
                System.out.println("Invalid Choice! Try again please: ");
            }

        }
        history.add(round);
        System.out.println("Thank you for playing! ");
        gameHistory();




    }

    public static Choice getRandomChoice() {
        Random randomChoice = new Random();
        int compChoice = randomChoice.nextInt(Choice.values().length);
        return Choice.values()[compChoice];

    }

    public static void gameHistory() {
        System.out.println(history);
    }


}
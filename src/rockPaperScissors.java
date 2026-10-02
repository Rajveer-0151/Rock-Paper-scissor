import java.util.Random;
import java.util.Scanner;

public class rockPaperScissors {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        String[] choice = {"Rock", "Paper", "Scissor"};
        String[] userChoice;
        int computerChoice = 0;
        int repeat = 0;
        boolean gamemodeOption = true;
        int gamemodeSelection = 0;
        int z = 0;

        System.out.println("Welcome to the rock paper scissor game");
        System.out.println("Choose game mode");
        System.out.println("Enter 1->Best of 1");
        System.out.println("Enter 2->Best of 3");
        System.out.println("Enter 3->Best of 5");

        while (gamemodeOption) {
            if (sc.hasNextInt()) {
                gamemodeSelection = sc.nextInt();
            } else {
                System.out.println("Please Enter a valid Number");
                sc.next();
            }
            if (gamemodeSelection == 1
                    || gamemodeSelection == 2
                    || gamemodeSelection == 3) {
                gamemodeOption = false;

                if (gamemodeSelection == 1) {
                    z = 1;
                } else if (gamemodeSelection == 2) {
                    z = 3;
                } else if (gamemodeSelection == 3) {
                    z = 5;
                }
            } else {
                System.out.println("invalid choice");
                System.out.println("Please select from 1, 2 ,3");
            }

            ;
        }
        System.out.println("Enter 1 ->rock");
        System.out.println("Enter 2-> paper");
        System.out.println("Enter 3-> scissor");
        System.out.println("Enter your move(1,2,3)");
        rps(z, choice, computerChoice);
    }


    public static void rps(int z,
                           String[] choice,
                           int computerChoice) {
        String inputOption;
        String computerOption;

        int input=0;
        int random;
        int userCount = 0;
        int computerCount = 0;
        while (userCount < z / 2 + 1 && computerCount < z / 2 + 1)  {
            boolean chossenOption = true;
            while (chossenOption) {
                if (sc.hasNextInt()) {
                    input = sc.nextInt();
                } else {
                    System.out.println("please enter a valid Number");
                    sc.next();
                }

                if (input > 0 && input < 4) {
                    random = rand.nextInt(3);
                    computerChoice = random + 1;
                    if (computerChoice == input) {
                        inputOption = choice[input - 1];
                        System.out.println("You choose " + inputOption);
                        computerOption = choice[random];
                        System.out.println("Computer chooses " + computerOption);
                        System.out.println("well that's a tie");
                        System.out.println("Enter your move(1,2,3)");

                    } else if (computerChoice == 1 && input == 2 ||
                            computerChoice == 2 && input == 3 ||
                            computerChoice == 3 && input == 1) {
                        inputOption = choice[input - 1];
                        System.out.println("You choose " + inputOption);
                        computerOption = choice[random];
                        System.out.println("Computer chooses " + computerOption);
                        System.out.println("You won the round");
                        userCount++;
                        chossenOption = false;
                        if (userCount >= z / 2 + 1) {
                            break;
                        }
                    } else if (computerChoice == 1 && input == 3 ||
                            computerChoice == 2 && input == 1 ||
                            computerChoice == 3 && input == 2) {
                        inputOption = choice[input - 1];
                        System.out.println("You choose " + inputOption);
                        computerOption = choice[random];
                        System.out.println("Computer chooses " + computerOption);
                        System.out.println("you lose the round");
                        chossenOption = false;
                        computerCount++;
                        if (computerCount >= z / 2 + 1) {
                            break;
                        }

                    }

                } else {
                    System.out.println("invalid Option selected");
                    System.out.println("Please select from (1 , 2 , 3)");


                }

            }
        }
        if (userCount > computerCount) {
            System.out.println("***********************");
            System.out.println("You have won the series");
            System.out.println("You - " + userCount + " Computer - " + computerCount);
        } else {
            System.out.println("***********************");
            System.out.println("You have lost the series");
            System.out.println("You - " + userCount + " Computer - " + computerCount);


        }
    }
}
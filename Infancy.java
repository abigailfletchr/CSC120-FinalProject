import java.util.Scanner;

public class Infancy {

    // attributes
    private static int pointsReceived;

    // methods
    public static void babbleChallenge(){

    }

    public static void signLangChallenge(){

    }

    public static int pickHeadUpChallenge(Baby baby){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("WELCOME TO LEARNING TO PICK YOUR HEAD UP");

        System.out.println("Guess a number between 1 and 10.\nThe closer you are to the right number\nthe more motor skill points you earn!");

        int rightNumber = (int)(Math.random()*(10 - 1 + 1) + 1);
        int guess = -1;
        pointsReceived = 0;
        Scanner input = new Scanner(System.in); // dont close

        while(true){
            try{
                guess = input.nextInt();
                if(guess > 0 && guess < 11){
                    break;
                }
            }catch(Exception e){
                System.out.println("Please enter a number between 1 and 10.");
            }
        }
        
        System.out.println("You guessed: " + guess);
        System.out.println("The right number was: " + rightNumber);

        if(guess == rightNumber){
            System.out.println("CONGRATS! " + baby.getName() + " guessed the right number!");
            System.out.println("You earned 5 motor points for picking up your head!");
            pointsReceived = 5;
        }else if(Math.abs(rightNumber-guess) < 3){
            System.out.println("Good try. " + baby.getName() + " was close!");
            System.out.println("You earned 1 motor point for attempting to pick up your head!");
            pointsReceived = 1;
        }else{
            System.out.println("Sorry! " + baby.getName() + "'s guess was too far off...");
            System.out.println("You earned 0 motor points for picking up your head!");
            pointsReceived = 0;
        }

        return pointsReceived;
    }

    public static void crawlChallenge(){

    }
    
    public static void bonusBabyChallenge(){

    }

}
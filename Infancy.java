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

        System.out.println("guess a number between 1 and 10.\nthe closer you are to the right number\nthe more motor skill points you earn!");

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
                System.out.println("please enter a number between 1 and 10.");
            }
        }
        
        System.out.println("you guessed: " + guess);
        System.out.println("the right number was: " + rightNumber);

        if(guess == rightNumber){
            System.out.println("CONGRATS! " + baby.getName() + " guessed the right number!");
            System.out.println("you earned 5 motor points for picking up your head!");
            pointsReceived = 5;
        }else if(Math.abs(rightNumber-guess) < 3){
            System.out.println("good try. " + baby.getName() + " was close!");
            System.out.println("you earned 1 motor point for attempting to pick up your head!");
            pointsReceived = 1;
        }else{
            System.out.println("sorry! " + baby.getName() + "'s guess was too far off...");
            System.out.println("you earned 0 motor points for picking up your head!");
            pointsReceived = 0;
        }

        return pointsReceived;
    }

    public static void crawlChallenge(){

    }
    
    public static void bonusBabyChallenge(){

    }

}
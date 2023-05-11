import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Infancy {

    // attributes
    private static int pointsReceived;

    // methods
    public static int babbleChallenge(Baby baby, Scanner input){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("WELCOME TO LEARNING TO BABBLE\n");

        System.out.println("you are going about your day and start to feel agitated.");
        System.out.println("one of your parents came to be with you! YAY!");
        System.out.println("you are still figuring life out and can not tell if it's your mom, moms, dad, dads, or parent helping you.\n");
        System.out.println("you know that you can babble the sounds 'mamama' 'dadada' or 'lalala' to identify who it is.");
        System.out.println("---------------------------------------------------------------------------------------------");
       
        System.out.println("IN ORDER TO SUCCESSFULLY BABBLE YOU MUST CORRECTLY IDENTIFY WHICH PARENT IS IN FRONT OF YOU.");
        System.out.println("if you think its your mom/moms guess, 'mamama'");
        System.out.println("if you think its your dad/dads guess, 'dadada'");
        System.out.println("if you think its your parent/parents guess, 'lalala'");
        System.out.println("you have 2 chances to guess.");
        System.out.println("if you guess correctly within 2 tries you win 3 Speaking Skills points.\n");
        System.out.println("GUESS... will you say 'mamama' 'dadada' or 'lalala'?");

        ArrayList<String> babbles = new ArrayList<String>();
        babbles.add("mamama"); // 1
        babbles.add("dadada"); // 2
        babbles.add("lalala"); // 3

        int randInt = (int)(Math.random()*(3 - 1 + 1) + 1);
        String babbleAnswer = babbles.get(randInt-1);
        int numGuesses = 0;
        String guess = "";

        while(numGuesses < 2 && !guess.equals(babbleAnswer)){
            System.out.println("-----------------------------------------------");
            System.out.println("your number of tries remaining: " + (2-numGuesses));
            System.out.print("are you babbling 'mamama' 'dadada' or 'lalala': ");
            guess = input.nextLine();

            for(String r : babbles){
                if(guess.equals(r)){
                    System.out.println("your guess was: " + r);
                }
            }

            if(guess.equals(babbleAnswer)){
                System.out.println("\nCORRECT!");
                System.out.println("good job, you earned 3 points toward Speech Skills\n");
                return 3; // return a value
            }else{
                System.out.println("sorry, wrong guess... try again.\n");
            }
            numGuesses++;

        }

        
        return 0;
    }

    public static int signLangChallenge(Baby baby, Scanner input){

        String enter = "";
        int guess = -1;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("WELCOME TO LEARNING TO SIGN (ASL)\n");

        System.out.println("you are finding that it is very hard to get your wants & needs through just babbles.");
        System.out.println("your parents never know if you want more food, thirsty for milk, or just need to poop.");
        System.out.println("as you and your parents become more frustrated, they try to teach you sign language.");
        System.out.println("you are a brand new infant and although your parents try to teach you, it can be very hard to remember the signs.");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();
        System.out.println("however, this evening you decide you want to try it out! (so exciting).");
        System.out.println(" but your parents have been working very hard and everytime you miss a sign, their trust diminishes.");
        System.out.println("this time you must get it right in order to trust & connect more with your parents...");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();
        System.out.println("------------------------------------------------------------------------------------------------------");

        System.out.println("IN ORDER TO TRUST & CONNECT WITH YOUR PARENT YOU MUST CHOOSE");
        System.out.println("THE CORRECT SIGN LANGUAGE DESCRIPTION BASED ON THE GIVEN NEED.");

        ArrayList<String> needs = new ArrayList<String>();
        needs.add("want more food"); // 1
        needs.add("want milk"); // 2
        needs.add("want to say thank you"); // 3
        needs.add("need to poop"); // 4

        int randInt = (int)(Math.random()*(4 - 1 + 1) + 1);
        String needAnswer = needs.get(randInt-1);
        System.out.println("YOUR NEED IS: " + needAnswer);

        System.out.println("PLEASE CHOOSE THE CORRECT SIGN DESCRIPTION BASED ON YOUR NEED.");

        ArrayList<String> signDescription = new ArrayList<String>();
        signDescription.add("tap fingertips together twice."); // 1
        signDescription.add("squeeze fists together (like milking a cow)."); // 2
        signDescription.add("touch lips with fingers, then move hand out (like blowing a kiss)."); // 3
        signDescription.add("both hands in fists and on top of each other, tuck the thumb of the bottom hand inside the upper fist. pull the bottom hand down from the upper hand, leaving the thumb extended."); // 4

        System.out.println("Your options are: \n");
        int i = 1;
        for(String sign: signDescription){
            System.out.println("[" + i + "] : " + sign);
            i++;
        }
    
        int numGuesses = 0;
        String signAnswer = signDescription.get(randInt-1);
        guess = 1;

        while(numGuesses < 2){
            System.out.println("--------------------------------------------------");
            System.out.println("your number of tries remaining: " + (2-numGuesses));
            System.out.print("which sign description do you choose : ");
            guess = input.nextInt();

            for(String s : signDescription){
                if(signDescription.get(guess-1).equals(s)){
                    System.out.println("your guess was: " + s);
                }
            }

            if(signDescription.get(guess-1).equals(signAnswer)){
                System.out.println("CORRECT!");
                System.out.println("good job, you earned 3 points toward Trust & Connection Skills!\n");
                return 3; // return a value
            }else{
                System.out.println("sorry, wrong guess... try again.\n");
            }
            numGuesses++;
        }

        System.out.println("Sorry, you earned no points here.");
        return 0;
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

    public static int crawlChallenge(Baby baby, String stuffedAnimal, Scanner input){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("WELCOME TO LEARNING TO CRAWL");

        System.out.println("you wake up from a nap and your " + stuffedAnimal + " stuffed animal is nowhere to be found.");
        System.out.println("you are feeling a bit more confident picking up your head and see a faint outline of your stuffed animal in the distance.");
        System.out.println("you try to cry and get your parent's attention but nothing is working.");
        System.out.println("you realize your only option is to get to your stuffed animal all by yourself...");
        System.out.println("---------------------------------------------------------------------------------");

        System.out.println("IN ORDER TO GET TO YOUR STUFFED ANIMAL YOU MUST CRAWL TO THE CORRECT ROOM.");
        System.out.println("you have 2 chances to guess.\n");
        System.out.println("GUESS...IS YOUR STUFFED ANIMAL IN THE: kitchen, living room, bedroom, bathroom, OR nursery?");

        ArrayList<String> rooms = new ArrayList<String>();
        rooms.add("kitchen"); // 1
        rooms.add("living room"); // 2
        rooms.add("bedroom"); // 3
        rooms.add("bathroom"); // 4
        rooms.add("nursery"); // 5

        int randInt = (int)(Math.random()*(5 - 1 + 1) + 1);
        String roomAnswer = rooms.get(randInt-1);
        int numGuesses = 0;
        String guess = "";

        while(numGuesses < 2 && !guess.equals(roomAnswer)){
            System.out.println("--------------------------------------------------");
            System.out.println("your number of tries remaining: " + (2-numGuesses));
            System.out.print("which room do you think the stuffed animal is in? : ");
            guess = input.nextLine();

            for(String r : rooms){
                if(guess.equals(r)){
                    System.out.println("your guess was: " + r);
                }
            }

            if(guess.equals(roomAnswer)){
                System.out.println("CORRECT!");
                System.out.println("good job, you earned 3 points toward Motor Skills!\n");
                return 3; // return a value
            }else{
                System.out.println("sorry, wrong guess... try again.\n");
            }
            numGuesses++;
        }

        return 0;

    }
    

}
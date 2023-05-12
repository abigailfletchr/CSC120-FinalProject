import java.util.ArrayList;
import java.util.Scanner;

public class Infancy {

    /**
     * @param pointsReceived the amount of points the player has received while completing the challenges
     */
    private static int pointsReceived;

    /**
     * A method that creates a challenge for the user to improve upon their speech skills.
     * The babble challenge has the user guess what parent is in front of them by inputing
     * different values. The user wins points based on if they guess correctly.
     * @param baby the baby created from the Baby class
     * @param input the input from the user
     * @return number of points won
     */
    public static int babbleChallenge(Baby baby, Scanner input){
        String enter = "";

        System.out.println("-------------------------------");
        System.out.println(" WELCOME TO LEARNING TO BABBLE 🗣️");
        System.out.println("-------------------------------\n");

        System.out.println("you are going about your day and start to feel agitated.");
        System.out.println("one of your parents comes to be with you! YAY!\n");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();
        System.out.println("you are still figuring life out and can not tell if it's your mom/s, dad/s, or parent/s helping you.");
        System.out.println("you know that you can babble the sounds 'mamama' 'dadada' or 'lalala' to identify who it is.\n");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();
        System.out.println("IN ORDER TO SUCCESSFULLY BABBLE YOU MUST CORRECTLY IDENTIFY WHICH PARENT IS IN FRONT OF YOU.\n");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();
        System.out.println("----------------------------------------------------------");
        System.out.println("if you think its your mom/moms guess, 'mamama'.\n");
        System.out.println("if you think its your dad/dads guess, 'dadada'.\n");
        System.out.println("if you think its your parent/parents guess, 'lalala'.");
        System.out.println("----------------------------------------------------------\n");

        ArrayList<String> babbles = new ArrayList<String>();
        babbles.add("mamama"); // 1
        babbles.add("dadada"); // 2
        babbles.add("lalala"); // 3

        int randInt = (int)(Math.random()*(3 - 1 + 1) + 1);
        String babbleAnswer = babbles.get(randInt-1);
        int numGuesses = 0;
        String guess = "";

        while(numGuesses < 2 && !guess.equals(babbleAnswer)){
            System.out.println("---------------------------");
            System.out.println("NUMBER OF TRIES REMAINING: " + (2-numGuesses));
            System.out.println("---------------------------\n");
            System.out.print("GUESS... WHAT WILL YOU BABBLE... ");
            guess = input.nextLine();

            for(String r : babbles){
                if(guess.equals(r)){
                    System.out.println("\nYOUR GUESS: " + r + "\n");
                }
            }

            if(guess.equals(babbleAnswer)){
                System.out.println("CORRECT!\n");
                System.out.println("\033[3mpress enter to continue\033[0m");
                enter = input.nextLine();
                System.out.println("YOU EARNED 3 SPEECH SKILLS POINTS\n");
                return 3; // return a value
            }else{
                System.out.println("WRONG GUESS...\n");
            }
            numGuesses++;

        }

        
        return 0;
    }

    /**
     * A method that creates a challenge for the user to improve upon their trust & connection skills.
     * The sign language challenge has the user guess what sign language description matches to the
     * need the computer randomly generates for them. The user wins points based on if they guess
     * correctly.
     * @param baby the baby created from the Baby class
     * @param input the input from the user
     * @return number of points won
     */
    public static int signLangChallenge(Baby baby, Scanner input){

        String enter = "";
        int guess = -1;

        System.out.println("----------------------------------");
        System.out.println("WELCOME TO LEARNING TO SIGN (ASL)🧏");
        System.out.println("----------------------------------\n");

        System.out.println("you are finding that it is very hard to get your wants & needs through just babbles.");
        System.out.println("your parents never know if you want more food, thirsty for milk, or just need to poop.\n");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();
        System.out.println("as you and your parents become more frustrated, they try to teach you sign language.");
        System.out.println("you are a brand new infant and although your parents try to teach you, it can be very hard to remember the signs.\n");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();
        System.out.println("this evening you decide you want to try it out! so exciting.");
        System.out.println("but remember your parents have been working very hard and everytime you miss a sign, their trust diminishes.");
        System.out.println("this time, you must get it right in order to trust & connect more with your parents...\n");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();

        System.out.println("IN ORDER TO TRUST & CONNECT WITH YOUR PARENT YOU MUST CHOOSE");
        System.out.println("THE CORRECT SIGN LANGUAGE DESCRIPTION BASED ON THE GIVEN NEED.\n");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();

        ArrayList<String> needs = new ArrayList<String>();
        needs.add("\033[3myou want more 🤗\033[0m"); // 1
        needs.add("\033[3myou want milk 🍼\033[0m"); // 2
        needs.add("\033[3myou want to say thank you 😙\033[0m"); // 3
        needs.add("\033[3myou need to poop 💩\033[0m"); // 4

        int randInt = (int)(Math.random()*(4 - 1 + 1) + 1);
        String needAnswer = needs.get(randInt-1);
        System.out.println("YOUR NEED IS: " + needAnswer + "\n");

        System.out.println("\nPLEASE CHOOSE THE CORRECT SIGN DESCRIPTION BASED ON YOUR NEED.\n");

        ArrayList<String> signDescription = new ArrayList<String>();
        signDescription.add("tap fingertips together twice."); // 1
        signDescription.add("squeeze fists together (like milking a cow)."); // 2
        signDescription.add("touch lips with fingers, then move hand out (like blowing a kiss)."); // 3
        signDescription.add("both hands in fists and on top of each other, tuck the thumb of the bottom hand inside the upper fist. pull the bottom hand down from the upper hand, leaving the thumb extended."); // 4

        System.out.println("DESCRIPTIONS: ");
        int i = 1;
        for(String sign: signDescription){
            System.out.println("[" + i + "] : " + sign);
            i++;
        }
    
        int numGuesses = 0;
        String signAnswer = signDescription.get(randInt-1);
        guess = 1;

        while(numGuesses < 2){
            System.out.println("---------------------------");
            System.out.println("NUMBER OF TRIES REMAINING: " + (2-numGuesses));
            System.out.println("---------------------------\n");
            System.out.print("WHAT SIGN DESCRIPTION MATCHES YOUR NEED... ");
            guess = input.nextInt();

            for(String s : signDescription){
                if(signDescription.get(guess-1).equals(s)){
                    System.out.println("\nYOUR GUESS: " + s + "\n");
                }
            }

            if(signDescription.get(guess-1).equals(signAnswer)){
                System.out.println("CORRECT!\n");
                System.out.println("\033[3mpress enter to continue\033[0m");
                enter = input.nextLine();
                System.out.println("YOU EARNED 3 POINTS TO TRUST & CONNECTION\n");
                return 3; // return a value
            }else{
                System.out.println("WRONG GUESS...\n");
            }
            numGuesses++;
        }

        System.out.println("NO POINTS EARNED");
        return 0;
    }

    /**
     * A method that creates a challenge for the user to improve upon their motor skills.
     * The picking head up challenge has the user guess a number. If the number is close to
     * or is the randomly generated number they 'have enough strength to pick their head up'.
     * The user wins points based on how close their guess is.
     * @param baby the baby created from the Baby class
     * @param input the input from the user
     * @return number of points won
     */
    public static int pickHeadUpChallenge(Baby baby, Scanner input){
        String enter = "";

        System.out.println("-----------------------------------------");
        System.out.println("WELCOME TO LEARNING TO PICK YOUR HEAD UP 🚼");
        System.out.println("-----------------------------------------\n");

        System.out.println("for the past few weeks all you have looked at is the ground... bbbbboooooorrrriiiinngggggg");
        System.out.println("the ground is great, but it's time to see the sights");
        System.out.println("and... lifting up your head is THE way\n");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();

        System.out.println("YOU MUST GUESS A NUMBER 1-10");
        System.out.println("IF YOUR GUESS IS CLOSE TO THE RANDOM NUMBER");
        System.out.println("THE MORE MOTOR SKILLS POINTS YOU EARN");
        System.out.println("GO...");
       
        int rightNumber = (int)(Math.random()*(10 - 1 + 1) + 1);
        int guess = -1;
        pointsReceived = 0;

        while(true){
            try{
                guess = input.nextInt();
                if(guess > 0 && guess < 11){
                    break;
                }
            }catch(Exception e){
                System.out.println("ONLY A NUMBER 1-10\n");
            }
        }
        
        System.out.println("\nYOUR GUESS: " + guess);
        System.out.println("\nTHE CORRECT NUMBER: " + rightNumber + "\n");

        if(guess == rightNumber){
            System.out.println("CONGRATS! " + baby.getName().toUpperCase() + " YOU GUESSED CORRECTLY\n");
            System.out.println("YOU EARNED 5 MOTOR SKILLS POINTS\n");
            pointsReceived = 5;
        }else if(Math.abs(rightNumber-guess) < 3){
            System.out.println("CLOSE " + baby.getName().toUpperCase() + " BUT NOT CORRECT\n");
            System.out.println("YOU EARNED 2 MOTOR SKILLS POINTS\n");
            pointsReceived = 2;
        }else{
            System.out.println("SORRY " + baby.getName().toUpperCase() + " YOU'RE TOO FAR OFF\n");
            System.out.println("NO POINTS EARNED\n");
            pointsReceived = 0;
        }

        return pointsReceived;
    }

    /**
     * A method that creates a challenge for the user to improve upon their motor skills.
     * The crawling challange has the user guess what room their stuffed animal is in.
     * The computer randomly generates a room and if the user guesses the room correctly
     * they win points.
     * @param baby the baby created from the Baby class
     * @param stuffedAnimal the stuffed animal the user chooses in the Game class
     * @param input the input from the user
     * @return number of points won
     */
    public static int crawlChallenge(Baby baby, String stuffedAnimal, Scanner input){
        String enter = "";

        System.out.println("------------------------------");
        System.out.println("WELCOME TO LEARNING TO CRAWL 🚶");
        System.out.println("------------------------------\n");

        System.out.println("you wake up from a nap and your " + stuffedAnimal.toLowerCase() + " stuffed animal is nowhere to be found.");
        System.out.println("you are feeling a bit more confident picking up your head and see a faint outline of your stuffed animal in the distance.\n");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();
        System.out.println("you try to cry and get your parent's attention but nothing is working.");
        System.out.println("you realize your only option is to get to your stuffed animal all by yourself...\n");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();

        Displays.displayRoom();
        System.out.println("IN ORDER TO GET TO YOUR STUFFED ANIMAL YOU MUST CRAWL TO THE CORRECT ROOM.\n");
        System.out.println("\033[3mpress enter to continue\033[0m");
        enter = input.nextLine();

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
            System.out.println("--------------------------");
            System.out.println("NUMBER OF TRIES REMAINING: " + (2-numGuesses));
            System.out.println("--------------------------\n");
            System.out.print("WHICH ROOM DO YOU THINK (kitchen, living room, bedroom, bathroom, OR nursery)... ");
            guess = input.nextLine();

            for(String r : rooms){
                if(guess.equals(r)){
                    System.out.println("\nYOUR GUESS: " + r + "\n");
                }
            }

            if(guess.equals(roomAnswer)){
                System.out.println("CORRECT\n");
                System.out.println("\033[3mpress enter to continue\033[0m");
                enter = input.nextLine();
                System.out.println("YOU EARNED 3 MOTOR SKILLS POINTS\n");
                return 3; // return a value
            }else{
                System.out.println("WRONG GUESS...\n");
            }
            numGuesses++;
        }

        return 0;

    }
    

}
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    // attributes
    private static boolean kindergarten = false;
    private static int points;
    private static Baby baby;
    private static ArrayList<String> eyeList = new ArrayList<String>();
    private static ArrayList<String> hairList = new ArrayList<String>();
    private static ArrayList<String> stuffedAnimal = new ArrayList<String>();


    // methods
    public static Baby createBaby(Scanner input){
        Baby baby = null;
        while(baby == null) {
            // try{
                System.out.println("Pick your baby's attributes!\n");
                System.out.println("What color eyes do you want your baby to have?\n1-Brown, 2-Blue, 3-Black, 4-Green, 5-Hazel");
                int eyes = input.nextInt();
                System.out.println("What color hair do you want your baby to have?\n1-Brown, 2-Black, 3-Blonde, 4-Red");
                int hair = input.nextInt();
                System.out.println("What stuffed animal do you want your baby to have?\n1-Dog, 2-Cat, 3-Horse, 4-Dolphin, 5-Bunny");
                int stuffy = input.nextInt();
                input.nextLine();
                System.out.println("What do you want to name your baby?");
                String name = input.nextLine();
            // }catch(Exception e){
            //     System.out.println("There was an issue with one of your inputs. Please redo this.");
            // }

            // Randomly generated values
            // int Random = (int)(Math.random()* ( Max - Min + 1) + min );
            int babyWeight = (int)(Math.random()* (13 - 5 + 1) + 5);
            int motorSkills = (int)(Math.random()* (5 + 1)); // out of 10
            int trustConnect = (int)(Math.random()* (5 + 1));
            int speechSkills = (int)(Math.random()* (5 + 1));

            try{
                baby = new Baby(babyWeight, name, hairList.get(hair-1), eyeList.get(eyes-1), stuffedAnimal.get(stuffy-1), "Infant", motorSkills, trustConnect, speechSkills);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Sorry, please choose attributes that we have provided you with (select within our number range).");
            }catch(Exception e){
                System.out.println("We are making you a default baby because it's not working, sorry.");
                baby = new Baby(babyWeight, name, hairList.get(0), eyeList.get(0), stuffedAnimal.get(0), "Infant", motorSkills, trustConnect, speechSkills);
            }
        }

        return baby;

    }

    public static void printBabyInfo(Baby b){
        System.out.println("\tBaby " + b.getName() + " has " + b.getEyes() + " eyes and " + b.getHair() + " hair!");
        System.out.println("\t" + b.getName() + "'s favorite stuffed animal is their stuffed " + b.getStuffedAnimal());
        System.out.println("\tHere are your official baby stats:");
        printBabyStats(b);
    }

    public static void printBabyStats(Baby b){
        System.out.println("\t\tWeight: " + b.getWeight() + " oz.");
        System.out.println("\t\tMotor Skills: " + b.getMotorSkills());
        System.out.println("\t\tTrust & Connection Skills: " + b.getTrustConnectSkills());
        System.out.println("\t\tSpeech Skills: " + b.getSpeechSkills());
    }

    public static void loadArrayLists(){
        // eye color options
        eyeList.add("brown");
        eyeList.add("blue");
        eyeList.add("black");
        eyeList.add("green");
        eyeList.add("hazel");

        // hair color options
        hairList.add("brown");
        hairList.add("black");
        hairList.add("blonde");
        hairList.add("red");

        // stuffed animal options
        stuffedAnimal.add("dog");
        stuffedAnimal.add("cat");
        stuffedAnimal.add("bear");
        stuffedAnimal.add("otter");
        stuffedAnimal.add("bunny");
    }
    
    public static void game(Baby baby, Scanner input){
        String challengeChoice = "";
        points = baby.getMotorSkills() + baby.getSpeechSkills() + baby.getTrustConnectSkills();
        boolean confirm = false;

        while(!kindergarten){
            System.out.println("\tSelect a challenge area to work on!\n\tmotor skills, trust and connection, or speech skills?");
            System.out.println("\tmotor skills, motor, or m | trust, connection, t, or, c | speech or s");
            // while(challengeChoice.equals("")){}
                challengeChoice = input.nextLine();

            if(challengeChoice.toLowerCase().equals("motor") || challengeChoice.toLowerCase().equals("motor skills") || challengeChoice.toLowerCase().equals("m")){
                // save value from this and set baby motor skill to this. (add)
                System.out.println("Do you want to try picking up your head or crawling?");
                confirm = false;
                while(!confirm){
                    challengeChoice = input.nextLine();
                    if(challengeChoice.toLowerCase().equals("picking up head") || challengeChoice.toLowerCase().equals("head")){
                        Infancy.pickHeadUpChallenge(baby);
                        confirm = true;
                    }else if(challengeChoice.toLowerCase().equals("crawling") || challengeChoice.toLowerCase().equals("crawl")){
                        Infancy.crawlChallenge();
                        confirm = true;
                    }else{
                        System.out.println("please choose again");
                    }
                }
            }else if(challengeChoice.toLowerCase().equals("trust") || challengeChoice.toLowerCase().equals("trust skills") || challengeChoice.toLowerCase().equals("t") || challengeChoice.toLowerCase().equals("connection")){

            }else if(challengeChoice.toLowerCase().equals("speech") || challengeChoice.toLowerCase().equals("speech skills") || challengeChoice.toLowerCase().equals("s") || challengeChoice.toLowerCase().equals("talk")){

            }else{
                System.out.println("We didn't recognize your choice. Please choose again.");
            }

            kindergarten = points >= 17;
        }
    }
    
    // where everything is run
    public static void main (String args[]) {

        loadArrayLists();

        Scanner input = new Scanner(System.in);
        Displays.display("\tWelcome to KinderGrow!\n\tThe aim of the game is to successfully help your baby (You) make it\n\tthrough infancy and the toddler stages to Kindergarten successfully!\n");

        Baby baby = createBaby(input);

        Displays.displayScene();
        System.out.println("\t 🎊 Congratulations! Your baby (you) has arrived! 🎊");
        printBabyInfo(baby);

        // actual game
        game(baby, input);

        System.out.println("\t🎊🎊🎊 Congratulations! You made it to Kindergarten!!!! 🎊🎊🎊🎊\n");

        input.close();
    }

    
}

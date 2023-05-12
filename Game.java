import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

    /**
     * @param kindergarten boolean value that specifies if the baby has reached kindergarten
     * @param points the amount of points the user/baby has/earns
     * @param baby a baby from the Baby class
     * @param eyeList an arraylist of the eye color choices
     * @param hairList an arraylist of the hair color choices
     * @param stuffedAnimal an arraylist of stuffed animal choices
     */
    private static boolean kindergarten = false;
    private static int points;
    private static Baby baby;
    private static ArrayList<String> eyeList = new ArrayList<String>();
    private static ArrayList<String> hairList = new ArrayList<String>();
    private static ArrayList<String> stuffedAnimal = new ArrayList<String>();


    /**
     * A method that basically creates the baby based on
     * the user's inputs and randomly generated values for
     * the skills points and weights.
     * @param input the input for the user to put their choices
     */
    public static Baby createBaby(Scanner input){
        String enter = "";
        Baby baby = null;
        while(baby == null) {
                System.out.println("LETS BEGIN...");
                System.out.println("\033[3mpress enter to continue\033[0m");
                enter = input.nextLine();
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("PICK YOUR ATTRIBUTES!\n");
                System.out.println("WHAT COLOR EYES DO YOU HAVE?\n1-BROWN, 2-BLUE, 3-BLACK, 4-GREEN, 5-HAZEL\n");
                int eyes = input.nextInt();
                System.out.println("\nWHAT COLOR HAIR DO YOU HAVE?\n1-BROWN, 2-BLACK, 3-BLONDE, 4-RED\n");
                int hair = input.nextInt();
                System.out.println("\nWHAT STUFFED ANIMAL DO YOU HAVE?\n1-DOG, 2-CAT, 3-HORSE, 4-OTTER, 5-BUNNY\n");
                int stuffy = input.nextInt();
                input.nextLine();
                System.out.println("\nWHAT IS YOUR LOVELY NAME?\n");
                String name = input.nextLine();
            
            int babyWeight = (int)(Math.random()* (13 - 5 + 1) + 5);
            int motorSkills = (int)(Math.random()* (5 + 1));
            int trustConnect = (int)(Math.random()* (5 + 1));
            int speechSkills = (int)(Math.random()* (5 + 1));

            try{
                baby = new Baby(babyWeight, name, hairList.get(hair-1), eyeList.get(eyes-1), stuffedAnimal.get(stuffy-1), "Infant", motorSkills, trustConnect, speechSkills);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("PLEASE CHOOSE ATTRIBUTES WE HAVE PROVIDED WITHIN THE NUMBER RANGE");
            }catch(Exception e){
                System.out.println("MAKING DEFAULT BABY... SORRY");
                baby = new Baby(babyWeight, name, hairList.get(0), eyeList.get(0), stuffedAnimal.get(0), "Infant", motorSkills, trustConnect, speechSkills);
            }
        }

        return baby;

    }

    /**
     * A method that prints the statistics 
     * but written out into a story almost.
     * @param b the baby created from the baby constructor from the Baby class
     */
    public static void printBabyInfo(Baby b){
        System.out.println("BABY " + b.getName().toUpperCase() + " HAS " + b.getEyes() + " EYES & " + b.getHair() + " HAIR!");
        System.out.println(b.getName().toUpperCase() + "'S STUFFED ANIMAL IS A " + b.getStuffedAnimal());
        System.out.println("\nOFFICIAL STATS:");
        printBabyStats(b);
    }

    /**
     * A method that prints the statistics 
     * and characteristics of the baby.
     * @param b the baby created from the baby constructor from the Baby class
     */
    public static void printBabyStats(Baby b){
        System.out.println("\nWEIGHT: " + b.getWeight() + " oz.");
        System.out.println("MOTOR SKILLS: " + b.getMotorSkills());
        System.out.println("TRUST & CONNECTION SKILLS: " + b.getTrustConnectSkills());
        System.out.println("SPEECH SKILLS: " + b.getSpeechSkills() + "\n");
    }

    /**
     * A method that adds values to array lists which act as the 
     * options for eye color, hair color, and stuffed animal choices.
     */
    public static void loadArrayLists(){
        eyeList.add("BROWN");
        eyeList.add("BLUE");
        eyeList.add("BLACK");
        eyeList.add("GREEN");
        eyeList.add("HAZEL");

        hairList.add("BROWN");
        hairList.add("BLACK");
        hairList.add("BLONDE");
        hairList.add("RED");

        stuffedAnimal.add("DOG");
        stuffedAnimal.add("CAT");
        stuffedAnimal.add("BEAR");
        stuffedAnimal.add("OTTER");
        stuffedAnimal.add("BUNNY");
    }
    
    /**
     * A method where the game is actually run. The user chooses
     * what challenge they want to try and the method runs the 
     * challenges. It also checks to make sure the user has not
     * completed each challenge more than twice & confirms and
     * congratulates the user once they have gotten to kindergarten.
     * Lastly, the method gives a description of the baby's readiness
     * for kindergarten based on the skills points they acheived.
     * @param baby a baby from the Baby class
     * @param input the input for the user to put their choices
     */
    public static void game(Baby baby, Scanner input){
        String challengeChoice = "";
        points = baby.getMotorSkills() + baby.getSpeechSkills() + baby.getTrustConnectSkills();
        boolean confirm = false;
        boolean maxHd = false, maxCrawl = false, maxSign = false, maxBabble = false;
        boolean blockMotor = false, blockTrust = false, blockSpeech = false;
        boolean allDone = false;
        HashMap<String, Integer> tries = new HashMap<String, Integer>();
        tries.put("head challenge", 0);
        tries.put("crawl challenge", 0);
        tries.put("sign challenge", 0);
        tries.put("babble challenge", 0);

        while(!kindergarten && !allDone){
            System.out.println("SELECT A CATEGORY TO IMPROVE ON!\nMOTOR SKILLS, TRUST & CONNECTION, OR SPEECH?\n\n");
            System.out.println("PLEASE INDICATE: MOTOR SKILLS, MOTOR, OR M | TRUST, CONNECTION, T, OR C | SPEECH OR S\n");
            
                challengeChoice = input.nextLine();

            if((challengeChoice.toLowerCase().equals("motor") || challengeChoice.toLowerCase().equals("motor skills") || challengeChoice.toLowerCase().equals("m")) && !blockMotor){
                // save value from this and set baby motor skill to this. (add)
                System.out.println("DO YOU WANT TO TRY PICKING YOUR HEAD UP OR CRAWLING?");
                confirm = false;
                while(!confirm){
                    challengeChoice = input.nextLine();
                    if((challengeChoice.toLowerCase().equals("picking up my head") || challengeChoice.toLowerCase().equals("head")) && !maxHd){
                        baby.setMotorSkills(Infancy.pickHeadUpChallenge(baby, input));
                        confirm = true;
                        tries.put("head challenge", tries.get("head challenge") + 1);
                        maxHd = tries.get("head challenge") >= 2;
                        input.nextLine();
                    }else if((challengeChoice.toLowerCase().equals("crawling") || challengeChoice.toLowerCase().equals("crawl")) && !maxCrawl){
                        baby.setMotorSkills(Infancy.crawlChallenge(baby, baby.getStuffedAnimal(), input));
                        confirm = true;
                        tries.put("crawl challenge", tries.get("crawl challenge") + 1);
                        maxCrawl = tries.get("crawl challenge") >= 2;
                        input.nextLine();
                    }else{
                        if(maxHd && !maxCrawl){
                            System.out.println("YOU CAN NOT DO THE HEADLIFT CHALLENGE ANYMORE! YOU CAN ONLY PLAY TWICE\n");
                        }else if(maxCrawl && !maxHd){
                            System.out.println("YOU CAN NOT DO THE CRAWLING CHALLENGE ANYMORE! YOU CAN ONLY PLAY TWICE\n");
                        }else if(maxCrawl && maxHd){
                            System.out.println("OOPS, NO MORE MOTOR SKILLS CHALLENGES LEFT");
                            blockMotor = true;
                            confirm = true;
                        }else{
                            System.out.println("PLEASE CHOOSE SOMETHING ELSE");
                        }
                    }
                }
            }else if((challengeChoice.toLowerCase().equals("trust") || challengeChoice.toLowerCase().equals("trust skills") || challengeChoice.toLowerCase().equals("t") || challengeChoice.toLowerCase().equals("connection") || challengeChoice.toLowerCase().equals("c")) && !blockTrust){
                if(!maxSign){
                    baby.setTrustConnectSkills(Infancy.signLangChallenge(baby, input));
                    tries.put("sign challenge", tries.get("sign challenge") + 1);
                    maxSign = tries.get("sign challenge") >= 2;
                    input.nextLine();
                }else{
                    System.out.println("OOPS, YOU HAVE NO MORE TRUST AND CONNECT CHALLENGES");
                    blockTrust = true;
                }
            }else if((challengeChoice.toLowerCase().equals("speech") || challengeChoice.toLowerCase().equals("speech skills") || challengeChoice.toLowerCase().equals("s") || challengeChoice.toLowerCase().equals("talk")) && !blockSpeech){
                if(!maxBabble){
                    baby.setSpeechSkills(Infancy.babbleChallenge(baby, input));
                    tries.put("babble challenge", tries.get("babble challenge") + 1);
                    maxBabble = tries.get("babble challenge") >= 2;
                    input.nextLine();
                }else{
                    System.out.println("OOPS, YOU HAVE NO MORE SPEECH SKILLS CHALLENGES");
                    blockSpeech = true;
                }
            }else{
                if(blockMotor && blockSpeech && blockTrust){
                    System.out.println("YOU CAN NOT ATTEMPT ANYMORE CHALLENGES, ONLY 2 ATTEMPTS PER CHALLENGE");
                }else if(blockMotor || blockSpeech || blockTrust){
                    System.out.println("SORRY, YOU ARE OUT OF TRIES FOR THAT CATEGORY");
                }else{
                    System.out.println("WE DID NOT RECOGNIZE, PLEASE TRY AGAIN");
                }
            }
            points = baby.getMotorSkills() + baby.getSpeechSkills() + baby.getTrustConnectSkills();
            kindergarten = (points >= 17);
            allDone = (maxHd && maxCrawl && maxSign && maxBabble);
            printBabyStats(baby);
        }

        if(kindergarten){
            System.out.println("🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊");
            System.out.println("CONGRATULATIONS! ITS TIME FOR KINDERGARTEN...\n");
            System.out.println("NOW...CAN YOU MAKE IT THROUGH KINDERGARTEN TO 1ST GRADE...");
            System.out.println("🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊");
            Displays.displayCongrats();
            System.out.println("");

            if(baby.getMotorSkills() < 7){
                System.out.println("BABY " + baby.getName().toUpperCase() + " IS GOING TO HAVE A HARD TIME IN PE WITH SUCH LOW MOTOR SKILLS.");
            }
            if(baby.getTrustConnectSkills() < 7){
                System.out.println("BABY " + baby.getName().toUpperCase() + " IS GOING TO HAVE A HARD TIME MAKING FRIENDS AND"); 
                System.out.println("BUILDING POSITIVE TEACHER-STUDENT RELATIONSHIPS WITH SUCH LOW TRUST & CONNECT SKILLS.");
            }
            if(baby.getSpeechSkills() < 7){
                System.out.println("WELL, LOOKS LIKE BABY " + baby.getName().toUpperCase() + " IS GOING TO BE SEEING A SPEECH PATHOLOGIST!");
            }

            System.out.println("BUT STILL... CONGRATULATIONS FOR MAKING IT TO KINDERGARTEN\nTHE END.");
        }else{
            System.out.println("SORRY YOU DID NOT MAKE IT TO KINDERGARTEN THIS YEAR. MAYBE ONE MORE YEAR WILL DO THE TRICK...");
        }
    }
    
    public static void main (String args[]) {

        loadArrayLists();

        Scanner input = new Scanner(System.in);
        Displays.display("WELCOME TO KINDERGROW!\n\nCONGRATS! YOU ARE A BABY AGAIN\n\nYOUR GOAL IS TO GET THROUGH INFANCY AND IMPROVE \nON ALL SKILLS BEFORE ENTERING KINDERGARTEN\n");

        Baby baby = createBaby(input);

        Displays.displayScene();
        System.out.println("\n🎊 CONGRATULATIONS! YOU WERE BIRTHED! 🎊\n");
        printBabyInfo(baby);

        game(baby, input);

        input.close();
    }

    
}

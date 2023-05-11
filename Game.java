import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

    /**
     * 
     */
    private static boolean kindergarten = false;
    private static int points;
    private static Baby baby;
    private static ArrayList<String> eyeList = new ArrayList<String>();
    private static ArrayList<String> hairList = new ArrayList<String>();
    private static ArrayList<String> stuffedAnimal = new ArrayList<String>();


    /**
     * 
     */
    public static Baby createBaby(Scanner input){
        String enter = "";
        Baby baby = null;
        while(baby == null) {
                System.out.println("LETS BEGIN...");
                System.out.println("\033[3mpress enter to continue\033[0m");
                enter = input.nextLine();
                System.out.println("PICK YOUR ATTRIBUTES!\n");
                System.out.println("WHAT COLOR EYES DO YOU HAVE?\n1-brown, 2-blue, 3-black, 4-green, 5-hazel\n");
                int eyes = input.nextInt();
                System.out.println("\nWHAT COLOR HAIR DO YOU HAVE?\n1-brown, 2-black, 3-blonde, 4-red\n");
                int hair = input.nextInt();
                System.out.println("\nWHAT STUFFED ANIMAL DO YOU HAVE?\n1-dog, 2-cat, 3-horse, 4-dolphin, 5-bunny\n");
                int stuffy = input.nextInt();
                input.nextLine();
                System.out.println("\nWHAT IS YOUR LOVELY NAME?\n");
                String name = input.nextLine();
            
            int babyWeight = (int)(Math.random()* (13 - 5 + 1) + 5);
            int motorSkills = (int)(Math.random()* (5 + 1)); // out of 10
            int trustConnect = (int)(Math.random()* (5 + 1));
            int speechSkills = (int)(Math.random()* (5 + 1));

            try{
                baby = new Baby(babyWeight, name, hairList.get(hair-1), eyeList.get(eyes-1), stuffedAnimal.get(stuffy-1), "Infant", motorSkills, trustConnect, speechSkills);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("sorry, please choose attributes that we have provided you with (select within our number range).");
            }catch(Exception e){
                System.out.println("we are making you a default baby because it's not working, sorry.");
                baby = new Baby(babyWeight, name, hairList.get(0), eyeList.get(0), stuffedAnimal.get(0), "Infant", motorSkills, trustConnect, speechSkills);
            }
        }

        return baby;

    }

    /**
     * 
     */
    public static void printBabyInfo(Baby b){
        System.out.println("\tBABY " + b.getName() + " HAS " + b.getEyes() + " EYES & " + b.getHair() + " HAIR!");
        System.out.println("\t" + b.getName() + "'S FAVORITE STUFFED ANIMAL IS " + b.getStuffedAnimal());
        System.out.println("\n\tOFFICIAL STATS:");
        printBabyStats(b);
    }

    /**
     * 
     * @param b
     */
    public static void printBabyStats(Baby b){
        System.out.println("\t\tWEIGHT: " + b.getWeight() + " oz.");
        System.out.println("\t\tMOTOR SKILLS: " + b.getMotorSkills());
        System.out.println("\t\tTRUST & CONNECTION SKILLS: " + b.getTrustConnectSkills());
        System.out.println("\t\tSPEECH SKILLS: " + b.getSpeechSkills() + "\n");
    }

    /**
     * 
     */
    public static void loadArrayLists(){
        eyeList.add("brown");
        eyeList.add("blue");
        eyeList.add("black");
        eyeList.add("green");
        eyeList.add("hazel");

        hairList.add("brown");
        hairList.add("black");
        hairList.add("blonde");
        hairList.add("red");

        stuffedAnimal.add("dog");
        stuffedAnimal.add("cat");
        stuffedAnimal.add("bear");
        stuffedAnimal.add("otter");
        stuffedAnimal.add("bunny");
    }
    
    /**
     * 
     * @param baby
     * @param input
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
            System.out.println("\tSELECT A CATEGORY TO IMPROVE ON!\n\tmotor skills, trust and connection, or speech skills?\n");
            System.out.println("\tplease indicate: motor skills, motor, or m | trust, connection, t, or, c | speech or s\n");
            
                challengeChoice = input.nextLine();

            if((challengeChoice.toLowerCase().equals("motor") || challengeChoice.toLowerCase().equals("motor skills") || challengeChoice.toLowerCase().equals("m")) && !blockMotor){
                // save value from this and set baby motor skill to this. (add)
                System.out.println("DO YOU WANT TO TRY PICKING YOUR HEAD UP OR CRAWLING?");
                confirm = false;
                while(!confirm){
                    challengeChoice = input.nextLine();
                    if((challengeChoice.toLowerCase().equals("picking up head") || challengeChoice.toLowerCase().equals("head")) && !maxHd){
                        baby.setMotorSkills(Infancy.pickHeadUpChallenge(baby));
                        confirm = true;
                        tries.put("head challenge", tries.get("head challenge") + 1);
                        maxHd = tries.get("head challenge") >= 2;
                    }else if((challengeChoice.toLowerCase().equals("crawling") || challengeChoice.toLowerCase().equals("crawl")) && !maxCrawl){
                        baby.setMotorSkills(Infancy.crawlChallenge(baby, baby.getStuffedAnimal(), input));
                        confirm = true;
                        tries.put("crawl challenge", tries.get("crawl challenge") + 1);
                        maxCrawl = tries.get("crawl challenge") >= 2;
                    }else{
                        if(maxHd && !maxCrawl){
                            System.out.println("Sorry, you can't do the head lift challenge any more! You can only play it twice!\nYou can only try the crawl challenge.");
                        }else if(maxCrawl && !maxHd){
                            System.out.println("Sorry, you can't do the crawling challenge any more! You can only play it twice!\nYou can only try the head lift challenge.");
                        }else if(maxCrawl && maxHd){
                            System.out.println("Oops, sorry, you can't do any more motor skill challenges!");
                            blockMotor = true;
                            confirm = true;
                        }else{
                            System.out.println("Please choose again:");
                        }
                    }
                }
            }else if((challengeChoice.toLowerCase().equals("trust") || challengeChoice.toLowerCase().equals("trust skills") || challengeChoice.toLowerCase().equals("t") || challengeChoice.toLowerCase().equals("connection")) && !blockTrust){
                if(!maxSign){
                    baby.setTrustConnectSkills(Infancy.signLangChallenge(baby, input));
                    tries.put("sign challenge", tries.get("sign challenge") + 1);
                    maxSign = tries.get("sign challenge") >= 2;
                    input.nextLine();
                }else{
                    System.out.println("Sorry! You are out of tries to boost trust and connection skills!");
                    blockTrust = true;
                }
            }else if((challengeChoice.toLowerCase().equals("speech") || challengeChoice.toLowerCase().equals("speech skills") || challengeChoice.toLowerCase().equals("s") || challengeChoice.toLowerCase().equals("talk")) && !blockSpeech){
                if(!maxBabble){
                    baby.setSpeechSkills(Infancy.babbleChallenge(baby, input));
                    tries.put("babble challenge", tries.get("babble challenge") + 1);
                    maxBabble = tries.get("babble challenge") >= 2;
                    input.nextLine();
                }else{
                    System.out.println("Sorry! You are out of tries to boost speech skills!");
                    blockSpeech = true;
                }
            }else{
                if(blockMotor && blockSpeech && blockTrust){
                    System.out.println("sorry, you cannot attempt any more challenges. it's two tries per challenge!");
                }else if(blockMotor || blockSpeech || blockTrust){
                    System.out.println("sorry, you can't attempt the challenge category you selected again. you're out of tries for that category!");
                }else{
                    System.out.println("we didn't recognize your choice. please choose again.");
                }
            }
            points = baby.getMotorSkills() + baby.getSpeechSkills() + baby.getTrustConnectSkills();
            kindergarten = (points >= 17);
            allDone = (maxHd && maxCrawl && maxSign && maxBabble);
            printBabyStats(baby);
        }

        if(kindergarten){
            // if(baby.getMotorSkills() < 10){
            //     System.out.println("\nOh no, baby " + baby.getName() + " is probably going to have a hard time in PE!");
            // }else if(baby.getTrustConnectSkills() < 10){
            //     System.out.println("\nOh no, baby " + baby.getName() + " is probably going to have a hard time making friends and will have complicated relationships with teachers!");
            // }else if(baby.getSpeechSkills() < 10){
            //     System.out.println("\nOh no, baby " + baby.getName() + " is going to have to go to a speech pathologist!");
            // }else{
            //     System.out.println("\t🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊");
            //     System.out.println("\t🎊🎊🎊 CONGRATULATIONS! ITS TIME FOR KINDERGARTEN... 🎊🎊🎊🎊\n");
            //     System.out.println("\tNOW...\n\tCAN YOU MAKE IT THROUGH KINDERGARTEN TO 1ST GRADE...");
            //     System.out.println("\t🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊");
            // }
            System.out.println("\t🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊");
            System.out.println("\t🎊🎊🎊 CONGRATULATIONS! ITS TIME FOR KINDERGARTEN... 🎊🎊🎊🎊\n");
            System.out.println("\tNOW...\n\tCAN YOU MAKE IT THROUGH KINDERGARTEN TO 1ST GRADE...");
            System.out.println("\t🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊");

            if(baby.getMotorSkills() < 7){
                System.out.println("\nhowever, baby " + baby.getName() + " is probably going to have a hard time in PE!");
            }
            if(baby.getTrustConnectSkills() < 7){
                System.out.println("\nkeep in mind, baby " + baby.getName() + " is probably going to have a hard time making friends and will have complicated relationships with teachers!");
            }
            if(baby.getSpeechSkills() < 7){
                System.out.println("\nit looks like, baby " + baby.getName() + " is going to have to go to a speech pathologist!");
            }

            System.out.println("But yay! Congratulations for making it to kindergarten anyway!\nThe end.");
        }else{
            System.out.println("Sorry, you didn't make it to kindergarten this year. Maybe next year...");
        }
    }
    
    public static void main (String args[]) {

        loadArrayLists();

        Scanner input = new Scanner(System.in);
        Displays.display("\tWELCOME TO KINDERGROW!\n\n\tCONGRATS! YOU ARE A BABY AGAIN\n\n\tYOUR GOAL IS TO GET THROUGH INFANCY AND IMPROVE ON ALL SKILLS BEFORE ENTERING KINDERGARTEN\n");

        Baby baby = createBaby(input);

        Displays.displayScene();
        System.out.println("\t 🎊 CONGRATULATIONS! YOU WERE BIRTHED! 🎊\n");
        printBabyInfo(baby);

        // actual game
        game(baby, input);

        input.close();
    }

    
}

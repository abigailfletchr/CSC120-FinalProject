public class Baby {

    /**
     * @param weight the randomly generated weight of the baby
     * @param name the name of the baby from the user input
     * @param hair the hair of the baby from the user input
     * @param eyes the eye color of the baby from the user input
     * @param stuffedAnimal the stuffed animal from the user input
     * @param stage the stage the baby is at
     * @param motorSkills the number of motor skills points the baby has
     * @param trustConnect the number of trust & connect skills points the baby has
     * @param speechSkills the number of speech skills points the baby has
     */
    private int weight;
    private String name;
    private String hair;
    private String eyes;
    private String stuffedAnimal;
    private String stage;
    private int motorSkills;
    private int trustConnect;
    private int speechSkills;


    /**
     *  The baby constructor in the Baby class.
     * @param weight the randomly generated weight of the baby
     * @param name the name of the baby from the user input
     * @param hair the hair of the baby from the user input
     * @param eyes the eye color of the baby from the user input
     * @param stuffedAnimal the stuffed animal from the user input
     * @param stage the stage the baby is at
     * @param motorSkills the number of motor skills points the baby has
     * @param trustConnect the number of trust & connect skills points the baby has
     * @param speechSkills the number of speech skills points the baby has
     */
    public Baby(int weight, String name, String hair, String eyes, String stuffedAnimal, String stage, int motorSkills,
            int trustConnect, int speechSkills) {
        this.weight = weight;
        this.name = name;
        this.eyes = eyes;
        this.hair = hair;
        this.stuffedAnimal = stuffedAnimal;
        this.stage = stage;
        this.motorSkills = motorSkills;
        this.trustConnect = trustConnect;
        this.speechSkills = speechSkills;
    }

    /**
     * Sets the stage the baby is in
     * @param s a new stage
     */
    public void setStage(String s) {
        this.stage = s;
    }

    /**
     * Adds/changes the motor skills points the baby has
     * @param m motor skills points added
     */
    public void setMotorSkills(int m){
        this.motorSkills += m;
    }

    /**
     * Adds/changes the trust & connect skills the baby has
     * @param t trust & connect skills points added
     */
    public void setTrustConnectSkills(int t){
        this.trustConnect += t;
    }

    /**
     * Adds/changes the speech skills the baby has
     * @param s speech skills points added
     */
    public void setSpeechSkills(int s) {
        this.speechSkills += s;
    }

    // in this version of game submitted only the infancy to kindergarten stage was created
    // the game is created so someone else can add stages or levels on to it

    /**
     * Gets the stage that the baby is in
     * @return the stage baby is in
     */
    public String getStage() {
        return this.stage;
    }

    /**
     * Gets the name of the baby
     * @return the name of the baby
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the weight of the baby
     * @return the weight of the baby
     */
    public int getWeight(){
        return this.weight;
    }

    /**
     * Gets the eye color of the baby
     * @return the eye color of the baby
     */
    public String getEyes(){
        return this.eyes;
    }

    /**
     * Gets the hair color of the baby
     * @return the hair color of the baby
     */
    public String getHair(){
        return this.hair;
    }

    /**
     * Gets the stuffed animal of the baby
     * @return the stuffed animal of the baby
     */
    public String getStuffedAnimal(){
        return this.stuffedAnimal;
    }

    /**
     * Gets the amount of motor skills points the baby has
     * @return the amount of motor skills points
     */
    public int getMotorSkills(){
        return this.motorSkills;
    }

    /**
     * Gets the amount of trust & connect skills points the baby has
     * @return the amount of trust & connect skills points
     */
    public int getTrustConnectSkills(){
        return this.trustConnect;
    }

    /**
     * Gets the amount of speech skills points the baby has
     * @return the amount of speech skills points
     */
    public int getSpeechSkills() {
        return this.speechSkills;
    }





    
}

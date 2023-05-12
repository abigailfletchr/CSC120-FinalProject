public class Baby {

    /**
     * 
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
     * 
     * @param weight
     * @param name
     * @param hair
     * @param eyes
     * @param stuffedAnimal
     * @param stage
     * @param motorSkills
     * @param trustConnect
     * @param speechSkills
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
     * 
     * @param s
     */
    public void setStage(String s) {
        this.stage = s;
    }

    /**
     * 
     * @param m
     */
    public void setMotorSkills(int m){
        this.motorSkills += m;
    }

    /**
     * 
     * @param t
     */
    public void setTrustConnectSkills(int t){
        this.trustConnect += t;
    }

    /**
     * 
     * @param s
     */
    public void setSpeechSkills(int s) {
        this.speechSkills += s;
    }

    /**
     * 
     * @return
     */
    public String getStage() {
        return this.stage;
    }

    /**
     * 
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * 
     * @return
     */
    public int getWeight(){
        return this.weight;
    }

    /**
     * 
     * @return
     */
    public String getEyes(){
        return this.eyes;
    }

    /**
     * 
     * @return
     */
    public String getHair(){
        return this.hair;
    }

    /**
     * 
     * @return
     */
    public String getStuffedAnimal(){
        return this.stuffedAnimal;
    }

    /**
     * 
     * @return
     */
    public int getMotorSkills(){
        return this.motorSkills;
    }

    /**
     * 
     * @return
     */
    public int getTrustConnectSkills(){
        return this.trustConnect;
    }

    /**
     * 
     * @return
     */
    public int getSpeechSkills() {
        return this.speechSkills;
    }





    
}

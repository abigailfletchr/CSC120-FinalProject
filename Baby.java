public class Baby {

    // attributes
    private int weight;
    private String name;
    private String hair;
    private String eyes;
    private String stuffedAnimal;
    private String stage;
    private int motorSkills;
    private int trustConnect;
    private int speechSkills;


    // constructor/s go here
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

    // setters
    public void setStage() {

    }

    public void setMotorSkills(){

    }

    public void setTrustConnectSkills(){

    }

    public void setSpeechSkills() {

    }

    // getters
    public String getStage() {
        return this.stage;
    }

    public String getName(){
        return this.name;
    }

    public int getWeight(){
        return this.weight;
    }

    public String getEyes(){
        return this.eyes;
    }

    public String getHair(){
        return this.hair;
    }

    public String getStuffedAnimal(){
        return this.stuffedAnimal;
    }

    public int getMotorSkills(){
        return this.motorSkills;
    }

    public int getTrustConnectSkills(){
        return this.trustConnect;
    }

    public int getSpeechSkills() {
        return this.speechSkills;
    }





    
}

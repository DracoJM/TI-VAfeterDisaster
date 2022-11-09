package model;



public class VideoGameController {

    private int displayResolutionX;
    private int displayResolutionY;
    private int levelsB = 0;


    private Player[] players;
    private Level[] levels;


    public VideoGameController( int displayResolutionX, int displayResolutionY){

        this.displayResolutionX= displayResolutionX;
        this.displayResolutionY = displayResolutionY;
        levels = new Level[10];
        players = new Player[25];
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////Methods
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public String addPlayer(String nickname,String name,int points,int lives,int lvl){

        String message = "Error";

        if (searchPlayer(nickname)){
             Player objPlayer = new Player(nickname, name, points, lives, lvl);

            for (int i = 0; i < players.length; i++) {
                
                if(players[i]==null){
                    players[i]=objPlayer;
                    i = players.length;
                    message = "Player successfully created";
                }
                else{
                    message = "Slots to create players are full";
                }
            }	  
		}
        else {
            message = "Error, the nickname has already been used";  
        } 
        return message; 
    }

    public boolean searchPlayer(String nickname){

        boolean isAvailable = true;
        for (int i = 0; i < players.length; i++) {
            if(isAvailable && players[i]!=null && players[i].getNickname().equalsIgnoreCase(nickname)){
                isAvailable=false;
            }
        }
        return isAvailable;
    }

    public void addLevel(int scoreToNextLevel){

        levels[levelsB] = new Level(levelsB+1, scoreToNextLevel);
        levelsB++;

        
    }

    public String addEnemy(String id, int pointsGiven, int pointsSubtracted,int lvl, int enemyType){

        int i= lvl-1;
        String message = levels[i].addEnemy(id, pointsGiven, pointsSubtracted, enemyType);
 
         return message;
    }

    public String addTreasure(String name, String imageURL, int foundTreasurepoints,int lvl){

        int i= lvl-1;
        String message=levels[i].addTreasure(name, imageURL, foundTreasurepoints);
        return message;
    }

    public String changePoints(String nickname,int points){

        String message = "Error";
        
        for (int i = 0; i < players.length; i++) {
            if(players[i]!=null && players[i].getNickname().equalsIgnoreCase(nickname)){
                players[i].setPoints(points);
                i=players.length;
                message=""+nickname+" score has been changed successfully.";
            }
            else{
                message="No player "+nickname+" has been found.";
            }
        }
        return message;
    }

    public String levelUp(String nickname){

        String message= "Error";
    
        for (int i = 0; i < players.length; i++) {
            if(players[i]!=null && players[i].getNickname().equalsIgnoreCase(nickname)){
                int lvl=players[i].getLvl();
                lvl=lvl+1;
                players[i].setLvl(lvl);
                i=players.length;
                message = "Has been successfully leveled, now "+nickname+" is at level: "+ lvl;
            }
            else{
                message = "No player "+nickname+" has been found.";
            }
        }
        return message;

    }

    public String treasuresAndEnemiesInfo(int lvl){

        String message= "Error";

        String message1=levels[lvl-1].getTreasureNames();
        String message2=levels[lvl-1].getEnemyNames();
        message="Enemies of level "+lvl+" are: "+message2+" And the treasures are: "+message1;
        return message;
    }   

    public String treasuresNum(String name){

        String message="";
        int treasureNum=0;

        for (int i = 0; i < levels.length; i++) {
            if(levels[i]!=null){
                treasureNum=treasureNum+levels[i].countreasuresNum(name);
            }
        }
        message= "there are "+treasureNum+" treasures "+name+" in the game";
        

        return message;
    }

    public String enemiesNum(String name){
        
        String message="";
        int enemyNum=0;

        for (int i = 0; i < levels.length; i++) {
            if(levels[i]!=null){
                enemyNum=enemyNum+levels[i].countenemiesNums(name);
            }
        }
        message= "There are "+enemyNum+" enemies "+name+" in the game";
        

        return message;
    }

    public String mostRepeatedTreasure(){ 

        String mostRepeated="Error";
        int maxCount=0;
        String nameToCompare="";

        for (int i = 0; i < levels.length; i++) {

            for (int j = 0; j < levels[i].getTreasuresLength(); j++) {
                int count=0;
                if(levels[i].isRegistered(j)){
                    nameToCompare=levels[i].getTreasureName(j);
                    
                    for(int k=0; k<levels.length; k++ ){
                        for(int l=0; l<levels[k].getTreasuresLength(); l++){
                            if(levels[k].isRegistered(l)&& nameToCompare.equalsIgnoreCase(levels[k].getTreasureName(l))){
                                count++;
                            }
                        }
                    }
                    if(count>maxCount){
                        mostRepeated=nameToCompare;
                        maxCount=count;
                    }    
                }
            }   
            
        }
        return mostRepeated;
    }

    public String mostValueEnemy(){

        String message="Error, no hay enemigos registrados";
        
        for (int i = 0; i < levels.length; i++) {
            for (int j = 0; j < levels[i].getEnemiesLength(); j++) {
                if(levels[i].isEnemyRegistered(j)){
                    
                    String mostValueEnemy=levels[i].getEnemyName(j);
                    int maxCount=levels[i].getEnemyPointsGiven(j);
                    int lvl=i+1;
                    
                    for(int k=0; k<levels.length; k++ ){
                        for(int l=0; l<levels[k].getEnemiesLength(); l++){
                            if(levels[k].isEnemyRegistered(l)&& levels[k].getEnemyPointsGiven(l)>maxCount){
                                mostValueEnemy=levels[k].getEnemyName(l);
                                maxCount=levels[k].getEnemyPointsGiven(l);
                                lvl=k+1;
                            }
                        }
                    }
                    message="The enemy that gives more points is"+mostValueEnemy+" and is at the level "+lvl;
                    j=levels[i].getEnemiesLength();
                }
                
            }   
        }
        return message;
    }

    public String consonantsNum(){

        String message="Error";
        int counter=0;

        for(int i=0; i<levels.length; i++ ){
            for (int j = 0; j < levels[i].getEnemiesLength(); j++) {

                if(levels[i].isEnemyRegistered(j)){
                    String name= levels[i].getEnemyName(j);
                    for (int k = 0; k < name.length(); k++) {
                        char letter = name.charAt(k);
                        if (isConsonant(letter)) {
                            counter++;
                        }
                    } 
                }
            }
        } 
        message="There are "+counter+" consonants in the names of enemies registered in the game";

        return message;
    }

    public boolean isConsonant(char letter) {
		boolean isConsonant="bcdfghjklmnpqrstvwxyz".contains(String.valueOf(letter).toLowerCase());

        return isConsonant;
	}

    public String topPlayers(){

        String message = "Error";
        String [] top5 = new String[5];

        for(int x=0; x<top5.length; x++){
            top5[x]="No players registered";
            for(int i=0; i<players.length; i++){
                if(players[i]!=null&& !players[i].getNickname().equalsIgnoreCase(top5[0])&& !players[i].getNickname().equalsIgnoreCase(top5[1])&& !players[i].getNickname().equalsIgnoreCase(top5[2])&& !players[i].getNickname().equalsIgnoreCase(top5[3])&& !players[i].getNickname().equalsIgnoreCase(top5[4])){
                    int points=players[i].getPoints();
                    top5[x]=players[i].getNickname();

                    for(int j=0; j<players.length; j++){
                        if(players[j]!=null&& !players[j].getNickname().equalsIgnoreCase(top5[0])&& !players[j].getNickname().equalsIgnoreCase(top5[1])&& !players[j].getNickname().equalsIgnoreCase(top5[2])&& !players[j].getNickname().equalsIgnoreCase(top5[3])&& !players[j].getNickname().equalsIgnoreCase(top5[4]) && players[j].getPoints()>points){
                            points=players[j].getPoints();
                            top5[x]=players[j].getNickname();
                        }
                    }
                }          
            }        
        }            
        message="Top 5 players \n1. "+top5[0]+"\n2. "+top5[1]+"\n3. "+top5[2]+"\n4. "+top5[3]+"\n5. "+top5[4];
        return message;
    }
    

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// get & set
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public int getDisplayResolutionX(){

		return displayResolutionX;
	}
    public void setDisplayresolutionX(int displayResolutionX){

		this.displayResolutionX = displayResolutionX;
	}

    public int getDisplayResolutionY(){

		return displayResolutionY;
	}
    public void setDisplayResolutionY(int displayResolutionY){

		this.displayResolutionY = displayResolutionY;
	}
    
}

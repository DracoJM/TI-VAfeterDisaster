package model;

public class Level {

    private int id;
	private int scoreToNextLevel;
     
    
	private Treasure[] treasures;
    private Enemy[] enemies;


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////Constructor
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public Level(int id, int scoreToNextLevel){

        this.id = id;
		this.scoreToNextLevel = scoreToNextLevel;
        enemies= new Enemy[5];
        treasures= new Treasure[10];
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////Methods
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //¿esto debería ir en el contoller?//
    //|-------------------------------|//

    public String addEnemy(String id, int pointsGiven, int pointsSubtracted, int type){

        String message="Error";

        if (searchEnemy(id)){
            Enemy objEnemy= new Enemy(id, pointsGiven, pointsSubtracted, type);

            for (int i = 0; i < enemies.length; i++) {
                if(enemies[i]==null){
                    enemies[i]= objEnemy;
                    i=enemies.length;
                    message="Enemy successfully saved in the level";
                }
                else{
                    message="It was not possible to save this enemy. Slots are full";
                }
            }	  
		}
        else {
            message="This enemy was previously registered at this level";
        }
        return message;
    }

    public boolean searchEnemy(String id){

        boolean isAvailable=true;

        for (int i = 0; i < enemies.length; i++) {
            if(isAvailable && enemies[i]!=null && enemies[i].getId().equalsIgnoreCase(id)){
                isAvailable=false;
            }
        }
        return isAvailable;
    }

    public String addTreasure(String name, String imageURL, int pointsIfFound){
        String message="Error";
        Treasure objTreasure= new Treasure(name, imageURL, pointsIfFound);

            for (int i = 0; i < treasures.length; i++) {
                if(treasures[i]==null){
                    treasures[i]= objTreasure;
                    i=treasures.length;
                    message="Treasure successfully saved in the level";
                }
                else{
                    message="It was not possible to save this treasure. Slots are full";
                }
            }	  
        return message;
    }


    public int countreasuresNum(String name){

		int treasureNum=0;

        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i]!=null && treasures[i].getName().equalsIgnoreCase(name)){
                treasureNum=treasureNum+1;
            }
        }
        return treasureNum;
    }

    public int countenemiesNums(String name){

		int enemyNum=0;
        
        for (int i = 0; i < enemies.length; i++) {
            if(enemies[i]!=null && enemies[i].getId().equalsIgnoreCase(name)){
                enemyNum=enemyNum+1;
            }
        }
        return enemyNum;
    }

    public boolean isEnemyRegistered(int j){

        boolean isRegistered=true;

        if(enemies[j]==null){
            isRegistered=false;
        }
        return isRegistered;
    }

    public boolean isRegistered(int j){

        boolean isRegistered=true;

        if(treasures[j]==null){
            isRegistered=false;
        }
        return isRegistered;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////get & set
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    public int getId(){

		return id;
	}
    public void setId(int id){

		this.id = id;
	}

    public int getTreasuresLength(){

        int treasureslength = treasures.length;

		return treasureslength;
	}

    public int getEnemiesLength(){

        int enemiesLength = enemies.length;

		return enemiesLength;
	}

    public int getScoreToNextLevel(){

		return scoreToNextLevel;
	}
    public void setScoreToNextLevel(int scoreToNextLevel){

		this.scoreToNextLevel=scoreToNextLevel;
	}

    public String getTreasureNames(){

		String treasureNames="No treasures registered";

        if(treasures[0]!=null){
            treasureNames=treasures[0].getName();
        }

        for(int i=1; i < treasures.length; i++){
            if(treasures[i]!=null){
                treasureNames=treasureNames+ ", " +treasures[i].getName();
            }
        }

        return treasureNames;
    }

    public String getEnemyNames(){

		String enemyNames="No enemys registered";

        if(enemies[0]!=null){
            enemyNames=enemies[0].getId();
        }

        for(int i=1; i < enemies.length; i++){
            if(enemies[i]!=null){
                enemyNames=enemyNames+ ", " +enemies[i].getId();
            }
        }
        return enemyNames;
    }

    public String getTreasureName(int j){

		String treasureName="No treasures registered";

        treasureName=treasures[j].getName();
        return treasureName;
    }

    public String getEnemyName(int j){

		String enemyName="No enemys registered";

        enemyName=enemies[j].getId();       
        return enemyName;
    }

    public int getEnemyPointsGiven(int j){

        int pointsGiven=0;

        pointsGiven=enemies[j].getPointsGiven();
        return pointsGiven;
    }
    
}

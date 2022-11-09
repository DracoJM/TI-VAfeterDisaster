package model;

public class Enemy {
    
    private String id;
	private int pointsGiven;
    private int pointsSubtracted;
	private int positionX;
    private int positionY;

    private TypeEnemy enemyType;


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////Constructor
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public Enemy(String id, int pointsGiven, int pointsSubtracted, int enemyType){
        this.id=id;
		this.pointsGiven= pointsGiven;
		this.pointsSubtracted= pointsSubtracted;
		this.positionX=(int)(Math.random()*640+1);
        this.positionY=(int)(Math.random()*480+1);

        if (enemyType==1){

            this.enemyType = TypeEnemy.OGRE;
        }
        else if(enemyType==2){

            this.enemyType = TypeEnemy.ABSTRACT;
        }
        else if (enemyType==3){

            this.enemyType = TypeEnemy.BOSS;
        }
        else if (enemyType==4){
            
            this.enemyType = TypeEnemy.WIZARD;
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////get & set
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    public String getId(){

		return id;
	}
    public void setid(String id){

		this.id = id;
	}

    public int getPointsGiven(){

		return pointsGiven;
	}
    public void setPointsGiven(int pointsGiven){

		this.pointsGiven = pointsGiven;
	}

    public int getPointsSubtracted(){
        
		return pointsSubtracted;
	}
    public void setPointsSubtracted(int pointsSubtracted){

		this.pointsSubtracted = pointsSubtracted;
	}

    public int getPositionX(){

		return positionX;
	}
    public void setPositionX(int positionX){

		this.positionX = positionX;
	}

    public int getPositionY(){

		return positionY;
	}
    public void setPositionY(int positionY){
        
		this.positionY = positionY;
	}
    
    public TypeEnemy getEnemyType() {

        return enemyType;
    }
    public void setEnemyType(TypeEnemy enemyType) {
        
        this.enemyType = enemyType;
    }
    
}

    

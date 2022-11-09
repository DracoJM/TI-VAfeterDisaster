package model;

public class Treasure {
    
    private String name;
    private String imageURL;
    private int foundTreasurepoints;
    private int positionX=(int)(Math.random()*640+1);
    private int positionY=(int)(Math.random()*480+1);


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////Constructor
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public Treasure(String name, String imageURL, int pointsIfFound){

    this.name=name;
		this.imageURL= imageURL;
		this.foundTreasurepoints= pointsIfFound;
    }

    

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////get & set
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public String getName(){

		return name;
	}
    public void setName(String name){

		this.name=name;
	}

    public String getImageURL(){

		return imageURL;
	}
    public void setImageURL(String imageURL){

		this.imageURL=imageURL;
	}

    public int getFoundTreasurepoints(){

        return foundTreasurepoints;
    }
    public void setTreasurepoints(int foundTreasurepoints){

        this.foundTreasurepoints = foundTreasurepoints;
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
}

package model;

public class Player {

  private String nickname;
	private String name;
  private int points=10;
	private int lives=5;
  private int lvl=1;


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////Constructor
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public Player(String nickname, String name, int points, int lives, int lvl){

      this.nickname=nickname;
		  this.name = name;
      this.points= points;
      this.lives= lives;
		  this.lvl= lvl;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////get & set
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public String getNickname(){

		return nickname;
	}
    public void setNickname(String nickname){

		this.nickname=nickname;
	}

    public String getName(){
        
		return name;
	}
    public void setName(String name){

		this.name=name;
	}

    public int getPoints(){

		return points;
	}
    public void setPoints(int points){

		this.points=points;
	}

    public int getLives(){

		return lives;
	}
    public void setLives(int lives){

		this.lives=lives;
	}

    public int getLvl(){

		return lvl;
	}
    public void setLvl(int lvl){

		this.lvl=lvl;
	} 
}

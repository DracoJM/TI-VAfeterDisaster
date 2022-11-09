package ui;

import java.util.Scanner;
import model.VideoGameController;


public class VideoGameManager{

public static Scanner rd = new Scanner(System.in);

public static VideoGameController videoGameController;

/**
 * Main<br>
 * <b>post: </b> calls the creat videogame method and later the menu method.
 */

public static int displayResolutionX;
public static int displayResolutionY;

    public static void main(String args[]){

        createVideoGame();
        menu();
    }


    /**
     * Creates the videogame <br>
     * <b>pre: </b> Creates the controller class videoGameController 'nd initializes its variables.
     * @param displayResolutionX is the num of pixels in the x axis of the screen
     * @param displayResolutionY is the num of pixels in the y axis of the screen
     * @param videoGameController is the obj VideoGameController that is created.
     */

    public static void createVideoGame(){

        displayResolutionX=640;
        displayResolutionY=480;

        videoGameController = new VideoGameController(displayResolutionX, displayResolutionY);
    }

    public static void menu(){

        boolean exit = false;
    
        System.out.println("Welcome to the creation menu of your video game...\n"+
        "Select an option:\n"+
        "|--------------------------------------------------|\n"+
        "Creation and modification options:\n "+
        "(0) Create a level.\n"+
        "(1) Create a player.\n"+
        "(2) Register an enemy at a level.\n"+
        "(3) Register treasure at one level.\n"+
        "(4) Modify a player's score.\n"+
        "(5) Increase level for a single player.\n"+
        "|--------------------------------------------------------------------------------|\n");
        System.out.println("Information options:\n"+
        "(6)   Treasure and enemy info.\n"+
        "(7)   Amount of treasure in all levels.\n"+
        "(8)   Amount of an enemy in all levels.\n"+
        "(9)   Most repeated treasure at all levels.\n"+
        "(10)  The enemy that gives the highest score and level, and its location.\n"+
        "(11)  Number of consonants found in the names of enemies in the game.\n"+
        "(12)  Top 5 players by score.\n"+
        "|--------------------------------------------------------------------------------|\n");
        System.out.println("(13) Exit.");

        int op = rd.nextInt();
        rd.nextLine();

        while(!exit){
            switch(op){
                case 0:
                    registerLevel();
                    break;
                case 1:
                    registerPlayer();
                    menu();
                    break;
                    
                case 2:
                    registerEnemy();
                    menu();
                    break;
                case 3:
                    registerTreasure();
                    menu();
                    break;
                case 4:
                    modifyPoints();
                    menu();
                    break;
                case 5:
                    levelUp();
                    menu();
                    break;


                case 6:
                    treasuresAndEnemiesInfo();
                    menu();
                    break;
                case 7:
                    treasuresNum();
                    menu();
                    break;
                case 8:
                    enemiesNum();
                    menu();
                    break;
                case 9:
                    mostRepeatedTreasure();
                    menu();
                    break;
                case 10:
                    mostValueEnemy();
                    menu();
                    break;
                case 11:
                    consonantsNum();
                    menu();
                    break;
                case 12:
                    topPlayers();
                    menu();
                    break;
                case 13:
                    System.out.println("You left the program");
                    
                    exit = true;
                    break;
                
                default: 
                    System.out.println("Error, invalid option");
                    menu();
                    exit = true;
            }
        }
         
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////Creation and modification options.
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    

    /**
     * Registers a new player <br>
     * <b>pre </b>The user chooses the option to register a player in the menu<br>
     * <b>post: </b> Creates a new player with the given data. 
     * @param nickname is the unique identifier that is created for each player. 
     * @param name player's name.
     * @param points the number of points the player has.
     * @param lives the number of lives the player has.
     * @param lvl player's level.
     * @param message the confirmation or error message that appears when trying to add a new player.
     */

    public static void registerPlayer(){
        
        System.out.println("Type the player's nickname.");
        String nickname = rd.nextLine();
        System.out.println("Type your name.");
        String name = rd.nextLine();
        int points = 10;
        int lives = 5;
        int lvl = 1;
        String message= videoGameController.addPlayer(nickname,name,points,lives,lvl);
        System.out.println(message);
    }


    /**
     * Register 
     */

    public static void registerLevel(){

        System.out.println("Type the score that this level requires to move to the next level.");
        int scoreToNextLevel = rd.nextInt();
        rd.nextLine();

        videoGameController.addLevel(scoreToNextLevel);
    }

    public static void registerTreasure(){

        System.out.println("Type the treasure's name");
        String name = rd.nextLine();
        System.out.println("Type the URL of the image");
        String imageURL = rd.nextLine();
        System.out.println("Type the points awarded for this treasure when it is found.");
        int foundTreasurepoints = rd.nextInt();
        rd.nextLine();
        System.out.println("Type the level at which you want to register this treasure.");
        int level = rd.nextInt();
        rd.nextLine();
        while (level>10 || level<1){

            System.out.println("Invalid number! Type a number from 1 to 10.");
            level = rd.nextInt();
            rd.nextLine();
        }
        String message = videoGameController.addTreasure(name, imageURL, foundTreasurepoints,level);
        System.out.println(message);
    }

    public static void registerEnemy(){

        System.out.println("Type the enemy's name");
        String enemyName = rd.nextLine();
        System.out.println("Enter the points given by the enemy when defeated.");
        int pointsGiven = rd.nextInt();
        rd.nextLine();
        System.out.println("Type enemy type:1. OGRO2. ABSTRACT 3. BOSS 4. WIZARD");
        int enemyType = rd.nextInt();
        while (enemyType>4 || enemyType<1){
            System.out.println("Invalid number! Type a number from 1 to 4.");
            enemyType = rd.nextInt();
            rd.nextLine();
        }
        rd.nextLine();
        System.out.println("Type the points removed by this enemy when it defeats you.");
        int pointsSubtracted = rd.nextInt();
        rd.nextLine();
        System.out.println("Type the number of the level at which you want to register the enemy");
        int level = rd.nextInt();
        rd.nextLine();
        while (level>10 || level<1){
            System.out.println("Invalid number! Type a number from 1 to 10. ");
            level = rd.nextInt();
            rd.nextLine();
        }
        String message = videoGameController.addEnemy(enemyName, pointsGiven, pointsSubtracted,level, enemyType);
        System.out.println(message);
    }

    public static void modifyPoints(){

        System.out.println("Type player's nickname");
        String nickname = rd.nextLine();
        System.out.println("Type the new score");
        int points = rd.nextInt();
        rd.nextLine();
        String message = videoGameController.changePoints(nickname,points);
        System.out.println(message);
    }

    public static void levelUp(){

        System.out.println("Type the player's name");
        String nickname = rd.nextLine();
        String message = videoGameController.levelUp(nickname);
        System.out.println(message);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////Information options.
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void treasuresAndEnemiesInfo(){

        System.out.println("Enter the level number from which you want to see the treasures and enemies.");
        int lvl = rd.nextInt();
        rd.nextLine();
        String message = videoGameController.treasuresAndEnemiesInfo(lvl);
        System.out.println(message);
    }

    public static void treasuresNum(){

        System.out.println("Type the treasure's name");
        String treasurename = rd.nextLine();
        String message= videoGameController.treasuresNum(treasurename);
        System.out.println(message);
    }

    public static void enemiesNum(){
       
        System.out.println("Enter the enemy's name");
        String enemyName= rd.nextLine();
        String message = videoGameController.enemiesNum(enemyName);
        System.out.println(message);
    }
    
    public static void mostRepeatedTreasure(){
        
        String message = videoGameController.mostRepeatedTreasure();
        System.out.println("Most repeated treasure in all levels: "+message);
    }

    public static void mostValueEnemy(){
       
        String message= videoGameController.mostValueEnemy();
        System.out.println(message);
    }

    public static void consonantsNum(){
       
        String message = videoGameController.consonantsNum();
        System.out.println(message);
    }

    public static void topPlayers(){
        
        System.out.println(videoGameController.topPlayers());
    }
}
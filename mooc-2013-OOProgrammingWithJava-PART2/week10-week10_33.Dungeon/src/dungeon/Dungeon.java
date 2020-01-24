/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author leonardo
 */
public class Dungeon {

    private int mapLength;                   //length limt of the map
    private int mapHeight;                   //height limit of the map
    private int vampires;                    //number of vampires in the game
    private int moves;                       //amount of moves the player has available
    private boolean vampiresMove;            //determines if vampires move or not
//    private ArrayList<String> mapLines;    //contains each line that composes the map
    private Map<Integer, String> map;        //contains the map of the game
    private ArrayList<Movable> characters;   //list with the characters in the dungeon (player and vampires)
    private Scanner reader = new Scanner(System.in);
    private Player player = new Player();
    private ArrayList<Vampire> vampireList;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.mapLength = length;
        this.mapHeight = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.map = new HashMap<Integer, String>();
        this.characters = new ArrayList<Movable>();
        this.vampireList = new ArrayList<Vampire>();
    }

    //method to start the game
    public void run() {
//        Player player = new Player();       //generate a new player
        characters.add(player);
        createVampires();
        //printStatus();
        generateMap();
        addVampiresToMap();
        addPlayerToMap();
        while (this.moves > 0) {       //while the player has remaining moves
            System.out.println(this.moves + "\n");
            //System.out.println("vampires left: " + vampireList.size());
            printStatus();
            System.out.println("");
            printDungeon();
            String command = reader.nextLine();
            executeCommand(command);
            moves--;
            if (vampireList.size() == 0) {
                System.out.println("YOU WIN");
                break;
            }
        }
        if (vampireList.size() != 0) {
            System.out.println("YOU LOSE");
        }

    }

    //method to execute the command
    public void executeCommand(String command) {

        for (Character step : command.toCharArray()) {

            switch (step) {
                case 'w':
//                    System.out.println("move up");
                    playerMoveUp();
                    break;
                case 'a':
//                    System.out.println("move left");
                    playerMoveLeft();
                    break;
                case 's':
//                    System.out.println("move down");
                    playerMoveDown();
                    break;
                case 'd':
//                    System.out.println("move right");
                    playerMoveRight();
                    break;
                default:
                    break;
            }

            checkForRemovedVampires();
            prepareDungeon();

        }

        if (vampiresMove) {
            moveVampires();
            prepareDungeon();
        }

    }

    //method to determine if a move is valid 
    public boolean validMovement(int x, int y) {
        //if player location is outside of the dungeon, it's not valid
        return !(x < 0 || y < 0 || x >= mapLength || y >= mapHeight);
    }

    public void playerMoveDown() {
        if (validMovement(player.getXLocation(), player.getYLocation() + 1)) {
            player.moveDown();
            //prepareDungeon();
        }
    }

    public void playerMoveUp() {
        if (validMovement(player.getXLocation(), player.getYLocation() - 1)) {
            player.moveUp();
            //prepareDungeon();
        }
    }

    public void playerMoveRight() {
        if (validMovement(player.getXLocation() + 1, player.getYLocation())) {
            player.moveRight();
            //prepareDungeon();
        }
    }

    private void playerMoveLeft() {
        if (validMovement(player.getXLocation() - 1, player.getYLocation())) {
            player.moveLeft();
            //prepareDungeon();
        }
    }

    private void createVampires() {
        int i = 1;
        while (i <= vampires) {
            Vampire vampire = new Vampire(mapLength, mapHeight);
            characters.add(vampire);
            vampireList.add(vampire);
            i++;
        }
    }

    public void moveVampires() {
        for (Vampire vampire : vampireList) {
            int proposedX = vampire.generateXLocation(mapLength);
            int proposedY = vampire.generateYLocation(mapHeight);
            if (validMovement(proposedX, proposedY)) {
                vampire.setXLocation(proposedX);
                vampire.setYLocation(proposedY);
            }
        }
    }

    public void checkForRemovedVampires() {
        ArrayList<Vampire> toRemove = new ArrayList<Vampire>();
        for (Vampire vampire : vampireList) {
            if (vampire.getXLocation() == player.getXLocation() && vampire.getYLocation() == player.getYLocation()) {
                toRemove.add(vampire);
            }
        }

        vampireList.removeAll(toRemove);
    }

    public void addVampiresToMap() {
        for (int i = 0; i < vampireList.size(); i++) {
            Vampire vampire = vampireList.get(i);
            String lineToModify = map.get(vampire.getYLocation());
            lineToModify = lineToModify.substring(0, vampire.getXLocation()) + 'v' + lineToModify.substring(vampire.getXLocation() + 1);
            map.put(vampire.getYLocation(), lineToModify);
        }
    }

    public void prepareDungeon() {
        generateMap();
        addPlayerToMap();
        addVampiresToMap();
    }

    //method to place the player in its current location
    public void addPlayerToMap() {
        String lineToModify = map.get(player.getYLocation());       //find the correct line
        lineToModify = lineToModify.substring(0, player.getXLocation()) + player.getSymbol() + lineToModify.substring(player.getXLocation() + 1);
        map.put(player.getYLocation(), lineToModify);
    }

    //method to generate empty dungeon 
    private void generateMap() {
        for (int h = 0; h < mapHeight; h++) {        //loop through each line of the map (h for height)
            String line = "";
            for (int l = 0; l < mapLength; l++) {    //loop through to make line out of dots (l for length)
                line += ".";
            }
            map.put(h, line);       //add each line into the hash map at their respective height
        }
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (String line : map.values()) {
            toReturn += line + "\n";        //add each line to a string object separated by line breaks
        }
        return toReturn;
    }

    //method to print the dungeon 
    public void printDungeon() {
        System.out.print(this);
    }

    //method to print the status of the character's locations
    public void printStatus() {

        System.out.println(player);

        for (Movable vampire : vampireList) {
            System.out.println(vampire);
        }
        //System.out.println("\n");
    }

}

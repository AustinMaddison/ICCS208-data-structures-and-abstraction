package game.room;

import game.command.CommandDirection;

import java.util.HashMap;

/**
 * Class game.room.Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "game.room.Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room {

    private String description;
    private HashMap<CommandDirection, Exit> exits;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) {
        exits = new HashMap<CommandDirection, Exit>();
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param direction  direction of the exit room.
     * @param adjacentRoom  the adjacent exiting room at given direction.
     */
    public void setExit(CommandDirection direction, Room adjacentRoom) {

        // Automatically sets corresponding room exits to each other.
        exits.put(direction, new Exit(direction, adjacentRoom));
        if(adjacentRoom != null) {
            adjacentRoom.exits.put(getOppositeDirection(direction), new Exit(getOppositeDirection(direction), this));
        }
    }



    /**
     * @param direction direction of the exit room.
     * @return returns the adjacent room according to direction.
     */
    public Room getExit(CommandDirection direction) {
        if(exits.get(direction) == null){
            return null;
        }
        return exits.get(direction).getAdjacentRoom();
    }

    /**
     * @return returns the all available exit rooms.
     */
    public String getAllExits() {
        StringBuilder allExits = new StringBuilder();

        /* It iterates through all available directions from enum Directions */
        /* If a certain direction exists in the current room then it appends the direction */
        for(CommandDirection direction : exits.keySet()) {
                allExits.append(direction.toString().toLowerCase()).append(" ");
        }

        return allExits.toString();
    }

    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param direction
     * @return returns opposite direction.
     */
    private CommandDirection getOppositeDirection(CommandDirection direction) {
        switch(direction) {
            case NORTH:
                return CommandDirection.SOUTH;

            case SOUTH:
                return CommandDirection.NORTH;

            case EAST:
                return  CommandDirection.WEST;

            case WEST:
                return CommandDirection.EAST;

            case UP:
                return CommandDirection.DOWN;

            case DOWN:
                return CommandDirection.UP;

            default:
                return CommandDirection.UNKNOWN;
        }

    }

}

class Exit {
    private CommandDirection direction;
    private Room adjacentRoom;

    public Exit(CommandDirection direction, Room adjacentRoom) {
        this.adjacentRoom = adjacentRoom;
        this.direction = direction;
    }

    public Room getAdjacentRoom() {
        return adjacentRoom;
    }

    public CommandDirection getDirection() {
        return direction;
    }
}
package game.map;

import game.command.CommandActionParam;
import game.command.Commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Map {
    private HashMap<String,Room> rooms;

    /**
     * Instanciates a map containing rooms loaded from a map file.
     * ------------------------------------------------------------------------
     * Map file must be columns formatted as such:
     *
     *      room_name, room_description, exit_direction, exit_room_name
     *      outside  , outside the uni., NORTH         , hallway
     *
     * The exit_direction and exit_room_name columns are optional and
     * to add more than 1 exit to a room you can just enumerate another pair:
     *
     *      outside,outside the uni.,NORTH,hallway,EAST,bathroom
     *                                              ^
     *                                           notice that an additional exit
     *                                           can be added
     * ---------------------------------------------------------------------------
     * @param mapFile .csv file which contains room information for map.
     */
    public Map(File mapFile) {
        rooms = new HashMap<String, Room>();
        initRooms(mapFile);
    }

    /**
     * @param roomName name of room.
     * @return Returns the room  according to room name.
     */
    public Room getRoom(String roomName) {
        return rooms.get(roomName);
    }

    /***
     * @return Returns a random room in the map.
     */
    public Room getRandomRoom() {
        Room[] roomArr = (Room[]) rooms.values().toArray();

        // Generates random index to select room.
        Random rand = new Random();
        int upperbound = roomArr.length-1;
        int randomIdx = rand.nextInt(upperbound);

        return roomArr[randomIdx];
    }

    /**
     * Creates, hashes and set exits from room descriptions from map .csv file.

     * @param mapFile .csv file which contains room information for map.
     */
    private void initRooms(File mapFile) {

        Commands commands = new Commands();
        String mapInfo[] = loadMapFromFile(mapFile);

        // Create new room.
        for(String roomInfo: mapInfo) {
            String[] roomInfoSplit = roomInfo.split(",");

            String name = roomInfoSplit[0];
            String description = roomInfoSplit[1];
            Room newRoom = new Room(name, description);

            // Hash rooms.
            rooms.put(name, newRoom);
        }

        // Assign exit(s) for new room.
        for(String roomInfo: mapInfo) {
            String[] roomInfoSplit = roomInfo.split(",");

            Room currentRoom = getRoom(roomInfoSplit[0]);

            // Assign exit(s) for new room.
            if(roomInfoSplit.length > 2) {
                for(int idx = 2; idx < roomInfoSplit.length; idx += 2) {

                    CommandActionParam direction = commands.getCommandParameter(roomInfoSplit[idx]);
                    Room adjacentRoom = rooms.get(roomInfoSplit[idx+1]);

                    currentRoom.setExit(direction, adjacentRoom);
                }
            }

        }



//        rooms.add(new Room("outside", "outside the main entrance of the university."));
//
//
//        Room outside, theater, bathroom, lab, office, hallwayFl1, hallwayFl2, stairwayFl1, stairwayFl2;
//
//
//
//        // create the rooms
//        outside = ;
//        theater = new Room("in a lecture theater.");
//        bathroom = new Room("in the bathroom.");
//        lab = new Room("in a computing lab.");
//        office = new Room("in the computing admin office.");
//        hallwayFl1 = new Room("in the 1st Floor hallway.");
//        hallwayFl2 = new Room("in the 2nd Floor hallway.");
//        stairwayFl1 = new Room("in the 1st Floor stairway.");
//        stairwayFl2 = new Room("in the 1st Floor stairway.");
//
//        // initialise room exits
//
//        outside.setExit(NORTH, hallwayFl1);
//        hallwayFl1.setExit(NORTH, stairwayFl1);
//        hallwayFl1.setExit(EAST, lab);
//        lab.setExit(SOUTH, office);
//        hallwayFl1.setExit(WEST, bathroom);
//        stairwayFl1.setExit(UP, stairwayFl2);
//        stairwayFl2.setExit(SOUTH, hallwayFl2);
//        stairwayFl2.setExit(EAST, theater);
//
//        currentRoom = outside;  // start game outside
    }

    /***
     * @param mapFile Path to .csv describing rooms and exits to construct map.
     * @return Returns array of room data.
     */
    private String[] loadMapFromFile(File mapFile){
        BufferedReader reader;
        String line;
        ArrayList<String> roomInfo = new ArrayList<String>();

        try {
            reader = new BufferedReader(new FileReader(mapFile));
            line = reader.readLine();

            while (line != null) {
                roomInfo.add(line);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  roomInfo.toArray(new String[roomInfo.size()]);
    }








}

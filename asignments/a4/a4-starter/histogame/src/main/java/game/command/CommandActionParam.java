package game.command;

public enum CommandActionParam {

    // GO parameters
    NORTH, EAST, SOUTH, WEST, UP, DOWN,

    // Utility
    UNKNOWN, EMPTY;

    /**
     * @param direction
     * @return returns opposite direction.
     */
    static public CommandActionParam getOppositeDirection(CommandActionParam direction) {
        switch(direction) {
            case NORTH:
                return CommandActionParam.SOUTH;

            case SOUTH:
                return CommandActionParam.NORTH;

            case EAST:
                return  CommandActionParam.WEST;

            case WEST:
                return CommandActionParam.EAST;

            case UP:
                return CommandActionParam.DOWN;

            case DOWN:
                return CommandActionParam.UP;

            default:
                return CommandActionParam.UNKNOWN;
        }

    }

}




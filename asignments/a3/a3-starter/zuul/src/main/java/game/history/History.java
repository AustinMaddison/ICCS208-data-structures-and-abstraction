package game.history;

import java.util.ArrayDeque;

public class History <T> {
    private ArrayDeque<T> states;

    public History() {
        states = new ArrayDeque<T>();
    }

    public T getCurrentState() {
        return states.getLast();
    }

    public void update(T room) {
        states.addLast(room);
    }

    public T undo() {
        return states.removeLast();
    }

    public int getSize() {
        return states.size();
    }
}

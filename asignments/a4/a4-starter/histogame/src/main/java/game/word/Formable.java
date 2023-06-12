package game.word;

public interface Formable<T> {
    public boolean canForm(T other);
}
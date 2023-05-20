class OffByN implements CharacterComparator {
    int n;

    // Ctor
    OffByN(int n) {
        this.n = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(Character.getNumericValue(x) - Character.getNumericValue(y)) == n;
    }
}
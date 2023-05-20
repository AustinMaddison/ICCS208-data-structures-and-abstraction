class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(Character.getNumericValue(x) - Character.getNumericValue(y)) == 1;
    }
}
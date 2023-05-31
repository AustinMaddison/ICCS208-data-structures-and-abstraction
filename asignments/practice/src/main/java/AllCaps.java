import java.util.ArrayList;

public class AllCaps {
    public static int[] allCapLocations(String st) {
        if(st == null) {
            return null;
        }
        ArrayList<Integer> positions = new ArrayList<Integer>();

        char begin = 'A';
        char end = 'Z';
        for(int stIdx = 0; stIdx < st.length(); stIdx++) {
            char currChar = st.charAt(stIdx);
            if(currChar >= begin & currChar <= end) {
                positions.add(stIdx);
            }
        }

        int[] result = positions.stream().mapToInt(i->i).toArray();
        return result;
    }
}

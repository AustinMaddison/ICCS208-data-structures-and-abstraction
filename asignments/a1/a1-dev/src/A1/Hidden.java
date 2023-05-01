package A1;
public class Hidden {
    public static boolean isHidden(String s, String t) {
        int sTargetLength = t.length();
        int matches = 0;
        for(int i = 0; i < s.length(); i++ ) {
            if( s.charAt(i) == t.charAt(matches) ) {
                matches ++;
                if(matches == sTargetLength)
                    return true;
            }
        }
        return false;
    }
}

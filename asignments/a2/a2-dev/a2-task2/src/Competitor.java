import java.util.*;

/**
 * Austin Maddison 6481268
 */


/*
 * The Competitor class represents a competitor in a dance competition. It keeps
 * attributes related to the competitor, including the competitor's scores from
 * dances.
 */
public class Competitor {

    // Do not modify or add the member variables
    private String aliasName;
    private ScoreKeeper poppingDanceScores;
    private ScoreKeeper hipHopDanceScores;
    private DanceCompetition competition;
    // -----------------------------------------
    
    // README: Implement the constructor and methods below. Feel free to add more
    // public methods such as getters and setters as necessary.

    // Competitor's constructor
    public Competitor() {
        this.aliasName = "";
        this.poppingDanceScores = new ScoreKeeper();
        this.hipHopDanceScores = new ScoreKeeper();
        this.competition = null;
    }

    // Set the alias name of the competitor
    public void setAlias(String name) {
        this.aliasName = name;
    }

    // Return the alias name of the competitor
    public String getAlias() {
        return this.aliasName;
    }
    
    // Record into the member variable poppingDanceScores a list of scores from the
    // judges (given as an array).
    public void setPoppingDanceScore(double[] scores) {
       this.poppingDanceScores.setScores(scores);
    }
    
    // Record into the member variable hipHopDanceScores a list of scores from the
    // judges (given as an array).
    public void setHipHopDanceScore(double[] scores) {
        this.hipHopDanceScores.setScores(scores);
    }

    // Set the competition to the given DanceCompetition object
    public void setDanceCompetition(DanceCompetition dc) {
        this.competition = dc;
    }
    
    // Print all recorded popping dance scores. The format is
    // [10.0, 9.0, 9.0, 9.0, 9.5, 9.5].
    public void printPoppingDanceScore() {
        System.out.println(Arrays.toString(this.poppingDanceScores.getScores()));
    }

    // Print all recorded hip-hop dance scores. The format is
    // [10.0, 9.0, 9.0, 9.0, 9.5, 9.5].
    public void printHipHopDanceScore() {
        System.out.println(Arrays.toString(this.hipHopDanceScores.getScores()));
    }

    // Return the average popping-dance score after excluding the minimum and
    // maximum. (Hint: Conveniently, the ScoreKeeper class has a matching method.)
    public double getPoppingDanceAverage() { 
        return this.poppingDanceScores.getCalibratedAverage();
    }

    // Return the average hip-hop score after excluding the minimum and
    // maximum. (Hint: Conveniently, the ScoreKeeper class has a matching method.)
    public double getHipHopDanceAverage() {
        return this.hipHopDanceScores.getCalibratedAverage();
    }

    // Return the weighted average of the dance scores. The weights are specified
    // in competition object as follows:
    //      p = competition.getPoppingDanceFraction();
    //      h = competition.getHipHopFraction();
    // If, however, the competition object is null, use p = 0.6 and h = 0.4.
    // Then, the weighted average is simply:
    //     p * (popping dance calibrated average) + h * (hip-hop dance calibrated average)
    // Remember that the calibrated average of a dance is the average computed after
    // excluding the min and the max.
    public double getTotalDanceScore() {
        double p , h;
        if(competition == null) {
            p = 0.6;
            h = 0.4;
        }
        else{
            p = this.competition.getPoppingDanceFraction();
            h = this.competition.getHipHopFraction();
        }

        return p * this.poppingDanceScores.getCalibratedAverage() +
                h * this.hipHopDanceScores.getCalibratedAverage();
    }


    public static void main(String[] args) {

        Competitor c1 = new Competitor();
        c1.setAlias("Peter C");
        c1.setPoppingDanceScore(new double[] {9.0,8.0,8.5,9.5,8.0,7.5});
        c1.setHipHopDanceScore(new double[] {10.0,9.0,9.5,8.0,8.5,9.0});

        System.out.println("=== "+c1.getAlias()+": Scores ===");
        System.out.println("[Popping]");
        c1.printPoppingDanceScore();
        System.out.println("AVG Popping Dance Score: "+c1.getPoppingDanceAverage());
        System.out.println("\n[Hip Hop]");
        c1.printHipHopDanceScore();
        System.out.println("AVG Hip Hop Dance Score: "+c1.getHipHopDanceAverage());
        System.out.println("\nTotal Score: " + c1.getTotalDanceScore());
        System.out.println("========================");


        Competitor c2 = new Competitor();
        c2.setAlias("Monkey D");
        c2.setPoppingDanceScore(new double[] {10.0,9.0,9.5,10.0,9.0,9.5});
        c2.setHipHopDanceScore(new double[] {10.0,9.0,9.0,9.0,9.5,9.5});

        System.out.println("\n=== "+c2.getAlias()+": Scores ===");
        System.out.println("[Popping]");
        c2.printPoppingDanceScore();
        System.out.println("AVG Popping Dance Score: "+c2.getPoppingDanceAverage());
        System.out.println("[Hip Hop]");
        c2.printHipHopDanceScore();
        System.out.println("AVG Hip Hop Dance Score: "+c2.getHipHopDanceAverage());
        System.out.println("\nTotal Score: " + c2.getTotalDanceScore());
        System.out.println("========================");
    }
}

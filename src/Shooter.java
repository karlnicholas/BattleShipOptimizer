
import org.apache.commons.math3.genetics.Chromosome;

public class Shooter extends Chromosome {
    private DecisionTree decisionTree;
    private int aveScore;
    private Counter c;
    private Ship ship;

    public Shooter() {
        c = new Counter();
        ship = new Ship();
        decisionTree = new DecisionTree();
        decisionTree.buildTree(c);
    }

    public Shooter(DecisionTree decisionTree) {
        c = new Counter();
        ship = new Ship();
        this.decisionTree = decisionTree;
    }

    // min, max, setters, getters
    public int getAveScore() {
        return aveScore;
    }
    public DecisionTree getDecisionTree() {
        return decisionTree;
    }
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("Shooter:"+aveScore+": [");
        ret.append(decisionTree.toString());
        return ret.append(']').toString();
    }

    @Override
    public double fitness() {
        int totalScores = 0;
        for (int play=0; play<100; ++play) {
            ship.newOrientation();
            ship.resetHits();
            c.reset();
            decisionTree.shoot(ship, c);
            totalScores = totalScores + c.i1;
        }
        aveScore = totalScores/100;
        // invert
        return 0-aveScore;
    }
}

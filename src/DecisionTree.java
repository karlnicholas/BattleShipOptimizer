

/**
 * A Node in the Shot Decision tree. Go to next node depending on whether the shot hit or missed
 * 
 * @author Karl Nicholas
 *
 */
public class DecisionTree {
    private static final int MAX_DEPTH = 10;
    private static final int MUTATE_PERCENT = 20;
    private DecisionTree hit;
    private DecisionTree miss;    
    private Position shot;
    
    public DecisionTree() {
        shot = new Position(
            (int)((Math.random()*6.0)-3), 
            (int)((Math.random()*6.0)-3)
        );
    }
    
    public DecisionTree(Position shot, DecisionTree hit, DecisionTree miss) {
        this.shot = new Position(shot.x, shot.y);
        this.hit = null; this.miss = null;
        if ( hit != null ) this.hit = hit.clone();
        if ( miss != null ) this.miss = miss.clone();
    }

    public DecisionTree clone() {
        return new DecisionTree(shot, hit, miss);
    }

    public void buildTree(Counter c) {
        if ( c.incI1() > MAX_DEPTH ) {
            hit = null;
            miss = null;
            c.decI1();
            return;
        } else {
            hit = new DecisionTree();
            hit.buildTree(c);
            miss = new DecisionTree();
            miss.buildTree(c);
        }
        c.decI1();
    }

    public void shoot(Ship ship, Counter c) {
        c.incI1();
        if ( ship.madeHit(shot)) {
            if ( c.incI2() == ship.getSize() ) return;
            if ( hit != null ) hit.shoot(ship, c);
        }
        else {
            if ( miss != null ) miss.shoot(ship, c);
        }
    }
    
    public DecisionTree mutate() {
        if ( (int)(Math.random() * 100.0) < MUTATE_PERCENT) {
            shot.x = (int)((Math.random()*6.0)-3);
            shot.y = (int)((Math.random()*6.0)-3);
        }
        if ( hit != null ) hit.mutate();
        if ( miss != null ) miss.mutate();
        return this;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(shot.toString());
        if ( hit != null ) sb.append("h:"+hit.toString());
        if ( miss != null ) sb.append("m:"+miss.toString());
        return sb.toString();
    }
}

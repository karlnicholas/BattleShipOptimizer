/**
 * Hold a position as an x,y coordinate
 * 
 * @author Karl Nicholas
 */
public class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object m) {
        return (((Position) m).x == x && ((Position) m).y == y);
    }
    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}


/**
 * A ship. Has an array of positions.
 * 
 * @author Karl Nicholas
 *
 */
public class Ship {
	// private class to keep track of hits
	private class Hit extends Position {
		boolean hit = false;
		Hit(int x, int y) {super(x, y);}
	}
	Hit[] positions;

	public Ship() {
		positions = new Hit[3];
		positions[0] = new Hit(0,0);
		positions[1] = new Hit(0,0);
		positions[2] = new Hit(0,0);
	}
	
	// need to reset the hits for each shooter test.
	public void resetHits() {
		for (Hit p: positions) {
			p.hit = false;
		}
	}
	// test if a hit was made, false if shot in spot already hit
	public boolean madeHit(Position shot) {
		for (Hit p: positions) {
			if ( p.equals(shot)) {
				if ( p.hit == false) {
					p.hit = true;
					return true;
				}
				return false;
			}
		}
		return false;
	}

	// make a new orientation
	public int newOrientation() {
		int shipInX=0, oShipInX=0 , shipInY=0, oShipInY=0;
		// make a random ship orientation.
		int orient = (int) (Math.random() * 4.0);
		if( orient == 0 ) {
			oShipInX = 1;
			shipInX = 0-(int)(Math.random()*3.0);
		}
		else if ( orient == 1 ) {
			oShipInX = -1;
			shipInX = (int)(Math.random()*3.0);
		}
		else if ( orient == 2 ) {
			oShipInY = 1;
			shipInY = 0-(int)(Math.random()*3.0);
		}
		else if ( orient == 3 ) {
			oShipInY = -1;
			shipInY = (int)(Math.random()*3.0);
		}

		// make the positions of the ship
		for (int i = 0; i < 3; ++i) {
			positions[i].x = shipInX;
			positions[i].y = shipInY;
			if (orient == 2 || orient == 3)
				shipInY = shipInY + oShipInY;
			else
				shipInX = shipInX + oShipInX;
		}
		return orient;
	}

	public int getSize() {
		return positions.length;
	}
}




/**
 * A helper class to keep track of how deep the code is in the decision tree.
 * 
 * @author Karl Nicholas.
 *
 */
public class Counter {
	int i1;
	int i2;
	
	public Counter() {reset();}
	public void reset() {i1=0;i2=0;}

	public int incI1() { return ++i1; }
	public int incI2() { return ++i2; }
	public int decI1() { return --i1; }
	public int decI2() { return --i2; }
}

public class UniqueList extends IntegerList {
	
	public UniqueList() {
		super();
	}
	
	public UniqueList(int capacity) {
		super(capacity);
	}

	public void add(int integer) {
        if (super.indexOf(integer) == -1) {
        	super.insert(super.size(), integer);
        } else {
        	throw new IllegalArgumentException("The integer " + integer + " is already in the list.");
        }
	}
	
	public void insert(int index, int integer) {
        if (super.indexOf(integer) == -1) {
        	super.insert(index, integer);
        } else {
        	throw new IllegalArgumentException("The integer " + integer + " is already in the list.");
        }
	}
	
}

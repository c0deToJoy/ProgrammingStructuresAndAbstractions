
public class RangeList extends IntegerList {

	public RangeList() {
		super();
	}
	
	public RangeList(int lowerBound, int upperBound) {
		super();
		if(lowerBound > upperBound) {
			throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
		}
		for(int i = lowerBound; i <= upperBound; i++) {
			super.insert(super.size(), i);
		}
	}
	
	public void add(int lowerBound, int upperBound) {
		if(lowerBound > upperBound) {
			throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
		}
		if (super.size() == 0) {
	        for (int i = lowerBound; i <= upperBound; i++) {
	            super.insert(super.size(), i);
	        }
	    } 
		else {
			if (lowerBound < super.get(0)) {
			    for (int i = super.get(0); i > lowerBound; i--) {
			        super.insert(0, i - 1);
			    }
			}
	        if (upperBound > super.get(super.size() - 1)) {
	            for (int i = super.get(super.size() - 1) + 1; i <= upperBound; i++) {
	                super.insert(super.size(), i);
	            }
	        }
	    }
	}
	
	public void remove(int lowerBound, int upperBound) {
	    if (lowerBound > upperBound) {
	        throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
	    } 
	    else if (super.size() == 0) {
	        throw new UnsupportedOperationException("Cannot remove range from an empty list.");
	    } 
	    else if (lowerBound < super.get(0) || upperBound > super.get(super.size() - 1)) {
	        throw new IllegalArgumentException("Lower and/or upper bounds are out of the current list range.");
	    } 
	    else {
	        int start = super.indexOf(lowerBound);
	        int end = super.indexOf(upperBound);
	        for (int i = end; i >= start; i--) {
	            super.remove(i);
	        }
	    }
	}
	
	public void insert(int index, int integer) {
		throw new UnsupportedOperationException();
	}
	
	public void add(int integer) {
		throw new UnsupportedOperationException();
	}
	
}


public class Triangle {

	private double sideA;
	private double sideB;
	private double sideC;
	public final static String POLYGONSHAPE = "Triangle";
	public final static double DEFAULT_SIDE = 1.0;
	
	public Triangle() {
		this.sideA = DEFAULT_SIDE;
		this.sideB = DEFAULT_SIDE;
		this.sideC = DEFAULT_SIDE;
	}
	
	public Triangle(double sideA, double sideB, double sideC) {
		if(isTriangle(sideA, sideB, sideC)== false) {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
		else {
			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;
		}
	}
	
	public Triangle(double[] sides) {
		if(isTriangle(sides) == false) {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
		else {
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
		}
	}
	
	public Triangle(Triangle triangle) {
		if(triangle == null) {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
		else {
			this.sideA = triangle.sideA;
			this.sideB = triangle.sideB;
			this.sideC = triangle.sideC;
		}
	}

	public double getSideA() {
		return sideA;
	}
	
	public double getSideB() {
		return sideB;
	}
	
	public double getSideC() {
		return sideC;
	}
	
	public double[] getSides() {
		double[] sides = new double[3];
		sides[0] = this.sideA;
		sides[1] = this.sideB;
		sides[2] = this.sideC;
		return sides;
	}
	
	public double getAngleA() {
		double angleA = lawOfCosines(this.sideB, this.sideC, this.sideA);
		return angleA;
	}
	
	public double getAngleB() {
		double angleB = lawOfCosines(this.sideC, this.sideA, this.sideB);
		return angleB;
	}
	
	public double getAngleC() {
		double angleC = lawOfCosines(this.sideA, this.sideB, this.sideC);
		return angleC;
	}
	
	public double[] getAngles() {
		double[] angles = new double[3];
		angles[0] = getAngleA();
		angles[1] = getAngleB();
		angles[2] = getAngleC();
		return angles;
	}

	public boolean setSideA(double sideA) {
	    if (isTriangle(sideA, this.sideB, this.sideC)) {
	        this.sideA = sideA;
	        return true;
	    }
	    return false;
	}

	public boolean setSideB(double sideB) {
	    if (isTriangle(this.sideA, sideB, this.sideC)) {
	        this.sideB = sideB;
	        return true;
	    }
	    return false;
	}

	public boolean setSideC(double sideC) {
	    if (isTriangle(this.sideA, this.sideB, sideC)) {
	        this.sideC = sideC;
	        return true;
	    }
	    return false;
	}
	
	public boolean setSides(double[] sides) {
	    if (isTriangle(sides) == false) {
	        return false;
	    } 
	    else {
	        this.sideA = sides[0];
	        this.sideB = sides[1];
	        this.sideC = sides[2];
	        return true;
	    }
	}
	
	public static boolean isTriangle(double a, double b, double c) {
		if(a <= 0 || b <= 0 || c <= 0 || a + b <= c || b + c <= a || c + a <= b) {
			return false;
		}
		return true;
	}
	
	public static boolean isTriangle(double[] sides) {
		if(sides == null || sides.length != 3 || sides[0] <= 0 || sides[1] <= 0 || sides[2] <= 0 || sides[0] + sides[1] <= sides[2] || sides[1] + sides[2] <= sides[0] || sides[2] + sides[0] <= sides[1]) {
			return false;
		}
		return true;
	}
	
	public static double lawOfCosines(double a, double b, double c) {
		double angle = Math.acos((a*a+b*b-c*c)/(2*a*b));
		return Math.toDegrees(angle);
	}
	
	public String toString() {
		String message = POLYGONSHAPE + String.format("(%.4f, %.4f, %.4f)", this.sideA, this.sideB, this.sideC);
		return message;
	}
	
	
}

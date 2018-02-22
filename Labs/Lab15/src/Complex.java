
public class Complex {
	//complex number = a+bi, i -> sqrt(-1)
	private double a = 0.0;
	private double b = 0.0;
	private static String i = "i";
	
	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}
	public Complex(double a) { //complex object with 0 for b
		this.a = a;
		//this.b = 0;
	}
	public Complex() { //complex object for 0
		//this.a = 0;
		//this.b = 0;
	}
	
	public String toString() { //returns (a+bi) as a String
	//if b is 0, just returns a
		if(this.b==0) {
			return (this.a+"");
		} else {
			return (this.a+"+"+this.b+i);
		}
	}
	
	//methods to compute
	//overrides (uses toString()) to return the number
	public String add(Complex y) {
		Complex res = new Complex();
		res.a = (this.a)+(y.a);
		res.b = (this.b)+(y.b);
		return res.toString();
	}
	public String subtract(Complex y) {
		Complex res = new Complex();
		res.a = (this.a)-(y.a);
		res.b = (this.b)-(y.b);
		return res.toString();
	}
	public String multiply(Complex y) {
		Complex res = new Complex();
		res.a = (this.a*y.a)-(this.b*y.b);
		res.b = (this.b*y.a)+(this.a*y.b);
		return res.toString();
	}
	public String divide(Complex y) {
		Complex res = new Complex();
		res.a = (this.a*y.a+this.b*y.b)/(2*y.a+2*y.b);
		res.b = (this.b*y.a)-(this.a*y.b);
		return res.toString()+"/"+(2*y.a+2*y.b);
	}
	
	public String getRealPart() { //return a
		return this.a+"";
	}
	public String getImaginaryPart() { //return bi
		return this.b+i;
	}
	
	
}


public class Fan {
	public static int SLOW = 1;
	public static int MEDIUM = 2;
	public static int FAST = 3;
	
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	private String color = "blue";
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int s) {
		speed = s;
	}
	
	public boolean getOn() {
		return on;
	}
	public void setOn(boolean b) {
		on = b;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double r) {
		radius  = r;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String c) {
		color = c;
	}
	
	public Fan() {
		
	}
	
	public String toString() {
		String result = "";
		if(on==true) {
			result = speed + " " + color + " " + radius;
		} else {
			result = color + " " + radius + " fan is off";
		}
		return result;
	}
	
}


public class sinCosDegreeTable {
	public static void main (String[] args) {
		int i;
		
		
		System.out.println("Degree   Sin             Cos");
		
		for (i=0; i<=360; i+=10) {
			
		System.out.format("%d %s %.4f %s %.4f \n",
				i , "\t" , Math.sin(Math.toRadians(i)) , "\t" , Math.cos(Math.toRadians(i)));
		
		
		
		}
		
	}
}

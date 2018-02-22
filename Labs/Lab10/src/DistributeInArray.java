import java.util.Arrays;
public class DistributeInArray {
	public static void main(String[] args) {
		int[] v  = {3,1,6,2,4,1,5};
		distribute(v,2);
		System.out.println(Arrays.toString(v));
		
	}
	
	public static void distribute(int[] values, int start_index) {
		int count = values[start_index]; //how many times 1 is added to the next indexes
		values[start_index] = 0;
		int j;
		int k = 0;
		//if (start_index+count < values.length) {
			for (j = start_index+1; j<=count+start_index; j++) {
				if (j<values.length) {
				values[j] = values[j]+1;
				} else {
					//for (k = 0; k<(count-((values.length-1)-(start_index))); k++) {
					values[k] = values[k]+1;
					k++;
					//}
					//break;
				}
			}
		/*} else { //would have to loop around
			for (int j = start_index+1; j<values.length; j++) {
				values[j] = values[j]+1;
			}
			for (int j = 0; j<count-((values.length-1)-(start_index)); j++) {
				values[j] = values[j]+1;
			}
		}*/
		
		
	}
	
}

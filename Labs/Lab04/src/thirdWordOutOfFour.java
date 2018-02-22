import java.util.Scanner; 
public class thirdWordOutOfFour {
	public static void main (String[] args) {
		String sentence;
		int start = 0;
		int space;
		int i;
		int beforeS = 0;
		int afterS = 0;
		
		System.out.print("Please enter a sentence with at least four words: ");
		Scanner input = new Scanner(System.in);
		sentence = input.nextLine();
		
		for(i=0; i<3; i++ ) { //would searching through each letter(char) in the String be more efficient?
			space = sentence.indexOf(' ',start);
			start = space+1; 
			if (i==1) {
				beforeS = space;
			} else if (i==2) {
				afterS = space;
			}
		}
		
		System.out.println("The third word is "+ sentence.substring(beforeS+1 , afterS));
	
		
	}

}

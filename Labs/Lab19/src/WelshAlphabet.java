import java.util.Scanner;
import java.util.ArrayList;
public class WelshAlphabet {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a Welsh word: ");
		String w = input.next();
		//ArrayList<String> print = welshLetters(w);
		System.out.println("Welsh letters:" + welshLetters(w).size());
		//welshLetters(w);
		System.out.print(welshLetters(w));
		
		
	}
	
	public static ArrayList<String> welshLetters(String word) {
		ArrayList<String> ans = new ArrayList<>();
		String[] diagraphs = {"ch","dd","ff","ng","ll","ph","rh","th"};
		for(int p = 0; p<word.length();p++) { //read through word, letters in pairs
		boolean found = false;	
			for(int d = 0; d<diagraphs.length; d++) { //checks diagraphs
				if(p<word.length()-1) { //by 2s
					String letters = word.charAt(p)+""+word.charAt(p+1)+"";
					if(letters.equals(diagraphs[d])) { //add the diagraph
						ans.add(letters);
						found = true;
						p++; //skip the next letter
						break;
					} 
				}
			}
			if(found==false) {
				ans.add(word.charAt(p)+"");
			}
			
		}
		
		return ans;
	}
	
}

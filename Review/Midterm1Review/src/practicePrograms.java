
public class practicePrograms {
	public static void main (String[] args) {
		String message = "I LIKE CSE114";
		String originalKey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		int shift = 3;
		String newKey = "";
		
		for(int k = 0; k<originalKey.length(); k++) {
			if( (k+shift)>originalKey.length()-1 ) { 
				newKey = newKey + originalKey.charAt(k+shift-36);
			} else {
				newKey = newKey + originalKey.charAt(k+shift);

			}
		} 
		
		//String newKey = "DEFGHIJKLMNOPQRSTUVWXYZ1234567890ABC";
		
		for(int i = 0; i<message.length();i++) {
			if(message.charAt(i)==' ') {
				System.out.print(" ");
			} else {
				System.out.print( newKey.charAt(originalKey.indexOf(message.charAt(i))) );	
				//System.out.print(originalKey.indexOf(message.charAt(i)) );
			}
		}
		
	}
	
}

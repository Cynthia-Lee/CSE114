//Name: Cynthia Lee
//ID: 111737790
import java.util.Scanner;
import java.io.File;
import java.io.*;
public class markdownToHTML {
	public static void main (String[] args) {
		//int blankLines = 0;
		//boolean currentParagraph = false;
		boolean processingList = false;
		//try block (in case file cannot be found)
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the name of the (plain text) input file: ");
		String in = input.next();
		System.out.print("Enter the name of the (plain text) output file: ");
		String ou = input.next();
		FileWriter fw = null; PrintWriter pw = null; Scanner fs = null;
		//answer output 
		File outFile = new File(ou);
		try {
			File inputFile = new File(in);	
			fs = new Scanner(inputFile); //Scanner fs = new Scanner(inputFile).useDelimeter("\\R");	
		
			//File ans = new File("answer.txt");
			//PrintWriter pw = new PrintWriter(ans);
			fw = new FileWriter(outFile, false); 
			pw = new PrintWriter(fw); 
		} catch (FileNotFoundException ex){
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
			//String result = "";
			//when line has been checked of each Markdown tag, append to "results" String or 
			//print it directly to output file via PrintWriter object
				
			//BEGIN HTML "boilerplate"
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>Results of Markdown Translation</title>");
			pw.println("</head>");
			pw.println("<body>");
			//pw.println();
			pw.flush();
			while(fs.hasNextLine()) { //Markdown-to-HTML transition code here
				String line = fs.nextLine(); //read the next line of the file
				
				//make sure to specify new paragraphs <p> (two or more consecutive blank lines)
				//PARAGRAPHS
/*					if(line.equals("")&&(currentParagraph==false)) { //counting blank lines, no paragraph
						blankLines++;	
					} else if(line.equals("")&&currentParagraph) { //encounters blank while paragraph
						pw.print("</p>"); //close the paragraph
						pw.flush();
						blankLines = 0; //reset
					} else if(!line.equals("")){ //hits a non blank
						if(blankLines>=2&&(currentParagraph==false)) { //can start paragraph
							pw.print("<p>");
							pw.flush();
							currentParagraph = true;	
						} else { //cannot start paragraph, reset count
						blankLines = 0;
						}
					} */
					if(line.equals("")&&processingList==false) {
						pw.print("<p>");
						pw.flush();
					}
						
					//BULLETED LIST
					//list has new lines
					if(line.startsWith("+ ")&&(processingList==false)) {
						//if encounter a list and not currently processing list, give <ul> 
						pw.println("<ul>");
						pw.flush();
						String s = line.substring(line.indexOf("+ ")+2);
						pw.println(translateListItem(s));
						pw.flush();
						processingList = true;
					} else if(processingList&&line.startsWith("+ ")) {
						String s = line.substring(line.indexOf("+ ")+2);
						pw.println(translateListItem(s));
						pw.flush();
					} else if(processingList&&
							( (!(line.startsWith("+ ")))||line.equals("") ) 
							) { //or ends on a list later
					//if currently processing list and encounter line that is not a list, end list </ul>
						pw.println("</ul>");
						//pw.println("");
						pw.flush();
						processingList = false;
						if(line.equals("")) { //prints <p> after
							pw.println("<p>");
							pw.flush();
						}
					} else {
				
				//if not a blank line or list, do other things
				for(int i = 0; i<line.length(); i=i+0) {	
					if((line.charAt(i)+"").equals("*")&&line.substring(i).contains("**")&&
							line.substring(line.indexOf("**",i)+2).contains("**")) { //EMPHASIS strong 
						int firstIndex = i+2;
						int secondIndex = line.indexOf("**",firstIndex);
						String s = line.substring(firstIndex,secondIndex);
						pw.print(translateStrongEmphasis(s));
						pw.flush();
						i = secondIndex+2;
					} else if(line.charAt(i)=='*') { //EMPHASIS em
						int firstIndex = i+1;
						int secondIndex = line.indexOf("*",firstIndex);
						String s = line.substring(firstIndex,secondIndex);
						pw.print(translateEmphasis(s));
						pw.flush();
						i = secondIndex+1;
					} else if ((line.charAt(i)+"").equals("!")&&
							line.substring(i).contains("![")&&
							(line.substring(line.indexOf("[")).contains("]("))&&
							(line.substring(line.indexOf("](")).contains("]"))) { //images 
						String imagePath = line.substring(line.indexOf("(",i)+1,line.indexOf(" \"",i));
						String alternateText = line.substring(i+2,line.indexOf("]",i));
						int firstQuote = line.indexOf("\"",i);
						String imageTitleText = line.substring(firstQuote+1,line.indexOf("\"",firstQuote+1)); 
						pw.print(translateImage(alternateText, imagePath, imageTitleText));
						pw.flush();
						i = line.indexOf(")",i)+1;
					} else if ((line.charAt(i)=='[')) { //hyper links
						String text = line.substring(i+1,line.indexOf("](",i));
						String url = line.substring(line.indexOf("(",i)+1,line.indexOf(")",i));
						pw.print(translateHyperLink(text, url));
						pw.flush();
						i = line.indexOf(")",i)+1;
					} else if ((line.charAt(i)+"").equals("`")) { //code
						int firstIndex = i+1;
						int secondIndex = line.indexOf("`",firstIndex);
						String s = line.substring(firstIndex,secondIndex);
						pw.print(translateCode(s));
						pw.flush();
						i = secondIndex+1;
					} else {
						pw.print(line.charAt(i));
						pw.flush();
						i++;
					}
				}
				
				pw.println("");
				pw.flush();
							
					//needs to check if these symbols appear twice
				/*	if(line.contains("**")&&
							line.substring(line.indexOf("**")).contains("**")) { //strong
						int firstIndex = line.indexOf("**")+2;
						int secondIndex = line.indexOf("**",firstIndex);
						String s = line.substring(firstIndex,secondIndex);
						pw.print(translateStrongEmphasis(s));
					} else if (line.contains("*")&&
							line.substring(line.indexOf("*")).contains("*")) { //em
						int firstIndex = line.indexOf("*")+1;
						int secondIndex = line.indexOf("*",firstIndex);
						String s = line.substring(firstIndex,secondIndex);
						pw.print(translateEmphasis(s));
					} 
					
					//IMAGES
					if(line.contains("![")&&
							(line.substring(line.indexOf("[")).contains("]("))&&
							(line.substring(line.indexOf("](")).contains("]"))
							) { //block of text
						String imagePath = line.substring(line.indexOf("(")+1,line.indexOf(" \""));
						String alternateText = line.substring(line.indexOf("[")+1,line.indexOf("]"));
						String imageTitleText = line.substring(line.indexOf("\"")+1,line.indexOf("\"")); 
						result += translateImage(alternateText, imagePath, imageTitleText);
					}
					
					//HYPER LINKS
					if(line.contains("[")&&
							(line.substring(line.indexOf("[")).contains("]("))&&
							(line.substring(line.indexOf("](")).contains("]"))
							) { //block of text
						String text = line.substring(line.indexOf("[")+1,line.indexOf("]("));
						String url = line.substring(line.indexOf("(")+1,line.indexOf(")"));
						result += translateHyperLink(text, url);
					}
				
					//CODE TAGS
					if(line.contains("'")&&
							line.substring(line.indexOf("'")).contains("'")) { 
						int firstIndex = line.indexOf("'")+1;
						int secondIndex = line.indexOf("'",firstIndex);
						String s = line.substring(firstIndex,secondIndex);
						result += translateCode(s);
					}
				
					*/
					
					}
				}	
			//if last line was part of a list, close it up
			if(processingList) { //or ends on a list
				//if currently processing list and encounter line that is not a list, end list </ul>
				pw.println("</ul>");
				pw.flush();
			} 
/*			if (currentParagraph) {
				pw.println("</p>"); //close the paragraph
				pw.flush();
			} */
			
			
			////END HTML "boilerplate" CLOSING TAGS
			pw.println("</body>");
			pw.println("</html>");
			pw.flush();
			pw.close();
				
			
		
	
	}
	
	//methods here:
	public static String translateEmphasis(String s) {
		return "<em>" + s + "</em>";
	}
	
	public static String translateStrongEmphasis(String s) {
		return "<strong>" + s + "</strong>";
	}
	
	public static String translateHyperLink(String text, String url) {
		return "<a href=\""+url+"\">"+text+"</a>";
	}
	
	public static String translateImage(String altText,String imagePath,String imageTitleText) {
		return "<img src=\""+imagePath+"\""+" alt=\""+altText+"\" title=\""+imageTitleText+"\">";
	}
	
	public static String translateCode(String s) {
		return "<code>" + s + "</code>";
	}
	
	public static String translateListItem(String s) { //ln<ul> ln</ul> outside of the whole list
		return "<li>" + s + "</li>";
	}
	
}

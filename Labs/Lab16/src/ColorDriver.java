
public class ColorDriver {
	public static void main (String[] args) {
		//color instance
		Color trueBlue = new Color(0,0,255,"true blue");
		System.out.println("Color name: "+trueBlue.getColorName());
		System.out.println("Values of color object: "+trueBlue.getRed()+" "+trueBlue.getGreen()+" "+trueBlue.getBlue());
		System.out.println();
		//AlphaChannelColor instance
		AlphaChannelColor salmon = new AlphaChannelColor(250,128,114,215,"salmon");
		System.out.println("Color name: "+salmon.getColorName());
		System.out.println("Values of alpha color object: "+salmon.getRed()+" "+salmon.getGreen()+" "+salmon.getBlue());
		System.out.println();
		
		AlphaChannelColor color1 = new AlphaChannelColor(20,50,10,55);
		System.out.println("Color name: "+color1.getColorName());
		System.out.println("Values of alpha color object: "+color1.getRed()+" "+color1.getGreen()+" "+color1.getBlue());
	}
}

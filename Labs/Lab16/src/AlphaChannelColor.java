
public class AlphaChannelColor extends Color{
	private int transparency; //0-255 (0 = opaque)
	
	public AlphaChannelColor(int r, int g, int b, int tra) {
		super(r,g,b);
		transparency = tra;
	}
	
	public AlphaChannelColor(int r, int g, int b, int tra, String name) {
		super(r,g,b,name);
		transparency = tra;
	}
	
	public String getColorName() {
		String prefix = "";
		if (transparency<100) {
			prefix = "opaque";
		} else if (transparency>=100 && transparency<=199) {
			prefix = "semi-transparent";
		} else {
			prefix = "transparent";
		}
		
		if(super.getColorName()==null) {
			return prefix+" color";
		} else {
			return prefix+" "+super.getColorName();
		}
	}
}

package littleTownFiles;
import java.awt.Color;
public class Appearance {

	private int attractiveness = 0;
	private final int MAX_ATTRACTIVENESS = 20 , MIN_ATTRACTIVENESS = -20; 
	private Color hairColor, skinColor;
	private boolean hasFreckles;
	private boolean hasBlush;
	
	public Appearance() {
		// will sets values to random ones
	}
	public boolean gethasBlush() {
		return hasBlush;
	}
	
	public boolean gethasFreckles() {
		
		return hasFreckles;
	}
	
	public Color getHairColor () {
		return this.hairColor ;
	}
	
	public Color getSkinColor () {
		return this.skinColor ;
	}
	
	public int getAttract() {

	   return this.attractiveness;
	}
	
	public boolean sethasBlush(boolean blush) {
		hasBlush = blush;
		return hasBlush;
	}
	
	public boolean sethasFreckles(boolean freckles) {
		
		hasFreckles = freckles ; 
		return hasFreckles;
	}
	
	public void setHairColor(Color hairColor) {
		this.hairColor = hairColor;
	}
	
	public void setSkinColor (Color skinColor ) {
		this.skinColor = skinColor;
	}
	
	public int setAttract( int attract) {
		
	   if ( attract > MAX_ATTRACTIVENESS)
		   this.attractiveness = MAX_ATTRACTIVENESS;
	   else if ( attract < MIN_ATTRACTIVENESS)
		   this.attractiveness = MIN_ATTRACTIVENESS;
	   else
		   this.attractiveness = attract;
	   return this.attractiveness;
	}
	
}

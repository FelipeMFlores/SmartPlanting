package settingsRepo;

public class Coordinates {
	public int RightDownCornerX;
	public int RightDownCornerY;
	public int LeftUpCornerX;
	public int LeftUpCornerY;
	
	public Coordinates(int RightDownCornerX, int RightDownCornerY, int LeftUpCornerX, int LeftUpCornerY){
		this.RightDownCornerX = RightDownCornerX;
		this.RightDownCornerY = RightDownCornerY;
		this.LeftUpCornerX = LeftUpCornerX;
		this.LeftUpCornerY = LeftUpCornerY;
	}
}

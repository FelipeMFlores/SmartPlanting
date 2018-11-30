package reportsRepo;

public class Report {
	private static int idgenerator = 0; //for generating a new id
	private int id;
	private int type; //1:Drone, 2: SoilAnalisys
	private int terrainID; //terrain that the report is about
	private String text; //report itself
	
	public Report(){
		this.id = idgenerator++;
	}
	
	public Report(int type, int terrainID, String text){
		this.id = idgenerator++;
		this.type = type;
		this.terrainID = terrainID;
		this.text = text;
	}
	
	//for cloning another report
	public Report(Report original){
		this.id = original.getID();
		this.type = original.getType();
		this.terrainID = original.getTerrainID();
		this.text = original.getText();	
	}
	
	public int getID(){return id;}
	
	public int getType(){return type;}
	public void setType(int type){this.type = type;}
	
	public int getTerrainID(){return terrainID;}
	public void setTerrainID(int terrainID){this.terrainID = terrainID;}
	
	public String getText(){return text;}
	public void setText(String text){this.text = text;}

	//two reports with the same id's are equal.
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
        if (getClass() != obj.getClass()) return false;
		
        Report other = (Report) obj;
        return id == other.getID();  
	}	
	
	
}

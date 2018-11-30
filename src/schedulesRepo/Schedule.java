package schedulesRepo;


public class Schedule {

	private static int idgenerator = 0; //for generating new id
	private int id;
	private int date;//YYYYMMDD
	private int terrainID;
	
	public Schedule(){
		id = idgenerator++;
	}
	
	public Schedule(Schedule original) { //cloning
		id = original.getId();
		date = original.getDate();
		terrainID = original.getTerrainID();
	}
	
	public Schedule(int date,int terrainID) {
		id = idgenerator++;
		this.date = date;
		this.terrainID = terrainID;
	}
	
	
	//two schedules with the same id's are equal.
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
        if (getClass() != obj.getClass()) return false;
		
        Schedule other = (Schedule) obj;
        return id == other.getId();  
	}
	
	
	//Getters & Setters
	
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getTerrainID() {
		return terrainID;
	}
	public void setTerrainID(int terrainID) {
		this.terrainID = terrainID;
	}
	public int getId() {
		return id;
	}
	
}

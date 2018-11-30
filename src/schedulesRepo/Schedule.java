package schedulesRepo;


public class Schedule {

	private static int idgenerator = 0;
	private int id;
	private int date;
	private int terrainID;
	
	public Schedule(){
		id = idgenerator++;
	}
	
	public Schedule(Schedule original) { //cloning
		id = original.getId();
		date = original.getDate();
		terrainID = original.getTerrainID();
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

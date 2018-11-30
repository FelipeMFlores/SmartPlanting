package agrotoxicRepo;


//a object Agrotoxic is about the ideals informations
//of a agrotoxic in a plant.
public class Agrotoxic {
	private static int idgenerator = 0; //for generating id's
	private int id;
	private String agrotoxicName;
	private String agrotoxicCompost;
	private String plant;
	private int agrotoxicAmount;
	
	
	public Agrotoxic(){
		id = idgenerator++;
	}
	
	public Agrotoxic(Agrotoxic original){ //Cloning
		  id = original.getId();
		  agrotoxicName = original.getAgrotoxicName();
		  agrotoxicCompost = original.getAgrotoxicCompost();
		  plant = original.plant;
		  agrotoxicAmount = original.agrotoxicAmount;
	}
	
	
	//two Agrotoxics with the same id's are equal.
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
        if (getClass() != obj.getClass()) return false;
		
        Agrotoxic other = (Agrotoxic) obj;
        return id == other.getId();  
	}	
	
	
	
	
	//Getters & Setters
	
	public String getAgrotoxicName() {
		return agrotoxicName;
	}
	public void setAgrotoxicName(String agrotoxicName) {
		this.agrotoxicName = agrotoxicName;
	}
	public String getAgrotoxicCompost() {
		return agrotoxicCompost;
	}
	public void setAgrotoxicCompost(String agrotoxicCompost) {
		this.agrotoxicCompost = agrotoxicCompost;
	}
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public int getAgrotoxicAmount() {
		return agrotoxicAmount;
	}
	public void setAgrotoxicAmount(int agrotoxicAmount) {
		this.agrotoxicAmount = agrotoxicAmount;
	}
	public int getId() {
		return id;
	}
	
	
}

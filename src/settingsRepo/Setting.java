package settingsRepo;


public class Setting {
	private static int idgenerator = 0; //for generating id's
	private int terrainID;
	private Coordinates coord;
	private int intervalDays; //of between agrotoxic apply
	private String agrotoxicName;
	private String mainChemCompost;
	private int amount; //of agrotoxic 
	private String product; //product that is planted in the terrain
	private int irrigationLimit;
	
	public Setting(){
		terrainID = idgenerator++;
	}
	
	public Setting(Setting original){ //cloning
	  terrainID = original.getTerrainID();
	  coord = original.getCoord();
	  intervalDays = original.getIntervalDays();
	  agrotoxicName = original.getAgrotoxicName();
	  mainChemCompost = original.getMainChemCompost();
	  amount = original.getAmount();
	  product = original.getProduct();
	  irrigationLimit = original.getIrrigationLimit();
		
	}

	//two settings with the same id's are equal.
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
        if (getClass() != obj.getClass()) return false;
		
        Setting other = (Setting) obj;
        return terrainID == other.getTerrainID();  
	}	
	
	
	
	//Getter & Setters
	
	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public int getTerrainID() {
		return terrainID;
	}

	public int getIntervalDays() {
		return intervalDays;
	}

	public void setIntervalDays(int intervalDays) {
		this.intervalDays = intervalDays;
	}

	public String getAgrotoxicName() {
		return agrotoxicName;
	}

	public void setAgrotoxicName(String agrotoxicName) {
		this.agrotoxicName = agrotoxicName;
	}

	public String getMainChemCompost() {
		return mainChemCompost;
	}

	public void setMainChemCompost(String mainChemCompost) {
		this.mainChemCompost = mainChemCompost;
	}


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getIrrigationLimit() {
		return irrigationLimit;
	}

	public void setIrrigationLimit(int irrigationLimit) {
		this.irrigationLimit = irrigationLimit;
	}

}

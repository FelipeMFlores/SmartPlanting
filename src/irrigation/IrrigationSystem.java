package irrigation;

import reportsRepo.ReportsDAO;
import reportsRepo.ReportsDAOImpl;
import settingsRepo.SettingsDAO;
import settingsRepo.SettingsDAOImpl;
import soilQualitysRepo.IdealSoilQualitiesDAO;
import soilQualitysRepo.IdealSoilQualitiesDAOImpl;

public class IrrigationSystem {
	private static int idgenerator = 0; //for generating unique id's.
	private int id;
	private int terrainID; //terrain in which the irrigation system are in.
	private int litersSpent = 0;

	
	public IrrigationSystem(){
		id = idgenerator++;
	}
	public IrrigationSystem(int terrainID){
		id = idgenerator++;
		this.terrainID = terrainID;
	}
	
	/********
	 Returns the product of the terrain from the settings repository.
	 "" if any error occur.
	 ******/
	private String getProductofTerrain(){
		try {
			SettingsDAO settingsRepo = new SettingsDAOImpl();
			String product;
			product = settingsRepo.getSetting(terrainID).getProduct();
			return product;
		}catch(NullPointerException e) {
			return "";
		}
		
		
	}
	
	
	/********
	 Returns the Irrigation Limit of the terrain from the settings repository.
	 -1 if any error occur.
	 ******/
	private int getIrrigationLimitofTerrain() {
		try{
			SettingsDAO settingsRepo = new SettingsDAOImpl();
			int irrigatioLimit;
			irrigatioLimit = settingsRepo.getSetting(terrainID).getIrrigationLimit();
			return irrigatioLimit;
		}catch(NullPointerException e) {
			return -1;
		}
	}
	
	
	/********
	 Returns the Latest Analysis of the terrain from the reports repository.
	 "" if any error occur.
	 ******/
	private String getLatestAnalysis() {
		try {
			ReportsDAO reportsRepo = new ReportsDAOImpl();
			return reportsRepo.getLatestReport(2, terrainID).getText();
		}catch(NullPointerException e) {
			return "";
		}
	}
	
	
	/********
	 Returns the Humidity of the text in the report format.  ("Humidity : XXX ; NutrientLevels : XXX ; AgrotoxicRate : XXX ;")
	 -1 if any error occur.
	 ******/
	private int readHumidityReport(String text) {
		try {
			String [] words = text.split(" ");
			return Integer.parseInt(words[2]);
		}catch(ArrayIndexOutOfBoundsException e) {
			return -1;
		}
		
	}
	
	
	/********
	 Returns the Ideal Humidity of the terrain from the Ideal Soil Qualities repository.
	 -1 if any error occur.
	 ******/
	private int getIdealHumidity(String plant) {
		try {
			IdealSoilQualitiesDAO sqRepo = new IdealSoilQualitiesDAOImpl();
			return sqRepo.getRegister(plant).getHumidity();
		}catch(NullPointerException e) {
			return -1;
		}
	}
	
	
	//turns on the irrigation system
	public void turnOn(int amountOfWater) {//fazer algo com dummy. adicionar umidade, algo do tipo.
		litersSpent += amountOfWater;
	}

	
	//check if the soil needs water, if it does, turn on the irrigators.
	public void controlHumidity() {
		int irrigationLimit = getIrrigationLimitofTerrain();
		String  plant = getProductofTerrain();
		int idealHumidity = getIdealHumidity(plant);
		String latestReport = getLatestAnalysis();
		int currentHumidity =  readHumidityReport(latestReport);
		
		if(idealHumidity < currentHumidity) {
			if(irrigationLimit > litersSpent + (idealHumidity - currentHumidity) ) {
				turnOn(idealHumidity - currentHumidity);
			}
			else
				turnOn(irrigationLimit - currentHumidity);
		}
		
	}
	

	
	
	//Getter & Setters;
	public int getTerrainID() {
		return terrainID;
	}
	public void setTerrainID(int terrainID) {
		this.terrainID = terrainID;
	}

	public int getLitersSpent() {
		return litersSpent;
	}
	public void setLitersSpent(int litersSpent) {
		this.litersSpent = litersSpent;
	}
	public int getId() {
		return id;
	} 

}

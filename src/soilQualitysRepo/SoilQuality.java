package soilQualitysRepo;


//class about the ideal conditions of the soil for a plant
public class SoilQuality {
	private String plant;
	private int nutrientLevels;
	private int humidity;

	
	public SoilQuality(SoilQuality original){ //cloning
		plant = original.getPlant();
		nutrientLevels = original.getNutrientLevels();
		humidity = original.getHumidity();

	}
	
	public SoilQuality(String plant, int nutrientLevels, int humidity) {
		this.plant = plant;
		this.nutrientLevels = nutrientLevels;
		this.humidity = humidity;
	}
	
	//two SoilQuality with the same plant are equal.
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
        if (getClass() != obj.getClass()) return false;
		
        SoilQuality other = (SoilQuality) obj;
        return plant.equals(other.getPlant());  
	}	

	
	//Getters & Setters
	
	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public int getNutrientLevels() {
		return nutrientLevels;
	}

	public void setNutrientLevels(int nutrientLevels) {
		this.nutrientLevels = nutrientLevels;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
}

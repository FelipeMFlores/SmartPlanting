package soilQualitysRepo;

import java.util.LinkedList;
import java.util.List;


public class IdealSoilQualitiesDAOImpl implements IdealSoilQualitiesDAO {
	
	private LinkedList<SoilQuality> idealSoilQualities = new LinkedList<SoilQuality>();

	
	/*********
	returns true if success, 
	and false if there is a register with the same plant in the repository.
	**********/
	@Override
	public boolean addRegister(SoilQuality soilQuality) {
		if(idealSoilQualities.indexOf(soilQuality) != -1) return false;
		idealSoilQualities.add(soilQuality); 
		return true;
	}

	
	/*********
	returns true if success, 
	and false if there is'nt a register with the same plant in the repository.
	**********/
	@Override
	public boolean deleteRegister(String plant) {
		return idealSoilQualities.removeIf(s -> s.getPlant().equals(plant));
	}

	
	
	/*********
	returns true if success, 
	and false if there is'nt a register with the same plant in the repository.
	The update is based on the plant, therefore you can't change it.
	**********/
	@Override
	public boolean updateRegister(SoilQuality soilQuality) {
		int index = idealSoilQualities.indexOf(soilQuality);
		if(index == -1) return false;
		idealSoilQualities.set(index, soilQuality);
		return true;
	}
	
	
	
	/*********
	returns the register if success, 
	and null if there is'nt a register with the same plant in the repository.
	**********/
	@Override
	public SoilQuality getRegister(String plant) {
		for (SoilQuality soilQuality : idealSoilQualities) {
		    if (plant.equals(soilQuality.getPlant())) {
		    	SoilQuality soilQualityClone = new SoilQuality(soilQuality);
		    	return soilQualityClone;
		    }
		}
		return null;
	}

	
	/*********
	returns all the registers.
	Returns empty list if there is'nt any register in the repository.
	**********/
	@Override
	public List<SoilQuality> getAllRegisters() {
		List<SoilQuality> listClone = new LinkedList<SoilQuality>();
		for(SoilQuality soilQuality : idealSoilQualities) {
			SoilQuality clone = new SoilQuality(soilQuality);
				listClone.add(clone);
		}
		
		return listClone;
	}

}

package soilQualitysRepo;

import java.util.List;

public interface IdealSoilQualitiesDAO {
	
	
	/*********
	returns true if success, 
	and false if there is a register with the same plant in the repository.
	**********/
	public boolean addRegister(SoilQuality soilQuality);
	
	/*********
	returns true if success, 
	and false if there is'nt a register with the same plant in the repository.
	**********/
	public boolean deleteRegister(String plant);
	
	/*********
	returns true if success, 
	and false if there is'nt a register with the same plant in the repository.
	The update is based on the plant, therefore you can't change it.
	**********/
	public boolean updateRegister(SoilQuality soilQuality);
	
	/*********
	returns the register if success, 
	and null if there is'nt a register with the same plant in the repository.
	**********/
	public SoilQuality getRegister(String plant);
	
	/*********
	returns all the registers.
	Returns empty list if there is'nt any register in the repository.
	**********/
	public List<SoilQuality> getAllRegisters();
	

}

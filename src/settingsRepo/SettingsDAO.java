package settingsRepo;
import java.util.List;

public interface SettingsDAO{
	
	/*********
	returns true if success, 
	and false if there is a setting with the same id in the repository.
	**********/
	public boolean addSetting(Setting setting);
	
	
	/*********
	returns true if success, 
	and false if there is'nt a setting with the same id in the repository.
	**********/
	public boolean deleteSetting(int terrainID);
	
	/*********
	returns true if success, 
	and false if there is'nt a setting with the same id in the repository.
	The update is based on the id, therefore you can't change it.
	**********/
	public boolean updateSetting(Setting setting);
	
	/*********
	returns the setting if success, 
	and null if there is'nt a report with the same id in the repository.
	**********/
	public Setting getSetting(int terrainID);
	
	/*********
	returns all the setting.
	Returns empty list if there is'nt any setting in the repository.
	**********/
	public List<Setting> getAllSettings(); 
	
}

package settingsRepo;
import java.util.LinkedList;
import java.util.List;


public class SettingsDAOImpl implements SettingsDAO {
	
	private LinkedList<Setting> settings;

	public SettingsDAOImpl(){
		settings = new  LinkedList<Setting>();
	}
	
	
	
	/*********
	returns true if success, 
	and false if there is a setting with the same id in the repository.
	**********/
	@Override
	public boolean addSetting(Setting setting) {
		if(settings.indexOf(setting) != -1) return false;
		settings.add(setting); 
		return true;
	}

	
	/*********
	returns true if success, 
	and false if there is'nt a setting with the same id in the repository.
	**********/
	@Override
	public boolean deleteSetting(int terrainID) {
		return settings.removeIf(s -> s.getTerrainID() == terrainID);
	}

	
	/*********
	returns true if success, 
	and false if there is'nt a setting with the same id in the repository.
	The update is based on the id, therefore you can't change it.
	**********/
	@Override
	public boolean updateSetting(Setting setting) {
		int index = settings.indexOf(setting);
		if(index == -1) return false;
		settings.set(index, setting);
		return true;
	}

	
	
	/*********
	returns the setting if success, 
	and null if there is'nt a report with the same id in the repository.
	**********/
	@Override
	public Setting getSetting(int terrainID) {
		for (Setting setting : settings) {
		    if (terrainID == setting.getTerrainID()) {
		        Setting settingClone = new Setting(setting);
		    	return settingClone;
		    }
		}
		return null;
	}

	
	/*********
	returns all the setting.
	Returns null is there is'nt any setting in the repository.
	**********/
	@Override
	public List<Setting> getAllSettings() {
		List<Setting> listClone = new LinkedList<Setting>();
		for(Setting setting : settings) {
		    	Setting clone = new Setting(setting);
				listClone.add(clone);
		}
		
		return listClone;
	
	}

	
}

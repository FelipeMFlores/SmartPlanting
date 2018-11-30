package agrotoxicRepo;

import java.util.LinkedList;
import java.util.List;


public class AgrotoxicsDAOImpl implements AgrotoxicsDAO {

	private LinkedList<Agrotoxic> agrotoxics;
	
	public AgrotoxicsDAOImpl() {
		agrotoxics = new LinkedList<Agrotoxic>();
	}
	
	
	/*********
	returns true if success, 
	and false if there is a Agrotoxic with the same id in the repository.
	**********/
	@Override
	public boolean addAgrotoxic(Agrotoxic agrotoxic) {
		if(agrotoxics.indexOf(agrotoxic) != -1) return false;
		agrotoxics.add(agrotoxic); 
		return true;
	}

	
	/*********
	returns true if success, 
	and false if there is'nt a Agrotoxic with the same id in the repository.
	**********/
	@Override
	public boolean deleteAgrotoxic(int id) {
		return agrotoxics.removeIf(a -> a.getId() == id);
	}

	
	/*********
	returns true if success, 
	and false if there is'nt a Agrotoxic with the same id in the repository.
	The update is based on the id, therefore you can't change it.
	**********/
	@Override
	public boolean updateAgrotoxic(Agrotoxic agrotoxic) {
		int index = agrotoxics.indexOf(agrotoxic);
		if(index == -1) return false;
		agrotoxics.set(index, agrotoxic);
		return true;
	}

	
	/*********
	returns the Agrotoxic if success, 
	and null if there is'nt a Agrotoxic with the same id in the repository.
	**********/
	@Override
	public Agrotoxic getAgrotoxic(int id) {
		for (Agrotoxic agrotoxic : agrotoxics) {
		    if (id == agrotoxic.getId()) {
		    	Agrotoxic agrotoxicClone = new Agrotoxic(agrotoxic);
		    	return agrotoxicClone;
		    }
		}
		return null;
	}

	
	/*********
	returns all the Agrotoxic. 
	Returns empty list if there is'nt any reAgrotoxicport in the repository.
	**********/
	@Override
	public List<Agrotoxic> getAllAgrotoxics() {
		List<Agrotoxic> listClone = new LinkedList<Agrotoxic>();
		for(Agrotoxic agrotoxic : agrotoxics) {
			Agrotoxic clone = new Agrotoxic(agrotoxic);
				listClone.add(clone);
		}
		
		return listClone;
	}

}

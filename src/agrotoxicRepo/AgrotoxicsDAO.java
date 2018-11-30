package agrotoxicRepo;

import java.util.List;

public interface AgrotoxicsDAO {

	
	/*********
	returns true if success, 
	and false if there is a Agrotoxic with the same id in the repository.
	**********/
	public boolean addAgrotoxic(Agrotoxic agrotoxic);
	
	
	/*********
	returns true if success, 
	and false if there is'nt a Agrotoxic with the same id in the repository.
	**********/
	public boolean deleteAgrotoxic(int id);
	
	/*********
	returns true if success, 
	and false if there is'nt a Agrotoxic with the same id in the repository.
	The update is based on the id, therefore you can't change it.
	**********/
	public boolean updateAgrotoxic(Agrotoxic agrotoxic);
	
	/*********
	returns the Agrotoxic if success, 
	and null if there is'nt a Agrotoxic with the same id in the repository.
	**********/
	public Agrotoxic getAgrotoxic(int id);
	
	/*********
	returns all the Agrotoxic. 
	Returns null is there is'nt any reAgrotoxicport in the repository.
	**********/
	public List<Agrotoxic> getAllAgrotoxics();
	
}

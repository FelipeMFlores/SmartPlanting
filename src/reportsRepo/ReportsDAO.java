package reportsRepo;
import java.util.List;

public interface ReportsDAO {

	/*********
	returns true if success, 
	and false if there is a report with the same id in the repository.
	**********/
	boolean addReport(Report report);
	
	/*********
	returns true if success, 
	and false if there is'nt a report with the same id in the repository.
	**********/
	boolean deleteReport(int id);
	
	/*********
	returns true if success, 
	and false if there is'nt a report with the same id in the repository.
	The update is based on the id, therefore you can't change it.
	**********/
	boolean updateReport(Report report);
	
	
	/*********
	returns the report if success, 
	and null if there is'nt a report with the same id in the repository.
	**********/
	Report getReport(int id);
	
	/*********
	returns the last report with the same type and terrainID added to the repository.
	If type is 0, returns of any type.
	If terrainID is 0, returns of any terrain.
	Returns null is there is'nt any report of the parameters specified.
	**********/
	Report getLatestReport(int type, int terrainID);
	
	/*********
	returns all the reports with the same type and terrainID.
	If type is 0, returns of any type.
	If terrainID is 0, returns of any terrain.
	Returns null is there is'nt any report in the repository.
	**********/
	List<Report> getAllReports(int type, int terrainID);
}

package reportsRepo;
import java.util.List;
import java.util.LinkedList;

public class ReportsDAOImpl implements ReportsDAO{
	private LinkedList<Report> reports;
	
	ReportsDAOImpl(){
		reports = new  LinkedList<Report>();
	}
	
	
	/*********
	returns true if success, 
	and false if there is a report with the same id in the repository.
	**********/
	@Override
	public boolean addReport(Report report) {
		if(reports.indexOf(report) != -1) return false;
		reports.add(0,report); //add to the front of the list.
		return true;
	}
	
	
	/*********
	returns true if success, 
	and false if there is'nt a report with the same id in the repository.
	**********/
	@Override
	public boolean deleteReport(int id) {
		return reports.removeIf(r -> r.getID() == id);
	}
	
	
	/*********
	returns true if success, 
	and false if there is'nt a report with the same id in the repository.
	The update is based on the id, therefore you can't change it.
	**********/
	@Override
	public boolean updateReport(Report report){
		int index = reports.indexOf(report);
		if(index == -1) return false;
		reports.set(index, report);
		return true;
	}	
	
	/*********
	returns the report if success, 
	and null if there is'nt a report with the same id in the repository.
	**********/
	@Override
	public Report getReport(int id) {
		for (Report report : reports) {
		    if (id == report.getID()) {
		        Report reportClone = new Report(report);
		    	return reportClone;
		    }
		}
		return null;
	}
	
	
	/*********
	returns the last report with the same type and terrainID added to the repository.
	If type is 0, returns of any type.
	If terrainID is 0, returns of any terrain.
	Returns null is there is'nt any report of the parameters specified.
	**********/
	@Override
	public Report getLatestReport(int type, int terrainID) {
		for(Report report : reports) {
		    if ((type == report.getType() || type == 0) &&
		    	(terrainID == report.getTerrainID()
		    						|| terrainID == 0)) {
		    	
		        Report reportClone = new Report(report);
		    	return reportClone;
		    }
		}
		
		return null;
	}
	
	/*********
	returns all the reports with the same type and terrainID.
	If type is 0, returns of any type.
	If terrainID is 0, returns of any terrain.
	Returns null is there is'nt any report in the repository.
	**********/	
	@Override
	public List<Report> getAllReports(int type, int terrainID ){
		List<Report> listClone = new LinkedList<Report>();
		for(Report report : reports) {
		    if ((type == report.getType() || type == 0) &&
			    	(terrainID == report.getTerrainID()
			    						|| terrainID == 0)) {
				Report clone = new Report(report);
				listClone.add(clone);
		    }
		}
		return listClone;
	}
	
	
	
}

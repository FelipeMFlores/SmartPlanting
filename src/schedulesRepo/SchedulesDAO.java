package schedulesRepo;

import java.util.List;

public interface SchedulesDAO {

	
	
	/*********
	returns true if success, 
	and false if there is a schedule with the same id in the repository.
	**********/
	public boolean addSchedule(Schedule schedule);
	
	
	/*********
	returns true if success, 
	and false if there is'nt a schedule with the same id in the repository.
	**********/
	public boolean deleteSchedule(int id);
	
	
	/*********
	returns true if success, 
	and false if there is'nt a schedule with the same id in the repository.
	The update is based on the id, therefore you can't change it.
	**********/
	public boolean updateSchedule(Schedule schedule);
	
	
	/*********
	returns the schedule if success, 
	and null if there is'nt a schedule with the same id in the repository.
	**********/
	public Schedule getSchedule(int id);
	
	
	/*********
	returns the schedule with the lowest date, 
	and null if there is'nt any schedule in the repository.
	**********/
	public Schedule getNextSchedule();
	
	
	/*********
	returns all the schedules.
	Returns empty list if there is'nt any schedule in the repository.
	**********/
	public List<Schedule> getAllSchedules();
}

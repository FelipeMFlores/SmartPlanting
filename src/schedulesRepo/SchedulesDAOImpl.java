package schedulesRepo;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class SchedulesDAOImpl implements SchedulesDAO {

	private LinkedList<Schedule> schedules;
	
	public SchedulesDAOImpl() {
		schedules = new LinkedList<Schedule>();
	}
	
	
	/*********
	returns true if success, 
	and false if there is a schedule with the same id in the repository.
	**********/
	@Override
	public boolean addSchedule(Schedule schedule) {
		if(schedules.indexOf(schedule) != -1) return false;
		schedules.add(schedule); 
		return true;
	}

	/*********
	returns true if success, 
	and false if there is'nt a schedule with the same id in the repository.
	**********/
	@Override
	public boolean deleteSchedule(int id) {
		return schedules.removeIf(s -> s.getId() == id);
	}

	
	/*********
	returns true if success, 
	and false if there is'nt a schedule with the same id in the repository.
	The update is based on the id, therefore you can't change it.
	**********/
	@Override
	public boolean updateSchedule(Schedule schedule) {
		int index = schedules.indexOf(schedule);
		if(index == -1) return false;
		schedules.set(index, schedule);
		return true;
	}

	
	
	/*********
	returns the schedule if success, 
	and null if there is'nt a schedule with the same id in the repository.
	**********/
	@Override
	public Schedule getSchedule(int id) {
		for (Schedule schedule : schedules) {
		    if (id == schedule.getId()) {
		    	Schedule scheduleClone = new Schedule(schedule);
		    	return scheduleClone;
		    }
		}
		return null;
	}
	
	class SortbyDate implements Comparator<Schedule> 
	{ 
	    // Used for sorting in ascending order of date
	    public int compare(Schedule a, Schedule b) 
	    { 
	        return a.getDate() - b.getDate(); 
	    } 
	} 
	
	
	/*********
	returns the schedule with the lowest date, 
	and null if there is'nt any schedule in the repository.
	**********/
	@Override
	public Schedule getNextSchedule() {
		// Sorting
		Collections.sort(schedules, new SortbyDate());
		Schedule original = schedules.peekFirst();
		if(original == null) return null;
		Schedule clone = new Schedule(original);
		return clone;
	}

	
	/*********
	returns all the schedules.
	Returns empty list if there is'nt any schedule in the repository.
	**********/
	@Override
	public List<Schedule> getAllSchedules() {
		List<Schedule> listClone = new LinkedList<Schedule>();
		for(Schedule schedule : schedules) {
				Schedule clone = new Schedule(schedule);
				listClone.add(clone);
		}
		
		return listClone;
	}





}

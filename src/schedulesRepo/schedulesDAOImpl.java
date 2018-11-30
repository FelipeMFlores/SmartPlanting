package schedulesRepo;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class schedulesDAOImpl implements SchedulesDAO {

	private LinkedList<Schedule> schedules;
	
	public schedulesDAOImpl() {
		schedules = new LinkedList<Schedule>();
	}
	
	
	@Override
	public boolean addSchedule(Schedule schedule) {
		if(schedules.indexOf(schedule) != -1) return false;
		schedules.add(schedule); 
		return true;
	}

	@Override
	public boolean deleteSchedule(int id) {
		return schedules.removeIf(s -> s.getId() == id);
	}

	@Override
	public boolean updateSchedule(Schedule schedule) {
		int index = schedules.indexOf(schedule);
		if(index == -1) return false;
		schedules.set(index, schedule);
		return true;
	}

	
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
	    // Used for sorting in ascending order of 
	    // roll number 
	    public int compare(Schedule a, Schedule b) 
	    { 
	        return a.getDate() - b.getDate(); 
	    } 
	} 
	
	@Override
	public Schedule getNextSchedule() {
		// Sorting
		Collections.sort(schedules, new SortbyDate());
		Schedule original = schedules.peekFirst();
		if(original == null) return null;
		Schedule clone = new Schedule(original);
		return clone;
	}

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

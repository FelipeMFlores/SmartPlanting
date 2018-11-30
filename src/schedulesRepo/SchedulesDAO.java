package schedulesRepo;

import java.util.List;

public interface SchedulesDAO {

	public boolean addSchedule(Schedule schedule);
	public boolean deleteSchedule(int id);
	public boolean updateSchedule(Schedule schedule);
	public Schedule getSchedule(int id);
	public Schedule getNextSchedule();
	public List<Schedule> getAllSchedules();
}

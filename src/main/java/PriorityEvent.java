import java.util.GregorianCalendar;

import calendar.Meeting;
import calendar.MeetingCalendar;

public class PriorityEvent extends CalendarEvent {

	
	public PriorityEvent(String description, String location, GregorianCalendar startTime, GregorianCalendar endTime) {
		super(description, location, startTime, endTime);
		// TODO Auto-generated constructor stub
	}

	public void scheduleEvent(MeetingCalendar cal) {
		Meeting M = new Meeting(getDescription(), getLocation(), getStartTime(), getEndTime());
		cal.addMeeting(M, true);
		
	}
}

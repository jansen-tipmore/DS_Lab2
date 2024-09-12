import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public class WeeklyEvent extends CalendarEvent {
	private GregorianCalendar repeatUntil;

	/**
	 * @param endTime
	 * @param startTime
	 * @param location
	 * @param description
	 * @param repeatUntil
	 */
	public WeeklyEvent(GregorianCalendar endTime, GregorianCalendar startTime, String location, String description,
			GregorianCalendar repeatUntil) {
		super(endTime, startTime, location, description);
		this.setRepeatUntil(repeatUntil);
	}

	public GregorianCalendar getRepeatUntil() {
		return repeatUntil;
	}

	public void setRepeatUntil(GregorianCalendar repeatUntil) {
		this.repeatUntil = repeatUntil;
	}
	public void sceduleEvent(MeetingCalendar cal) {
		
	}

	@Override
	public void scheduleEvent(MeetingCalendar cal) {
		// TODO Auto-generated method stub
		
	}
}

import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public class MultiDayPerWeekEvent extends CalendarEvent {
	private GregorianCalendar repeatUntil;
	private int days;
	/**
	 * @param endTime
	 * @param startTime
	 * @param location
	 * @param description
	 * @param repeatUntil
	 * @param days
	 */
	public MultiDayPerWeekEvent(GregorianCalendar endTime, GregorianCalendar startTime, String location,
			String description, GregorianCalendar repeatUntil, int days) {
		super(endTime, startTime, location, description);
		this.setRepeatUntil(repeatUntil);
		this.setDays(days);
	}
	public GregorianCalendar getRepeatUntil() {
		return repeatUntil;
	}
	public void setRepeatUntil(GregorianCalendar repeatUntil) {
		this.repeatUntil = repeatUntil;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public void scheduleEvent(MeetingCalendar cal) {
		
	}
}

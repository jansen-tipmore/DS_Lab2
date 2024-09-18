import java.util.GregorianCalendar;
import calendar.MeetingCalendar;

public abstract class CalendarEvent {
	private GregorianCalendar endTime;
	private GregorianCalendar startTime;
	private String location;
	private String description;
	/**
	 * @return the endTime
	 */
	public GregorianCalendar getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(GregorianCalendar endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the startTime
	 */
	public GregorianCalendar getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(GregorianCalendar startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param endTime
	 * @param startTime
	 * @param location
	 * @param description
	 */
	public CalendarEvent(String description, String location, GregorianCalendar startTime, GregorianCalendar endTime) {
		super();
		this.description = description;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public abstract void scheduleEvent(MeetingCalendar cal);

}

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calendar.Meeting;
import calendar.MeetingCalendar;

class CalendarEventTest {
	OneTimeEvent A; 
	MultiDayPerWeekEvent B;
	PriorityEvent C;
	WeeklyEvent D;
	OneTimeEvent E;
	
	GregorianCalendar startA;
	GregorianCalendar endA;
	GregorianCalendar startB;
	GregorianCalendar endB;
	GregorianCalendar startC;
	GregorianCalendar endC;
	GregorianCalendar startD;
	GregorianCalendar endD;
	GregorianCalendar startAB;
	GregorianCalendar endAB;
	GregorianCalendar endBC;
	
	int[] weekDays = {2,4,6};
	
	MeetingCalendar cal;

	Meeting AM;
	Meeting BM;
	Meeting CM;
	Meeting ABM;
	Meeting BCM;
	
	@BeforeEach
	void setUp() throws Exception {
		startA = new GregorianCalendar(2024, 9, 11, 12, 00);
		endA = new GregorianCalendar(2024, 9, 11, 13, 00);
		startB = new GregorianCalendar(2024, 9, 13, 7, 00);
		endB = new GregorianCalendar(2024, 9, 13, 7, 59);
		startC = new GregorianCalendar(2025, 1, 1, 9, 10);
		endC = new GregorianCalendar(2025, 1, 1, 9, 15);
		startD = new GregorianCalendar(2100, 12, 30, 9, 00);
		endD = new GregorianCalendar(2100, 12, 30, 9, 01);
		
		A = new OneTimeEvent("A", "LocationA", startA, endA);
		B = new MultiDayPerWeekEvent("B", "LocationB", startB, endB, endD, weekDays);
		C = new PriorityEvent("C", "LocationC", startC, endC);
		D = new WeeklyEvent("D", "LocationD", startA, endA, endD);
		E = new OneTimeEvent("E", "LocationE", startC, endC);
		
		cal = new MeetingCalendar();
		
		startAB = new GregorianCalendar(2023,8,28,9,00);
		endAB = new GregorianCalendar(2023,8,28,10,00);
		endBC = new GregorianCalendar(2023,8,28,11,00);
		
		
		AM = new Meeting("A", "LocationA", endA, endA);
		BM = new Meeting("B","LocationB",endA,endB);
		CM = new Meeting("C","LocationC",endB,endC);

		
		ABM = new Meeting("AB","ABLoc",startAB,endAB);
		BCM = new Meeting("BC","BCLoc",endAB,endBC);

		
	}

	@Test
	public void testOneTimeEvent() {
		assertEquals("A", A.getDescription());
		assertEquals("LocationA", A.getLocation());
		assertEquals(startA, A.getStartTime());
		assertEquals(endA, A.getEndTime());
	}
	
	@Test
	public void testPriorityEvent() {
		assertEquals("C", C.getDescription());
		assertEquals("LocationC", C.getLocation());
		assertEquals(startC, C.getStartTime());
		assertEquals(endC, C.getEndTime());
	}
	
	@Test
	public void testWeeklyEvent() {
		assertEquals("D", D.getDescription());
		assertEquals("LocationD", D.getLocation());
		assertEquals(startA, D.getStartTime());
		assertEquals(endA, D.getEndTime());
		assertEquals(endD, D.getRepeatUntil());
	}
	
	@Test
	public void testMultiDayPerWeekEvent() {
		assertEquals("B", B.getDescription());
		assertEquals("LocationB", B.getLocation());
		assertEquals(startB, B.getStartTime());
		assertEquals(endB, B.getEndTime());
		assertEquals(endD, B.getRepeatUntil());
		assertArrayEquals(weekDays, B.getDays());
	}
	
	@Test
	public void testOneTimeScheduleEvent() {
		A = new OneTimeEvent("A", "Location A", startA, endA);
		A.scheduleEvent(cal);
		
		Meeting Alien = new Meeting("Alien", "LocationAlien", startA, endA);
		assertEquals(A.getDescription(), cal.findMeeting(endA).getDescription());
		
		
	}
	
	@Test
	public void testPriorityScheduleEvent() {
		
	}
	
	@Test
	public void testWeeklyEventSchedule() {
		//D.scheduleEvent(cal);
		
	}
	@Test
	public void testMultiDayPerWeekScheduleEvent() {
		
	}

}

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
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
	OneTimeEvent F;
	
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
	GregorianCalendar startF;
	GregorianCalendar endF;
	GregorianCalendar endDE;
	
	int[] weekDays = {Calendar.MONDAY, Calendar.WEDNESDAY};
	

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
		startD = new GregorianCalendar(2024, 9, 15, 7, 00);
		endDE = new GregorianCalendar(2024, 9, 15, 7, 59);
		endD = new GregorianCalendar(2024, 9, 20, 9, 01);
		startF = new GregorianCalendar(2024, 9, 18, 12, 00);
		endF = new GregorianCalendar(2024, 9, 18, 13, 00);
		
		A = new OneTimeEvent("A", "LocationA", startA, endA);
		B = new MultiDayPerWeekEvent("B", "LocationB", startB, endB, endD, weekDays);
		C = new PriorityEvent("C", "LocationC", startC, endC);
		D = new WeeklyEvent("D", "LocationD", startA, endA, endD);
		E = new OneTimeEvent("E", "LocationE", startC, endC);
		F = new OneTimeEvent("F", "LocationF", startF, endF);
		
		
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
		MeetingCalendar cal = new MeetingCalendar();
		A = new OneTimeEvent("A", "Location A", startA, endA);
		A.scheduleEvent(cal);		
		assertEquals(A.getDescription(), cal.findMeeting(startA).getDescription());
		E = new OneTimeEvent("E", "LocationE", startA, endA);
		E.scheduleEvent(cal);
		assertEquals(A.getDescription(), cal.findMeeting(startA).getDescription());
	}
	
	@Test
	public void testPriorityScheduleEvent() {
		MeetingCalendar cal2 = new MeetingCalendar();
		A = new OneTimeEvent("A", "Location A", startA, endA);
		A.scheduleEvent(cal2);
		assertEquals(A.getDescription(), cal2.findMeeting(startA).getDescription());
		C = new PriorityEvent("C", "LocationC", startA, endA);
		C.scheduleEvent(cal2);
		assertEquals(C.getDescription(), cal2.findMeeting(startA).getDescription());
	}
	
	@Test
	public void testWeeklyEventSchedule() {
		MeetingCalendar cal3 = new MeetingCalendar();
		MeetingCalendar cal5 = new MeetingCalendar();
		GregorianCalendar weekLater = new GregorianCalendar(2024, 9, 18, 12, 00);
		GregorianCalendar twoWeekLater = new GregorianCalendar(2024, 9, 25, 12, 00);
		D = new WeeklyEvent("D", "LocationD", startA, endA, endD);
		D.scheduleEvent(cal3);
		assertEquals(D.getDescription(), cal3.findMeeting(startA).getDescription());
		assertEquals(D.getDescription(), cal3.findMeeting(weekLater).getDescription());
		assertNull(cal3.findMeeting(twoWeekLater));
		A = new OneTimeEvent("A", "LocationA", startA, endA);
		A.scheduleEvent(cal5);
		D.scheduleEvent(cal5);
		assertEquals(A.getDescription(), cal5.findMeeting(startA).getDescription());
		
	}
	@Test
	public void testMultiDayPerWeekScheduleEvent() {
		MeetingCalendar cal4 = new MeetingCalendar();
		MeetingCalendar cal6 = new MeetingCalendar();
		B = new MultiDayPerWeekEvent("B", "LocationB", startB, endB, endD, weekDays);
		GregorianCalendar firstDay = new GregorianCalendar(2024, 9, 14, 7, 00);
		GregorianCalendar firstDayEnd = new GregorianCalendar(2024, 9, 14, 7, 30);
		GregorianCalendar secondDay = new GregorianCalendar(2024, 9, 16, 7, 00);
		GregorianCalendar thirdDay = new GregorianCalendar(2024, 9, 17, 7, 00);
		GregorianCalendar fourthDay = new GregorianCalendar(2024, 9, 21, 7, 00);
		B.scheduleEvent(cal4);
		assertEquals(B.getDescription(), cal4.findMeeting(firstDay).getDescription());
		assertEquals(B.getDescription(), cal4.findMeeting(secondDay).getDescription());
		assertNull(cal4.findMeeting(thirdDay));
		assertNull(cal4.findMeeting(fourthDay));
		A = new OneTimeEvent("A", "LocationA", firstDay, firstDayEnd);
		A.scheduleEvent(cal6);
		B.scheduleEvent(cal6);
		assertEquals(A.getDescription(), cal6.findMeeting(firstDay).getDescription());
		
	}

}

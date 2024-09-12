import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalendarEventTest {
	CalendarEvent A; 
	CalendarEvent B;
	CalendarEvent C;
	CalendarEvent D;
	
	GregorianCalendar startA;
	GregorianCalendar endA;
	GregorianCalendar startB;
	GregorianCalendar endB;
	GregorianCalendar startC;
	GregorianCalendar endC;
	GregorianCalendar startD;
	GregorianCalendar endD;
	
	int[] weekDays = {2,4,6};
	
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
		D = new WeeklyEvent("D", "LocationD", startA, endB, endD);
		
		
	}
	
	
	@Test
	final void testGetEndTime() {
		fail("Not yet implemented");
	}

	@Test
	final void testSetEndTime() {
		fail("Not yet implemented");
	}

	@Test
	final void testGetStartTime() {
		fail("Not yet implemented");
	}

	@Test
	final void testSetStartTime() {
		fail("Not yet implemented");
	}

	@Test
	final void testGetLocation() {
		fail("Not yet implemented");
	}

	@Test
	final void testSetLocation() {
		fail("Not yet implemented");
	}

	@Test
	final void testGetDescription() {
		fail("Not yet implemented");
	}

	@Test
	final void testSetDescription() {
		fail("Not yet implemented");
	}

	@Test
	final void testCalendarEvent() {
		fail("Not yet implemented");
	}

	@Test
	final void testScheduleEvent() {
		fail("Not yet implemented");
	}

}

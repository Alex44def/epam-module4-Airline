package ru.epam.jonline.module4.simple_class.airline.enam;

public enum DaysWeek {
	SUNDAY("Sunday"),
	MONDAY("Monday"),
	TUESDAY("Tuesday"),
	WEDNESDAY("Wednesday"),
	THURSDAY("Thursday"),
	FRIDAY("Friday"),
	SATURDAY("Saturday");
	
	String day;
	
	private DaysWeek() {
		this.day = "Monday";
	}

	private DaysWeek(String day) {
		this.day = day;
	}

	public String getDay() {
		return day;
	}

	
	

}

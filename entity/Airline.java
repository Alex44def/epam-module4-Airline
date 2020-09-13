package ru.epam.jonline.module4.simple_class.airline.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import ru.epam.jonline.module4.simple_class.airline.enam.AirlineType;
import ru.epam.jonline.module4.simple_class.airline.enam.DaysWeek;

//Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.

public class Airline {
	private String destination;
	private int flightNumber;
	private AirlineType typeAirline;
	private LocalTime departureTime;
	private List<DaysWeek> daysOfWeek;
	
		
	public Airline() {
		super();
		this.destination = "";
		this.flightNumber = 0;
		this.typeAirline = AirlineType.REACTIVE;
		this.departureTime = LocalTime.now();
		this.daysOfWeek = new ArrayList<DaysWeek>();
	}

	public Airline(String destination, int flightNumber, AirlineType typeAirline, LocalTime departureTime, List<DaysWeek> daysOfWeek) {
		super();
		this.destination = destination;
		this.flightNumber = flightNumber;
		this.typeAirline = typeAirline;
		this.departureTime = departureTime;
		this.daysOfWeek = daysOfWeek;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public AirlineType getTypeAirline() {
		return typeAirline;
	}

	public void setTypeAirline(AirlineType airlineType) {
		this.typeAirline = airlineType;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public List<DaysWeek> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(List<DaysWeek> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	@Override
	public String toString() {
		return "Airline [destination=" + destination + ", flightNumber=" + flightNumber + ", typeAirline=" + typeAirline
				+ ", departureTime=" + departureTime + ", daysOfWeek=" + daysOfWeek + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((daysOfWeek == null) ? 0 : daysOfWeek.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + flightNumber;
		result = prime * result + ((typeAirline == null) ? 0 : typeAirline.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airline other = (Airline) obj;
		if (daysOfWeek == null) {
			if (other.daysOfWeek != null)
				return false;
		} else if (!daysOfWeek.equals(other.daysOfWeek))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (flightNumber != other.flightNumber)
			return false;
		if (typeAirline == null) {
			if (other.typeAirline != null)
				return false;
		} else if (!typeAirline.equals(other.typeAirline))
			return false;
		return true;
	}
	
	
	
	
}

package ru.epam.jonline.module4.simple_class.airline.entity;

import java.util.ArrayList;
import java.util.List;

public class Airlines {
	
	List<Airline> airlines;
	int size;

	public Airlines() {
		super();
		this.airlines = new ArrayList<Airline>();
		this.size = 0;
	}

	public Airlines(List<Airline> airlines) {
		super();
		this.airlines = airlines;
		this.size = airlines.size();
	}

	public List<Airline> toList() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}
	
	public void add(Airline airline) {
		airlines.add(airline);
		size = airlines.size();
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "Airlines [airlines=" + airlines + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlines == null) ? 0 : airlines.hashCode());
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
		Airlines other = (Airlines) obj;
		if (airlines == null) {
			if (other.airlines != null)
				return false;
		} else if (!airlines.equals(other.airlines))
			return false;
		return true;
	}

	
}

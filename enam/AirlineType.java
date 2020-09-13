package ru.epam.jonline.module4.simple_class.airline.enam;

public enum AirlineType {
	
	REACTIVE("Reactive Aircraft"),
	PROPELLER("Propeller Aircraft"),
	TURBOPROP("Turboprop Aircraft");

	String type;
	
	private AirlineType() {
		this.type = "Reactive Aircraft";
	}

	private AirlineType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	
	
	
	
}

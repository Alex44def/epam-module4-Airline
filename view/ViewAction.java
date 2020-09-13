package ru.epam.jonline.module4.simple_class.airline.view;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import ru.epam.jonline.module4.simple_class.airline.entity.Airline;
import ru.epam.jonline.module4.simple_class.airline.entity.Airlines;

public class ViewAction {

	public void print(Airline airline) {

		String time = airline.getDepartureTime().format(DateTimeFormatter.ofPattern("HH:mm"));

		System.out.printf("flightNumber: %d, destination: %s, typeAirline: %s, departureTime: %s, daysOfWeek %s%n",
				airline.getFlightNumber(), airline.getDestination(), airline.getTypeAirline().getType(), time,
				airline.getDaysOfWeek().toString());

	}

	public void print(Airlines airlines) {

		List<Airline> list = airlines.toList();

		for (Airline airline : list) {

			String time = airline.getDepartureTime().format(DateTimeFormatter.ofPattern("HH:mm"));

			System.out.printf("flightNumber: %d, destination: %s, typeAirline: %s, departureTime: %s, daysOfWeek %s%n",
					airline.getFlightNumber(), airline.getDestination(), airline.getTypeAirline().getType(), time,
					airline.getDaysOfWeek().toString());

		}

		System.out.println();
	}

	@SuppressWarnings("resource")
	public String enterStringFromConsole(String message) {

		String inputStr;

		Scanner in = new Scanner(System.in);
		System.out.println(message);

		while (!in.hasNext()) {
			in.next();
			System.out.print(message);
		}

		inputStr = in.next();
		inputStr.trim().toLowerCase();

		StringBuilder builder = new StringBuilder(inputStr);
		builder.setCharAt(0, Character.toUpperCase(inputStr.charAt(0)));
		inputStr = builder.toString();

		return inputStr;
	}
	
	@SuppressWarnings("resource")
	public int enterIntFromConsole(String str, int minValue, int maxValue) {

		int result;
		boolean check;
		Scanner in = new Scanner(System.in);

		System.out.print(str);

		do {
			check = true;
			while (!in.hasNextInt()) {
				in.next();
				System.out.println("Значение должно быть числом от " + minValue + " до " + maxValue);
			}

			result = in.nextInt();

			if (result > maxValue || result < minValue) {
				System.out.println("Значение должно быть от " + minValue + " до " + maxValue);
				check = false;
			}

		} while (!check);

		return result;
	}

}

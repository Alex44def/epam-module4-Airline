package ru.epam.jonline.module4.simple_class.airline.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.epam.jonline.module4.simple_class.airline.enam.AirlineType;
import ru.epam.jonline.module4.simple_class.airline.enam.DaysWeek;
import ru.epam.jonline.module4.simple_class.airline.entity.Airline;
import ru.epam.jonline.module4.simple_class.airline.entity.Airlines;

public class ServiceAction {

	public Airlines getAirlinesByDest(Airlines airlines, String dest) {

		List<Airline> list = airlines.toList();
		Airlines result = new Airlines();

		for (Airline airline : list) {
			if (airline.getDestination().equalsIgnoreCase(dest)) {
				result.add(airline);
			}
		}

		return result;
	}

	public Airlines getAirlinesByDay(Airlines airlines, String day) {

		List<Airline> list = airlines.toList();
		Airlines result = new Airlines();
		
		 

		for (Airline airline : list) {			
			if (airline.getDaysOfWeek().contains(DaysWeek.valueOf(day.toUpperCase()))) {
				result.add(airline);
			}
		}

		return result;
	}

	public Airlines getAirlinesAfterTime(Airlines airlines, LocalTime time) {

		List<Airline> list = airlines.toList();
		Airlines result = new Airlines();

		for (Airline airline : list) {
			if (airline.getDepartureTime().isAfter(time)) {
				result.add(airline);
			}
		}

		return result;
	}

	public Airlines getAirlines(int count) {

		Airlines airlines = new Airlines();

		for (int i = 0; i < count; i++) {

			Airline airline = new Airline();

			airline.setFlightNumber(i + 1);
			airline.setDestination("Dest" + ((int) (Math.random() * (i + 10))));
			airline.setDepartureTime(LocalTime.now().plusMinutes(i + 30).plusHours(i));
			airline.setDaysOfWeek(getRandomDays());
			airline.setTypeAirline(getRandomType());

			airlines.add(airline);
		}

		return airlines;

	}

	private AirlineType getRandomType() {

		AirlineType type;

		int countType = 3;
		int randomInt;

		randomInt = (int) (Math.random() * (countType));

		type = AirlineType.values()[randomInt];

		return type;
	}

	private List<DaysWeek> getRandomDays() {

		Set<DaysWeek> randomDaysSet = new HashSet<>();

		final int maxCount = 7;
		int randomCount;
		int randomDayNumber;
		int i = 0;

		randomCount = (int) (1 + Math.random() * (maxCount + 1));

		while (i < 100000 && randomDaysSet.size() != randomCount) {
			randomDayNumber = (int) (Math.random() * (maxCount));
			randomDaysSet.add(DaysWeek.values()[randomDayNumber]);
			i++;

		}

		List<DaysWeek> randomDaysList = new ArrayList<>(randomDaysSet);

		sortEnumList(randomDaysList);

//		randomDaysList.sort(Comparator.comparing(DaysWeek::ordinal));

//		Collections.sort(randomDaysList, new Comparator<DaysWeek>() {
//            @Override
//            public int compare(DaysWeek o1, DaysWeek o2) {
//                return o1.ordinal() - o2.ordinal();
//            }
//        });

		return randomDaysList;
	}

	private void sortEnumList(List<DaysWeek> list) {

		boolean check = true;
		DaysWeek temp;

		while (check) {
			check = false;
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i).ordinal() > list.get(i + 1).ordinal()) {
					check = true;
					temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);

				}
			}
		}
	}

}

package ru.epam.jonline.module4.simple_class.airline.logic;

import java.time.LocalTime;

import ru.epam.jonline.module4.simple_class.airline.enam.DaysWeek;
import ru.epam.jonline.module4.simple_class.airline.entity.Airlines;
import ru.epam.jonline.module4.simple_class.airline.service.ServiceAction;
import ru.epam.jonline.module4.simple_class.airline.view.ViewAction;

public class MainAction {

	ServiceAction service = new ServiceAction();
	ViewAction view = new ViewAction();

	Airlines result;

	public Airlines airlinesInDest(Airlines airlines) {

//		Airlines result;
		String dest;
		int choiсe = 2;

		dest = view.enterStringFromConsole("Введите пункт назначения: ");

		result = service.getAirlinesByDest(airlines, dest);

		if (result.getSize() == 0) {
			System.out.println("Airlines in this destination is not found!!! \nLooking for another destination?");

			choiсe = view.enterIntFromConsole("1 - yes \n2 - no\n", 1, 2);
		}

		if (choiсe == 1) {
			airlinesInDest(airlines);
		}

		return result;
	}

	public Airlines airlinesInDay(Airlines airlines) {

		final DaysWeek[] days = DaysWeek.values();

//		Airlines result;
		int dayNumber;
		int choiсe = 2;

		System.out.println("Выберите день вылета: ");
		System.out.printf(
				"1 - Monday, 2 - Tuesday, 3 - Wednesday, 4 - Thursday, %n5 - Friday, 6 - Saturday, 7 - Sunday%n");

		dayNumber = view.enterIntFromConsole("", 1, 7);
		dayNumber = (dayNumber == 7) ? 0 : dayNumber;

		result = service.getAirlinesByDay(airlines, days[dayNumber].getDay());

		if (result.getSize() == 0) {

			System.out.println("Airlines in this day is not found!!! \nChoose another day?");
			choiсe = view.enterIntFromConsole("1 - yes \n2 - no\n", 1, 2);

			switch (choiсe) {
			case 1:
				airlinesInDay(airlines);
				break;
			case 2:
				System.out.println("GoobBay!!");
			}
		}

		return result;
	}

	public Airlines airlinesInDayAfterTime(Airlines airlines) {

		int hour = 0;
		int minute = 0;
		int choiсe = 2;

//		Airlines result;
		result = airlinesInDay(airlines);
		view.print(result);

		System.out.println("Enter the earliest departure time: ");
		hour = view.enterIntFromConsole("Hour: ", 0, 24);
		minute = view.enterIntFromConsole("Minute: ", 0, 60);

		LocalTime time = LocalTime.of(hour, minute);
		result = service.getAirlinesAfterTime(result, time);

		if (result.getSize() == 0) {

			System.out.println("Airlines after this time is not found!!! \nChoose another time?");
			choiсe = view.enterIntFromConsole("1 - yes \n2 - no\n", 1, 2);

			switch (choiсe) {
			case 1:
				airlinesInDayAfterTime(airlines);
				break;
			case 2:
				System.out.println("GoobBay!!");
			}
		}

		return result;
	}

}

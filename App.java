package ru.epam.jonline.module4.simple_class.airline;

import ru.epam.jonline.module4.simple_class.airline.entity.Airlines;
import ru.epam.jonline.module4.simple_class.airline.logic.MainAction;
import ru.epam.jonline.module4.simple_class.airline.service.ServiceAction;
import ru.epam.jonline.module4.simple_class.airline.view.ViewAction;

// Создать класс Airline, спецификация которого приведена ниже. 
// Определить конструкторы, set- и get- методы и метод toString(). 
// Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами. 
// Задать критерии выбора данных и вывести эти данные на консоль.
// Найти и вывести:
//    a) список рейсов для заданного пункта назначения;
//    b) список рейсов для заданного дня недели;
//    c) список рейсов для заданного дня недели, время вылета для которых больше заданного.

public class App {

	public static void main(String[] args) {
		
		MainAction action = new MainAction();
		ServiceAction service = new ServiceAction();
		ViewAction view = new ViewAction();

		Airlines airlines;
		Airlines resultAirlines;
		airlines = service.getAirlines(10);

		view.print(airlines);
		
		resultAirlines = action.airlinesInDest(airlines);	
		if (resultAirlines.getSize() != 0) {
			view.print(resultAirlines);
		}
		
		resultAirlines = action.airlinesInDay(airlines);
		if (resultAirlines.getSize() != 0) {
			view.print(resultAirlines);
		}
		
		
		resultAirlines = action.airlinesInDayAfterTime(airlines);
		if (resultAirlines.getSize() != 0) {
			view.print(resultAirlines);
		}
		
	}

}

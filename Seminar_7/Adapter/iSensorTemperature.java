package Seminar_7.Adapter;

// Интерфейс дополнительного датчика
interface iSensorTemperature{
	int identifier(); // идентификатор датчика
	double temperature(); // температура датчика
	int year();			 // Год
	int day();			 // День года
	int second();		 // Секунда дня
}
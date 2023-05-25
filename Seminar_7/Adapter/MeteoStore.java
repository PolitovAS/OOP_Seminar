package Seminar_7.Adapter;

// Класс, сохраняющий данные от метеодатчиков
class MeteoStore {
    // сохранение данных в базу
    boolean save(iMeteoSensor meteoSensor) {
        System.out.format("Saving data from sensor [%d] at %s%n temperature - %f ; humidity - %f ; pressure - %f \n\r",
				meteoSensor.getId(),
				meteoSensor.getDateTime(),
				meteoSensor.getTemperature(),
				meteoSensor.getHumidity(),
				meteoSensor.getPressure());
        return true;
    }
}
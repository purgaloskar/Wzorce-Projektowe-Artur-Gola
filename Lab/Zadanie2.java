public class Zadanie2 {

    interface TemperatureCelsius {
        double getTemperatureCelsius();
    }

    static class KelvinSensor {
        public double getTemperatureKelvin() {
            return 300.0;
        }
    }

    static class FahrenheitSensor {
        public double getTemperatureFahrenheit() {
            return 86.0;
        }
    }

    static class KelvinAdapter implements TemperatureCelsius {
        private KelvinSensor sensor;

        public KelvinAdapter(KelvinSensor sensor) {
            this.sensor = sensor;
        }

        @Override
        public double getTemperatureCelsius() {
            return sensor.getTemperatureKelvin() - 273.15;
        }
    }

    static class FahrenheitAdapter implements TemperatureCelsius {
        private FahrenheitSensor sensor;

        public FahrenheitAdapter(FahrenheitSensor sensor) {
            this.sensor = sensor;
        }

        @Override
        public double getTemperatureCelsius() {
            return (sensor.getTemperatureFahrenheit() - 32) * 5.0 / 9.0;
        }
    }

    static class WeatherApp {
        public void showTemperature(TemperatureCelsius sensor) {
            System.out.println("Temperatura: " + sensor.getTemperatureCelsius() + " °C");
        }
    }

    public static void main(String[] args) {
        WeatherApp app = new WeatherApp();

        TemperatureCelsius kelvin = new KelvinAdapter(new KelvinSensor());
        TemperatureCelsius fahrenheit = new FahrenheitAdapter(new FahrenheitSensor());

        app.showTemperature(kelvin);
        app.showTemperature(fahrenheit);
    }
}

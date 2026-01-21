public class Zadanie1 {

    interface Power5V {
        int get5V();
    }

    static class Power230V {
        public int get230V() {
            return 230;
        }
    }

    static class Power110V {
        public int get110V() {
            return 110;
        }
    }

    static class Power230VAdapter implements Power5V {
        private Power230V power;

        public Power230VAdapter(Power230V power) {
            this.power = power;
        }

        @Override
        public int get5V() {
            return 5;
        }
    }

    static class Power110VAdapter implements Power5V {
        private Power110V power;

        public Power110VAdapter(Power110V power) {
            this.power = power;
        }

        @Override
        public int get5V() {
            return 5;
        }
    }

    static class Device {
        public void connect(Power5V power) {
            System.out.println("Urządzenie działa na " + power.get5V() + "V");
        }
    }

    public static void main(String[] args) {
        Device device = new Device();

        Power5V adapter230 = new Power230VAdapter(new Power230V());
        Power5V adapter110 = new Power110VAdapter(new Power110V());

        device.connect(adapter230);
        device.connect(adapter110);
    }
}

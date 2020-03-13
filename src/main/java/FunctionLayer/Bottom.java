package FunctionLayer;

public class Bottom {


        private final String name;
        private final int price;


        public Bottom(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Bottom{" + "name=" + name + ", price=" + price + '}';
        }



    }

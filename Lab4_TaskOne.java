
// This is a Java program that defines a class called Lab4_TaskOne. 
// Within this class, there is another class defined called Automobile, which represents different automobile objects.
// The Automobile class has private attributes such as make, model, year, and price, along with constructors and methods to access and modify these attributes.
public class Lab4_TaskOne {
    static class Automobile { // This defines a nested class called Automobile within the Lab4_TaskOne class.

        // These are the attributes of the Automobile class.
        private String make; // This stores the make of the automobile.
        private String model; // This stores the model of the automobile.
        private int year; // This stores the manufacturing year of the automobile.
        private double price; // This stores the price of the automobile.

        // Constructor method for creating an Automobile object with make and model parameters.
        public Automobile (String make, String model) {
            this.make = make; // Sets the make of the automobile.
            this.model = model; // Sets the model of the automobile.
        }

        // Constructor method for creating an Automobile object with make, model, and year parameters.
        public Automobile (String make, String model, int year) {
            this.make = make; // Sets the make of the automobile.
            this.model = model; // Sets the model of the automobile.
            this.year = year; // Sets the manufacturing year of the automobile.
        }

        // Constructor method for creating an Automobile object with make, model, year, and price parameters.
        public Automobile (String make, String model, int year, double price) {
            this.make = make; // Sets the make of the automobile.
            this.model = model; // Sets the model of the automobile.
            this.year = year; // Sets the manufacturing year of the automobile.
            this.price = price; // Sets the price of the automobile.
        }

        // Getter method to retrieve the make of the automobile.
        public String getMake() {
            return this.make; // Returns the make of the automobile.
        }

        // Setter method to update the make of the automobile.
        public void setMake(String make) {
            this.make = make; // Sets the make of the automobile.
        }

        // Getter method to retrieve the model of the automobile.
        public String getModel() {
            return this.model; // Returns the model of the automobile.
        }

        // Setter method to update the model of the automobile.
        public void setModel(String model) {
            this.model = model; // Sets the model of the automobile.
        }

        // Getter method to retrieve the manufacturing year of the automobile.
        public int getYear() {
            return this.year; // Returns the manufacturing year of the automobile.
        }

        // Setter method to update the manufacturing year of the automobile.
        public void setYear(int year) {
            this.year = year; // Sets the manufacturing year of the automobile.
        }

        // Getter method to retrieve the price of the automobile.
        public double getPrice() {
            return this.price; // Returns the price of the automobile.
        }

        // Setter method to update the price of the automobile.
        public void setPrice(double price) {
            this.price = price; // Sets the price of the automobile.
        }

        // Method to display details of the automobile.
        public void displayDetails() {
            // Prints the make, model, manufacturing year, and price of the automobile.
            System.out.printf("\nMake: %s\nModel: %s\nYear: %d\nPrice: $%.2f\n", this.make, this.model, this.year, this.price);
        }
    }

    // This is the main class where the program execution starts.
    public static void main (String args[]) {
        // Creating instances of Automobile class and initializing them with specific values.
        Automobile tesla = new Automobile("Tesla", "S", 2020, 175300.45); // Creates a Tesla automobile object with specified details.
        Automobile toyota = new Automobile("Toyota", "Corolla", 2015); // Creates a Toyota automobile object with specified details.
        Automobile suzuki = new Automobile("Suzuki", "Mehran"); // Creates a Suzuki automobile object with specified details.
        
        // Displaying details of each automobile object.
        tesla.displayDetails(); // Displays details of the Tesla automobile object.
        toyota.displayDetails(); // Displays details of the Toyota automobile object.
        suzuki.displayDetails(); // Displays details of the Suzuki automobile object.
    }
}    



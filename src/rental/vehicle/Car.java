package rental.vehicle;

import rental.Vehicle;

/**
 * The Car class extends the Vehicle class and represents a car.
 */
public class Car extends Vehicle {
    private int nbpassagers;

    /**
     * Constructs a Car object with the specified brand, model, production year, daily rental price, and number of passengers.
     * 
     * @param brand The brand of the car.
     * @param model The model of the car.
     * @param productionYear The production year of the car.
     * @param dailyRentalPrice The daily rental price of the car.
     * @param nbpassagers The number of passengers the car can accommodate.
     */
    public Car(String brand, String model, int productionYear, double dailyRentalPrice, int nbpassagers) {
        super(brand, model, productionYear, dailyRentalPrice);
        this.nbpassagers = nbpassagers;
    }

    /**
     * Returns the number of passengers the car can accommodate.
     * 
     * @return The number of passengers.
     */
    public int getNbPassagers() {
        return this.nbpassagers;
    }

    /**
     * Returns a string representation of the car, including its brand, model, production year, daily rental price, and number of passengers.
     * 
     * @return A string representation of the car.
     */
    @Override
    public String toString() {
        return super.toString() + " " + this.nbpassagers;
    }
}
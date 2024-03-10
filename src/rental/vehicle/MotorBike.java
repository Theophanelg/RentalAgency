package rental.vehicle;

import rental.Vehicle;

/**
 * The MotorBike class extends the Vehicle class and represents a motorbike.
 */
public class MotorBike extends Vehicle {
    private double cylindre;

    /**
     * Constructs a MotorBike object with the specified brand, model, production year, daily rental price, and cylinder capacity.
     * 
     * @param brand The brand of the motorbike.
     * @param model The model of the motorbike.
     * @param productionYear The production year of the motorbike.
     * @param dailyRentalPrice The daily rental price of the motorbike.
     * @param cylindre The cylinder capacity of the motorbike.
     */
    public MotorBike(String brand, String model, int productionYear, double dailyRentalPrice, double cylindre) {
        super(brand, model, productionYear, dailyRentalPrice);
        this.cylindre = cylindre;
    }

    /**
     * Returns the cylinder capacity of the motorbike.
     * 
     * @return The cylinder capacity.
     */
    public double getCylindre() {
        return this.cylindre;
    }

    /**
     * Returns a string representation of the motorbike, including its brand, model, production year, daily rental price, and cylinder capacity.
     * 
     * @return A string representation of the motorbike.
     */
    @Override
    public String toString() {
        return super.toString() + " " + this.cylindre;
    }
}
package rental.agency;

import rental.Client;
import rental.RentalAgency;
import rental.UnknownVehicleException;
import rental.Vehicle;

/**
 * The SuspiciousRentalAgency class extends the RentalAgency class and represents a rental agency
 * that applies a surcharge to the rental cost for clients who are under 25 years old.
 */
public class SuspiciousRentalAgency extends RentalAgency {
    /**
     * Constructs a SuspiciousRentalAgency object.
     */
    public SuspiciousRentalAgency() {
        super();
    }

    /**
     * Rents a vehicle to a client, applying a surcharge to the rental cost if the client is under 25 years old.
     * 
     * @param client The client renting the vehicle.
     * @param v The vehicle being rented.
     * @return The cost of the rental, with a surcharge applied if applicable.
     * @throws IllegalStateException If the rental agency is not properly initialized.
     * @throws UnknownVehicleException If the specified vehicle is not available for rental.
     */
    @Override
    public double rentVehicle(Client client, Vehicle v) throws IllegalStateException, UnknownVehicleException {
        double res;

        if (client.getAge() < 25) {
            double value = super.rentVehicle(client, v);
            res = value * 110 / 100;
        } else {
            res = super.rentVehicle(client, v);
        }

        return res;
    }
}
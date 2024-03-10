package rental.agency;

import java.util.HashMap;
import java.util.Map;

import rental.Client;
import rental.RentalAgency;
import rental.UnknownVehicleException;
import rental.Vehicle;

/**
 * The FriendlyRentalAgency class extends the RentalAgency class and represents a rental agency
 * that offers special discounts to loyal clients based on their accumulated points.
 * The class keeps track of the loyalty points for each client and applies a discount percentage
 * to the rental cost if the client's loyalty points exceed a certain threshold.
 */
public class FriendlyRentalAgency extends RentalAgency {
    protected Map<Client, Integer> points = new HashMap<>();
    private int seuil;
    private double pourcentage;

    /**
     * Constructs a FriendlyRentalAgency object with the specified discount percentage and loyalty points threshold.
     * 
     * @param pourcentage The discount percentage applied to the rental cost for loyal clients.
     * @param seuil The loyalty points threshold required for a client to be eligible for the discount.
     */
    public FriendlyRentalAgency(double pourcentage, int seuil) {
        super();
        this.seuil = seuil;
        this.pourcentage = pourcentage;
    }

    /**
     * Rents a vehicle to a client, taking into account the loyalty points and applying a discount if applicable.
     * 
     * @param client The client renting the vehicle.
     * @param v The vehicle being rented.
     * @return The cost of the rental, taking into account any applicable discounts.
     * @throws UnknownVehicleException If the specified vehicle is not available for rental.
     * @throws IllegalStateException If the rental agency is not properly initialized.
     */
    @Override
    public double rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
        double res;
        int loyaltyPoints;

        if (points.containsKey(client)) {
            loyaltyPoints = points.get(client);
        } else {
            loyaltyPoints = 0;
        }

        if (loyaltyPoints >= seuil) {
            double value = super.rentVehicle(client, v);
            res = (100 - pourcentage) * value / 100;
        } else {
            res = super.rentVehicle(client, v);
        }

        loyaltyPoints += 1;
        points.put(client, loyaltyPoints);

        return res;
    }

    /**
     * Returns a map of clients and their corresponding loyalty points.
     * 
     * @return A map of clients and their loyalty points.
     */
    public Map<Client, Integer> getPoints() {
        return points;
    }
}
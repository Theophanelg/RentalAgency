package rental.agency;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import rental.Client;
import rental.UnknownVehicleException;
import rental.Vehicle;

public class FriendlyRentalAgencyTest {
    private Vehicle v1;
    private Vehicle v2;
    private Client Roxanne;
    private FriendlyRentalAgency Fagency;

    @Before
    public void before(){
        this.v1 = new Vehicle("RoxCar", "RoxModel", 2019, 9000);
        this.v2 = new Vehicle("VCar", "VModel", 2020, 5000);
        this.Roxanne = new Client("Roxanne", 21);
        this.Fagency = new FriendlyRentalAgency(10, 2);
    }

    @Test
    public void testGetPoints() throws IllegalStateException, UnknownVehicleException{

        Fagency.addVehicle(v1);
        Fagency.addVehicle(v2);
        Fagency.rentVehicle(Roxanne, v1);
        Fagency.returnVehicle(Roxanne);
        Fagency.rentVehicle(Roxanne, v2);

        assertTrue(this.Fagency.getPoints().get(Roxanne) == 2);
    }
}

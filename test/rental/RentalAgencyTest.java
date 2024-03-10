package rental;

import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Test;

public class RentalAgencyTest {
    @Test
    public void testHasRentedAvehicule() throws IllegalStateException, UnknownVehicleException{
        Vehicle vehicle = new Vehicle("Tesla", "M8", 2022, 1000);
        Client client = new Client("Théophane", 20);
        RentalAgency agency = new RentalAgency();
        
        agency.addVehicle(vehicle);
        agency.rentVehicle(client, vehicle);
        
        assertTrue(agency.hasRentedAVehicle(client));
    }

    @Test
    public void testIsRented() throws IllegalStateException, UnknownVehicleException{
        Vehicle vehicle = new Vehicle("Tesla", "M9", 2023, 10000);
        Client client = new Client("Roxanne", 21);
        RentalAgency agency = new RentalAgency();
        
        agency.addVehicle(vehicle);
        agency.rentVehicle(client, vehicle);

        assertTrue(agency.isRented(vehicle));
    }

    @Test
    public void testRentVehicule() throws UnknownVehicleException, IllegalStateException{
        Vehicle vehicle = new Vehicle("Tesla", "M10", 2023, 1000);
        Client client = new Client("Véro", 45);
        RentalAgency agency = new RentalAgency();

        agency.addVehicle(vehicle);
        agency.rentVehicle(client, vehicle);
        
        assertTrue(agency.isRented(vehicle));
    }

    @Test
    public void testReturnVehicule() throws UnknownVehicleException, IllegalStateException{
        Vehicle vehicle = new Vehicle("Tesla", "M11", 2024, 2000);
        Client client = new Client("Margerite", 99);
        RentalAgency agency = new RentalAgency();

        agency.addVehicle(vehicle);
        agency.rentVehicle(client, vehicle);
        agency.returnVehicle(client);

        assertTrue(!agency.hasRentedAVehicle(client));
    }

}

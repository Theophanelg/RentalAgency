package rental;
import rental.agency.FriendlyRentalAgency;
import rental.agency.SuspiciousRentalAgency;
import rental.filter.AndFilter;
import rental.filter.BrandFilter;
import rental.filter.MaxPriceFilter;
import rental.vehicle.Car;
import rental.vehicle.MotorBike;

public class MainAgency {
    public static void main(String[] args) throws IllegalStateException, UnknownVehicleException {
    
        //Instance of vehicle
        Vehicle vehicle = new Vehicle("renault", "V8", 2000, 1000);
        Vehicle vehicle2 = new Vehicle("Tesla", "Model 3", 2020,5000);
        Vehicle vehicle5 = new Vehicle("Tesla", "Model 4", 2022,9999);
        Vehicle vehicle3 = new Vehicle("Honda", "Paralepipède", 2009, 100);
        Vehicle vehicle4 = new Vehicle("Mercedes", "Plage", 2021, 6000);

        //Instance agency
        RentalAgency agency = new RentalAgency();

        //Add of vehicle in agency 
        agency.addVehicle(vehicle);
        agency.addVehicle(vehicle2);
        agency.addVehicle(vehicle3);
        agency.addVehicle(vehicle4);
        agency.addVehicle(vehicle5);
        
        //Instance filter
        BrandFilter brandFilter = new BrandFilter("Tesla");
        MaxPriceFilter maxFilter = new MaxPriceFilter(10000);
        BrandFilter brandFilter2 = new BrandFilter("Honda");
        MaxPriceFilter maxFilter2 = new MaxPriceFilter(2000);
        AndFilter andfilter = new AndFilter();

        //Add brandfilter in andfilter
        andfilter.addFilter(brandFilter);
        andfilter.addFilter(maxFilter);

        //Display
        System.out.println("Affichage avec deux filtres : ");
        agency.displaySelection(andfilter);

        System.out.println("Affichage du brandfilter : ");
        agency.displaySelection(brandFilter2);

        //Instance of client
        Client client = new Client("Roxanne", 22);
        Client client2 = new Client("Basic", 25);

        //Rent vehicle
        agency.rentVehicle(client, vehicle);
        agency.rentVehicle(client2, vehicle2);

        System.out.println("-------------------------------------------------------------");
        System.out.println("Rent vehicle (Roxanne) : " + agency.isRented(vehicle));
        System.out.println("Rent vehicle (Basic) : " + agency.isRented(vehicle2));

        //Return vehicle
        agency.returnVehicle(client);
        agency.returnVehicle(client2);

        System.out.println("Return vehicle (Roxanne) : " + agency.isRented(vehicle));
        System.out.println("Return vehicle (Basic) : " + agency.isRented(vehicle2));
        System.out.println("-------------------------------------------------------------");

        //Instance of car
        Car car = new Car("Tesla", "M1", 2000, 1000, 4);
        
        //Instance of MotorBike
        MotorBike motorBike = new MotorBike("Porshe", "A9", 1999, 1000, 2.5f);

        //add car and motorbike in ageency
        agency.addVehicle(car);
        agency.addVehicle(motorBike);

        //Display maxFilter2
        System.out.println("Display car and motorbike with maxFilter < 2000");
        agency.displaySelection(maxFilter2);

        //Instance of Suspicious Rental Agency
        SuspiciousRentalAgency SuspectAgency = new SuspiciousRentalAgency();

        //add vehicle at the SuspectAgency
        SuspectAgency.addVehicle(vehicle2);
        SuspectAgency.addVehicle(vehicle);
        SuspectAgency.addVehicle(car);
        SuspectAgency.addVehicle(motorBike);
        
        //Rent vehicle and display the rent of SuspectAgency
        System.out.println("-------------------------------------------------------------");
        System.out.println("Display the Suspect Agency");
        System.out.println(SuspectAgency.rentVehicle(client2, vehicle));
        System.out.println(SuspectAgency.rentVehicle(client, car));

        //Instance of Friendly Rental Agency
        FriendlyRentalAgency FriendlyAgency = new FriendlyRentalAgency(10, 3);

        //Instance of vehicle for FriendlyAgency
        Vehicle fvehicle = new Vehicle("Dell", "F4", 2000, 2300);
        Vehicle fvehicle2 = new Vehicle("Intel", "N22", 2003, 4000);
        Vehicle fvehicle3 = new Vehicle("Tiranosore", "PouetePouete", 2005, 100000);
        Vehicle fvehicle4 = new Vehicle("CocaCola", "Cristaline", 3000, 10000);

        //add vehicle at the FriendlyAgency
        FriendlyAgency.addVehicle(fvehicle);
        FriendlyAgency.addVehicle(fvehicle2);
        FriendlyAgency.addVehicle(fvehicle3);
        FriendlyAgency.addVehicle(fvehicle4);

        //Rent vehicle and display the rent of FriendlyAgency
        System.out.println("-------------------------------------------------------------");
        System.out.println("Display the Friendly Agency");

        //client 2 without the point for got a reduction :
        FriendlyAgency.rentVehicle(client2, fvehicle);
        FriendlyAgency.returnVehicle(client2);

        System.out.println(FriendlyAgency.rentVehicle(client2, fvehicle));
        FriendlyAgency.returnVehicle(client2);
        System.out.println("The points of fidelity are : " + FriendlyAgency.getPoints().get(client2));
        
        //client 1 with the point for got a reduction :
        FriendlyAgency.rentVehicle(client, fvehicle);
        FriendlyAgency.returnVehicle(client);
        
        FriendlyAgency.rentVehicle(client, fvehicle2);
        FriendlyAgency.returnVehicle(client);
        
        FriendlyAgency.rentVehicle(client, fvehicle3);
        FriendlyAgency.returnVehicle(client);
        
        System.out.println(FriendlyAgency.rentVehicle(client, fvehicle4));
        System.out.println("The points of fidelity are : " + FriendlyAgency.getPoints().get(client));
    }
}

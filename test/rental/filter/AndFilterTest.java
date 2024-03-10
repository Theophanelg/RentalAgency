package rental.filter;
import org.junit.jupiter.api.*;

import rental.Vehicle;
import rental.VehicleFilter;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class AndFilterTest {
    
    @Test
    public void testAddFilter(){
        BrandFilter brandfilter = new BrandFilter("renault");
        MaxPriceFilter maxFilter = new MaxPriceFilter(100);        
        
        AndFilter andfilter = new AndFilter();
        
        Vehicle vehicle = new Vehicle("renault", "3s", 5, 10);

        andfilter.addFilter(brandfilter);
        andfilter.addFilter(maxFilter);

        assertTrue(andfilter.accept(vehicle));
    } 

    @Test
    public void testAccept(){
        BrandFilter brandfilter = new BrandFilter("renault");
        MaxPriceFilter maxFilter = new MaxPriceFilter(100);        
        
        AndFilter andfilter = new AndFilter();
        andfilter.addFilter(brandfilter);
        andfilter.addFilter(maxFilter);

        Vehicle vehicle = new Vehicle("renault", "3s", 5, 10);

        assertTrue(andfilter.accept(vehicle));
    }
}

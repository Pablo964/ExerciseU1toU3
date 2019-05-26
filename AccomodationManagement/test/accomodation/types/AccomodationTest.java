package accomodation.types;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccomodationTest 
{
    /**
     * Test of getTotal method, of class Accomodation.
     */
    @Test
    public void testGetTotal() 
    {
        Accomodation hotel = new Hotel("Meliá", 20, 5, true);
        
        assertEquals(40,hotel.getTotal(2));
        assertNotEquals(40,hotel.getTotal(-2));
    }

    /**
     * Test of getCheckOutDate method, of class Accomodation.
     */
    @Test
    public void testGetCheckOutDate() 
    {
        
        assertEquals("20/05/2019", 
                Accomodation.getCheckOutDate("10/05/2019", 10));
        assertEquals("29/06/2019", 
                Accomodation.getCheckOutDate("10/05/2019", 50));
       assertNotEquals("20/05/2019", 
                Accomodation.getCheckOutDate("10/05/2019", -10));
        
    } 
}

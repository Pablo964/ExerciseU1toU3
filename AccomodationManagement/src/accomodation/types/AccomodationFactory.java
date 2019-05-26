
package accomodation.types;

public class AccomodationFactory 
{
    public static Accomodation getAccomodation(String accomodationType,
            String name, int price, int maxPeople, int totalRooms, 
            int rating, boolean swimingPool)
    {
        if(accomodationType.equalsIgnoreCase("HOTEL"))
            return new Hotel(name, price, rating, swimingPool);
        else if(accomodationType.equalsIgnoreCase("RURALHOUSE"))
            return new RuralHouse(name, price, maxPeople, totalRooms);
   
        return null;
    }
}

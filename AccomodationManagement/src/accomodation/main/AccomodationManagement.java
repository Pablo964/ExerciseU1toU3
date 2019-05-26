package accomodation.main;

import accomodation.types.Accomodation;
import accomodation.types.Hotel;
import java.util.List;
import java.util.Scanner;

public class AccomodationManagement 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int option;
        AccomodationManager a = new AccomodationManager();
        a.readAccomodations("accomodations.txt");
        
        do 
        {
            System.out.println("Enter a option:");
            System.out.println("1.-filtered hotels by rating");
            System.out.println("2.-filtered accomodations by price");
            System.out.println("0.-Exit");
            System.out.println();
            option = sc.nextInt();
            
            switch(option)
            {
                case 1:
                    System.out.println("introduces a rating by which to filter");
                    int rating = sc.nextInt();
                    List<Hotel> hotelsByRating = a.searchByHotelRating(rating);
                    for(Hotel h : hotelsByRating)
                    {
                        System.out.println(h.toString());
                    }
                    break;
                case 2:
                    System.out.println("introduces a price by which to filter");
                    int price = sc.nextInt();
                    List<Accomodation> accomodationsByPrice =
                            a.searchByPrice(price);
                    for(Accomodation accomodation : accomodationsByPrice)
                    {
                        System.out.println(accomodation.toString());
                    }
                    break;
            }
            System.out.println();
        } while (option != 0);
        System.out.println("Bye!");
    }
}

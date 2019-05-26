package accomodation.main;

import accomodation.types.Accomodation;
import accomodation.types.Hotel;
import accomodation.types.RuralHouse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AccomodationManager 
{
    protected List<Accomodation> accomodations;
    
    public AccomodationManager() 
    {
        accomodations = new ArrayList<>();
    }
    
    private void AddAccomodation(Accomodation newAccomodation)
    {
        accomodations.add(newAccomodation);
    }
    public void readAccomodations(String fileName)
    {
        try
        {            
            File archivo = new File (fileName);
            FileReader fr = new FileReader (fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line=br.readLine())!=null)
            {
                String typeObject = line.split(";")[0];
                String name = line.split(";")[1];
                int price = Integer.parseInt(line.split(";")[2]);
                int extra1 = Integer.parseInt(line.split(";")[3]);
                String extra2 = line.split(";")[4];

                switch(typeObject)
                {
                    case "Hotel":
                        boolean swimmingPool;
                        
                        if (extra2.equals("YES")) 
                            swimmingPool = true;
                        else
                            swimmingPool = false;
                        
                        accomodations.add(new Hotel(name, price, extra1, 
                                swimmingPool));
                        break;
                    case "RuralHouse":
                        accomodations.add(new RuralHouse(name, price, extra1, 
                                Integer.parseInt(extra2)));
                        break;
                }
            }
            br.close();
        }
        catch(Exception e)
        {
            System.out.println("ERROR: not store data in the list");
        }    
    }
    
    public List<Hotel> searchByHotelRating(int searchRating)
    {
        
        List<Hotel> hotelsByRating = new ArrayList<>();
        for(Accomodation a : accomodations)
        {
            int rating = Integer.parseInt(a.toString().split("=")[3]
                    .split(";")[0]);
            if (a instanceof Hotel && rating >= searchRating)
            {
                hotelsByRating.add((Hotel)a);
            }
        }
        return hotelsByRating;
    }
    List<Accomodation> searchByPrice(float searchPrice)
    {
        List<Accomodation> accomodationsByPrice = new ArrayList<>();
        for(Accomodation a : accomodations)
        {
            if (a.getPrice() <= searchPrice)
            {
                accomodationsByPrice.add(a);
            }
        }
        return accomodationsByPrice;
    }
}

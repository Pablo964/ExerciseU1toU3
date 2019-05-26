package accomodation.types;

/**
 * Class to define accomodation
 * @author Pablo
 */
public abstract class Accomodation 
{
    private String name;
    private int price;

    /**
     * Instanties a object Accomodation
     * @param name name of accomodation
     * @param price price of accomodation
     */
    public Accomodation(String name, int price) 
    {
        this.name = name;
        this.price = price;
    }

    /**
     * @return name of accomodation 
     */
    public String getName(){return name;}
    
    /**
     * @return price per night of accomodation
     */
    public int getPrice(){return price;}

    /**
     * calculate the total price of the accommodation
     * @param nights nights that the client will be staying
     * @return total price of the accommodation
     */
    public int getTotal(int nights){return nights*price;}
    
    /**
     * calculates the departure date of the accommodation
     * @param checkInDate date when accommodation begins
     * @param nights nights that the client will be staying
     * @return date in which the accommodation ends.
     */
    public static String getCheckOutDate(String checkInDate, 
            int nights)
    {
        String[] dateRecived = checkInDate.split("/");
        int day = Integer.parseInt(dateRecived[0]);
        int month = Integer.parseInt(dateRecived[1]);
        int year = Integer.parseInt(dateRecived[2]);
        int numDays = 0;
        String zeroInDay;
        String zeroInMonth;
        
        day += nights;
        do 
        {
            switch (month) 
            {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    numDays = 31;
                    break;
                case 4: case 6: case 9: case 11:
                    numDays = 30;
                    break;
                case 2:
                    if((year%4==0 && year%100!=0) || year%400==0)
                    {
                        numDays = 29;
                    }
                    else
                    {
                        numDays = 28;
                    }
                    break;
            }
            if (day > numDays) 
            {
                day -= numDays;
                month++;  
            }
     
        }
        while ((day > numDays));
        
        if (day < 10)
            zeroInDay = "0";
        else
            zeroInDay = "";
        if (month < 10)
            zeroInMonth = "0";
        else
            zeroInMonth = "";
        
        String date = zeroInDay+day+"/"+zeroInMonth+month+"/"+year;
        
        return date;
    }
    
    /**
     * @return the properties of the accommodation
     */
    @Override
    public String toString() 
    {
        return "Accomodation;" + "name=" + name + "; price=" + 
                price + ';';
    }
}

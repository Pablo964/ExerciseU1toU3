package accomodation.types;

public class RuralHouse extends Accomodation
{
    protected int maxPeople;
    protected int totalRooms;
    
    public RuralHouse(String name, int price, int maxPeople, int totalRooms)
    {
        super(name, price);
        this.maxPeople = maxPeople;
        this.totalRooms = totalRooms;
    }

    public int getMaxPeople(){return maxPeople;}

    public int getTotalRooms() {return totalRooms;}

    @Override
    public String toString() 
    {
        return super.toString()+"RuralHouse;" + "maxPeople=" + maxPeople + "; totalRooms=" 
                + totalRooms + ';';
    }

}

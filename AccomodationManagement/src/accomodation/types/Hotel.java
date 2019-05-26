package accomodation.types;

public class Hotel extends Accomodation
{
    protected int rating;
    protected boolean swimmingPool;

    public Hotel(String name, int price, int rating, boolean swimmingPool) 
    {
        super(name, price);
        this.rating = rating;
        this.swimmingPool = swimmingPool;
    }

    public int getRating() {return rating;}

    public boolean isSwimmingPool() {return swimmingPool;}

    @Override
    public String toString() 
    {
        return super.toString()+"Hotel;" + "rating=" + rating 
                + "; swimmingPool=" + swimmingPool + ';';
    }

}

public class Passenger {
    
    private String name;

    
    /**
     * constructor for passenger class
     * @param name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * accesses the name since it is private 
     * @return the name for usage in other methods
     */
    public String getName(){
        return name;
    }

   
    /**
     * method to add a passenger in the car
     * @param c for car class
     * nothing else worked except "this", so i left it just 
     */
    public void boardCar(Car c) {
        c.addPassenger(this);
    }

    /**
     * method that calls the remove passenger to pass the name to car class's method
     * @param c
     */
    public void getOffCar(Car c) {
        c.removePassenger(this);
    }
}

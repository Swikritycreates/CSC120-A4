public class Engine {
    //attributes 
    private double currentFuelLevel;
    private double maxFuelLevel;
    private FuelType fuelType; 

    /**
     * Constructor
     * @param fuelType access for either the train uses Electricm diesel, petrol, etc.
     * @param capacity the maximum capacity of fuel for the train
     */

    public Engine(FuelType fuelType, double capacity){
        this.fuelType = fuelType;
        this.maxFuelLevel = capacity;
    }
    /**
     * 
     * @return accesses currentFuelLevel since it is private
     */

    public double getcurrentFuelValue() {
        return this.currentFuelLevel; 
    }
    /**
     * 
     * @return accesses maxFuelLevel since it is private
     */

    public double  getmaxFuelLevel() {
        return this.maxFuelLevel; 
    }

    /**
     * 
     * @return accesses fuelType since it is private
     */

    public FuelType getfuelType() {
        return this.fuelType; 
    }

    /**
     * changes the current fuel level to maximum fuel capacity value and prints it.
     */

    public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
        System.out.println("Engine refueled. Current Fuel Level: " + this.getcurrentFuelValue());
    }

    /**
     * 
     * @param fuelPerTrip is the fuel required to complete one journey
     * this method takes fuelperTrip as an input, checks if the currentfuel level is more than that, then proceeds to calculate 
     * the value that can be obtained after the completion of that journey
     * @return true if the fuel level is enough for one journey and false it is not.
     */
    public boolean go(double fuelPerTrip){
            if (currentFuelLevel >= fuelPerTrip){
                currentFuelLevel -= fuelPerTrip;
                System.out.println("Remaining Fuel Level:"+ currentFuelLevel);
                return true;
            } else{
                System.out.println("Not enough Fuel! REquired:"+ fuelPerTrip+ " Available: "+ currentFuelLevel);
                return false;
            }
        }
        /**
         * main 
         * creates object for engine
         * runs engine
         * @param args
         */

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        double fuelPerTrip = 10.00;
        while (myEngine.go(fuelPerTrip)) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");

        myEngine.refuel();
        myEngine.go(fuelPerTrip);
    }
}

    
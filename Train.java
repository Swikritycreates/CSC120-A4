import java.util.ArrayList;

public class Train {
    private Engine engine;
    private int passengerCapacity;
    private ArrayList<Car> cars;
    private FuelType fuelType;
    private double fuelCapacity;
    int nCars;

    /**
     * constructor
     * @param fuelType what does the train run on
     * @param engine to intergrate the engine with rest of the cars
     * @param fuelCapacity h the amount of fuel req for the train
     * @param nCars number of cars to be connected to the train 
     * @param passengerCapacity max number of passengers that can board the train 
     */

    public Train(FuelType fuelType, Engine engine, double fuelCapacity, int nCars, int passengerCapacity){
       this.fuelType = fuelType;
       this.engine = engine;
       this.fuelCapacity = fuelCapacity;
       this.passengerCapacity = passengerCapacity;
       this.nCars = nCars;
       this.cars = new ArrayList<>(nCars);

       for (int i = 0; i < nCars; i++) {
            Car myCar = new Car(null, passengerCapacity); //adds the car to the train
            this.cars.add(myCar);
            
        }
    }

    /**
     * accesess fuelCapacity
     * @return it since it is private
     */

    public double getfuelCapacity() {
        return fuelCapacity;
    }

    /**
     * accessor
     * @return fuelType
     */
    public FuelType getFuelType() {
            return fuelType;
        }
    
    /**
     * accessor
     * @return engine
     */
    public Engine getEngine() {
            return engine;
        }

    /**
     * accessor 
     * @return list of cars
     */
    public ArrayList<Car> getCars() {
        return cars;
    }
    /**
     * setter/ maniuplator
     * @param cars
     */
    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    /**
     * to access each car
     * @param i for going through the required number of cars
     * @return 
     */

    public Car getCar(int i) {
        if (i >= 0 && i < cars.size()) {
            return cars.get(i);
        }else{
            throw new IndexOutOfBoundsException("Car index out of range");
        }
    }

    /**
     * calculates the total passenger capacity through out the train 
     * @param car
     * @return
     */

    public int  getMaxCapacity(Car car) {
        for (int i= 0; i < nCars; i++) {
           passengerCapacity += car.getCapacity();
        }
        return passengerCapacity;
    }

    /**
     * calculates the total number of remainig seats by going through each car and tracking their remainig seats
     * @param car
     * @return
     */

    public int totalSeatsRemaining(Car car) {
        int totalSeatsRemaining = 0;
        for (int i= 0; i < nCars; i++){
            totalSeatsRemaining += car.seatsRemaining();
        }
        return totalSeatsRemaining;
    }

    /**
     * loops to print passengers of all cars
     */
    public void printManifest(){
        for (int i= 0; i < nCars; i++) {
            this.getCar(i).printManifest();
        }
    }
public static void main(String[] args){
    Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
    Train mytrain = new Train(FuelType.ELECTRIC, myEngine, 100, 5, 50);
    Passenger myPassenger = new Passenger("Ramesh");
    mytrain.getCar(1).addPassenger(myPassenger);
    mytrain.printManifest();
}
}
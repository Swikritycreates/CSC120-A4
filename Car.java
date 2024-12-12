import java.util.ArrayList;

public class Car {
    private ArrayList<Passenger> passengersOnBoard;
    private int maxCapacity;

    //constructor

    public Car(ArrayList<Passenger> passengersOnBoard, int maxCarCapacity){
        this.passengersOnBoard = new ArrayList<>();
        this.maxCapacity = maxCarCapacity;
    }


        /**
         * gets and returns maximum capacity
         * @param args
         */

        public int getCapacity(){
          return this.maxCapacity;
        }
        
        /**
         * access ArrayList<Passenger> 
         * @return the passengersOnBoard
         */

        public ArrayList<Passenger> getPassengers() {
            return this.passengersOnBoard; // Return the list of passengers
        }
        
        /**
         * calculates the available seats in the car
         * @return the number of seats that are available
         */
        public int seatsRemaining(){
            int size = passengersOnBoard.size(); 
            int seatsRemaining = this.maxCapacity - size ;
            return seatsRemaining;
        }

        /**
         * adds passenger into the car if there are seats
         * @param name of the passenger
         * @return true if the passenger was successful to board the car and false if they were not.
         */
        public boolean addPassenger(Passenger name){
            //how to append list to add passenger
            if (seatsRemaining()> 0 && !passengersOnBoard.contains(name)){
                passengersOnBoard.add(name);
                System.out.println(name + " has boarded the car.");
                return true;
            } else{
                System.out.println("Car Full, couldn't add passenger!");
                return false;
            }
        }

        /**
         * removes passenger from a car
         * @param name of the passenger
         * @return true if the passenger is present in the car and removes them and false if the passenger wasnot found in the acar
         */

        public boolean  removePassenger(Passenger name){
            if (passengersOnBoard.contains(name)){
                passengersOnBoard.remove(name);
                return true;
            } else{
                System.out.println("Passenger not on Car, offboarding Failed!");
                return false;
            }

        }
        /**
         * prints the list of passengers in the car.
         */

        public void printManifest(){
            if (!passengersOnBoard.isEmpty()){
                for(int i = 0; i < passengersOnBoard.size(); i++)  
                System.out.println(passengersOnBoard.get(i).getName());
            } else {
                System.out.println("This car is EMPTY. There is no one on board"); //prints this if there is nobody in the car
            }
            
            } 
// main
    public static void main(String[] args) {
        Car myCar = new Car(null, 50);
    }
}
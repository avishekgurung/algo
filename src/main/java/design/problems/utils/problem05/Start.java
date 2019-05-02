package design.problems.utils.problem05;

public class Start {

  public static void main(String[] args) {
    ParkingLot parkingLot = new ParkingLot(10);

    parkingLot.addVehicle(new Vehicle(Constant.TYPE_BIKE, "b001"));
    parkingLot.addVehicle(new Vehicle(Constant.TYPE_CAR, "c001"));
    parkingLot.addVehicle(new Vehicle(Constant.TYPE_CAR, "c001"));
    parkingLot.addVehicle(new Vehicle(Constant.TYPE_CAR, "c001"));
    parkingLot.addVehicle(new Vehicle(Constant.TYPE_BUS, "b001"));
    parkingLot.addVehicle(new Vehicle(Constant.TYPE_CAR, "c001"));
    parkingLot.addVehicle(new Vehicle(Constant.TYPE_CAR, "c001"));
    parkingLot.addVehicle(new Vehicle(Constant.TYPE_CAR, "c001"));
    parkingLot.addVehicle(new Vehicle(Constant.TYPE_BIKE, "b001"));
    parkingLot.addVehicle(new Vehicle(Constant.TYPE_BIKE, "b001"));
    parkingLot.addVehicle(new Vehicle(Constant.TYPE_BIKE, "b001"));
    parkingLot.display();

  }

}

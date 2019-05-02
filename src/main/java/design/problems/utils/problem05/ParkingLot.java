package design.problems.utils.problem05;

public class ParkingLot {

  private int capacity;
  private Spot[] spots;
  private int count;

  ParkingLot(int capacity) {
    this.capacity = capacity;
    this.count = 0;
    spots = new Spot[capacity];
    allocation();
  }

  private void allocation() {
    for(int i=0; i < capacity; i++) {
      if(i < 3) {
        spots[i] = new Spot(i, Constant.TYPE_BUS);
      }
      else if(i < 6) {
        spots[i] = new Spot(i, Constant.TYPE_CAR);
      }
      else {
        spots[i] = new Spot(i, Constant.TYPE_BIKE);
      }
    }
  }

  public boolean addVehicle(Vehicle vehicle) {
    if(addVehicleToCorrectSpot(vehicle)) return true;
    return addVehicleToVacantSpot(vehicle);
  }

  public boolean deleteVehicle(Vehicle vehicle) {
    for(int i=0; i < capacity; i++) {
      if(spots[i].getVehicle() == vehicle) {
        spots[i].setVehicle(null);
        return true;
      }
    }
    return false;
  }

  public void display() {
    for(int i=0; i < capacity; i++) {
      Spot spot = spots[i];
      Vehicle vehicle = spot.getVehicle();
      System.out.println("Spot: " + spot.getLocationId());
      if(vehicle == null) {
        System.out.println("Vehicle: Vacant");
      }
      else {
        System.out.println("Vehcile : " + vehicle.getType() + ", Number: " + vehicle.getId());
      }
      System.out.println("-------------------");
    }
  }

  private boolean addVehicleToCorrectSpot(Vehicle vehicle) {
    for(int i=0; i < capacity; i++) {
      if(spots[i].getVehicle() == null && spots[i].getType() == vehicle.getType()) {
        spots[i].setVehicle(vehicle);
        return true;
      }
    }
    return false;
  }

  private boolean addVehicleToVacantSpot(Vehicle vehicle) {
    for(int i=0; i < capacity; i++) {
      Spot spot = spots[i];
      if(spot.getVehicle() == null) {
        if(spot.getType() == Constant.TYPE_BUS) {
          spot.setVehicle(vehicle);
          return true;
        }
        if(spot.getType() == Constant.TYPE_CAR && vehicle.type == Constant.TYPE_BIKE) {
          spot.setVehicle(vehicle);
          return true;
        }
      }
    }
    return false;
  }

}

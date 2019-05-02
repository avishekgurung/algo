package design.problems.utils.problem05;

public class Spot {

  private int locationId;
  private Vehicle vehicle;
  private String type;

  Spot(int locationId, String type) {
    this.locationId = locationId;
    this.type = type;
  }

  public int getLocationId() {
    return locationId;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public String getType() {
    return type;
  }
}

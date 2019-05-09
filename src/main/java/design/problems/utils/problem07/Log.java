package design.problems.utils.problem07;

public class Log {

  private String type;
  private long time;
  private String message;

  Log(String type) {
    this.type = type;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setTime(long time) {
    this.time = time;
  }

  public long getTime() {
    return time;
  }

  public String getMessage() {
    return message;
  }

  public String getType() {
    return type;
  }
}

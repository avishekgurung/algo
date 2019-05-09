package design.problems.utils.problem07;

public class NetworkAppender implements Appender{

  private String url;
  private boolean use;

  NetworkAppender(String url, boolean use) {
    this.url = url;
    this.use = use;
  }

  public void process(Log log) {
    if(use) {
      System.out.println("Logging to network: " + url);
      System.out.println(log.getType() + " : " + log.getTime() + " : "  + log.getMessage());
    }
  }
}

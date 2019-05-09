package design.problems.utils.problem07;

public class DatabaseAppender implements Appender {

  private String database;
  private boolean use;
  private Appender networkAppender;


  DatabaseAppender(Appender networkAppender, String database, boolean use) {
    this.database = database;
    this.use = use;
    this.networkAppender = networkAppender;
  }

  public void process(Log log) {

    if(use) {
      System.out.println("Logging to databse: " + database);
      System.out.println(log.getType() + " : " + log.getTime() + " : "  + log.getMessage());
    }

    networkAppender.process(log);
  }
}

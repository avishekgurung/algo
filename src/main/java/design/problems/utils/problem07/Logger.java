package design.problems.utils.problem07;

public class Logger {

  private Appender databaseAppender;
  private Appender networkAppender;
  private Appender fileAppender;


  Logger() {
    networkAppender = new NetworkAppender("", false);
    fileAppender = new FileAppender(networkAppender, "", false);
    databaseAppender = new DatabaseAppender(fileAppender, "", false);
  }

  public void registerFileAppender(String filename) {
    
  }


}

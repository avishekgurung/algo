package design.problems.utils.problem07;

public class FileAppender implements Appender {

  private String filename;
  private boolean use;
  private Appender databaseAppender;

  FileAppender(Appender databaseAppender, String filename, boolean use) {
    this.databaseAppender = databaseAppender;
    this.use = use;
    this.filename = filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public void setUse(boolean use) {
    this.use = use;
  }

  public void setDatabaseAppender(Appender databaseAppender) {
    this.databaseAppender = databaseAppender;
  }

  public void process(Log log) {

    if(use) {
      writeToFile(log);
    }

    databaseAppender.process(log);
  }

  private void writeToFile(Log log) {
    System.out.println("Logging to file: " + filename);
    System.out.println(log.getType() + " : " + log.getTime() + " : "  + log.getMessage());
  }

}

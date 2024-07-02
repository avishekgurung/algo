package concurrency.problems.quota;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public abstract class BaseRequest {
    public String id;
    public String client;
    public abstract void execute();

}

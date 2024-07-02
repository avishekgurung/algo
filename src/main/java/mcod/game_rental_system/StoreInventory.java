package mcod.game_rental_system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class StoreInventory {
    private String gameName;
    private String storeName;
    private int price;
    private int availability;
}

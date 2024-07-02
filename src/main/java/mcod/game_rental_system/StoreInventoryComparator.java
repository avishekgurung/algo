package mcod.game_rental_system;

import java.util.Comparator;

public class StoreInventoryComparator implements Comparator<StoreInventory> {

    @Override
    public int compare(StoreInventory o1, StoreInventory o2) {
        if(o1.getAvailability() == 0) {
          return 1;
        } else if (o2.getAvailability() == 0) {
            return 1;
        } else {
            if(o1.getPrice() > o2.getPrice()) return 1;
            else return -1;
        }
    }
}

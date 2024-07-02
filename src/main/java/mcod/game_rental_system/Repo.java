package mcod.game_rental_system;

import java.util.*;

public class Repo {

    public Map<String, List<StoreInventory>> gameToStoreInventories;
    public Map<String, StoreInventory> gameStoreToStoreInventory;

    Repo() {
        gameToStoreInventories = new HashMap<>();
        gameStoreToStoreInventory = new HashMap<>();
    }

    public void addGameAndStoreInventory(StoreInventory storeInventory) {
        String gameName = storeInventory.getGameName();
        String storeName = storeInventory.getStoreName();

        if(!gameToStoreInventories.containsKey(gameName)) {
            List<StoreInventory> list = new ArrayList<>();
            gameToStoreInventories.put(gameName, list);
        }
        gameToStoreInventories.get(gameName).add(storeInventory);
        gameToStoreInventories.get(gameName).sort(new StoreInventoryComparator());
        gameStoreToStoreInventory.put(gameName + "-" + storeName, storeInventory);
    }

    public List<StoreInventory> search(String gameName) {
        int k = 3;
        List<StoreInventory> result = new ArrayList<>();
        List<StoreInventory> storeInventories = gameToStoreInventories.get(gameName);

        //System.out.println(storeInventories);
        int count = 0;

        while(count < k && count < storeInventories.size() && storeInventories.get(count).getAvailability() != 0) {
            result.add(storeInventories.get(count));
            count++;
        }
        return result;
    }

    public void rentGame(String gameName, String storeName) {
        StoreInventory storeInventory = gameStoreToStoreInventory.get(gameName + "-" + storeName);
        storeInventory.setAvailability(storeInventory.getAvailability()-1);
        List<StoreInventory> storeInventories = gameToStoreInventories.get(gameName);
        storeInventories.sort(new StoreInventoryComparator());
    }

    public void returnGame(String gameName, String storeName) {
        StoreInventory storeInventory = gameStoreToStoreInventory.get(gameName + "-" + storeName);
        storeInventory.setAvailability(storeInventory.getAvailability()+1);
        List<StoreInventory> storeInventories = gameToStoreInventories.get(gameName);
        storeInventories.sort(new StoreInventoryComparator());
    }


}

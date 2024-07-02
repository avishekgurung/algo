package mcod.game_rental_system;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Repo repo = new Repo();


        StoreInventory s1 = new StoreInventory("Farmville", "Bangalore1", 1200, 2);
        StoreInventory s2 = new StoreInventory("Farmville", "Bangalore2", 1100, 1);
        StoreInventory s3 = new StoreInventory("Farmville", "Bangalore3", 1300, 3);
        StoreInventory s4 = new StoreInventory("Farmville", "Bangalore4", 1000, 0);

        repo.addGameAndStoreInventory(s1);
        repo.addGameAndStoreInventory(s2);
        repo.addGameAndStoreInventory(s3);
        repo.addGameAndStoreInventory(s4);


        search(repo);
        repo.rentGame("Farmville", "Bangalore2");

        search(repo);



    }

    private static void search(Repo repo) {
        List<StoreInventory> searchResults = repo.search("Farmville");
        for(StoreInventory storeInventory : searchResults) {
            System.out.println(storeInventory);
        }
        System.out.println("---------------------------");
    }
}

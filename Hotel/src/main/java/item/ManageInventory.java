package item;

public interface ManageInventory { 
    void addItem(Item item);
    void removeItem(Item item);
    void updateQuantity(int id, int quantity);
    Item findItem(int id);
    void printInventory();
}

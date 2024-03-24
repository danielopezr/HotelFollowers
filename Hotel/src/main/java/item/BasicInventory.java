package item;

import java.util.List;
import java.util.ArrayList;

public class BasicInventory implements ManageInventory{
    private List<Item> inventory;
    private int nextId;
    
    public BasicInventory() {
        this.inventory = new ArrayList<>();
        this.nextId = 1;
        initializeInventory();
    }
    
    private void initializeInventory() {
        // Estos articulos solo son de ejemplo, por lo que estan en espera de modificacion
        addItem(new Item("Cama", 1, 0));
        addItem(new Item("Silla", 1, 0));
        addItem(new Item("Mesa", 1, 0));
        addItem(new Item("Lampara", 1, 0));
        addItem(new Item("Cortina", 1, 0));
        addItem(new Item("Alfombra", 1, 0));
        addItem(new Item("Toalla", 1, 0));
        addItem(new Item("Televisor", 1, 0));
        addItem(new Item("Telefono", 1, 0));
    }
    
    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
    
    @Override
    public void addItem(Item item) {
        item.setId(nextId);
        inventory.add(item);
        nextId++;
    }

    @Override
    public void removeItem(Item item) {
        inventory.remove(item);
    }
    
    @Override
    public void updateQuantity(int itemId, int newQuantity) {
        Item itemToUpdate = findItem(itemId);
        if (itemToUpdate != null) {
            itemToUpdate.setQuantity(newQuantity);
            System.out.println("Cantidad del articulo '" + itemToUpdate.getName() + "' actualizada a: " + newQuantity);
        } else {
            System.out.println("El articulo con ID " + itemId + " no se encontro en el inventario");
        }
    }
    
    @Override
    public Item findItem(int id) {
        for (Item item : inventory) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    
    @Override
    public void printInventory() {
        System.out.println("-------------------------");
        for (Item item : inventory) {
            item.printInfo();
            System.out.println("-------------------------");
        }
    }    
}

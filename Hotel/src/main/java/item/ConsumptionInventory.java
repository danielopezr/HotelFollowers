package item;

import java.util.List;
import java.util.ArrayList;

public class ConsumptionInventory implements ManageInventory{
    private List<Item> inventory;
    private int nextId;
    
    public ConsumptionInventory() {
        this.inventory = new ArrayList<>();
        this.nextId = 1;
        initializeInventory();
    }
    
    private void initializeInventory() {
        // Agregar los elementos iniciales al inventario
        addItem(new Item("Cerveza", 0, 2.0));
        addItem(new Item("Refresco", 0, 4.0));
        addItem(new Item("Champu", 0, 2.0));
        addItem(new Item("Jabon", 0, 3.0));
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
            System.out.println("El artículo con ID " + itemId + " no se encontro en el inventario");
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
        System.out.println("-----------------------------");
        for (Item item : inventory) {
            item.printInfo();
            System.out.println("-----------------------------");
        }
    }
    
    public void Cost(int itemId, int newCost) {
        Item itemToUpdate = findItem(itemId);
        if (itemToUpdate != null) {
            itemToUpdate.setCost(newCost);
            System.out.println("Costo del articulo '" + itemToUpdate.getName() + "' actualizada a: " + newCost);
        } else {
            System.out.println("El articulo con ID " + itemId + " no se encontro en el inventario");
        }
    }
    
    public List<Item> getInventory() {
        return inventory;
    }
}

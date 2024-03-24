package room;

import item.*;

public class Room {
    private int id;
    private RoomLocation location;
    private RoomType type;
    private int capacity;
    private double cost;
    private RoomStatus status;
    private BasicInventory basicInventory;
    private ConsumptionInventory consumInventory;
    
    public Room() {
    }

    public Room(RoomType type, RoomLocation location) {
        this.id = 0;
        this.type = type;
        this.location = location;
        calculateCapacity();
        calculateCost();
        this.status = new RoomStatus(true, true, false, false);
        this.basicInventory = new BasicInventory();
        this.consumInventory = new ConsumptionInventory();
    }
    
    private void calculateCapacity() {
        // Modificar a conveniencia la capacidad según el tipo de habitación
        switch (type) {
            case SINGLE -> {
                this.capacity = 1;
            }
            case DOUBLE -> {
                this.capacity = 2;
            }
            case FAMILIAR -> {
                this.capacity = 4;
            }
            case SUITE -> {
                this.capacity = 2;
            }
            default -> {
                this.capacity = 0;
            }
        }
    }
    
    private void calculateCost() {
        // Modificar a conveniencia el precio según el tipo de habitación
        switch (type) {
            case SINGLE -> {
                this.cost = 50.0;
            }
            case DOUBLE -> {
                this.cost = 80.0;
            }
            case FAMILIAR -> {
                this.cost = 110.0;
            }
            case SUITE -> {
                this.cost = 150.0;
            }
            default -> {
                this.cost = 0;
            }
        }
    }
    
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomLocation getLocation() {
        return location;
    }

    public void setLocation(RoomLocation location) {
        this.location = location;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public BasicInventory getBasicInventory() {
        return basicInventory;
    }

    public void setBasicInventory(BasicInventory basicInventory) {
        this.basicInventory = basicInventory;
    }

    public ConsumptionInventory getConsumInventory() {
        return consumInventory;
    }

    public void setConsumInventory(ConsumptionInventory consumInventory) {
        this.consumInventory = consumInventory;
    }
    
    public void printRoom() {
        System.out.println("ID: " + getId());
        System.out.println("Tipo: " + getType());
        System.out.println(getLocation().toString());
        System.out.println("Capacidad: " + getCapacity());
        System.out.println("Costo: $" + getCost());
        getStatus().printStatus();
    }
}

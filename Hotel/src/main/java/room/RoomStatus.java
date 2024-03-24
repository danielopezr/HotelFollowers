package room;

public class RoomStatus {
    private boolean available;
    private boolean clean;
    private boolean damaged;
    private boolean stolen;

    public RoomStatus() {
    }

    public RoomStatus(boolean availability, boolean clean, boolean damaged, boolean stolen) {
        this.available = availability;
        this.clean = clean;
        this.damaged = damaged;
        this.stolen = stolen;
    }

    public boolean isStolen() {
        return stolen;
    }

    public void setStolen(boolean stolen) {
        this.stolen = stolen;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }
    
    public void printStatus() {
        System.out.print("Estado: ");
        if (isAvailable()) {
            System.out.println("Disponible");
        } else {
            System.out.println("No Disponible");
            System.out.println("    - Limpia: " + isClean());
            System.out.println("    - Dañada: " + isDamaged());
            System.out.println("    - Robada: " + isStolen());
        }
    }
}

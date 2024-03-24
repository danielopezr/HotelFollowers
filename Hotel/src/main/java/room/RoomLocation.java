package room;

public class RoomLocation {
    private int block;
    private int floor;
    private int number;

    public RoomLocation() {
    }

    public RoomLocation(int block, int floor, int number) {
        this.block = block;
        this.floor = floor;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "Ubicacion:\n    -Bloque: " + block + "\n    -Piso: " + 
                floor + "\n    -No: " + number;
    }
}

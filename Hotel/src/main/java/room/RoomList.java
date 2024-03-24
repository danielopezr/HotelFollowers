package room;

import java.util.List;
import java.util.ArrayList;

public class RoomList {
    private List<Room> rooms;
    private int nextId;
    
    public RoomList() {
        this.rooms = new ArrayList<>();
        this.nextId = 1;
    }
    
    public List<Room> getRooms() {
        return rooms;
    }

    
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    
    public void addRoom(Room room) {
        room.setId(nextId);
        rooms.add(room);
        nextId++;
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }
    
    public void updateRoom(int roomId, Room newRoom) {
        Room room = findRoom(roomId);
        if (room != null) {
            room.setLocation(newRoom.getLocation());
            room.setType(newRoom.getType());
            room.setStatus(newRoom.getStatus());
        } 
        else {
        System.out.println("La habitacion con ID " + roomId + " no se encontro en la lista");
        }
    }
    
    public Room findRoom(int id) {
        for (Room room : rooms) {
            if (room.getId() == id) {
                return room;
            }
        }
        return null;
    }
    
    public void printRooms() {
        System.out.println("-------------------------");
        for (Room room : rooms) {
            room.printRoom();
            System.out.println("-------------------------");
        }
    }
}

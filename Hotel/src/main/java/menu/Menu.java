package menu;

import item.*;
import java.util.List;
import room.*;

public class Menu {
    Reader reader = new Reader();
    RoomList roomList = new RoomList();
    
    public void start() {
        System.out.println("\n¡Bienvenido al Sistema de Gestion del Hotel!");
        System.out.println("1. Administracion");
        System.out.println("2. Salir");
        int option = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 2);
        
        switch (option) {
            case 1 -> managerMenu();
            case 2 -> exit();
            default -> System.out.println("Opcion no valida");
        }
    }
    
    public void managerMenu() {
        System.out.println("\nMenu de Administrador:");
        System.out.println("1. Gestion de Habitaciones");
        System.out.println("2. Gestion de Inventario");
        System.out.println("3. Volver Atras");
        System.out.println("4. Salir");
        int option = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 4);
        
        switch (option) {
            case 1 -> roomsMenu();
            case 2 -> itemsMenu();
            case 3 -> start();
            case 4 -> exit();
            default -> System.out.println("Opcion no valida");
        }
    }
    
    public void roomsMenu() {
        System.out.println("\nMenu de Habitaciones:");
        System.out.println("1. Agregar Habitacion");
        System.out.println("2. Eliminar Habitacion");
        System.out.println("3. Actualizar detalles de Habitacion");
        System.out.println("4. Ver lista de Habitaciones");
        System.out.println("5. Volver Atras");
        System.out.println("6. Salir");
        int option = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 6);
        
        switch (option) {
            case 1 -> addRoomMenu();
            case 2 -> removeRoomMenu();
            case 3 -> updateRoomMenu();
            case 4 -> showRoomsMenu();
            case 5 -> managerMenu();
            case 6 -> exit();
            default -> System.out.println("Opcion no valida");
        }
    }
    
    public void itemsMenu() {
        System.out.println("\nMenu de Articulos:");
        System.out.println("1. Articulos Generales");
        System.out.println("2. Articulos Consumibles");
        System.out.println("3. Volver Atras");
        System.out.println("4. Salir");
        int option = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 4);
        
        switch (option) {
            case 1 -> basicItemsMenu();
            case 2 -> consumptionItemsMenu();
            case 3 -> managerMenu();
            case 4 -> exit();
            default -> System.out.println("Opcion no valida");
        }
    }
    
    public void basicItemsMenu() {
        System.out.println("\nMenu de Articulos Basicos:");
        System.out.println("1. Agregar Articulo");
        System.out.println("2. Eliminar Articulo");
        System.out.println("3. Actualizar detalles de Articulo");
        System.out.println("4. Ver lista de Articulos");
        System.out.println("5. Volver Atras");
        System.out.println("6. Salir");
        int option = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 6);
        
        switch (option) {
            case 1 -> addBasicItemMenu();
            case 2 -> removeBasicItemMenu();
            case 3 -> updateBasicItemMenu();
            case 4 -> showBasicItemMenu();
            case 5 -> itemsMenu();
            case 6 -> exit();
            default -> System.out.println("Opcion no valida");
        }
    }
    
    public void consumptionItemsMenu() {
        System.out.println("\nMenu de Articulos Consumibles:");
        System.out.println("1. Agregar Articulo");
        System.out.println("2. Eliminar Articulo");
        System.out.println("3. Actualizar detalles de Articulo");
        System.out.println("4. Ver lista de Articulos");
        System.out.println("5. Volver Atras");
        System.out.println("6. Salir");
        int option = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 6);
        
        switch (option) {
            case 1 -> addConsumptionItemMenu();
            case 2 -> removeConsumptionItemMenu();
            case 3 -> updateConsumptionItemMenu();
            case 4 -> showConsumptionItemMenu();
            case 5 -> itemsMenu();
            case 6 -> exit();
            default -> System.out.println("Opcion no valida");
        }
    }
    
    public void addRoomMenu() {
        System.out.println("\nAgregar Habitacion:");
        
        System.out.println("Seleccione el tipo de habitacion:");
        System.out.println("1. Normal");
        System.out.println("2. Doble");
        System.out.println("3. Familiar");
        System.out.println("4. Suite");
        int option = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 4);
        RoomType type = null;
        switch (option) {
            case 1 -> type = RoomType.SINGLE;
            case 2 -> type = RoomType.DOUBLE;
            case 3 -> type = RoomType.FAMILIAR; 
            case 4 -> type = RoomType.SUITE; 
            default -> System.out.println("Opcion no valida");
        }
        
        System.out.println("Seleccione la ubicacion de la habitacion:");
        int block = reader.validatePositiveInt("Ingrese el bloque: ");
        int floor = reader.validatePositiveInt("Ingrese el piso: ");
        int number = reader.validatePositiveInt("Ingrese el numero: ");
        
        RoomLocation location = new RoomLocation(block, floor, number);
        Room newRoom = new Room(type, location);
        roomList.addRoom(newRoom);
        System.out.println("Habitacion agregada con exito");
        roomsMenu();
    }
    
    public void removeRoomMenu() {
        System.out.println("\nEliminar Habitacion:");
        int roomId = reader.validatePositiveInt("Ingrese el ID de la habitacion que desea eliminar: ");
        Room roomToRemove = roomList.findRoom(roomId);
        
        if (roomToRemove != null) {
            roomList.removeRoom(roomToRemove);
            System.out.println("Habitacion eliminada exitosamente.");
        } else {
            System.out.println("La habitacion con ID " + roomId + " no se encontró en la lista");
        }
        roomsMenu();
    }
    
    public void updateRoomMenu() {
        System.out.println("\nActualizar Habitacion:");
        System.out.println("1. Actualizar Tipo");
        System.out.println("2. Actualizar Ubicacion");
        System.out.println("3. Actualizar Estatus");
        System.out.println("4. Volver Atras");
        System.out.println("5. Salir");
        int option = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 5);
        
        switch (option) {
            case 1 -> updateTypeMenu();
            case 2 -> updateLocationMenu();
            case 3 -> updateStatusMenu();
            case 4 -> roomsMenu();
            case 5 -> exit();
            default -> System.out.println("Opcion no valida");
        }
    }
    
    public void updateTypeMenu() {
        System.out.println("\nActualizar Tipo de Habitacion:");
        int roomId = reader.validatePositiveInt("Ingrese el ID de la habitacion que desea actualizar: ");
        Room room = roomList.findRoom(roomId);
        
        if (room != null) {
            System.out.println("Seleccione el tipo de habitacion:");
            System.out.println("1. Normal");
            System.out.println("2. Doble");
            System.out.println("3. Familiar");
            System.out.println("4. Suite");
            int option = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 4);
            RoomType newType = null;
            
            switch (option) {
                case 1 -> newType = RoomType.SINGLE;
                case 2 -> newType = RoomType.DOUBLE;
                case 3 -> newType = RoomType.FAMILIAR; 
                case 4 -> newType = RoomType.SUITE; 
                default -> System.out.println("Opcion no valida");
            }
            double newCost = reader.readDouble("Ingrese el nuevo precio de la habitacion: ");
            int newCapacity = reader.validatePositiveInt("Ingrese la nueva capacidad de la habitacion: ");
            
            room.setCost(newCost);
            room.setCapacity(newCapacity);
            room.setType(newType);
            
            System.out.println("Tipo de habitacion actualizado correctamente");
            updateRoomMenu();
        } else {
            System.out.println("La habitacion con ID " + roomId + " no se encontro");
            updateRoomMenu();
        }        
    }
    
    public void updateLocationMenu() {
        System.out.println("\nActualizar Ubicacion de la Habitacion:");
        int roomId = reader.validatePositiveInt("Ingrese el ID de la habitacion que desea actualizar: ");
        Room room = roomList.findRoom(roomId);
    
        if (room != null) {
            int block = reader.validatePositiveInt("Ingrese el nuevo bloque: ");
            int floor = reader.validatePositiveInt("Ingrese el nuevo piso: ");
            int number = reader.validatePositiveInt("Ingrese el nuevo numero: ");
        
            RoomLocation newLocation = new RoomLocation(block, floor, number);
            room.setLocation(newLocation);
        
            System.out.println("Ubicacion de la habitacion actualizada correctamente");
            updateRoomMenu();
        } else {
            System.out.println("La habitacion con ID " + roomId + " no se encontro");
            updateRoomMenu();
        }
    }
    
    public void updateStatusMenu() {
    System.out.println("\nActualizar Estado de la Habitacion:");
    int roomId = reader.validatePositiveInt("Ingrese el ID de la habitación que desea actualizar: ");
    Room room = roomList.findRoom(roomId);
    
    if (room != null) {
        boolean clean = false;
        boolean damaged = false;
        boolean stolen = false;
        
        System.out.println("¿La habitacion esta limpia?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int option1 = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 2);
        
        switch (option1) {
            case 1 -> clean = true;
            case 2 -> clean = false;
            default -> System.out.println("Opcion no valida");
        }
        
        System.out.println("¿La habitacion tiene daños?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int option2 = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 2);
        
        switch (option2) {
            case 1 -> damaged = true;
            case 2 -> damaged = false;
            default -> System.out.println("Opción no valida");
        }
        
        System.out.println("¿La habitación fue robada?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int option3 = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 2);
        
        switch (option3) {
            case 1 -> stolen = true;
            case 2 -> stolen = false;
            default -> System.out.println("Opcion no valida");
        }
        
        boolean availability = clean && !damaged && !stolen;
        RoomStatus newStatus = new RoomStatus(availability, clean, damaged, stolen);
        room.setStatus(newStatus);
        System.out.println("Estado de la habitacion actualizado correctamente");
        updateRoomMenu();
    } else {
        System.out.println("La habitacion con ID " + roomId + " no se encontro");
        updateRoomMenu();
    }
}

    
    public void showRoomsMenu() {
        System.out.println("\nLista de Habitaciones:");

        if (roomList.getRooms().isEmpty()) {
            System.out.println("No hay habitaciones para mostrar");
            roomsMenu();
        }
        
        roomList.printRooms();
        roomsMenu();
    }
    
    public void addBasicItemMenu() {
        System.out.println("\nAgregar Articulo al Inventario de una Habitacion:");
        int roomId = reader.validatePositiveInt("Ingrese el ID de la habitacion a la que desea agregar el articulo: ");

        Room room = roomList.findRoom(roomId);

        if (room != null) {
            String name = reader.readString("Ingrese el nombre del articulo: ");
            int quantity = reader.validatePositiveInt("Ingrese la cantidad del articulo: ");
            double cost = 0;

            Item newItem = new Item(name, quantity, cost);
            room.getBasicInventory().addItem(newItem);
            System.out.println("Articulo agregado exitosamente al inventario general de la habitacion " + roomId);
        } else {
            System.out.println("La habitacion con ID " + roomId + " no se encontro");
        }
        basicItemsMenu();
    }
    
    public void removeBasicItemMenu() {
        System.out.println("\nEliminar Articulo del Inventario de una Habitacion:");
        int roomId = reader.validatePositiveInt("Ingrese el ID de la habitacion de la que desea eliminar el articulo: ");

        Room room = roomList.findRoom(roomId);

        if (room != null) {
            int itemId = reader.validatePositiveInt("Ingrese el ID del articulo que desea eliminar: ");
            Item itemToRemove = room.getBasicInventory().findItem(itemId);

            if (itemToRemove != null) {
                room.getBasicInventory().removeItem(itemToRemove);
                System.out.println("Articulo eliminado exitosamente del inventario de la habitacion " + roomId);
            } else {
                System.out.println("El articulo con ID " + itemId + " no se encontro en el inventario general de la habitacion " + roomId);
            }
        } else {
            System.out.println("La habitacion con ID " + roomId + " no se encontro");
        }
        basicItemsMenu();
    }
    
    public void updateBasicItemMenu() {
        System.out.println("\nActualizar Articulo del Inventario de una Habitacion:");
        int roomId = reader.validatePositiveInt("Ingrese el ID de la habitacion en la que desea actualizar el articulo: ");
        Room room = roomList.findRoom(roomId);

        if (room != null) {
            int itemId = reader.validatePositiveInt("Ingrese el ID del articulo que desea actualizar: ");
            Item itemToUpdate = room.getBasicInventory().findItem(itemId);

            if (itemToUpdate != null) {
                int newQuantity = reader.validatePositiveInt("Ingrese la nueva cantidad del articulo: ");
                itemToUpdate.setQuantity(newQuantity);

                System.out.println("Articulo actualizado exitosamente en el inventario de la habitacion " + roomId);
            } else {
                System.out.println("El articulo con ID " + itemId + " no se encontro en el inventario de la habitacion " + roomId);
            }
        } else {
            System.out.println("La habitacion con ID " + roomId + " no se encontro");
        }
        basicItemsMenu();
    }
    
    public void showBasicItemMenu() {
        System.out.println("\nMostrar Inventario de una Habitación:");
        int roomId = reader.validatePositiveInt("Ingrese el ID de la habitacion de la que desea ver el inventario: ");
        
        Room room = roomList.findRoom(roomId);

        if (room != null) {
            System.out.println("\nInventario estandar de la Habitación " + roomId + ":");
            BasicInventory roomInventory = room.getBasicInventory();
            List<Item> items = roomInventory.getInventory();

            if (items.isEmpty()) {
                System.out.println("El inventario de la habitacion esta vacio");
            } else {
                roomInventory.printInventory();
            }
        } else {
            System.out.println("La habitacion con ID " + roomId + " no se encontro");
        }
        basicItemsMenu();
    }
    
    public void addConsumptionItemMenu() {
        System.out.println("\nAgregar Articulo al Inventario de una Habitacion:");
        int roomId = reader.validatePositiveInt("Ingrese el ID de la habitacion a la que desea agregar el articulo: ");

        Room room = roomList.findRoom(roomId);

        if (room != null) {
            String name = reader.readString("Ingrese el nombre del articulo: ");
            int quantity = reader.validatePositiveInt("Ingrese la cantidad del articulo: ");
            double cost = reader.validatePositiveDouble("Ingrese el costo del articulo: ");

            Item newItem = new Item(name, quantity, cost);
            room.getConsumInventory().addItem(newItem);
            System.out.println("Articulo agregado exitosamente al inventario consumible de la habitacion " + roomId);
        } else {
            System.out.println("La habitacion con ID " + roomId + " no se encontro");
        }
        consumptionItemsMenu();
    }
    
    public void removeConsumptionItemMenu() {
        System.out.println("\nEliminar Articulo del Inventario de una Habitacion:");
        int roomId = reader.validatePositiveInt("Ingrese el ID de la habitacion de la que desea eliminar el articulo: ");

        Room room = roomList.findRoom(roomId);

        if (room != null) {
            int itemId = reader.validatePositiveInt("Ingrese el ID del articulo que desea eliminar: ");
            Item itemToRemove = room.getConsumInventory().findItem(itemId);

            if (itemToRemove != null) {
                room.getConsumInventory().removeItem(itemToRemove);
                System.out.println("Articulo eliminado exitosamente del inventario de la habitacion " + roomId);
            } else {
                System.out.println("El articulo con ID " + itemId + " no se encontro en el inventario consumible de la habitacion " + roomId);
            }
        } else {
            System.out.println("La habitacion con ID " + roomId + " no se encontro");
        }
        consumptionItemsMenu();
    }
    
    public void updateConsumptionItemMenu() {
        System.out.println("\nActualizar Articulo del Inventario de una Habitacion:");
        int roomId = reader.validatePositiveInt("Ingrese el ID de la habitacion en la que desea actualizar el articulo: ");
        Room room = roomList.findRoom(roomId);

        if (room != null) {
            int itemId = reader.validatePositiveInt("Ingrese el ID del articulo que desea actualizar: ");
            Item itemToUpdate = room.getConsumInventory().findItem(itemId);

            if (itemToUpdate != null) {
                int newQuantity = reader.validatePositiveInt("Ingrese la nueva cantidad del articulo: ");
                double newCost = reader.validatePositiveDouble("Ingrese el nuevo costo del articulo: ");
                
                itemToUpdate.setQuantity(newQuantity);
                itemToUpdate.setCost(newCost);

                System.out.println("Articulo actualizado exitosamente en el inventario consumible de la habitacion " + roomId);
            } else {
                System.out.println("El articulo con ID " + itemId + " no se encontro en el inventario de la habitacion " + roomId);
            }
        } else {
            System.out.println("La habitacion con ID " + roomId + " no se encontro");
        }
        consumptionItemsMenu();
    }
    
    public void showConsumptionItemMenu() {
        System.out.println("\nMostrar Inventario de una Habitacion:");
        int roomId = reader.validatePositiveInt("Ingrese el ID de la habitacion de la que desea ver el inventario: ");
        
        Room room = roomList.findRoom(roomId);

        if (room != null) {
            System.out.println("\nInventario consumible de la Habitacion " + roomId + ":");
            ConsumptionInventory roomInventory = room.getConsumInventory();
            List<Item> items = roomInventory.getInventory();

            if (items.isEmpty()) {
                System.out.println("El inventario de la habitacion esta vacio");
            } else {
                roomInventory.printInventory();
            }
        } else {
            System.out.println("La habitacion con ID " + roomId + " no se encontro");
        }
        consumptionItemsMenu();
    }
    
    public void exit() {
        System.out.println("\n¿Esta seguro que desea salir?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int option = reader.validateRange("Ingrese el numero que corresponda a su eleccion: ", 1, 2);
        
        switch (option) {
            case 1 -> System.exit(0);
            case 2 -> start();
            default -> System.out.println("Opcion no valida");
        }
    }
}

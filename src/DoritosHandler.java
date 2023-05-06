public class DoritosHandler extends SnackDispenseHandler {
    public DoritosHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void handleRequest(VendingMachine machine) {
        if(machine.getSelectedSnack().getName().equals("Doritos")) {
            System.out.println("Dispensing Doritos");
            machine.removeStock(machine.getSelectedSnack().getName(), 1);
        }
        else {
            super.handleRequest(machine);
        }
    }
}

public class SnickersHandler extends SnackDispenseHandler {
    public SnickersHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void handleRequest(VendingMachine machine) {
        if(machine.getSelectedSnack().getName().equals("Snickers")) {
            System.out.println("Dispensing Snickers");
            machine.removeStock(machine.getSelectedSnack().getName(), 1);
        }
        else {
            super.handleRequest(machine);
        }
    }
}

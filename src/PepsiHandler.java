public class PepsiHandler extends SnackDispenseHandler {
    public PepsiHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void handleRequest(VendingMachine machine) {
        if(machine.getSelectedSnack().getName().equals("Pepsi")) {
            System.out.println("Dispensing Pepsi");
            machine.removeStock(machine.getSelectedSnack().getName(), 1);
        }
        else {
            super.handleRequest(machine);
        }
    }
}

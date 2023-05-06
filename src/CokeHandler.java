public class CokeHandler extends SnackDispenseHandler {
    public CokeHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void handleRequest(VendingMachine machine) {
        if(machine.getSelectedSnack().getName().equals("Coke")) {
            System.out.println("Dispensing Coke");
            machine.removeStock(machine.getSelectedSnack().getName(), 1);
        }
        else {
            super.handleRequest(machine);
        }
    }
}

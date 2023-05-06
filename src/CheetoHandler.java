public class CheetoHandler extends SnackDispenseHandler {
    public CheetoHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void handleRequest(VendingMachine machine) {
        if(machine.getSelectedSnack().getName().equals("Cheetos")) {
            System.out.println("Dispensing Cheetos");
            machine.removeStock(machine.getSelectedSnack().getName(), 1);
        }
        else {
            super.handleRequest(machine);
        }
    }
}

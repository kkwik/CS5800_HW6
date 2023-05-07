public class DispensingSnackState implements StateOfVendingMachine {
    public void selectSnack(VendingMachine machine, String snackName) {}

    public void insertMoney(VendingMachine machine, double money) {}

    public void dispenseSnack(VendingMachine machine) {
        SnackDispenseHandler handler = new CokeHandler(new PepsiHandler(new CheetoHandler(new DoritosHandler(new KitKatHandler(new SnickersHandler(null))))));

        machine.purchaseSelectedSnack();
        handler.handleRequest(machine);

        machine.resetMachine();

        machine.setState(new IdleState());
    }

    public void cancelTransaction(VendingMachine machine) {
        System.out.println("Cancelling transaction...");
        machine.resetMachine();
        machine.setState(new IdleState());
    }
}

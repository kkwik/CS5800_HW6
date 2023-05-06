public class DispensingSnackState implements StateOfVendingMachine {
    public void selectSnack(VendingMachine machine, String snackName) {}

    public void insertMoney(VendingMachine machine, double money) {}

    public void dispenseSnack(VendingMachine machine) {
        machine.purchaseSelectedSnack();

        machine.resetMachine();

        machine.setState(new IdleState());
    }

    public void cancelTransaction(VendingMachine machine) {
        machine.resetMachine();
        machine.setState(new IdleState());
    }
}

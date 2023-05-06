public class WaitingForMoneyState implements StateOfVendingMachine {
    public void idle(VendingMachine machine) {
        System.out.println("WaitingForMoney -> Idle");
        machine.setState(new IdleState());
    }

    public void waitingForMoney(VendingMachine machine) {}

    public void waitingForSelect(VendingMachine machine) {

    }

    public void dispensingSnack(VendingMachine machine) {}

    public void endTransaction(VendingMachine machine) {
        machine.reset();

        machine.setState(new IdleState());
    }
}

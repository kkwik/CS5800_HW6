public class IdleState implements StateOfVendingMachine {
    public void idle(VendingMachine machine) {}

    public void waitingForMoney(VendingMachine machine) {
        System.out.println("IdleState -> WaitingForMoney");
        machine.setState(new WaitingForMoneyState());
    }

    public void waitingForSelect(VendingMachine machine) {}

    public void dispensingSnack(VendingMachine machine) {}

    public void endTransaction(VendingMachine machine) {}
}

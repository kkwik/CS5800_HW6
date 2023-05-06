public class DispensingSnackState implements StateOfVendingMachine {
    public void idle(VendingMachine machine) {
        System.out.println("DispensingSnack -> Idle");
        machine.setState(new IdleState());
    }

    public void waitingForMoney(VendingMachine machine) {}

    public void dispensingSnack(VendingMachine machine) {}
}

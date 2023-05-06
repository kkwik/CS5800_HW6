public class WaitingForMoneyState implements StateOfVendingMachine {
    public void selectSnack(VendingMachine machine, String snackName) {}

    public void insertMoney(VendingMachine machine, double money) {
        machine.addFunds(money);

        if(machine.containsSelectedSnack() && machine.canAffordSelectedSnack()) {
            machine.setState(new DispensingSnackState());
        }
        else if(!machine.containsSelectedSnack()) {
            System.out.println(String.format("No %s available, returning money", machine.getSelectedSnack().getName()));
            this.cancelTransaction(machine);
        }
    }

    public void dispenseSnack(VendingMachine machine) {}

    public void cancelTransaction(VendingMachine machine) {
        machine.resetMachine();
        machine.setState(new IdleState());
    }
}

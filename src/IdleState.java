public class IdleState implements StateOfVendingMachine {
    public void selectSnack(VendingMachine machine, String snackName) {
        if(machine.machineContainsSnack(snackName)) {
            System.out.println(String.format("%s costs $%.2f", snackName, machine.getSnackCost(snackName)));
            machine.selectSnack(snackName);
            machine.setState(new WaitingForMoneyState());
        }
        else
            System.out.println("Snack is not valid");
    }

    public void insertMoney(VendingMachine machine, double money) {}

    public void dispenseSnack(VendingMachine machine) {}

    public void cancelTransaction(VendingMachine machine) {}
}

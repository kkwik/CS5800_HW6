public class IdleState implements StateOfVendingMachine {
    public void selectSnack(VendingMachine machine, String snackName) {
        if(machine.machineContainsSnack(snackName)) {
            System.out.println(String.format("%s costs $%.2f", snackName, machine.getSnackCost(snackName)));

            machine.setSelectedSnack(snackName);
            machine.setState(new WaitingForMoneyState());


        }
        else
            System.out.println("Snack is not valid or the machine is out of them");
    }

    public void insertMoney(VendingMachine machine, double money) {
        System.out.println("Please select a snack before inserting money");
    }

    public void dispenseSnack(VendingMachine machine) {
        System.out.println("Please select a snack and pay before attempting to dispense snack");
    }

    public void cancelTransaction(VendingMachine machine) {}
}

public class WaitingForMoneyState implements StateOfVendingMachine {
    public void selectSnack(VendingMachine machine, String snackName) {}

    public void insertMoney(VendingMachine machine, double money) {
        machine.addFunds(money);
        System.out.println(String.format("Added $%.2f in funds", money));

        if(machine.containsSelectedSnack() && machine.canAffordSelectedSnack()) {
            System.out.println(String.format("Ready to dispense %s", machine.getSelectedSnack().getName()));
            machine.setState(new DispensingSnackState());
        }
        else if(!machine.containsSelectedSnack()) {
            System.out.println(String.format("No %s available, returning money", machine.getSelectedSnack().getName()));
            this.cancelTransaction(machine);
        }
        else {
            System.out.println(String.format("$%.2f inserted, %s costs $.2f. Please insert $.2f more", machine.getFundsAmount(), machine.getSelectedSnack().getName(), machine.getSelectedSnack().getPrice(), machine.getSelectedSnack().getPrice() - machine.getFundsAmount()));
        }
    }

    public void dispenseSnack(VendingMachine machine) {}

    public void cancelTransaction(VendingMachine machine) {
        System.out.println("Cancelling transaction...");
        machine.resetMachine();
        machine.setState(new IdleState());
    }
}

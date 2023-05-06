import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachine implements StateMachine {
    private StateOfVendingMachine stateOfVendingMachine;
    private Snack selectedSnack;
    private double currentPaymentAmount;
    private HashMap<String, Snack> inventory;

    public VendingMachine() {
        this.stateOfVendingMachine = new IdleState();
        this.selectedSnack = null;
        this.currentPaymentAmount = 0.0;
        this.inventory = new HashMap<>();
    }

    public void addStock(String name, int count) {
        if(!SnackFactory.validSnackName(name)) {
            System.out.println(String.format("%s is not a valid snack name", name));
            return;
        }

        if(!inventory.containsKey(name))
            inventory.put(name, SnackFactory.getSnack(name));

        this.updateInventory(name, inventory.get(name).getQuantity() + count);

    }

    public void removeStock(String name, int count) {
        addStock(name, -count);
    }

    public void updateInventory(String name, int newTotal) {
        Snack temp = inventory.get(name);
        temp.setQuantity(newTotal);
        inventory.put(name, temp);
    }

    public void printInventory() {
        System.out.println("Inventory: ");
        for(Snack snack : inventory.values()) {
        System.out.println(String.format("%s: %d", snack.getName(), snack.getQuantity()));
        }
        System.out.println();
    }


    public StateOfVendingMachine getState() {
        return this.stateOfVendingMachine;
    }

    public void setState(StateOfVendingMachine state) {
        this.stateOfVendingMachine = state;
    }

    public Snack getSelectedSnack() {
        return this.selectedSnack;
    }

    public void insertMoney(double money) {
        if(this.stateOfVendingMachine.getClass() != WaitingForMoneyState.class || this.selectedSnack == null) {
            System.out.println("Attempted to insert money, please select a snack first");
            return;
        }

        this.currentPaymentAmount += money;
        System.out.println(String.format("Inserted $%.2f, current balance is $%.2f", money, currentPaymentAmount));
    }

    public void selectSnack(String snackName) {
        if(machineContainsSnack(snackName)) {
            this.selectedSnack = SnackFactory.getSnack(snackName);

            System.out.println("Selected " + snackName);

            this.stateOfVendingMachine.waitingForMoney(this);
        }
        else {
            System.out.println(String.format("Machine does not contain snack %s", snackName));
        }
    }





    public void dispenseSnackIfPossible() {
        if(canAffordSelectedSnack()) {
            System.out.println("Payment accepted, preparing to dispense snack");

            this.dispenseSnack();
        }
        else {
            System.out.println(String.format("%s costs $%.2f. You have inserted $%.2f, please insert $%.2f more", this.selectedSnack.getName(), selectedSnack.getPrice(), currentPaymentAmount, selectedSnack.getPrice() - currentPaymentAmount));
        }
    }

    public void dispenseSnack() {
        stateOfVendingMachine.dispensingSnack(this);

        this.currentPaymentAmount = this.currentPaymentAmount - selectedSnack.getPrice();

        this.printBalance();
        this.stateOfVendingMachine.idle(this);
    }

    public void reset() {
        returnChange();
        this.selectedSnack = null;
    }

    public void returnChange() {
        System.out.println(String.format("Returned $%.2f change", this.currentPaymentAmount));

        this.currentPaymentAmount = 0.0;
    }

    public void cancelTransaction() {
        this.selectedSnack = null;
        this.returnChange();

        this.stateOfVendingMachine.idle(this);
    }

    public boolean canAffordSelectedSnack() {
        return this.currentPaymentAmount > selectedSnack.getPrice();
    }

    public void printBalance() {
        System.out.println(String.format("Current balance is $%.2f", this.currentPaymentAmount));
    }

    public boolean machineContainsSnack(String snackName) {
        if(!SnackFactory.validSnackName(snackName))
            return false;

        if(!inventory.containsKey(snackName))
            return false;

        if(inventory.get(snackName).getQuantity() <= 0)
            return false;

        return true;
    }

}

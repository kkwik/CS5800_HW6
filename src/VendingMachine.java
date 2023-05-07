import java.util.HashMap;

public class VendingMachine implements StateMachine {
    private StateOfVendingMachine state;
    private Snack selectedSnack;
    private double currentPaymentAmount;
    private HashMap<String, Snack> inventory;

    public VendingMachine() {
        this.state = new IdleState();
        this.selectedSnack = null;
        this.currentPaymentAmount = 0.0;
        this.inventory = new HashMap<>();
    }

    public StateOfVendingMachine getState() {
        return this.state;
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public void addStock(String snackName, int count) {
        if(!SnackFactory.validSnackName(snackName)) {
            System.out.println(String.format("%s is not a valid snack name", snackName));
            return;
        }

        if(!inventory.containsKey(snackName))
            inventory.put(snackName, SnackFactory.getSnack(snackName));

        this.updateInventory(snackName, inventory.get(snackName).getQuantity() + count);

    }

    public void removeStock(String snackName, int count) {
        if(machineContainsSnack(snackName))
            addStock(snackName, -count);
    }

    public void updateInventory(String name, int newTotal) {
        Snack temp = inventory.get(name);

        temp.setQuantity(newTotal);

        inventory.put(name, temp);
    }

    
    public void selectSnack(String snackName) {
        state.selectSnack(this, snackName);
    }

    public double getSnackCost(String snackName) {
        if(machineContainsSnack(snackName))
            return inventory.get(snackName).getPrice();

        return -1.0;
    }

    public Snack getSelectedSnack() {
        return this.selectedSnack;
    }

    public void setSelectedSnack(String snackName) {
        selectedSnack = inventory.get(snackName);
    }

    public boolean machineContainsSnack(String snackName) {
        if(getStockOfSnack(snackName) <= 0)
            return false;

        return true;
    }

    public int getStockOfSnack(String snackName) {
        if(!SnackFactory.validSnackName(snackName))
            return 0;

        if(!inventory.containsKey(snackName))
            return 0;

        return inventory.get(snackName).getQuantity();
    }


    public void insertMoney(double money) {
        state.insertMoney(this, money);
    }

    public void addFunds(double amount) {
        this.currentPaymentAmount += amount;
    }

    public boolean canAffordSelectedSnack() {
        return this.currentPaymentAmount > selectedSnack.getPrice();
    }

    public double getFundsAmount() {
        return this.currentPaymentAmount;
    }

    public boolean containsSelectedSnack() {
        return machineContainsSnack(selectedSnack.getName());
    }


    public void dispenseSnack() {
        state.dispenseSnack(this);
    }

    public void purchaseSelectedSnack() {
        removeFunds(selectedSnack.getPrice());
    }

    public void removeFunds(double amount) {
        this.currentPaymentAmount -= amount;
    }


    public void cancelTransaction() {
        state.cancelTransaction(this);
    }

    public void resetMachine() {
        returnChange();
        this.selectedSnack = null;
    }

    public void returnChange() {
        System.out.println(String.format("Returned $%.2f change", this.currentPaymentAmount));

        this.currentPaymentAmount = 0.0;
    }


    public void updateSnackCost(String name, double cost) {
        Snack temp = inventory.get(name);

        temp.setPrice(cost);

        inventory.put(name, temp);
    }

    public void printInventory() {
        System.out.print(String.format("Machine contains: "));
        for(Snack snack : inventory.values()) {
            System.out.print(String.format("%s: %d,", snack.getName(), snack.getQuantity()));
        }
        System.out.println();
    }

    public boolean canSelectSnack(String snackName) {
        if(SnackFactory.validSnackName(snackName) && inventory.containsKey(snackName)) {
            return true;
        }
        return false;
    }
}

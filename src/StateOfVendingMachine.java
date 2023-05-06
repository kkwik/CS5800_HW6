public interface StateOfVendingMachine {
    void idle(VendingMachine machine);
    void waitingForMoney(VendingMachine machine);
    void waitingForSelect(VendingMachine machine);
    void dispensingSnack(VendingMachine machine);
    void endTransaction(VendingMachine machine);

}

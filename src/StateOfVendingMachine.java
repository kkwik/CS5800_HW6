public interface StateOfVendingMachine {
    void insertMoney(VendingMachine machine, double money);
    void selectSnack(VendingMachine machine, String snackName);
    void dispenseSnack(VendingMachine machine);
    void cancelTransaction(VendingMachine machine);
}

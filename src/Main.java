public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        selectSnackWithoutPaying();
        insertMoneyWithoutSelectingSnack();
        selectSnackAndPayWithoutDispensing();
        attemptPaymentWithInsufficientFunds();
        addFundsThenSwitchSelection();
        cancelAfterPaying();
        buyTwoOfASnack();
        ranOutOfSnack();
    }

    public static void selectSnackWithoutPaying() {
        System.out.println("Testing selecting snack without paying");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);
        machine.selectSnack("Coke");
        System.out.println();
    }

    public static void insertMoneyWithoutSelectingSnack() {
        System.out.println("Testing paying without selecting a snack");
        VendingMachine machine = new VendingMachine();
        machine.insertMoney(100.0);
        System.out.println();
    }

    public static void selectSnackAndPayWithoutDispensing() {
        System.out.println("Testing selecting a snack and paying but not dispensing");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);

        machine.selectSnack("Coke");
        machine.insertMoney(10.0);

        System.out.println();
    }

    public static void attemptPaymentWithInsufficientFunds() {
        System.out.println("Testing attempting payment with insufficient funds");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);

        machine.selectSnack("Coke");
        machine.insertMoney(1.0);

        machine.dispenseSnackIfPossible();

        System.out.println();
    }

    public static void addFundsThenSwitchSelection() {
        System.out.println("Testing selecting a snack, paying a bit, then switching to another snack");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);
        machine.addStock("KitKat", 1);

        machine.selectSnack("Coke");
        machine.insertMoney(1.0);

        machine.selectSnack("KitKat");
        machine.dispenseSnackIfPossible();

        System.out.println();
    }

    public static void cancelAfterPaying() {
        System.out.println("Testing cancelling after paying");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);
        machine.selectSnack("Coke");
        machine.insertMoney(5.0);
        machine.cancelTransaction();

        System.out.println();
    }

    public static void buyTwoOfASnack() {
        System.out.println("Testing buying two of a snack");
        VendingMachine machine = new VendingMachine();
        machine.addStock("KitKat", 2);
        machine.selectSnack("KitKat");
        machine.insertMoney(5.0);

        machine.dispenseSnackIfPossible();
        machine.dispenseSnackIfPossible();

        System.out.println();
    }

    public static void ranOutOfSnack() {
        System.out.println("Testing running out of stock");
        VendingMachine machine = new VendingMachine();
        machine.addStock("KitKat", 1);
        machine.selectSnack("KitKat");
        machine.insertMoney(5.0);

        machine.dispenseSnackIfPossible();
        machine.dispenseSnackIfPossible();

        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        testInsertMoneyWithoutSelectingSnack();
        testSelectSnack();
        testSelectSnackAndPayWithoutDispensing();
        testDispenseSnack();
        testSelectingInvalidSnack();
        testSelectingAnOutOfStockSnack();
        testRanOutOfSnack();
        testCancelOutOfSelection();
        testCancelOutOfPayment();
        testRunningOutOfSnickers();
    }

    public static void testInsertMoneyWithoutSelectingSnack() {
        System.out.println("Testing paying without selecting a snack");
        VendingMachine machine = new VendingMachine();
        machine.insertMoney(100.0);
        System.out.println();
    }

    public static void testSelectSnack() {
        System.out.println("Testing selecting a snack");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);

        machine.selectSnack("Coke");

        System.out.println();
    }

    public static void testSelectSnackAndPayWithoutDispensing() {
        System.out.println("Testing selecting a snack and paying but not dispensing");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);

        machine.selectSnack("Coke");
        machine.insertMoney(10.0);

        System.out.println();
    }

    public static void testDispenseSnack() {
        System.out.println("Testing dispensing a snack");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);

        machine.printInventory();

        machine.selectSnack("Coke");
        machine.insertMoney(10.0);

        machine.dispenseSnack();

        machine.printInventory();

        System.out.println();
    }

    public static void testSelectingInvalidSnack() {
        System.out.println("Testing selecting an invalid snack");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);

        machine.selectSnack("Twizzlers");

        System.out.println();
    }

    public static void testSelectingAnOutOfStockSnack() {
        System.out.println("Testing selecting an out of stock snack");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 0);

        machine.selectSnack("Coke");

        System.out.println();
    }

    public static void testRanOutOfSnack() {
        System.out.println("Testing running out of stock of a snack");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);

        machine.selectSnack("Coke");
        machine.insertMoney(10.0);
        machine.dispenseSnack();

        machine.selectSnack("Coke");
        machine.insertMoney(10.0);
        machine.dispenseSnack();

        System.out.println();
    }

    public static void testCancelOutOfSelection() {
        System.out.println("Testing cancelling after paying");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);

        machine.selectSnack("Coke");
        machine.cancelTransaction();

        System.out.println();
    }

    public static void testCancelOutOfPayment() {
        System.out.println("Testing cancelling after paying");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);

        machine.selectSnack("Coke");
        machine.insertMoney(100.0);

        machine.cancelTransaction();

        System.out.println();
    }

    public static void testRunningOutOfSnickers() {
        System.out.println("Testing running out of snickers");
        VendingMachine machine = new VendingMachine();
        machine.addStock("Coke", 1);
        machine.addStock("Pepsi", 5);
        machine.addStock("KitKat", 3);
        machine.addStock("Snickers", 2);

        machine.selectSnack("Coke");
        machine.insertMoney(100.0);
        machine.dispenseSnack();

        machine.selectSnack("Snickers");
        machine.insertMoney(100.0);
        machine.dispenseSnack();

        machine.selectSnack("Snickers");
        machine.insertMoney(100.0);
        machine.dispenseSnack();

        machine.selectSnack("Snickers");

        System.out.println();
    }
}
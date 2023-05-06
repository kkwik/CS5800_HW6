public class SnackFactory {
    public static Snack getSnack(String name) {
        switch (name) {
            case "Coke":
                return new Coke();
            case "Pepsi":
                return new Pepsi();
            case "Cheetos":
                return new Cheetos();
            case "Doritos":
                return new Doritos();
            case "KitKat":
                return new KitKat();
            case "Snickers":
                return new Snickers();
            default:
                return null;
        }
    }

    public static boolean validSnackName(String name) {
        return SnackFactory.getSnack(name) != null;
    }
}

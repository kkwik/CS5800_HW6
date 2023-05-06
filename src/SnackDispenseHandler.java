public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;

    public SnackDispenseHandler(SnackDispenseHandler next) {
        this.next = next;
    }

    public void handleRequest(VendingMachine machine) {
        if(next != null) {
            next.handleRequest(machine);
        }
    }

    public static SnackDispenseHandler getSnackHandler() {
        return new CokeHandler(new PepsiHandler(new CheetoHandler(new DoritosHandler(new KitKatHandler(new SnickersHandler(null))))));
    }
}

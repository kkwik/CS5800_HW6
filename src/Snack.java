public abstract class Snack {
    private final String name;
    private double price;
    private int quantity;

    public Snack(String name, int count) {
        this.name = name;
        this.quantity = count;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int count) {
        this.quantity = count;
    }

    public void incrementQuantity() {
        this.quantity = this.quantity + 1;
    }

    public void decrementQuantity() {
        if(this.quantity > 0)
            this.quantity = this.quantity - 1;
    }
}

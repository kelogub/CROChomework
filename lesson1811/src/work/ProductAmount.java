package work;

public class ProductAmount {
    private String product;
    private int amount;

    ProductAmount(String product, int amount){
        this.product = product;
        this.amount = amount;
    }

    public String getproduct() {
        return product;
    }

    public void setproduct(String product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

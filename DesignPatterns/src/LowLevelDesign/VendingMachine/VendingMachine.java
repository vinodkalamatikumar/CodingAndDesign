package LowLevelDesign.VendingMachine;

import java.util.ArrayList;

public class VendingMachine {
    State vendingMachineState;
    Inventory inventory;
    ArrayList<Coins> coins = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();

    public VendingMachine() {
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public VendingMachine(State vendingMachineState, Inventory inventory, ArrayList<Coins> coins) {
        this.vendingMachineState = vendingMachineState;
        this.inventory = inventory;
        this.coins = coins;
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Coins> getCoins() {
        return coins;
    }

    public void setCoins(ArrayList<Coins> coins) {
        this.coins = coins;
    }
    public Product getProduct(Product product){
        for(Product pro : products){
           if(pro.getProductId()== product.productId){
               return product;
           }
        }
        return null;
    }
}

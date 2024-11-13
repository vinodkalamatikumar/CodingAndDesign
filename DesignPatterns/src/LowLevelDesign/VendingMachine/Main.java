package LowLevelDesign.VendingMachine;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        ArrayList<Product> products = new ArrayList<>();
        Product p1 = new Product(101,"Coke",5);
        Product p2 = new Product(102,"ThumpsUP",5);
        Product p3 = new Product(103,"Pepsi",5);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        vendingMachine.setProducts(products);

        State state = vendingMachine.vendingMachineState;
        state.clickOnInsertcoin(vendingMachine);
        state = vendingMachine.getVendingMachineState();
        state.insertCoin(vendingMachine,Coins.DIME);
        state = vendingMachine.getVendingMachineState();
        state.clickOnSelectProduct(vendingMachine);
        state = vendingMachine.getVendingMachineState();
        state.selectProduct(vendingMachine,p1);
        state = vendingMachine.getVendingMachineState();
        System.out.println(state);
        state.dispenseProduct(vendingMachine,p1);
    }
}

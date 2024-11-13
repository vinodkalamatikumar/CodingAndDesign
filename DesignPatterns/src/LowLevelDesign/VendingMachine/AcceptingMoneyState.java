package LowLevelDesign.VendingMachine;

import java.util.ArrayList;

public class AcceptingMoneyState implements State{

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coins coin) {
        System.out.println("Accepted the money");
         vendingMachine.getCoins().add(coin);
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Product product) {
        vendingMachine.getProduct(product);
    }

    @Override
    public int returnChange(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Not applicable as you are inserting money");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, Product product) throws Exception {
        throw new Exception("Not applicable as you are inserting money");

    }

    @Override
    public void refundMoneyForCancelAction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Not applicable as you are inserting money");

    }

    @Override
    public void clickOnInsertcoin(VendingMachine vendingMachine) {
  return;
    }

    @Override
    public void clickOnSelectProduct(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineState(new SelectProductState());

    }
}

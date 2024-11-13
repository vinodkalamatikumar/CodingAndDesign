package LowLevelDesign.VendingMachine;

import java.util.ArrayList;

public class DispenseProductState implements State{
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coins coin) throws Exception {
       throw new Exception("not applicable as the dispensing inprogress");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Product product) throws Exception {
        throw new Exception("not applicable as the dispensing inprogress");

    }

    @Override
    public int returnChange(VendingMachine vendingMachine) throws Exception {
        ArrayList<Coins> coins = vendingMachine.getCoins();
        return 0;
    }


    @Override
    public void dispenseProduct(VendingMachine vendingMachine, Product product) throws Exception {
      Product pro = vendingMachine.getProduct(product);
        System.out.println(pro.productName);
        pro.quantity--;
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
    }

    @Override
    public void refundMoneyForCancelAction(VendingMachine vendingMachine) throws Exception {

        return;
    }

    @Override
    public void clickOnInsertcoin(VendingMachine vendingMachine) throws Exception {
        throw new Exception("not applicable as the dispensing inprogress");

    }

    @Override
    public void clickOnSelectProduct(VendingMachine vendingMachine) throws Exception {
        throw new Exception("not applicable as the dispensing inprogress");

    }
}

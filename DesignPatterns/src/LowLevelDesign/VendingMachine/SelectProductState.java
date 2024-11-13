package LowLevelDesign.VendingMachine;

public class SelectProductState implements State{
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coins coin) throws Exception {
      throw new Exception("not applicable as the machine is in select product state");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Product product) {
        System.out.println("in select");
        vendingMachine.getProduct(product);
        vendingMachine.setVendingMachineState(new DispenseProductState());

    }

    @Override
    public int returnChange(VendingMachine vendingMachine) {
        return 0;
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, Product product) throws Exception {
        throw new Exception("not applicable as the machine is in select product state");

    }

    @Override
    public void refundMoneyForCancelAction(VendingMachine vendingMachine) {
     return;
    }

    @Override
    public void clickOnInsertcoin(VendingMachine vendingMachine) throws Exception {
        throw new Exception("not applicable as the machine is in select product state");

    }

    @Override
    public void clickOnSelectProduct(VendingMachine vendingMachine) throws Exception {
        throw new Exception("not applicable as the machine is already in select product state");

    }
}

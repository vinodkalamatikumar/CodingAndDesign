package LowLevelDesign.VendingMachine;

public class IdleState implements State{

    VendingMachine vendingMachine;
    public IdleState(VendingMachine vendingMachine) {
     this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coins coin) throws Exception {
        throw new Exception("Not applicable as the machine is in Idle State");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Product product) throws Exception {
        throw new Exception("Not applicable as the machine is in Idle State");
    }

    @Override
    public int returnChange(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Not applicable as the machine is in Idle State");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, Product product) throws Exception {
        throw new Exception("Not applicable as the machine is in Idle State");

    }

    @Override
    public void refundMoneyForCancelAction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Not applicable as the machine is in Idle State");

    }

    @Override
    public void clickOnInsertcoin(VendingMachine vendingMachine) {
 this.vendingMachine.setVendingMachineState(new AcceptingMoneyState());
    }

    @Override
    public void clickOnSelectProduct(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Please click on insercoin Button first");

    }
}

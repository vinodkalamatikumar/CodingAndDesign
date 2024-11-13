package LowLevelDesign.VendingMachine;

public interface State {

    void insertCoin(VendingMachine vendingMachine,Coins coin) throws Exception;
    void selectProduct(VendingMachine vendingMachine, Product product) throws Exception;
    int  returnChange(VendingMachine vendingMachine) throws Exception;
    void dispenseProduct(VendingMachine vendingMachine,Product product) throws Exception;
    void refundMoneyForCancelAction(VendingMachine vendingMachine) throws Exception;
    void clickOnInsertcoin(VendingMachine vendingMachine) throws Exception;
    void clickOnSelectProduct(VendingMachine vendingMachine) throws Exception;


}

package LowLevelDesign.VendingMachine;

public enum Coins {

    NICKEL(10),
    PENNY (1),
    DIME(15),
    QUARTER(25);


    int value;
    Coins(int value){
        this.value = value;
    }

}

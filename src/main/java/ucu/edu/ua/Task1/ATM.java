package ucu.edu.ua.Task1;

public class ATM {
    private final Banknote firstTrade;
    public ATM(){
        this.firstTrade = new Banknote100(new Banknote50(new Banknote5(null)));
    }
    public void process(int ammount){
        firstTrade.process(ammount);
    }
}

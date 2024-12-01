package ucu.edu.ua.Task1;

public abstract class Banknote {
    public Banknote nextItem;
    public int BanknoteNominale;
    public Banknote(Banknote nextItem, int BanknoteNominale) {
        this.nextItem = nextItem;
        this.BanknoteNominale = BanknoteNominale;
    }

    public void process(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Can't process " + amount);
        }

        int quantity = amount / BanknoteNominale;
        int remainder = amount % BanknoteNominale;

        if (quantity > 0) {
            System.out.format("Provided %d x %d%n", quantity, BanknoteNominale);
        }

        if (remainder > 0) {
            if (nextItem != null) {
                nextItem.process(remainder);
            } else {
                throw new IllegalArgumentException("Can't process " + remainder);
            }
        }
    }
}
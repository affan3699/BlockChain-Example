import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Transaction transaction1 = new Transaction("Affan", "Hasan", 500L);
        Transaction transaction2 = new Transaction("Juanid", "Jack", 1000L);
        Transaction transaction3 = new Transaction("Huzaifa", "Goku", 600L);

        Block block1 = new Block("0", List.of(transaction1));
        Block block2 = new Block(block1.getCurrentHash(), List.of(transaction2));
        Block block3 = new Block(block2.getCurrentHash(), List.of(transaction3));

        System.out.println("Block 1 Current Hash = " + block1.getCurrentHash());
        System.out.println("Block 2 Current Hash = " + block2.getCurrentHash());
        System.out.println("Block 3 Current Hash = " + block3.getCurrentHash());

        System.out.println("\nBlock 1 Previous Hash = " + block1.getprevHash());
        System.out.println("Block 2 Previous Hash = " + block2.getprevHash());
        System.out.println("Block 3 Previous Hash = " + block3.getprevHash());
    }
}

import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

public class Block
{
    private String prevHash, currentHash;
    private List<Transaction> transactions;
    private Long timeStamp;

    public Block(String prevHash, List<Transaction> transactions) {
        this.transactions = transactions;
        this.prevHash = prevHash;
        this.timeStamp = new Date().getTime();
        generateHash();
    }

    public String getprevHash() {
        return prevHash;
    }

    public void setprevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void generateHash()
    {
        String dataToHash = prevHash + timeStamp + transactions.get(0).toString();
        this.currentHash = generateHash(dataToHash);
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public void setCurrentHash(String currentHash) {
        this.currentHash = currentHash;
    }

    private static String generateHash(String data) {
        try {
            // we will get the instance of SHA256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //by using  digest() function, we will get has as one dimensional byte array
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            //we wanna use hexadecimal values not bytes in our program
            // will covert byte into hexadecimal
            StringBuffer hexadecimalString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hexadecimal = Integer.toHexString(0xff & hash[i]);
                if (hexadecimal.length() == 1) hexadecimalString.append('0');
                hexadecimalString.append(hexadecimal);
            }
            return hexadecimalString.toString();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

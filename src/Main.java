import java.util.ArrayList;
import com.google.gson.GsonBuilder;
import java.time.Instant;
import java.time.Duration;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 6;

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the count of block you want to mine: ");
        int howMany = input.nextInt();

        for(int i = 0; i < howMany; i++) {
            Instant start = Instant.now();
            blockchain.add(new Block((i + 1) + " block", "0"));
            System.out.println("Mine block " + (i + 1) + " ...");
            blockchain.get(i).mineBlock(difficulty);
            Instant end = Instant.now();
            System.out.println(Duration.between(start, end).toSeconds() + " seconds");
        }

        System.out.println("Blockchain is Valid: " + isChainValid());
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("Blockchain JSON: " + blockchainJson);


    }

    public static Boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;

        for(int i = 1; i < blockchain.size(); i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            if(!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("Previous hashes not equal");
                return false;
            }
        }

        return true;
    }
}


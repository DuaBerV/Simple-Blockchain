import java.util.Date;

public class Block{
    public String hash;
    public String previousHash;
    public String data;
    public long timeStamp; //number of milliseconds since 1/1/1970

    //Block constructor
    public Block(String hash, String previousHash){
        this.hash = hash;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
    }

}

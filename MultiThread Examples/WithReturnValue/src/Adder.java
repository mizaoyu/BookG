import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

/**
 * Created by Misky on 9/5/2017.
 */
public class Adder implements Callable<Integer>{
    String inFile;

    public Adder(String inFile){
        this.inFile = inFile;
    }

    public Adder(){
        this.inFile = "file.txt";
    }

    public int doAdd() throws IOException {
        int total = 0;
        try(BufferedReader br = Files.newBufferedReader(Paths.get(inFile))){
            String str = null;
            while((str = br.readLine()) != null && str.length() > 0){
                int num = Integer.parseInt(str);
                total += num;
            }
        }
        return total;
    }

    @Override
    public Integer call() throws IOException {
        return doAdd();
    }
}

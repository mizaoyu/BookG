import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Misky on 9/5/2017.
 */
public class Adder implements Runnable{
    String inFile;
    String outFile;

    public Adder(String inFile, String outFile){
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public Adder(){
        this.inFile = "file.txt";
        this.outFile = "file_out.txt";
    }

    public void doAdd() throws IOException {
        int total = 0;
        try(BufferedReader br = Files.newBufferedReader(Paths.get(inFile))){
            String str = null;
            while((str = br.readLine()) != null && str.length() > 0){
                int num = Integer.parseInt(str);
                total += num;
            }
        }

        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(outFile))){
            bw.write("Total: " + total);
        }
    }

    @Override
    public void run() {
        try{
            doAdd();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Misky on 9/5/2017.
 */
public class Worker{
    String[] inFiles = {"file.txt","file1.txt","file2.txt","file3.txt"};
    String[] outFiles = {"file_out.txt","file_out1.txt","file_out2.txt","file_out3.txt"};
    ExecutorService es = Executors.newFixedThreadPool(4);

    public void run(){
        for (int i=0;i<inFiles.length;i++){
            Adder ad = new Adder(inFiles[i],outFiles[i]);
            es.submit(ad);
        }
        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

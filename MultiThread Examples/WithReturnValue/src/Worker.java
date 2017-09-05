import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.concurrent.*;

/**
 * Created by Misky on 9/5/2017.
 */
public class Worker{
    String[] inFiles = {"file.txt","file1.txt","file2.txt","file3.txt"};
    ExecutorService es = Executors.newFixedThreadPool(4);

    public void run(){
        try {
            for (int i=0;i<inFiles.length;i++){
                Adder ad = new Adder(inFiles[i]);
                Future<Integer> result = es.submit(ad);
                int rs = result.get();
                System.out.println(rs);
            }
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e2){
            Throwable reason = e2.getCause(); //forgggggggggggggggggggggggget
            reason.printStackTrace();
        }
    }
}

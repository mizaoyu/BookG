import java.io.IOException;

/**
 * Created by Misky on 9/5/2017.
 */
public class Worker{
    String[] inFiles = {"file.txt","file1.txt","file2.txt","file3.txt"};
    String[] outFiles = {"file_out.txt","file_out1.txt","file_out2.txt","file_out3.txt"};
    Thread[] threads = new Thread[inFiles.length];
    public void run(){
        for (int i=0;i<inFiles.length;i++){
            Adder ad = new Adder(inFiles[i],outFiles[i]);
            threads[i] = new Thread(ad);
            threads[i].start();
        }
        try {
            for (Thread tr : threads){
                tr.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

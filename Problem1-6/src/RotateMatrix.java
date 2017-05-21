/**
 * Created by Misky on 5/21/2017.
 */
public class RotateMatrix {
    public int[][] rotateMatrix(int[][] matrix){
        int size = matrix.length;
        int layer =  size/ 2;
        for (int k=0;k<layer;k++){
            int start = k;
            int end = size - k - 1;
            for (int i=start;i<end;i++){
                int offset = i-start;
                //move left to top
                int top = matrix[k][i];
                matrix[start][i] = matrix[end-offset][start];
                //move bottom to left
                matrix[end-offset][start] = matrix[end][end-offset];
                //move right to bottom
                matrix[end][end-offset] = matrix[i][end];
                //move top to right
                matrix[i][end] = top;
            }
        }
        return matrix;
    }

    public static void main(String [] args){
        RotateMatrix rm = new RotateMatrix();
        int[][] matrix = {{1,2,3,4,25},{5,6,7,8,24},{9,10,11,12,23},{13,14,15,16,22},{17,18,19,20,21}};
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] result = rm.rotateMatrix(matrix);
        for (int i=0;i<result.length;i++){
            for (int j=0;j<result[0].length;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }


}

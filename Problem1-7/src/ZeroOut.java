/**
 * Created by Misky on 5/20/2017.
 */
public class ZeroOut {
    public int[][] zeroOut(int[][] matrix){
        boolean [] rowB = new boolean[matrix.length];
        boolean [] colB = new boolean[matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if (matrix[i][j] == 0){
                    rowB[i] = true;
                    colB[j] = true;
                }
            }
        }
        for (int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if (rowB[i] || colB[j]){
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static void main(String [] args){
        ZeroOut zo = new ZeroOut();
        int [][] matrix = {{1,2,3,0,5,6,7},{1,2,3,4,5,6,7},{1,0,3,4,5,6,7},{1,2,3,4,5,6,7},{1,2,3,4,5,6,7},{1,2,3,4,5,6,7},{1,2,3,4,5,6,0}};
        zo.zeroOut(matrix);
        for (int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

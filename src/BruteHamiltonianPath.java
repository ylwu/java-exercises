import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class BruteHamiltonianPath {

    static int height;
    static int width;
    static int size;
    static int [][] x;
    static int len;
    static int count = 0;
    
    public static void HamiltonPath (int start){
        ArrayList path = new ArrayList<Integer>();
        path.add(start);
        hp(path);
    }
    
    public static void hp(ArrayList<Integer> path){
        if (path.size() == len){
                count +=1;
                //printSolution(path);
           return;
        } else {
            int currentNode = path.get(path.size()-1);
            if (path.get(path.size()-1) == width * (height-1)) return;
            for (int i=0; i<len; i++){
                if(!path.contains(i) && x[currentNode][i] != 0){
                    ArrayList newpath = (ArrayList) path.clone();
                    newpath.add(i);
                    hp(newpath);
                }
            }
        }
    }
    
    public static void generateMatrix(int width, int height){  
        int size = width * height;
        for (int i=1; i<=height; i++){
            for (int j=1; j<=width; j++){
                populate (i, j);
            }
            
        }
    }
    
    /*
     * populate the neighboring indices for the square in "row" row and "col" column of the grid
     */
    public static void populate (int row, int col){ 
        int pos = (row-1) * width + col ;
        if (row !=1) mark(pos, (row-2) * width + col);
        if (row != height) mark(pos, (row * width + col ));
        if (col != width) mark(pos, (pos + 1));
        if (col != 1) mark(pos, (pos -1));
    }
    
    public static void mark(int m, int n){
            x[m-1][n-1] = 1;
        }
    
    public static void printSolution (ArrayList<Integer> path){
        System.out.println("#" + count);
        Iterator<Integer> it = path.iterator();
        while (it.hasNext()) {
        System.out.print(it.next()+" ");
        }
        System.out.println("  got it");
    }
    
    public static void printMatrix (int [][] matrix){
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }
    
    public static void main(String[] args) {
        //BruteHamiltonianPath obj = new BruteHamiltonianPath();
        height = Integer.parseInt(args[1]);
        width = Integer.parseInt(args[0]);
        size = height * width;
        x = new int[size][size];
        len = x.length;
        generateMatrix(width,height);
        //printMatrix(x);
        HamiltonPath(0);  
        System.out.println(count);
    }
}

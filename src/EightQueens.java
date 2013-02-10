public class EightQueens {
    static int row;
    static int[] path;
    static int count;
    static int num = 15;
    
    private static void findPath(){
       for (int i =1; i <= num; i++){
           if (detect(path, row, i)) continue;
           row ++;
           path[row - 1] = i;
           if (row == num) {
               //display (path);
               count ++;
               row --;
               continue;
           }
           findPath();
           row--;
           
       }
       path[row] = 0;
    }
    
    private static boolean detect(int[] x, int row, int target){
        if (row == 0) return false;
        for (int i = 1; i <= row; i++){
            if (target == x[i-1] - (row - i +1) || target == x[i-1] + (row - i + 1)
                    || target == x[i-1]){
                return true;
            }
        }
        return false;
    }
    
    private static void display (int[] x){
        for (int i : x){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        row = 0;
        path = new int[num];
        findPath();
        System.out.println(count);
    }

}

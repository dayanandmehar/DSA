public class SubArray {

    public static void main(String[] args) {
        SubArray solve = new SubArray();
        int[] arr = {36, 63, 63, 26, 87, 28, 77, 93, 7};
 //       int[] arr = {5,2,1,4};
        int[][] ans = solve.solve(arr);
        for (int[] i: ans) {
            for (int j:i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public int[][] solve(int[] A) {
        int n = A.length;
        int[][] ans = new int[n*(n+1)/2][];
        int count = 0;
        for (int s = 0; s < n; s++) {
            for (int e = s; e < n; e++) {
                ans[count] = new int[e - s + 1];
                int sArr = 0;
                for (int i=s; i<=e; i++) {
                    ans[count][sArr] = A[i];
                    sArr++;
                    //System.out.print(A[i] + ", ");
                }
                //System.out.println();
                count++;
            }
        }
        return ans;
    }
}



/*
public class Solution {
    public int[][] solve(int[] A) {
        int n=A.length;
        int[][] result=new int[(n*(n+1))/2][];
        int counter=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                result[counter]=new int[j-i+1];
                int size=0;
                for(int k=i;k<=j;k++){
                    result[counter][size]=A[k];
                    size++;
                }
                counter++;
            }
        }
        return result;
    }*/

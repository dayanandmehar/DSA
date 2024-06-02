package searching;

public class PaintersPartition {
    //A - Painters, B - Time/Unit, C - Boards

    public boolean isPossible(int A, int B, int[] C, long maxTime){
        long timeLeft = maxTime, requiredTime;
        int paintersCount = 1;
        for(int i=0; i<C.length; i++){
            requiredTime = C[i] * (long)B;
            if(requiredTime > maxTime)   return false;
            if(requiredTime <= timeLeft){
                timeLeft -= requiredTime;
            }
            else{
                paintersCount++;
                timeLeft = maxTime - requiredTime;
            }
        }

        return paintersCount <= A ;
    }

    public int paint(int A, int B, int[] C) {

        int n = C.length ;
        int MOD = 10000003;
        long max = C[0];
        long sum = C[0];
        for(int i=1; i<n; i++){
            max = Math.max(max, C[i]);
            sum += C[i];
        }
        //System.out.println("sum="+sum+", max="+max);

        long minPossibleTime = max * B;
        long maxPossibleTime = sum * B;
        //System.out.println("minPossibleTime="+minPossibleTime + ", maxPossibleTime="+maxPossibleTime);

        long l = minPossibleTime ;
        long r = maxPossibleTime ;
        long mid, ans = maxPossibleTime % MOD;
        //System.out.println("l="+l + ", r="+r);
        while(l <= r){
            mid = l + (r-l)/2;

            if(isPossible(A, B, C, mid)){
                ans = mid % MOD;
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return (int)ans;
    }
}

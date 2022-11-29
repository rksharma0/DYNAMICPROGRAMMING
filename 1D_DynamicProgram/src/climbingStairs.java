import java.util.Arrays;
import java.util.Scanner;

public class climbingStairs {

    public static void main(String[] args) {

        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(solveWithRec(n));
        System.out.println(solveWithMemo(n,dp));
        System.out.println(solveWithTop(n));
        System.out.println(solveWithConstantSpace(n));
    }

    private static int solveWithConstantSpace(int n) {

        int firstStep=1;
        int secondStep=1;
        int temp=0;
        for(int i=2;i<=n;i++){
            temp=firstStep+secondStep;
            secondStep=firstStep;
            firstStep=temp;
        }
        return firstStep;
    }

    private static int solveWithTop(int n) {

        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){

            dp[i]=dp[i-1]+dp[i-2];

        }
        return dp[n];
    }

    private static int solveWithMemo(int n, int[] dp) {

        if(n==0)return 1;
        if(dp[n]!=-1)return dp[n];
        int oneStep=solveWithMemo(n-1,dp);
        int twoStep=0;
        if(n>1){
            twoStep=solveWithMemo(n-2,dp);
        }
        return dp[n]=oneStep+twoStep;
    }


    public static int solveWithRec(int n){

        if(n==0)return 1;

        int oneStep= solveWithRec(n-1);
        int twoStep=0;
        if(n>1){
             twoStep=solveWithRec(n-2);
        }
        return oneStep+twoStep;
    }
}

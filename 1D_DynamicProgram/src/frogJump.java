import java.util.Arrays;
import java.util.Scanner;

public class frogJump {

    public static void main(String[] args) {

        Scanner scn=new Scanner(System.in);
        int n= scn.nextInt();
        int arr[]=new int[n];
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        for (int i=0;i<n;i++)arr[i]=scn.nextInt();
        System.out.println(Memorization(n-1,arr,dp));
    }

    private static int Memorization(int i, int[] arr,int[] dp) {

        if(i==0)return 0;
        if(dp[i]!=-1)return dp[i];
        int jumpOne=Memorization(i-1,arr,dp)+Math.abs(arr[i]-arr[i-1]);
        int jump2Step=Integer.MAX_VALUE;
        if(i>1)jump2Step=Memorization(i-2,arr,dp)+Math.abs(arr[i]-arr[i-2]);
        return dp[i]=Math.min(jumpOne,jump2Step);
    }
}

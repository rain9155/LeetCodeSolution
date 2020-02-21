import java.lang.reflect.Method;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Main solution = new Main();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int l = scan.nextInt();
            int[][] intervals = new int[n][2];
            for(int i = 0; i < n; i++){
                intervals[i][0] = scan.nextInt();
                intervals[i][1] = scan.nextInt();
            }
            System.out.println(solution.minIntervalCount(intervals, l));
        }
    }

    public int minIntervalCount(int[][] intervals, int l){
        if(intervals == null || intervals.length == 0 || l <= 0){
            return -1;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        if(intervals[0][0] != 0){
            return -1;
        }
        int n = intervals.length;
        int len = intervals[0][1];
        int[] dp = new int[n];
        dp[0] = 1;
        int i = 1;
        while(i < n){
            int[] pre = intervals[i - 1];
            int[] cur = intervals[i];
            if(cur[0] < l && cur[0] <= pre[1]){
                if(cur[1] > pre[1]) {
                    len = cur[1];
                    dp[i] = dp[i - 1] + 1;
                    for (int j = i - 1; j >= 0; j--) {
                        pre = intervals[j];
                        if (cur[0] <= pre[1] && cur[1] > pre[1]) {
                            dp[i] = Math.min(dp[i], dp[j] + 1);
                        }
                    }
                }else {
                    dp[i] = dp[i - 1];
                }
            }else{
                break;
            }
            i++;
        }
        return len >= l ? dp[i - 1] : -1;
    }

}

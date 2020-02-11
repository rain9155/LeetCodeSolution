import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Main solution = new Main();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int len = scan.nextInt();
            int[] companys = new int[len];
            int[] gyms = new int[len];
            for(int i = 0; i < len; i++){
                companys[i] = scan.nextInt();
            }
            for(int i = 0; i < len; i++){
                gyms[i] = scan.nextInt();
            }
            System.out.println(solution.restDay(companys, gyms));
        }
    }

    public int restDay(int[] companys, int[] gyms){
        return 0;
    }

}

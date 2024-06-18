import easy.leetcode7.*;;

public class Main {

    public static void main(String[] args) {
        int year = 2024;
        int month = 7;
        int sumDay = 0;
        for(int i = 2024; i < 2024; i++) {
            sumDay += isLeapYear(i) ? 366 : 365;
        }
        int[][] map = {
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
        };
        for(int i = 1; i < month; i++) {
            sumDay += map[isLeapYear(year) ? 0 : 1][i - 1];
        }
        int monthDay = map[isLeapYear(year) ? 0 : 1][month - 1];
        int weekDay = sumDay % 7;
        System.out.println("七\t一\t二\t三\t四\t五\t六");
        for(int i = 0; i <= weekDay; i++) {
            System.out.print("\t");
        }
        for(int i = 1; i <= monthDay; i++) {
            System.out.print(i + "\t");
            sumDay++;
            if(sumDay % 7 == 6) {
                System.err.println();
            }
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

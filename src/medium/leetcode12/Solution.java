package medium.leetcode12;

/**
 * 整数转罗马数字
 */
public class Solution {

    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        while(num > 0){
            if(num >= 1000){
                num -= 1000;
                str.append("M");
            }else if(num >= 900){
                num -= 900;
                str.append("CM");
            }else if(num >= 500){
                num -= 500;
                str.append("D");
            }else if(num >= 400){
                num -= 400;
                str.append("CD");
            }else if(num >= 100){
                num -= 100;
                str.append("C");
            }else if(num >= 90){
                num -= 90;
                str.append("XC");
            }else if(num >= 50){
                num -= 50;
                str.append("L");
            }else if(num >= 40){
                num -= 40;
                str.append("XL");
            }else if(num >= 10){
                num -= 10;
                str.append("X");
            }else if(num >= 9){
                num -= 9;
                str.append("IX");
            }else if(num >= 5){
                num -= 5;
                str.append("V");
            }else if(num >= 4){
                num -= 4;
                str.append("IV");
            }else if(num >= 1){
                num -= 1;
                str.append("I");
            }
        }
        return str.toString();
    }

}

package main;

import java.util.ArrayList;
import java.util.List;

public class FindTotal {

    // green gable
    /*public static void main(String[] args) {
       int sum = 0 ;
        sum = getFeet("17.0", "18.4" , sum); // hall
        sum = getFeet("12.0", "13.0" , sum); // bed room m
       sum = getFeet("5.0", "8.4" , sum); // foyer
        sum = getFeet("11.6", "8.0" , sum); // kitchen
        sum = getFeet("3.6", "8.0" , sum); // utility
        sum = getFeet("11.0", "13.0" , sum); // bedroom
        sum = getFeet("11.0", "12.0" , sum); // bedroom
        sum = getFeet("5.3", "8.2" , sum); // toilet
        sum = getFeet("5.3", "8.2" , sum); // toilet
        sum = getFeet("5.3", "8.2" , sum); // toilet
        int feet = sum / 144;
        int inch = sum % 144;
        System.out.println(sum);
        System.out.println(feet); // 1032
        System.out.println(inch); // 138
    }*/

    // utopia
    public static void main(String[] args) {
        int sum = 0 ;
        sum = getFeet("11.0", "17.10" , sum); // hall
        sum = getFeet("11.2", "16.0" , sum); // bed room m
        sum = getFeet("5.0", "3.10" , sum); // bed room foyer
        sum = getFeet("4.6", "8.10" , sum); // foyer
        sum = getFeet("11.2", "8.10" , sum); // kitchen
        sum = getFeet("6.0", "8.3" , sum); // utility
        sum = getFeet("11.4", "12.8" , sum); // dining
        sum = getFeet("10.10", "13.8" , sum); // bedroom
        sum = getFeet("10.8", "11.9" , sum); // bedroom
        sum = getFeet("5.0", "8.1" , sum); // toilet
        sum = getFeet("5.0", "8.1" , sum); // toilet
        sum = getFeet("5.0", "8.1" , sum); // toilet
        int feet = sum / 144;
        int inch = sum % 144;
        System.out.println(sum);
        System.out.println(feet); //1120
        System.out.println(inch); //12
    }

    public static int getFeet(String num, String num2, int sum) {

        String arr[] = num.split("\\.");
        String arr1 = arr[0];
        String arr2 = arr[1];

        int total1 = (12 * Integer.parseInt(arr1)) + Integer.parseInt(arr2);

        String arrr[] = num2.split("\\.");
        String arrr1 = arrr[0];
        String arrr2 = arrr[1];

        int totall1 = (12 * Integer.parseInt(arrr1)) + Integer.parseInt(arrr2);

        return sum + (total1 * totall1);
    }
}

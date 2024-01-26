import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;


public class Assignment1 {
    public static void main(String[] args) {

//        int Q1 = 20;                       //This is ques 01
//        int ans=sumOdd(Q1);
//        System.out.println(ans);

//        int Q2 = 100;                      //ques 02
//        PrintPrime(Q2);

//        int Q3 = 1000;                      //Ques 03
//        PrintArm(Q3);

//        int Q4 = 151;                       //Ques 04
//        PrintPalindrome(Q4);

//        PrintTriangle(6);                 //Ques 05

//        PrintPattern(5,3);                //Ques 06

//        int[][] arr = { {0,0,0},            //Ques 09
//                        {0,0,0},
//                        {0,0,0}};
//        boolean a = NullMatrix(arr);
//        System.out.println(a);

//        int a =10;                        //Ques 10
//        int b=20;
//        hcfAndLcm(a,b);

//        int[] arr = {1,2,3,4,5,6};         //Ques 11
//        int target = 5;
//        int ansLinear =linearSearch(arr,target);
//        System.out.println("The Index is "+ansLinear);
//        int ansBinary = binarySearch(arr,target);
//        System.out.println("The Index is "+ansBinary);

//        String s = "Biswajit Biswas Is very good at coding";   // Ques 13
//        int ans = countString(s);
//        System.out.println(ans);

//        String input = "radar";                                  //Ques 14
//        if (PalindromeChecker.checkPalindrome(input)) {
//            System.out.println("Is True");
//        }

//        int[] arr = {1,2,3,4,5,6,7,8,55};                            // Ques 15
//        int ans = difference(arr);
//        System.out.println(ans);

    }


    //////////////////////////////////////////////////////////////////////////////////////////////
    //Q.1 Write a program to print sum of odd numbers between 1- n.
    static int sumOdd(int n){
        int sum=0;
        for (int i = 0; i < n; i++) {
            if(i % 2 !=0){
                sum+=i;
            }
        }
        return sum;

    }
    /////////////////////////////////////////////////////////////////////////////////////////////

    //Q.2 Write a program to print prime number series up to n.
    static void PrintPrime(int n){
        for (int i = 0; i < n; i++) {
            if(Isprime(i)){
                System.out.print(i+" ");
            }
        }
    }
    static boolean Isprime(int n){
        int count=0;
        for (int i = 1; i <= n; i++) {
            if(n%i==0){
                count++;
            }
        }
        if(count==2){
            return true;
        }
        return false;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////

    //Q.3 Write a program to print Armstrong number between 1 to n.
    static void PrintArm(int n){
        for (int i = 0; i <= n; i++) {
            if(IsArm(i)){
                System.out.print(i+" ");
            }
        }
    }
    static boolean IsArm(int n){
        int x=n;
        int sum=0;
        int count = count(n);
        while (x>0){
            int digit = x%10;
            sum+=(int) pow(digit,count);
            x/=10;

        }
        if(sum==n){
            return true;
        }
        return false;
    }
    static int count(int n){
        int x =n;
        int count=0;
        while(x>0){  //This is to find the total digit
            x/=10;
            count++;
        }
        return count;
    }
    ///////////////////////////////////////////////////////////////////////////////////////

    //Q.4 Write a program to print palindrome number up to N numbers.
    static void PrintPalindrome(int n){
        for (int i = 0; i <=n; i++) {
            if(IsPalindrome(i)){
                System.out.print(i+" ");
            }
        }
    }
    static boolean IsPalindrome(int n){
        int x=n;
        int ans=0;
        while(x>0){
            int digit = x%10;
            x/=10;
            ans = ans*10+digit;
        }
        if(n == ans){
            return true;
        }
        return false;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////


    //Q.5 Write a program to print Floyds triangle.
    //1
    //2 3
    //4 5 6
    //7 8 9 10
    //11 12 13 14 15
    //16 17 18 19 20 21
    static void PrintTriangle(int n){
        int count=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    //Q.6 Write a program to print numbers in sequence way.
    //3 4 7
    //7 5 12
    //12 6 18
    //18 7 25
    //25 8 33
    //33 9 42
    //42 10 52
    //52 11 63
    static void PrintPattern(int row , int col){
        int count=3;
       int  a=0;
       int b=4;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if(j==1){
                    a+=count;
                    System.out.print(a+" ");
                    count++;

                } else if (j==2) {
                    System.out.print(b+" ");
                    b++;
                }
                else {
                    System.out.println(a+b-1+" ");
                }
            }
            System.out.println();
        }
    }

    //Q.09 Write a program to check given matrix is null matrix
    static boolean NullMatrix(int[][] arr){
        int row= arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    //Q.10 Write a program to calculate HCF and LCM.
    static void hcfAndLcm(int num1,int num2)
    {
        int a=num1,b=num2;
        while(num1!=num2)
        {
            if(num1>num2)
            {
                num1-=num2;
            }
            else {
                num2-=num1;
            }
        }
        int hcf=num1;
        int lcm=(a*b)/hcf;
        System.out.println("HCF is : "+hcf);
        System.out.println("LCM is : "+lcm);
    }
    //Q.11 Write a program for linear search and binary search.
    static int linearSearch(int[] arr,int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }


    static int binarySearch(int[]arr,int target){
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target > arr[mid]){
                start = mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    //Q.13 Write a program to count each words and total number of words in given string
    static int countString(String str){
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                count++;
            }
        }

//        for(int index : str.toCharArray()){
//            if(index == ' '){
//                count++;
//            }
//        }
        return count+1;
    }

    //Q.14 Write a program to reverse the string and check whether it is palindrome or not
    public class PalindromeChecker {

        public static void main(String[] args) {
            String input = "abc def fed cba";
            if (checkPalindrome(input)) {
                System.out.println(input + " is a palindrome.");
            } else {
                System.out.println(input + " is not a palindrome.");
            }
        }

        //Q.14 Write a program to reverse the string and check whether it is palindrome or not
        static void swap(char[] str1, int a, int b) {
            char temp = str1[a];
            str1[a] = str1[b];
            str1[b] = temp;
        }

        static boolean checkPalindrome(String s) {
            String p = reverse(s);
            System.out.println(p);
            return s.equals(p);
        }

        static String reverse(String str) {
            char[] str1 = str.toCharArray();
            int start = 0;
            int end = str1.length - 1;
            while (start < end) {
                swap(str1, start, end);
                start++;
                end--;
            }
            return new String(str1);
        }
    }

    //Q.15 Write a program to find difference of minimum and maximum numbers of array in java.
    static int difference(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max-min;
    }


}

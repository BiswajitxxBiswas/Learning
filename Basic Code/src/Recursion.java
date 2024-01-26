import java.util.ArrayList;
import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,7,8};
//        int ans = binarySearch(arr,7,0,arr.length-1);
//        System.out.println(ans);

       int[] arr = {1,2,3,4,8,8,7};
       ArrayList<Integer> aA= returnTarget(arr,8,0);
        System.out.println(aA);

    }

//    static int factorial(int num){
//        if(num <=1){
//            return num;
//        }
//        return factorial(num-1)+factorial(num-2);
//    }

    static int binarySearch(int[] arr,int target,int start,int end){
        if(start>end){
            return -1;
        }

        int mid = start+(end-start)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid] > target){
            return binarySearch(arr,target,start,mid-1);
        }
        return binarySearch(arr,target,mid+1,end);
    }

    static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }

    static int sumDigit(int n){
        if(n%10 == 0){
            return 0;
        }
        int digit = n%10;
        n /= 10;
        return digit + sumDigit(n);
    }
    static int sum=0;
    static void reverseNumber(int n){
        if(n == 0){
            return;
        }
        int digit = n %10;
        sum = sum*10 + digit;
        reverseNumber(n/10);
    }

    static int reverseNumber2(int n){
        // for number of digit we can use log function
        int digit = (int)(Math.log10(n))+1;    // for 1234 then digit is 4
        return helper(n,digit);
    }

    private static int helper(int n, int digit) {
        // Base condition
        if(n==0){
         return 0;
        }
        int rem = n%10;
        return rem*(int)(Math.pow(10,digit-1)) + helper(n/10,digit-1);
    }

    //to find palindrome same as reverse but use boolean
    static int reversePalin(int n){
        int digit  = (int)(Math.log10(n))+1;
        return helperPalin(n,digit);
    }

    static int helperPalin(int n, int digit) {
         if(n == 0){return 0;}
         int rem = n%10;
         return rem*(int)(Math.pow(10,digit-1)) + helper(n/10,digit-1);
    }
    static boolean checkPalin(int n){
        return (n == reversePalin(n));
    }

    //count number of zeros in the given number
    static int countZero(int n){
        //need s another argument so use helper
        return helperCountzero(n,0);
    }

    static int helperCountzero(int n, int count) {
            //Base
        if(n%10 == n){
            return count;
        }
        int rem = n%10;
        if( rem == 0){
             return helperCountzero(n/10,count+1);
        }
        return helperCountzero(n/10,count);
    }

    static boolean sortedArraycheck(int[] arr){
            return helperSorted(arr,0);
    }

    static boolean helperSorted(int[] arr, int i) {
        //Base
        if(i == arr.length-1){
            return true;
        }
//        if(arr[i]  < arr[i+1]){
//            return helperSorted(arr,i+1);
//        }
//        return false;
        return arr[i] < arr[i+1] && helperSorted(arr,i+1);
    }

    //Linear Search with recursion
    static boolean linearSearch(int[] arr,int i,int target){
        //Base
        if(i == arr.length){     //Base will be the terminating one like in while the false condition
            return false;
        }
       return arr[i] == target || linearSearch(arr,i+1,target);
    }

    //same as above question but return all the index containing target using ArrayList
    static ArrayList<Integer> linearSearchList(int[] arr,int target,int index,ArrayList<Integer> list){
        //Base
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
//            return linearSearchList(arr,target,index+1,list);
        }
        return linearSearchList(arr,target,index+1,list);
    }

    //same as above but created an ArrayList for each function call because not included in the argument
    static ArrayList<Integer> returnTarget(int[] arr,int target,int index){
        ArrayList<Integer> list = new ArrayList<>();
        //Base
        if(index == arr.length){
            return list;
        }
        //now check in 1st function weather it exists or not
        if(arr[index] == target){
            list.add(index);
        }
//        now for all the other function calls
        ArrayList<Integer> ans = returnTarget(arr,target,index+1);
        list.addAll(ans);
        return list ;
    }
}
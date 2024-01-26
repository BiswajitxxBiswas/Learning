//class Solution {
//    public static void main(String[] args) {
//        int ans = pivotInteger(8);
//        System.out.println(ans);
//    }
//    public static int pivotInteger(int n) {
//        int[] arr = GiveArray(n);
//        int length = arr.length;
//        int start = 0;
//        int end = length-1;
//        int mid = start+(end-start)/2;
//        while(start<=end){
//
//            int lsum = Leftsum(arr,start,mid);
//            int rsum = Rightsum(arr,mid,end);
//            if(lsum<rsum){
//                mid++;
//            } else if (lsum > rsum) {
//                mid--;
//            }
//            else{
//                return arr[mid];
//            }
//        }
//        return -1;
//    }
//    static int Leftsum(int[] arr,int start,int mid){
//        int leftsum=0;
//        for (int i = start; i <=mid ; i++) {
//            leftsum+=arr[i];
//        }
//        return leftsum;
//    }
//    static int Rightsum(int[] arr,int mid,int end){
//        int rightsum=0;
//        for (int i = mid; i <=end ; i++) {
//            rightsum+=arr[i];
//        }
//        return rightsum;
//    }
//    static int[] GiveArray(int n){
//        int x=n;
//        int[] arr = new int[n];
//        for(int i=0;i<n;i++){
//            arr[i] = i+1;
//        }
//        return arr;
//    }
//
//}
//


class Solution {
    public static void main(String[] args) {
        int ans = pivotInteger(8);
        System.out.println(ans);
    }

    public static int pivotInteger(int n) {
        int[] arr = giveArray(n);
        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum -= arr[i];

            if (leftSum == totalSum) {
                return arr[i];
            }

            leftSum += arr[i];
        }

        return -1; // No pivot found
    }

    static int[] giveArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}


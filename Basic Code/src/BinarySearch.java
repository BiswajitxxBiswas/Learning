public class BinarySearch {// the complexity is O(logn)  // 1 = N/2^k worst case
    public static void main(String[] args) {
        int arr[] = {-22,-3,-1,0,3,5,7,33,88,765};// must be a sorted array
        int target = 765;
        int ans = another(arr,target);
        System.out.println(ans);

        int arr1[] = {99,77,55,45,22,3,1,0,-3,-5,-7,-33,-88,-765};// must be a sorted array
        int target1 = 0;
        int ans1= desendingBinarySearch(arr1,target1);
        System.out.println(ans1);
    }
    static int binarysearch(int[] arr, int target){
        int start =0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end - start)/2; // we use this so that limit wont cross
            if(target < arr[mid]){
                end = mid -1;

            }
            else if(target > arr[mid]){
                start = mid +1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    static int another(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + ( end - start)/2;
            if(target < arr[mid]){
                end = mid -1;
            }
            else if(target > arr[mid]){
                start =  mid +1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    static int desendingBinarySearch(int[] arr,int target){
        int start =0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target > arr[mid]){
                end = mid -1;
            }
            else if(target < arr[mid]){
                start =  mid +1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}

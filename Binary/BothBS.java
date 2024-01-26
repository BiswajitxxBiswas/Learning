public class BothBS {
    public static void main(String[] args) {
        int arr[] = {-22,-3,-1,0,3,5,7,33,88,765};// must be a sorted array
        int target = 765;

        int arr1[] = {99,77,55,45,22,3,1,0,-3,-5,-7,-33,-88,-765};// must be a sorted array
        int target1 = 0;

        int ans = Binary(arr,target);
        System.out.println(ans);

    }
    static int Binary(int[] arr,int target){
        int start =0;
        int end = arr.length-1;
        boolean isAs = arr[start] < arr[end];

        while(start <= end){
            int mid = start + ( end -start)/2;
            if(arr[mid] == target){
                return mid;
            }

            if(isAs){
                if(target < arr[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(target > arr[mid]){
                    end= mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}

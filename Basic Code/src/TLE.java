class TLE {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        boolean ans = check(nums);
        System.out.println(ans);
    }
    public static boolean check(int[] nums) {
        sorted(nums);
        return checkSorted(nums);
    }
    static boolean checkSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }


    static void swap(int[] nums,int a,int b){
        int temp;
        int start =a;
        int end =b;
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    static void sorted(int[] nums){
        int index = rotatedInddex(nums)+1;
        swap(nums,0,index);
        swap(nums,index+1,nums.length-1);
        swap(nums,0,nums.length-1);

    }

    static int rotatedInddex(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }

            // Skip the duplicate
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                // Check whether it's a pivot or not before skipping
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // Same for end
                if (arr[end] < arr[end - 1]) {
                    return end-1;
                }
                end--;
            }
        }
        return -1; //not found
    }
}
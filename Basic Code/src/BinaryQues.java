public class BinaryQues {
    public static void main(String[] args) {
//        int[] arr = {2,3,4,5,9,11,13,14,15};
//        int target = 12;
//        int ans =Floor(arr,target);
//        System.out.println(ans);
//        char[] arr = {'c','f','j'};
//        char target = 'g';
//        char ans = FloorChar(arr,target);
//        System.out.println(ans);
        int[] arr = {11,13,15,17,11,11,11};
        int ans = pivotDuplicate(arr);
        System.out.println(ans);

    }
    //Find the ceiling Number
    static int Ceiling(int[] arr,int target){  // Smallest number greater than equal to Target
        int n= arr.length;
        int start =0,end =n-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if (arr[mid] > target) {
                end =mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return start;

    }
    static int Floor(int[] arr,int target){ // Greatest Number that is less than equal to target
        int n = arr.length;
        int start=0;
        int end =n-1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] > target){
                end = mid-1;
            }
            else {
                start= mid+1;
            }
        }
        return end;

    }

//     https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
//     Find Smallest Letter Greater Than Target
//    Ex. letters = ["c","f","j"], target = "g"
    static char FloorChar(char[] letters,char target){
        int n= letters.length;
        int start =0;
        int end = n-1;
        while(start <= end){
            int mid = start +(end-start)/2;

            if(target < letters[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return letters[start % n];
    }

    static int[] FirstAndLast(int[] arr,int target){
        int[] ans = {-1,-1};
        ans[0]=Index(arr,target,true);
        if(ans[0] !=-1){
            ans[1]=Index(arr,target,false) ;
        }
        return ans;
    }
    // check for first and last index
    static int Index(int[] arr,int target, boolean check){
        int ans=-1;
        int start=0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target < arr[mid]){
                end = mid-1;
            }
            else if(target > arr[mid]){
                start = mid+1;
            }
            else{
                ans = mid;
                if(check){
                    end = mid-1;
                }
                else{
                    start =mid+1;
                }
            }
        }
        return ans;
    }

    static int[] LastAndfirstAgain(int[] arr,int target){ // {1,2,3,3,3,3,3,4,5,6,6,7}||target->3||Ans[2,6]
        int[] ans ={-1,-1};
        ans[0]= checkCondition(arr,target,true);
        if(ans[0] != -1){
            ans[1]= checkCondition(arr,target,false);
        }
        return ans;
    }
    static int checkCondition(int[]  arr,int target,boolean left){
        int ans =-1;
        int start =0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if( arr[mid] < target){
                start = mid+1;
            }
            else if(arr[mid] > target){
                end = mid-1;
            }
            else {
            ans = mid ;// This might be the ans.....but there might another answer exist
            if(left){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
            }
        }
        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        ans[0] =position(nums,target,true);
        if(ans[0] != -1){
            ans[1] = position(nums,target,false);
        }
        return ans;
    }

    static int position(int[] nums,int target,boolean check){
        int ans = -1; //This will be the ans if nothing is found
        int start =0;
        int end =nums.length-1;
        while(start <= end){
            int mid = start +(end-start)/2;
            if(nums[mid] < target){
                start = mid+1;
            }
            else if(nums[mid] > target){
                end = mid-1;
            }
            else{
                ans = mid;   // This might be the ans but checking for another if
                if(check){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        return ans;
    }

    //Find the target index in the infinite sorted array
    //We will use the opposite of binary search to find the range for that target
    //then binary search in that range for that index
    static int ans(int[] arr,int target){
        //start with the box of size 2
        //and keep searching and increasing the size till target found
        int start =0;
        int end = 1;
        while (target > arr[end]){
            int newStart = end+1;
            end  = end + (end-start+1)*2;
            start = newStart;
        }
        int ans = binarySearch(arr,target,start,end);
        return ans;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end){
            int mid  = start + (end - start)/2;
            if(target < arr[mid]){
                end = mid-1;
            }
            else if (target > arr[mid]){
                start = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1; // not found
    }

    //Find The peak element in the mountain array
    //We don't have any target, so we will compare every middle element with the current
    static int peak(int[] nums){
        int start =0;
        int end =nums.length-1;
        while(start < end){
           int mid = start+(end - start)/2;
            //first mid can be the max, but there is possibility to have max in left or right
            if( nums[mid] > nums[mid+1]){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }

    public static int findMin(int[] nums) {
        // first find pivot
        int ans = pivot(nums);//This is pivot index
        return nums[ans+1];
    }
    static int pivot(int[] nums){
        int start =0;
        int end = nums.length-1;
        while( start <= end){
            int mid = start + (end - start)/2;
            if(mid<end && nums[mid] > nums[mid+1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid-1]){
                return  mid-1;
            }
            // now for binary
            if(nums[start] > nums[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

    //find the pivot number in the duplicate array
    static int pivotDuplicate(int[] arr){
        int start =0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid<end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if( mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            //skip the duplicate
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                //but before skipping first check weather its pivot or not
                if(arr[start] > arr[start+1]){
                    return start;
                }
                start++;
                //same for end
                if(arr[end] < arr[end-1]){
                    return end-1;
                }
                end--;
            }
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    class Solution {
        public int search(int[] nums, int target) {
            int p = pivot(nums);
            if(p == -1){
                return binary(nums,target,0,nums.length-1);
            }
            //then if target isequal to pivot then return it
            if(nums[p] == target){
                return p;
            }
            //if target is greater than start than till pivot-1
            if(target >= nums[0]){
                return binary(nums,target,0,p-1);
            }
            //else from pivot+1 to end
            return binary(nums,target,p+1,nums.length-1);
        }

        int binary(int[] arr,int target,int start,int end){
            while(start <= end){
                int mid =start + (end - start)/2;
                if( target == arr[mid]){
                    return mid;
                }
                else if(arr[mid] > target){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }

            }
            return -1;//not found target
        }


        //First we need pivot index
        static int pivot(int[] arr){
            int start =0;
            int end= arr.length-1;
            while(start <= end){
                int mid = start + (end-start)/2;
                if(end > mid && arr[mid] > arr[mid+1]){
                    return mid;
                }
                if(mid > start && arr[mid-1] > arr[mid]){
                    return mid-1;
                }
                //now for binary search
                if(arr[start] > arr[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            return -1; //if its only sorted array there any arent any pivot
        }

        //find the pivot number in the duplicate array
        static int pivotDuplicate(int[] arr){
            int start =0;
            int end = arr.length-1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(mid<end && arr[mid] > arr[mid+1]){
                    return mid;
                }
                if( mid > start && arr[mid] < arr[mid-1]){
                    return mid-1;
                }
                //skip the duplicate
                if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                    //but before skipping first check weather its pivot or not
                    if(arr[start] > arr[start+1]){
                        return start;
                    }
                    start++;
                    //same for end
                    if(arr[end] < arr[end-1]){
                        return end-1;
                    }
                    end--;
                }
            }
            return -1;
        }
    }
}

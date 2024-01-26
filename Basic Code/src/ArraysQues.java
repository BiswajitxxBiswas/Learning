import java.util.*;
public class ArraysQues {

    public static void main(String[] args) {
       int[] arr = {1,1,1};
       int ans = subarraySum(arr,2);
        System.out.println(ans);
    }
   static int[] OneDigit(int[] arr){   // try when you are free!!
        int n = arr.length;
       int index=0;
        int ans[] = new int[n/2];
       for (int i = 0; i < n; i+=2) {
           if(arr[i] != arr[i+1]){
               ans[index] = arr[i];
               index++;
           }
       }
       return Arrays.copyOf(ans,index);
   }


    static int FreqSingle(int[] arr){   // Frequency Array
        int n =arr.length;
        int max =Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {        // first we find out the max in array
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //now we will treat index as an element
        int[] freq = new int[max+1];// here +1 is because 0 is also present there
        for (int i = 0; i <n; i++) {  // upto n is taken because we will check every element of (arr)
            freq[arr[i]]++;
        }
        for (int i = 0; i <= max; i++) {
            if(freq[i] == 1){
                return i;
            }
        }
        return -1; // None is single
    }

    static int MaxSubArray(int[] arr){
        int n = arr.length;
        int bag=0;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            bag += arr[i];         // adding values in bag (sum)
            if(bag > sum){
                sum = bag;         // compare and initialized with bigger value
            }
            else if (bag< 0) {      // if sum in bag becomes Neg(-) then initialized to 0
                bag = 0;
            }
        }
        return sum;
    }

    //This method if Brute Force Using Nested For loop
    static int[] TargetSum(int[] arr,int target){
        int n= arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] + arr[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    static int TargetSum1(int[] arr,int target){   // Using Two Pointer
        int n = arr.length;                        // First we have to sort the number

        return -1;
    }

    static int[] TwoSumDublicate(int[] arr,int target){
        int n = arr.length;
        Arrays.sort(arr);
        int i=0;
        int j=n-1;
        int sum =0;
        while(i<j){

            if(arr[i] == arr[i+1]){
                i++;
            }
            sum = arr[i] + arr[j];
            if (sum > target) {
                j--;
            }
            else if (sum < target){
                i++;
            }
            else{
                return new int[]{i,j};
            }

        }
        return null;
    }

    // MC Remember THIS!! Always Sort.
    static List<List<Integer>> ThreeSum(int[] arr, int target){  // There are some error SOLVE THIS!! LATER
        int n = arr.length; //{-1,-3,6,5,-3,-7,8,4} Target-> 18 {-7,-3,-3,-1,4,5,6,8}
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int sum=0;
        for (int i = 0; i < n-2; i++) {
            if(i>0 && arr[i] == arr[i-1]){
                continue;
            }

            int start = i+1;
            int end = n-1;
            while(start<end){



                sum = arr[start] + arr[end];
                if (sum > target - arr[i]) { //If sum is greater target End--
                    end--;
                }
                else if (sum < target -arr[i]){ //If sum is greater target Start++
                    start++;
                }
                else{                           // If Sum is equal to Given Target
                    result.add(Arrays.asList(arr[i],arr[start],arr[end]));
                    while(start < end && arr[start] == arr[start+1]){
                        start++;
                    }
                    while(start < end && arr[end] == arr[end-1]){
                        end--;
                    }
                }
                start++;
                end--;

            }
        }
        return result;
    }

    static int numOfSubarrays(int[] arr, int k, int threshold) { // There are some minor bugs don't know yet
        int n = arr.length;
        int start=0;
        int ans=0,sum=0,end = k;
        for (int i = 0; i < k ; i++) {
            sum+=arr[i];
        }
        if(sum >= threshold * k){
            ans++;
        }
        while(end < n-1){
            sum -= arr[start];
            sum+=arr[end+1];
            start++;
            end++;
            if(sum >= threshold * k){
                ans++;
            }
        }
        return ans;
    }

    static int[] RemoveDublicate(int[] arr){   //{1,1,2,2,3};
        int n= arr.length;
        int i=0;
        int j=0;
        ArrayList<Integer>  ans = new ArrayList<>();
        while(i<n) {
            if(i == n){       // This is for last index to avoid ArrayIndexOutOfBound
                ans.add(arr[n]);
                break;
            }
            while(j<n && arr[i] == arr[j]){
                    j++;
            }
            ans.add(arr[i]);
            i=j;
        }
        int[] result = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            result[k] = ans.get(k);
        }
        return result;
    }

    // Ex. nums = [1,1,0,1,1,1] Output: 3
    public static int findMaxConsecutiveOnes(int[] nums) {
            int n= nums.length;
            int bag=0;
            int ans=0;
        for (int i = 0; i < n; i++) {

            if(nums[i] == 1){
                bag++;
            }
            if(bag > ans){
                ans = bag;
            }
            if(nums[i] != 1){
                bag =0;
            }
        }
        return ans;
    }
    /*                        // Pivot Number      //Check And correct errors
    class Solution {
	public int pivotIndex(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		int Lsum= nums[start];
		int Rsum= nums[end];
		while(start < end){
				if(Lsum < Rsum){
					start++;
					Lsum+=nums[start];
				}
				else if(Lsum > Rsum){
					end--;
					Rsum+=nums[end];
				}
				else{
					if( start+1 != end){
						return start+1;
					}

				}
		}
		return -1;
	}
}
    */

    static int numOfSubarrays1(int[] arr, int k, int threshold) {
        // As we read the question now we know we need to apply Sliding Window
        int n= arr.length;
        int start = 0; // initialized for 1st Window
        int end = k-1;
        int WindowSum = 0;
        int totalWindow =0;
        int ans=0;
        for (int i = start; i <= end; i++) {   // one window created
            WindowSum+=arr[i];
        }
        totalWindow++;
        while(totalWindow<=n-k+1){// Condition To...........Check Again
            if(WindowSum >= threshold*k){
                ans++;
            }
            WindowSum -=arr[start];
            start++;
            end++;
            if(end<n){
                WindowSum+=arr[end];
            }
            totalWindow++;
        }
        return ans;
    }
    static int PivotNumber(int[] arr){ //{1,2,3,4,5,6,7,8} Check Weather The number is Pivot or not
        int length = arr.length;
        int start = 0;
        int end = length-1;
        int mid = start+(end-start)/2;
        while(start<=end){

            int lsum = Leftsum(arr,start,mid);
            int rsum = Rightsum(arr,mid,end);
            if(lsum<rsum){
                mid++;
            } else if (lsum > rsum) {
                mid--;
            }
            else{
                return arr[mid];
            }
        }
        return -1;
    }
    static int Leftsum(int[] arr,int start,int mid){
        int leftsum=0;
        for (int i = start; i <=mid ; i++) {
            leftsum+=arr[i];
        }
        return leftsum;
    }
    static int Rightsum(int[] arr,int mid,int end){
        int rightsum=0;
        for (int i = mid; i <=end ; i++) {
            rightsum+=arr[i];
        }
        return rightsum;
    }

    static int PivotUsingTwoSum(int[] nums){
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int lsum=nums[start],rsum=nums[end];
        while(start<=end){
            if(lsum<rsum){
                start++;
                lsum+=nums[start];
            }
            else if(lsum>rsum ){
                end--;
                rsum += nums[end];
            }
            else{
                return nums[start+1];
            }
        }
        return -1;
    }

    static List<List<Integer>> ThreeSumCount(int[] nums){   //{-1,0,1,2,-1,-4} //we will have to sort it
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            int target = 0 - nums[i];

            while (start < end) {
                int sum = nums[start] + nums[end];

                if (sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }

                    start++;
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }

            // Skip duplicate ith numbers
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return ans;
    }

    static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n= nums.length;
        for (int i = 0; i <n-3 ; i++) {  // fixed for 4Sum
            int targetA = target -nums[i];
            if(targetA < min || targetA > max){
                return null;
            }
            for (int j = i+1; j <n-2 ; j++) { //Fixed for Three Sum
                int start = j+1;
                int end = n-1;
                int targetB = targetA-nums[j];
                if(targetB < min || targetB > max){
                    return new ArrayList<>();
                }
                while (start< end){
                    int sum= nums[start] + nums[end];
                    if(sum == targetB){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        while(start<end && nums[start] == nums[start+1]){
                            start++;
                        }
                        while(start<end && nums[end] == nums[end-1]){
                            end--;
                        }
                        start++;
                        end--;
                    } else if (sum < targetB) {
                        start++;
                    }
                    else {
                        end--;
                    }
                }
                while(j<n-2 && nums[j] == nums[j+1]){
                    j++;  // Skip Duplicate B(j)
                }
            }
            while(i<n-3 && nums[i] == nums[i+1]){
                i++;  // Skip Duplicate A(i)
            }
        }
        return ans;

    }
    static List<List<Integer>> fourSumgpt(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int start = j + 1;
                int end = n - 1;

                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));

                        // Skip duplicates for start
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        start++;

                        // Skip duplicates for end
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return ans;
    }

    // https://nextleap.app/course-dashboard/nlcfssnwcprmb7tcu1uv3/practice/nlactpp3pw70qkmww90om88
//    static  List<Integer> findAnagrams(String s, String p) { // {a,b,a,b} // {a,b}
//        ArrayList<Integer> Index  = new ArrayList<>();
//        int[]  freq1 = FrequencyArray(p,0,p.length());//Stored The Freq Of P
//        int start =0;
//        int end = p.length();
//        while( end <= s.length() && start<end){
//            int[] freq2 = FrequencyArray(s,start,end);
//            if(isSameFrequency(freq1,freq2)){
//                Index.add(start);
//            }
//            start++;
//            end++;
//        }
//        return Index;
//
//    }
    // making a method for frequency array
    static int[] FrequencyArray(String s,int start,int end,int size){
        int[] Frequency = new int[size];
        for (int i = start; i < end; i++) {
            Frequency[s.charAt(i)-'a']++;
        }
        return Frequency;
    }
    static boolean isSameFrequency(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    static int CountElementMaxFreq(int[] nums){
        Arrays.sort(nums);
        int sum=0;
        int n = nums.length;
//        if(n==1){
//            return 1;
//        }
        int max = max(nums);
        int[] freq = FrequencyArrayLeet(nums,0,n,max);
        int Maxcount=max(freq);
        for (int i = 0; i <= max; i++) {
            if(freq[i] == Maxcount){
                sum +=freq[i];
            }
        }
        return sum;

    }

    static int[] FrequencyArrayLeet(int[] nums,int start,int end,int size){
        int[] Frequency = new int[size+1];
        for (int i = start; i < end; i++) {
           Frequency[nums[i]]++;
        }
        return Frequency;
    }
    static int max(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] > max){
                max = nums[i];
            }

        }
        return max;
    }
//     static int characterReplacement(String s, int k) {
//        int i=0,j=0;
//        int max=0,current=0;
//        while(j<s.length() && i<=j){
//            if(  currectSliding(s,i,j,k)   ){
//                current = j-i+1;
//                max = Math.max(max,current);
//                j++;
//            }
//            else {
//                i++;
//            }
//        }
//        return max;
//    }
//
//     static boolean currectSliding(String s, int i, int j, int k) { //   [0:A | 1:B]
//        int[] freq = new int[26];
//         for (int l = i; l <=j ; l++) {
//             freq[s.charAt(l) -'A']++;
//         }
//         for (int l = 0; l < 26; l++) {
//             if(freq[l] > k){
//                 re
//             }
//         }
//         return true;
//    }

    static int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        int max = 0, current = 0;
        while (j < s.length()) {
            if (currentSliding(s, i, j, k)) {
                current = j - i + 1;
                max = Math.max(max, current);
                j++;
            } else {
                i++;
            }
        }
        return max;
    }

    static boolean currentSliding(String s, int i, int j, int k) {
        int[] freq = new int[26];
        for (int l = i; l <= j; l++) {
            freq[s.charAt(l) - 'A']++;
        }
        int maxFreq = 0;
        for (int l = 0; l < 26; l++) {
            maxFreq = Math.max(maxFreq, freq[l]);
        }
        return (j - i + 1 - maxFreq) <= k;
    }
    static void rotate(int[] nums, int k) {
        int n = nums.length;
        //for reverse whole array
        swap(nums,0,n-1);
        swap(nums,0,k-1);
        swap(nums,k,n-1);
    }
    static void swap(int[] nums,int a,int b){
        int start =a;
        int end=b;
        int temp;
        while(start<end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;

        }
    }

    static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

}



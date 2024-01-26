import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class SolvedQuesNet {
    public static void main(String[] args) {
        int[] nums = {-1, -3, 6, -5, -3, -7, 8, -4, 9, 7};
        int target = 18;

        List<List<Integer>> result = threeSum(nums);

        // Print the result
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }


        static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            int target=0;
            Arrays.sort(nums);
            int size = nums.length;
            for(int i=0;i<size-2;i++){
                if(i>0 && nums[i] == nums[i-1]){
                    continue;
                }
                int start =i+1;
                int end = size-1;
                int sum = nums[start] + nums[end];
                while(start < end){
                    if(sum < target- nums[i]){
                        start++;
                    }
                    else if (sum > target- nums[i]){
                        end--;
                    }
                    else{
                        result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                        while(start < end && nums[start] == nums[start+1]){
                            start++;
                        }
                        while(start < end && nums[end] == nums[end-1]){
                            end--;
                        }
                        start++;
                        end--;
                    }

                }
            }
            return result;
        }

    }


//

//import java.util.List;
//        import java.util.ArrayList;
//        import java.util.Arrays;

//public class SolvedQuesNet {
//    public static void main(String[] args) {
//        int[] nums = {-1, -3, 6, -5, -3, -7, 8, -4, 9, 7};
//        List<List<Integer>> result = threeSum(nums);
//
//        // Print the result
//        for (List<Integer> triplet : result) {
//            System.out.println(triplet);
//        }
//    }
//
//    static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//        int size = nums.length;
//        int target=0;
//
//        for (int i = 0; i < size - 2; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//
//            int start = i + 1;
//            int end = size - 1;
//            while (start < end) {
//                int sum = nums[i] + nums[start] + nums[end];
//
//                if (sum < target- nums[i]) {
//                    start++;
//                } else if (sum > target - nums[i]) {
//                    end--;
//                } else {
//                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
//
//                    while (start < end && nums[start] == nums[start + 1]) {
//                        start++;
//                    }
//                    while (start < end && nums[end] == nums[end - 1]) {
//                        end--;
//                    }
//
//                    start++;
//                    end--;
//                }
//            }
//        }
//        return result;
//    }
//}

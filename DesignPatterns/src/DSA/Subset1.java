package DSA;

import java.util.ArrayList;
import java.util.List;

public class Subset1 {

    public static List<List<Integer>> subsets(int[] nums) {


        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums,results, new ArrayList<>(),0);
        return results;

    }

    static void  backtrack(int[] nums,List<List<Integer>> results, List<Integer> result,int index){
        if(!results.contains(result)) {
            results.add(new ArrayList<>(result));
        }
        for(int i=index;i<nums.length;i++){
            if(result.contains(nums[i])) continue;
            result.add(nums[i]);
            backtrack(nums,results,result,index+1);
            result.remove(result.size()-1);
        }

    }

    public static void main(String[] args) {
       int  nums[] = {1,2,3};
        System.out.println(subsets(nums));
    }


}

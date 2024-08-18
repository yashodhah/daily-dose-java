package leetcode.onefiivenote;

import org.junit.jupiter.api.Test;

public class PlayGround {

    @Test
    void removeElement(){
        Solution solution = new Solution();
        solution.removeElement(new int[]{3,2,2,3}, 3);
    }



    class Solution {
        public int removeElement(int[] nums, int val) {
            int p1 = 0;
            int p2 = nums.length-1;

            while(nums[p2] == val){
                nums[p2] = 101;
                p2 = p2-1;
            }

            while (p1 < p2) {
                if(nums[p1] == val ){
                    nums[p1] = nums[p2];
                    nums[p2] = 101;

                    p2 = p2-1;
                }

                p1 = p1+1;
            }

            return p1+1;
        }
    }
}

// 300. Longest Increasing Subsequence

class LongestIncreasingSubsequenceBF {
    public int lengthOfLIS(int[] nums) {
        
        
        if(nums.length == 0) {
            
            return 0;
        }

        if(nums.length == 1) {
            
            return 1;
        }
       
        int[] auxArray = new int[nums.length];
        
        auxArray[0] = 1;
        
        int maxCount = 0;
        int result = 0;    
        
        for(int i = 1; i < nums.length; i++) {
            
            maxCount = 0;
            
            for(int j = 0; j < i; j++) {
                
                if(nums[i] > nums[j]) {
                    
                    maxCount = Math.max(maxCount, auxArray[j]);
                    
                }
            }
            
            auxArray[i] = maxCount + 1;
            result = Math.max(result, auxArray[i]);
            
        }
        
        return result;
    }
}
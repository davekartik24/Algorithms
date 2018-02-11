//300. Longest Increasing Subsequence

class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 0) {
            
            return 0;
        }
        
        int[] auxArray = new int[nums.length];
        
        int length = 0;
        
        
        for(int element : nums) {
            
            int index = Arrays.binarySearch(auxArray, 0, length, element);
            
            if(index < 0) index = -(index + 1);
            
            auxArray[index] = element;
            
            if(index == length) length++;
            
        }
        
        
        return length;
        
       
    }
}
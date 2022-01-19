class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Lowest aur heaviest ko chance denge pehele 
        // Agar limit ko cross kare toh heavy ko bol denge akele chale jao
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        int boats = 0;
        while( left < right ){
            int sum = people[left] + people[right];
            
            if( sum <= limit ){
                left++;
                right--;
            }else{
                right--;
            }
            boats++;
        }
        // Middle element ek hi bacha hai
        
        if( left == right ) boats++;
        
        
        return boats;
    }
}
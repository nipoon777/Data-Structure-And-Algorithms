class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap <Integer, PriorityQueue<Integer>> treeMap = new TreeMap <>();
        
        for(int[] item : items ){
            int stdId = item[0];
            int marks = item[1];
            
            if( treeMap.containsKey(stdId) ){
                PriorityQueue<Integer> markL = treeMap.get(stdId);
                markL.offer(marks);
                if( markL.size() > 5 ){
                    markL.remove();
                }
                treeMap.put(stdId, markL);
                
            }else{
                PriorityQueue<Integer> markL = new PriorityQueue<>();
                markL.offer(marks);
                treeMap.put(stdId, markL );
            }
        }
        
        int[][] res = new int[ treeMap.size() ][2];
        int idx = 0;
        for(int id : treeMap.keySet() ){
            
            PriorityQueue<Integer> heap = treeMap.get(id);
            int sum = 0;
            while( heap.size() > 0 ){
                sum += heap.remove();
            }
            sum /= 5;
            
            res[idx][0] = id;
            res[idx][1] = sum;
            idx++;
        }
        return res;
    }
}
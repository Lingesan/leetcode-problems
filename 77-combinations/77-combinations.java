class Solution {
    
    List<List<Integer>> result = new LinkedList<>();
    int k;
    int n;
    
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        combine(new ArrayList<>(), 0);
        return result;
    }
    
    public void combine(List<Integer> currentList, int index){
        if(currentList.size() == k){
            result.add(new ArrayList(currentList));
            return;
        }
        for(int i=index+1;i<=n;i++){
            currentList.add(i);
            combine(currentList,i);
            currentList.remove(currentList.size() -1);
        }
    }
}
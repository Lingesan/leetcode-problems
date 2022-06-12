class Solution {
    
    
    List<String> result = new ArrayList<String>();
    int n;
    
    public List<String> generateParenthesis(int n) { 
        this.n = n;
        generateParenthesis("",0,0);
        return result;
    }
    
    public void generateParenthesis(String currWord,int openCount, int closedCount){
        if( currWord.length() == n*2){
            result.add(currWord);
            return;
        }
        
        if(openCount<n){
            generateParenthesis(currWord + "(",openCount+1, closedCount);
        }
        
        if(closedCount<openCount){
            generateParenthesis(currWord + ")",openCount, closedCount+1);
        }
        
    }
}
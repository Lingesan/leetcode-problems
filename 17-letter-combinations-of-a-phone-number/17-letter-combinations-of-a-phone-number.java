import java.util.*;

class Solution {
    
    public static Map<Character,String> LETTER_PATTERN;
    
    static {
        Map<Character,String> pattern = new HashMap<>();
        pattern.put('2',"abc");
        pattern.put('3',"def");
        pattern.put('4',"ghi");
        pattern.put('5',"jkl");
        pattern.put('6',"mno");
        pattern.put('7',"pqrs");
        pattern.put('8',"tuv");
        pattern.put('9',"wxyz");
        LETTER_PATTERN = Collections.unmodifiableMap(pattern);
    }
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.equals("")){
            return Collections.emptyList();
        }
        List<String> list = new ArrayList<>();
        list.add("");
        return recursivelyGenerateCombinations(digits, list);
    }
    
    
    public List<String> recursivelyGenerateCombinations(String digits, List<String> list){
        if(digits == ""){
            return list;
        }
        String pattern = LETTER_PATTERN.get(digits.charAt(0));
        List<String> comboList = new ArrayList<>();
        for(char ch: pattern.toCharArray()){
            for(String combo : list){
                comboList.add(combo + ch);
            }
        }
        return recursivelyGenerateCombinations(digits.substring(1),comboList);
    }
}
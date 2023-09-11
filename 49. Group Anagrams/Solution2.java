import java.util.*;

class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>res=new ArrayList<>();
        HashMap<String,List<String>> hm=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char ch[]=strs[i].toCharArray();
            Arrays.sort(ch);
            String s=String.valueOf(ch);
            if(hm.get(s)!=null){
                List<String>a=hm.get(s);
                a.add(strs[i]);
                hm.put(s,a);
            }
            else{
                List<String>a=new ArrayList<>();
                a.add(strs[i]);
                hm.put(s,a);
            }
        }
        for(Map.Entry<String,List<String>> en:hm.entrySet()){
            res.add(en.getValue());
        }
        return res;
    }}
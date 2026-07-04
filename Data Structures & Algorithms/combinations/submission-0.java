class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(n , k ,outer, curr,1 );
        return outer;
    }
    public void backtrack(int n ,int k ,List<List<Integer>> outer, List<Integer> curr,int y){
        if(curr.size() == k){
            outer.add(new ArrayList<>(curr));
            return;
        }
        for(int i = y ; i <= n ; i++){
        curr.add(i);
        backtrack(n ,k , outer,curr,i+1);
        curr.remove(curr.size() - 1);
        }
    }
}
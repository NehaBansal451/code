class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outer =  new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        permutation(p,nums,outer);
        return outer;
    }
    static void permutation(List<Integer> p , int[] up , List<List<Integer>> outer){
        if(up.length == 0){
            outer.add(new ArrayList(p));
            return;
        }
        int curr = up[0];
         for (int i = 0; i <= p.size(); i++) {

            List<Integer> temp = new ArrayList<>(p);
            temp.add(i, curr);

            permutation(
                temp,
                Arrays.copyOfRange(up, 1, up.length),
                outer
            );
        }
    }
}
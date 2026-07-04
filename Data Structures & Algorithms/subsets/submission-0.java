class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>(); //[]
        outer.add(new ArrayList<>()); //[[]]
        for (int num : nums) { // num = 1
            int n = outer.size(); // n = 1
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
}

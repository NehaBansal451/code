class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        permutationWithDuplicate(outer, nums, p);
        return outer;
    }
    static void permutationWithDuplicate(List<List<Integer>> outer, int[] nums, List<Integer> p) {
        if (nums.length == 0) {
            outer.add(new ArrayList(p));
            return;
        }
        int curr = nums[0];
        for (int i = 0; i <= p.size(); i++) {
            if (i > 0 && p.get(i - 1) == curr) {
                break;
            }

            List<Integer> temp = new ArrayList<>(p);
            temp.add(i, curr);

           permutationWithDuplicate(
                outer,
                Arrays.copyOfRange(nums, 1, nums.length),
                temp
        );
        }
    }
}
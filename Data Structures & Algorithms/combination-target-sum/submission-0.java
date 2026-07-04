class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtrack(nums, target, list, 0, outer);

        return outer;
    }

    public void backtrack(int[] nums,
                          int target,
                          List<Integer> list,
                          int i,
                          List<List<Integer>> outer) {

        if (target == 0) {
            outer.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        // Take
        list.add(nums[i]);
        backtrack(nums, target - nums[i], list, i, outer);

        // Undo
        list.remove(list.size() - 1);

        // Skip
        backtrack(nums, target, list, i + 1, outer);
    }
}

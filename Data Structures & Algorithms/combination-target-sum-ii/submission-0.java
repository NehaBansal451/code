class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(outer , candidates , target, list ,0);
        return outer;
    }
    public void backtrack(List<List<Integer>> outer , int[] candidates , int target ,List<Integer> list, int start){
        
        if(target == 0){
            outer.add(new ArrayList(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicate values at the same level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
         // Pruning
            if (candidates[i] > target) {
                break;
            }
        list.add(candidates[i]);
        backtrack(outer , candidates , target - candidates[i], list ,i + 1);
        list.remove(list.size() - 1);
        }
    }
}

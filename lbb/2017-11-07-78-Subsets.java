class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        list.add(new ArrayList<>());
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                ArrayList tmp = new ArrayList(list.get(j));
                tmp.add(nums[i]);
                list.add(tmp);
            }
        }
        return list;
    }
}
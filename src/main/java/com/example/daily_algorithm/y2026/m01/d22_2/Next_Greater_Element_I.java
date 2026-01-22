class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // nums2 기준으로 next greater element 계산
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // 스택에 남은 값들은 next greater element가 없음
        while(!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // nums1 결과 구성
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
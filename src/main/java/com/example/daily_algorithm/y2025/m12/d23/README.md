# 🧩 Majority Element

**난이도:** Easy  
**플랫폼:** LeetCode  
**유형:** Array, HashMap, Greedy  
**링크:** https://leetcode.com/problems/majority-element/

---

## 📝 문제 설명

정수 배열 `nums`가 주어질 때, 배열에서 **과반수(majority)** 원소를 반환하라.

majority 원소란 배열 길이가 `n`일 때, **`n/2`번 초과** 등장하는 원소를 의미한다.  
문제에서는 majority 원소가 항상 존재한다고 가정한다.

---

## 🔍 예시

입력  
nums = [3,2,3]

출력  
3

---

입력  
nums = [2,2,1,1,1,2,2]

출력  
2

---

## 📋 제약 조건 (Constraints)

- `1 <= nums.length <= 5 * 10^4`
- `-10^9 <= nums[i] <= 10^9`
- majority element는 항상 존재한다.

---

## 💡 접근 방식

### 방법 1: HashMap을 이용한 빈도 카운팅 (내 풀이)

#### 아이디어
- 각 숫자의 등장 횟수를 `HashMap`에 저장한다.
- 순회하면서 가장 많이 등장한 숫자를 갱신한다.
- majority element가 항상 존재하므로, 최댓값을 반환하면 된다.

#### 특징
- 직관적이고 이해하기 쉽다.
- 추가 메모리를 사용한다.

#### 시간 / 공간 복잡도
- 시간 복잡도: `O(n)`
- 공간 복잡도: `O(n)`

---

### 코드 (HashMap)

    class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int maxCount = 0;
            int answer = nums[0];

            for (int num : nums) {
                int cnt = map.getOrDefault(num, 0) + 1;
                map.put(num, cnt);

                if (cnt > maxCount) {
                    maxCount = cnt;
                    answer = num;
                }
            }

            return answer;
        }
    }

---

### 방법 2: Boyer–Moore Voting Algorithm (최적 해법)

#### 아이디어
- majority 원소는 다른 모든 원소와 **상쇄하고도 남는다**는 성질을 이용한다.
- 후보(candidate)와 카운트(count)를 유지한다.
    - count가 0이면 현재 값을 후보로 설정
    - 같은 값이면 count 증가
    - 다른 값이면 count 감소

#### 특징
- 추가 자료구조 없이 해결 가능
- 가장 효율적인 해법

#### 시간 / 공간 복잡도
- 시간 복잡도: `O(n)`
- 공간 복잡도: `O(1)`

---

### 코드 (Boyer–Moore)

    class Solution {
        public int majorityElement(int[] nums) {
            int candidate = 0;
            int count = 0;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }

                if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            return candidate;
        }
    }

# 🧩 Largest Rectangle in Histogram

**난이도:** Hard  
**플랫폼:** LeetCode  
**유형:** Stack, Monotonic Stack, Array  
**링크:** https://leetcode.com/problems/largest-rectangle-in-histogram/

---

## 📝 문제 설명

정수 배열 `heights`가 주어진다.  
`heights[i]`는 i번째 막대의 높이를 의미하며, 모든 막대의 너비는 1이다.

히스토그램에서 만들 수 있는 **가장 큰 직사각형의 넓이**를 반환하라.

---

## 🔍 예시

입력  
heights = [2,1,5,6,2,3]

출력  
10

설명  
높이 5와 6 막대를 포함하는 구간(인덱스 2~3)의 직사각형이 최대이며,  
높이 5 × 너비 2 = 10 이다.

---

## 📋 제약 조건 (Constraints)

- `1 <= heights.length <= 10^5`
- `0 <= heights[i] <= 10^4`

---

## 💡 접근 방식

각 막대 `heights[i]`를 “직사각형의 최소 높이”로 사용할 때,
그 막대가 확장될 수 있는 최대 너비는

- 왼쪽으로는 **자기보다 작은 막대를 만날 때까지**
- 오른쪽으로는 **자기보다 작은 막대를 만날 때까지**

확장한 구간이다.

즉, 어떤 높이 `h`에 대해
- `h`보다 작은 막대가 등장하는 순간, 더 이상 확장할 수 없으므로
- 그때 `h`의 최대 넓이를 확정할 수 있다.

---

### 스택에 저장하는 것
- 막대의 **인덱스(index)**
- 스택은 높이가 증가하는 형태(단조 증가)를 유지한다.

---

### 왜 단조 증가인가?
- 현재 막대 높이가 스택 top보다 작아지는 순간,
  top 막대는 “오른쪽 경계”가 확정된다.
- 이때 top 막대의 넓이를 계산하고 pop한다.
- pop 후에도 현재 높이가 더 작다면 연쇄적으로 pop하며 넓이를 계산한다.

---

### 넓이 계산 방법

pop된 인덱스를 `mid`라고 하면, 높이는 `heights[mid]`이다.

- 오른쪽 경계: 현재 인덱스 `i - 1`
- 왼쪽 경계: pop 이후 스택 top 인덱스 `left`
    - 만약 스택이 비어있다면 left = -1 (왼쪽 끝까지 확장 가능)

따라서 너비는:

    width = i - left - 1

넓이는:

    area = heights[mid] * width

---

### 
모든 막대를 처리한 뒤에도 스택에 남아있는 막대들이 있다.  
이를 한 번에 정리하기 위해, 마지막에 높이 0을 하나 추가한 것처럼 처리한다.

즉, 반복 범위를 `i <= n`까지 돌고,
`i == n`일 때 높이를 0으로 간주하여 스택을 모두 비우게 만든다.

---

## 코드

    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            Deque<Integer> stack = new ArrayDeque<>();
            int maxArea = 0;

            for (int i = 0; i <= n; i++) {
                int currHeight = (i == n) ? 0 : heights[i];

                while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                    int mid = stack.pop();
                    int h = heights[mid];

                    int left = stack.isEmpty() ? -1 : stack.peek();
                    int width = i - left - 1;

                    maxArea = Math.max(maxArea, h * width);
                }

                stack.push(i);
            }

            return maxArea;
        }
    }

---

## ⏱ 시간 / 공간 복잡도

- 시간 복잡도: `O(n)`  
  (각 인덱스는 최대 1번 push, 1번 pop)
- 공간 복잡도: `O(n)`  
  (스택 사용)

---

## ✨ 정리

- 이 문제는 “각 막대를 최소 높이로 하는 최대 직사각형”을 계산하는 문제다.
- 단조 증가 스택을 유지하다가, 높이가 꺾이는 순간(pop) 넓이를 확정한다.
- pop되는 막대는 그 시점에서 **오른쪽 경계가 현재 i-1로 확정**되며,
  pop 이후의 스택 top이 **왼쪽 경계 바로 밖**이 된다.
- 센티넬(높이 0)을 이용하면 스택에 남은 값들도 깔끔하게 처리할 수 있다.

---

## 🔗 관련 문제

- Daily Temperatures
- Stock Span
- Maximal Rectangle
- Trapping Rain Water

# 🧩 Stock Span

**난이도:** Medium  
**플랫폼:** LeetCode  
**유형:** Stack, Monotonic Stack  
**링크:** https://leetcode.com/problems/online-stock-span/

---

## 📝 문제 설명

주식의 일별 가격이 주어진다.  
각 날짜마다, **오늘 가격보다 작거나 같은 이전 날짜들이 연속으로 몇 일인지**를 구하라.

이를 **Stock Span**이라 부른다.

- 오늘 하루는 항상 포함된다.
- 연속이 끊기는 순간까지의 길이를 계산한다.

---

## 🔍 예시

입력  
prices = [100, 80, 60, 70, 60, 75, 85]

출력  
[1, 1, 1, 2, 1, 4, 6]

---

### 예시 설명

- 100 → 이전 없음 → 1
- 80 → 100보다 작음 → 연속 1
- 60 → 80보다 작음 → 연속 1
- 70 → 60, 70 ≤ 70 → 연속 2
- 60 → 70보다 작음 → 연속 1
- 75 → 60, 70, 60 ≤ 75 → 연속 4
- 85 → 75, 60, 70, 60, 80 ≤ 85 → 연속 6

---

## 📋 제약 조건 (Constraints)

- `1 <= prices.length <= 10^5`
- `1 <= prices[i] <= 10^5`

---

## 💡 접근 방식

- Daily Temperatures  
  → 오른쪽에서 **더 큰 값**을 찾음
- Stock Span  
  → 왼쪽에서 **작거나 같은 값들의 연속 길이**를 계산

---

### 스택에 저장하는 것
- `(가격, 해당 가격의 span)` 쌍을 저장

왜 인덱스가 아닌 span을 저장할까?
- 이전 값들을 pop하면서 **span을 누적**하기 위함이다.

---

### 진행 방식
1. 현재 가격을 기준으로 span을 1로 시작한다.
2. 스택의 top 가격이 현재 가격보다 **작거나 같다면**:
    - 해당 값을 pop
    - pop된 값의 span을 현재 span에 더한다
3. 더 이상 pop할 수 없을 때:
    - `(현재 가격, 누적된 span)`을 스택에 push
4. 누적된 span이 오늘의 정답이 된다.

이 과정에서 스택은 **가격 기준 단조 감소**를 유지한다.

---

## 코드

    class StockSpanner {

        private Deque<int[]> stack;

        public StockSpanner() {
            stack = new ArrayDeque<>();
        }

        public int next(int price) {
            int span = 1;

            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                span += stack.pop()[1];
            }

            stack.push(new int[]{price, span});
            return span;
        }
    }
---

## 🔗 관련 문제

- Daily Temperatures
- Next Greater Element I
- Largest Rectangle in Histogram

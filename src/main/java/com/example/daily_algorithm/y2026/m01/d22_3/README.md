# 🧩 Daily Temperatures

**난이도:** Medium  
**플랫폼:** LeetCode  
**유형:** Stack, Array, Monotonic Stack  
**링크:** https://leetcode.com/problems/daily-temperatures/  

---

## 📝 문제 설명

정수 배열 `temperatures`가 주어진다.  
`temperatures[i]`는 i번째 날의 기온을 의미한다.

각 날짜마다,  
**자기보다 더 높은 기온이 나올 때까지 며칠을 기다려야 하는지**를 구해라.

- 더 높은 기온이 없다면 `0`을 반환한다.

결과는 같은 길이의 배열로 반환한다.

---

## 🔍 예시

입력  
temperatures = [73,74,75,71,69,72,76,73]

출력  
[1,1,4,2,1,1,0,0]

---

### 예시 설명 (일부)
- 73 → 다음 날 74가 더 높음 → 1일
- 75 → 76이 나올 때까지 4일
- 76 → 이후 더 높은 기온 없음 → 0

---

## 📋 제약 조건 (Constraints)

- `1 <= temperatures.length <= 10^5`
- `30 <= temperatures[i] <= 100`

---

## 💡 접근 방식

- 스택에는 아직 더 따뜻한 날을 못 찾은 날짜의 인덱스를 저장한다.
- 스택은 기온 기준 단조 감소를 유지한다.

---

### 스택에 저장하는 것
- `temperatures`의 **인덱스(index)**

왜 값이 아니라 인덱스인가?
- “며칠을 기다리는지” = `현재 인덱스 - 이전 인덱스` 이기 때문

---

### 진행 방식
1. 날짜를 앞에서부터 순회한다.
2. 현재 기온이 스택 top 인덱스의 기온보다 높다면:
   - 스택에서 pop
   - pop된 인덱스의 정답은  
     `현재 인덱스 - pop된 인덱스`
3. 더 이상 pop할 수 없을 때까지 반복
4. 현재 인덱스를 스택에 push
5. 끝까지 남은 인덱스들은 더 높은 기온이 없으므로 기본값 `0`


---

## 🔗 관련 문제

- Next Greater Element I
- Next Greater Element II
- Stock Span
- Largest Rectangle in Histogram

# 🧩 Subarray Sum Equals K

**난이도:** Medium  
**플랫폼:** LeetCode  
**유형:** Array, Prefix Sum, HashMap  
**링크:** https://leetcode.com/problems/subarray-sum-equals-k/

---

## 📝 문제 설명

정수 배열 `nums`와 정수 `k`가 주어질 때,  
합이 `k`가 되는 **연속된 부분 배열(subarray)**의 개수를 반환하라.

---

## 🔍 예시

입력  
nums = [1,1,1], k = 2

출력  
2

설명  
[1,1] (0~1), [1,1] (1~2) 두 개가 존재한다.

---

입력  
nums = [1,2,3], k = 3

출력  
2

설명  
[1,2], [3]

---

## 📋 제약 조건 (Constraints)

- `1 <= nums.length <= 2 * 10^4`
- `-1000 <= nums[i] <= 1000`
- `-10^7 <= k <= 10^7`

---

## 💡 접근 방식

### 핵심 아이디어 (Prefix Sum + HashMap)
연속 부분 배열 `nums[l..r]`의 합은 다음과 같다.

    sum(l..r) = prefix[r] - prefix[l-1]

이 값이 `k`가 되려면,

    prefix[r] - prefix[l-1] = k
    prefix[l-1] = prefix[r] - k

즉, 현재까지의 누적합을 `prefix`라고 할 때,
- 현재 `prefix`가 있을 때
- 이전에 `prefix - k`가 나온 횟수만큼
  **(그 지점 다음부터 현재까지)** 합이 `k`인 부분 배열이 생긴다.

### 구현 포인트
- `map[prefixSum] = prefixSum이 등장한 횟수`
- 시작점 처리 위해 `map.put(0, 1)`을 먼저 넣는다.
    - 누적합 자체가 k인 경우를 세기 위함

---

## 1) 부분 배열 합을 누적합으로 표현

연속 부분 배열 nums[l..r]의 합은

    sum(l..r) = prefix[r] - prefix[l-1]

이게 k가 되려면

    prefix[r] - prefix[l-1] = k
    prefix[l-1] = prefix[r] - k

즉, "현재 누적합(prefix[r])에서 k를 뺀 값이 과거에 몇 번 나왔는지" 알면
그 횟수만큼 k가 되는 부분배열이 존재

---

## 3) map의 의미

    Map<Integer, Integer> map

- key: 누적합 값(prefixSum)
- value: 그 누적합이 등장한 횟수

예를 들어 map에 (3 -> 2)가 있다면,
"누적합 3이 과거에 2번 있었다"는 뜻

---

## 4) map.put(0, 1) 이게 왜 필요?

    map.put(0, 1);

이건 "누적합이 0인 경우를 1번 있었다"라고 미리 넣는 거

왜냐면,
- 어떤 시점의 prefix가 바로 k라면
- prefix - k = 0이 되는데
- 이때 0이 map에 없으면 "처음부터 시작하는 부분 배열"을 못 세게 됨.

예: nums=[1,1], k=2
- i=1에서 prefix=2
- prefix-k=0
- map에 0이 있어야 count가 1 증가 (부분배열 [1,1])

---

## 5) 반복문 내부 핵심 3줄

### (1) 누적합 갱신
    prefix += num;

현재까지의 합을 계속 업데이트.

### (2) 정답 개수 누적
    count += map.getOrDefault(prefix - k, 0);

현재 prefix에서 k를 뺀 값이 과거에 몇 번 있었는지 찾는다.
그 횟수만큼 "k가 되는 부분배열"이 생긴다.

### (3) 현재 누적합을 map에 기록
    map.put(prefix, map.getOrDefault(prefix, 0) + 1);

현재 prefix가 이후에 쓰일 수 있으니 등장 횟수를 +1 한다.

---

## 6) 예시로 한 번 따라가보기

nums = [1, 1, 1], k = 2

초기:
- map = {0:1}
- prefix = 0
- count = 0

### i=0, num=1
- prefix = 1
- prefix-k = -1 → map에 없음 → count += 0
- map에 prefix=1 기록 → map {0:1, 1:1}

### i=1, num=1
- prefix = 2
- prefix-k = 0 → map에 1번 있음 → count += 1 (부분배열 [1,1])
- map에 prefix=2 기록 → map {0:1, 1:1, 2:1}

### i=2, num=1
- prefix = 3
- prefix-k = 1 → map에 1번 있음 → count += 1 (부분배열 [1,1] (1~2))
- map에 prefix=3 기록

결과 count = 2

---

## 7) 시간/공간 복잡도

- 시간: `O(n)` (한 번 순회 + HashMap O(1) 평균)
- 공간: `O(n)` (누적합이 여러 개 저장될 수 있음)

---

"현재 누적합 prefix에서 k를 뺀 값이 과거에 몇 번 나왔는지"를 세면
그만큼 합이 k인 연속 부분 배열이 존재한다.
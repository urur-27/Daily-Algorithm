# 🧩 387. First Unique Character in a String

**난이도:** Easy  
**플랫폼:** LeetCode  
**유형:** HashMap, String  
**링크:** https://leetcode.com/problems/first-unique-character-in-a-string/
---

## 📝 문제 설명

문자열 `s`가 주어졌을 때,  
문자열에서 **오직 한 번만 등장하는 문자 중 가장 첫 번째 문자**의 인덱스를 반환하는 문제이다.

만약 유일한 문자가 없다면 `-1`을 반환한다.

핵심은 문자열 내에서 각 문자의 등장 횟수를 파악하고,  
그 중에서 빈도수가 1인 문자를 가장 앞에서부터 찾아야 한다는 점이다.

---

## 🔍 예시

### ✔ 예시 1
입력

    s = "leetcode"

출력

    0

설명:  
'l' 문자가 가장 먼저 등장하는 유일 문자.

---

### ✔ 예시 2
입력

    s = "loveleetcode"

출력

    2

설명:  
'l' = 2회, 'o' = 2회  
하지만 'v'는 1회 등장하며 가장 먼저 나오는 유일 문자 → 인덱스 2.

---

### ✔ 예시 3
입력

    s = "aabb"

출력

    -1

설명:  
유일하게 등장하는 문자가 없다.

---

## 📋 제약 조건 (Constraints)

- `1 ≤ s.length ≤ 10⁵`
- `s는 오직 소문자 알파벳으로 구성된다. ('a' ~ 'z')`

---

## 💡 접근 방식

이 문제는 문자열에서 **오직 한 번만 등장하는 문자 중 가장 먼저 등장하는 문자**의 인덱스를 찾는 문제이다.  
이를 해결하기 위해 **문자 빈도수를 카운팅하는 HashMap**을 활용한다.

문제 해결의 핵심 과정은 다음 두 단계로 나뉜다:

---

### ✔ 1) HashMap에 문자 빈도수 저장하기

문자열을 한 번 순회하며 각 문자의 등장 횟수를 저장한다.

- key → 문자(Character)
- value → 등장 횟수(Integer)

문자가 처음 등장하면 1로 저장하고,  
이미 존재하는 경우 기존 값에 +1을 해준다.

---

### ✔ 2) 다시 문자열을 순회하며 빈도수가 1인 문자 찾기

문자열을 앞에서부터 다시 탐색하면서  
해당 문자의 빈도수가 **정확히 1**인 순간  
그 문자의 인덱스를 반환하면 된다.

HashMap은 key 조회가 평균 O(1)이기 때문에  
전체 시간 복잡도는 O(n)으로 매우 효율적이다.

---

### 📌 전체 흐름 정리

1. 문자열 순회 → HashMap에 문자 빈도수 카운팅
2. 문자열 다시 순회 → map.get(char) == 1 이면 해당 인덱스 반환
3. 끝까지 없으면 -1 반환

---

### 시간 복잡도
- 문자열 길이 n
- HashMap 조회/삽입 O(1)  
  → 전체 시간복잡도: **O(n)**


---

## 코드

```java

    class Solution {
        public int firstUniqChar(String s) {

            Map<Character, Integer> map = new HashMap<>();

            // 1) 빈도수 카운트
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            // 2) 첫 번째 유일 문자 찾기
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }

            return -1;
        }
    }
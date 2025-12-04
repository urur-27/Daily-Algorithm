# 🧩 242. Valid Anagram

**난이도:** Easy  
**플랫폼:** LeetCode  
**유형:** HashMap, 문자열, 빈도수 카운팅  
**링크:** https://leetcode.com/problems/valid-anagram/
---

## 📝 문제 설명

문자열 `s`와 `t`가 주어졌을 때,  
`t`가 `s`의 **아나그램(anagram)** 이라면 `true`, 아니면 `false`를 반환하는 문제이다.

**아나그램이란?**  
문자 구성은 동일하지만 문자 순서만 다른 문자열을 의미한다.

예:

- `"anagram"` → `"nagaram"` 은 아나그램
- `"rat"` → `"car"` 는 아나그램이 아님

핵심은 두 문자열이 **각 문자별 등장 횟수(빈도수)** 가 같은지를 비교하는 것이다.

---

## 🔍 예시

### ✔ 예시 1
입력

    s = "anagram", t = "nagaram"

출력

    true

---

### ✔ 예시 2
입력

    s = "rat", t = "car"

출력

    false

---

## 📋 제약 조건 (Constraints)

- `1 ≤ s.length, t.length ≤ 5 * 10⁴`
- `s`와 `t`는 모두 소문자 알파벳(a~z)로 구성됨

---
## 💡 접근 방식

이 문제는 문자열 `s`와 `t`가 **아나그램(anagram)** 관계인지 확인하는 문제이다.  
즉, 두 문자열이 **동일한 문자들을 동일한 개수만큼** 포함하고 있는지를 판단하면 된다.

아래는 내가 처음 접근했던 방식과, 이를 안정적으로 개선한 최종 접근 방식이다.

---

## ✔ 접근 방식 1 — 내가 처음 떠올린 풀이
### “문자 → 빈도수(HashMap) 두 개에 저장 후 비교하기”

1. 문자열 `s`의 문자 빈도수를 `mapS`에 저장한다.
    - key: 문자(Character)
    - value: 등장 횟수(Integer)

2. 문자열 `t`의 문자 빈도수를 `mapT`에 저장한다.

3. `s`의 각 문자에 대해
    - `mapS.get(c)` 와 `mapT.get(c)` 의 값이 같은지 비교한다.
    - 다르면 false

이 방식은 **아이디어 자체는 정답과 동일**하고,  
두 문자열의 “각 문자 빈도수 비교”라는 문제의 핵심을 잘 잡고 있다.

하지만 몇 가지 문제점이 있었다:

### ⚠️ 문제점

- `s.length()`만큼 반복하면서 `tChar[i]` 를 접근하므로  
  문자열 길이가 다르면 IndexOutOfBoundsException 발생 위험이 있음.
- `Integer == Integer` 비교는 위험함 → `.equals()` 사용해야 정확함.
- `mapT.containsKey(c)` 체크가 필요할 수 있음.
- 길이가 다르면 애초에 아나그램이 될 수 없기 때문에 바로 false를 반환하는 것이 효율적임.

---

## ✔ 접근 방식 2 — 개선된 최종 풀이
### “HashMap 두 개를 유지하되, 안전하게 비교하기”

1. 두 문자열 길이를 먼저 비교
    - 길이가 다르면 아나그램이 될 수 없으므로 바로 false

2. 문자열 `s`와 `t`를 순회하면서
    - `mapS`와 `mapT` 각각에 등장 횟수 저장
    - `map.put(c, map.getOrDefault(c, 0) + 1)` 패턴 사용

3. 다시 s를 순회하며
    - `mapS.get(c)` 와 `mapT.get(c)` 가 동일한지 `.equals()` 로 비교
    - t에 없는 문자의 경우 `mapT.get(c) == null` → false

4. 모든 비교가 통과하면 true

이 방식은 “처음 떠올린 내 아이디어”를 유지하면서도  
예외 없이 안전하게 동작하도록 만든 구조이다.

---

## 📌 최종 코드

    class Solution {
        public boolean isAnagram(String s, String t) {

            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> mapS = new HashMap<>();
            Map<Character, Integer> mapT = new HashMap<>();

            char[] sChar = s.toCharArray();
            char[] tChar = t.toCharArray();

            // 1) 각 문자열의 문자 빈도수 카운트
            for (int i = 0; i < s.length(); i++) {
                mapS.put(sChar[i], mapS.getOrDefault(sChar[i], 0) + 1);
                mapT.put(tChar[i], mapT.getOrDefault(tChar[i], 0) + 1);
            }

            // 2) s의 문자 기준으로 빈도 비교
            for (int i = 0; i < s.length(); i++) {
                char c = sChar[i];

                Integer countS = mapS.get(c);
                Integer countT = mapT.get(c);

                if (countT == null || !countS.equals(countT)) {
                    return false;
                }
            }

            return true;
        }
    }

---

## 📝 요약

- 핵심 아이디어는 “두 문자열의 문자 빈도수 비교”.
- HashMap 두 개를 사용하는 구조는 적절하며,  
  길이 체크 + null 체크 + equals 비교만 추가하면 완전 정답 풀이가 된다.
- 이 문제를 통해 “문자 빈도수 카운팅” 패턴을 확실하게 익힐 수 있다.

---
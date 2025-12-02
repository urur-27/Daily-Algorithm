# 🧩 3. Longest Substring Without Repeating Characters

**난이도:** Medium  
**플랫폼:** LeetCode  
**유형:** Sliding Window, HashSet, Two Pointers, String  
**링크:** https://leetcode.com/problems/longest-substring-without-repeating-characters/
---

## 📝 문제 설명

문자열 `s`가 주어졌을 때,  
**중복되는 문자가 없는 가장 긴 부분 문자열(substring)** 의 길이를 반환하는 문제이다.

부분 문자열은 문자열에서 **연속된 문자들**로 구성되어야 한다.

예를 들어:

- `"abcabcbb"` → 가장 긴 부분 문자열은 `"abc"` (길이 3)
- `"bbbbb"` → `"b"` (길이 1)
- `"pwwkew"` → `"wke"` (길이 3)

중복 문자 없이 가장 긴 구간을 찾는 것이 핵심이며,  
브루트 포스 방식(O(n²))으로는 비효율적이므로  
슬라이딩 윈도우(two pointer) 방식으로 효율적인 O(n) 풀이가 필요하다.

---

## 🔍 예시

### ✔ 예시 1
입력

    s = "abcabcbb"

출력

    3

설명:  
중복 없는 가장 긴 부분 문자열은 `"abc"`.

---

### ✔ 예시 2
입력

    s = "bbbbb"

출력

    1

설명:  
중복 없는 부분 문자열은 `"b"`.

---

### ✔ 예시 3
입력

    s = "pwwkew"

출력

    3

설명:  
중복 없는 부분 문자열은 `"wke"`.  
부분 문자열이기 때문에 `"wkew"`는 포함하면 안 됨.

---

## 📋 제약 조건 (Constraints)

- `0 ≤ s.length ≤ 5 * 10⁴`
- `s는 공백, 숫자, 기호, 영문 등 ASCII 문자로 구성될 수 있음`

---

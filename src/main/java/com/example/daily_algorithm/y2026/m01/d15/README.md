# 🧩 Longest Common Prefix

**난이도:** Easy  
**플랫폼:** LeetCode  
**유형:** String  
**링크:** https://leetcode.com/problems/longest-common-prefix/

---

## 📝 문제 설명

문자열 배열 `strs`가 주어질 때,  
모든 문자열에 공통으로 포함된 **가장 긴 접두사(prefix)**를 반환하라.

공통 접두사가 없다면 빈 문자열 `""`을 반환한다.

---

## 🔍 예시

입력  
strs = ["flower","flow","flight"]

출력  
"fl"

---

입력  
strs = ["dog","racecar","car"]

출력  
""

설명  
공통 접두사가 존재하지 않는다.

---

## 📋 제약 조건 (Constraints)

- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`
- `strs[i]`는 소문자 영어 알파벳으로만 구성된다.

---

## 💡 접근 방식

- 첫 번째 문자열을 기준으로 잡는다.
- 다른 문자열들과 하나씩 비교하면서,
    - 접두사가 맞지 않는 순간까지 기준(prefix)을 줄여간다.
- prefix가 빈 문자열이 되면 바로 종료한다.

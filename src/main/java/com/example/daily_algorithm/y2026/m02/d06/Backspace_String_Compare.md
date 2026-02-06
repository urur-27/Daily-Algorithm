# 🧩 Backspace String Compare

**난이도:** Easy  
**플랫폼:** LeetCode  
**유형:** Stack, Two Pointers, String  
**링크:** https://leetcode.com/problems/backspace-string-compare/

---

## 📝 문제 설명

문자열 `s`, `t`가 주어진다.  
문자 `'#'`는 백스페이스를 의미하며, 직전에 입력된 문자가 있으면 삭제한다.

두 문자열을 각각 “입력 처리”한 최종 결과가 같은지 판단하여 `true/false`를 반환하라.

---

## 🔍 예시

입력  
s = "ab#c"  
t = "ad#c"

출력  
true

설명  
s: "ab#c" → "ac"  
t: "ad#c" → "ac"

---

입력  
s = "a#c"  
t = "b"

출력  
false

---

## 📋 제약 조건 (Constraints)

- `1 <= s.length, t.length <= 200`
- `s`와 `t`는 소문자 알파벳과 `'#'`로만 구성된다.

---

## 💡 접근 방식

- 왼쪽부터 문자를 읽는다.
- 일반 문자는 push
- `'#'`면 직전 문자가 있으면 pop
- 두 문자열을 각각 처리한 뒤 결과를 비교한다.


---

## 코드

    class Solution {
        public boolean backspaceCompare(String s, String t) {
            return build(s).equals(build(t));
        }

        private String build(String str) {
            Deque<Character> stack = new ArrayDeque<>();

            for (char c : str.toCharArray()) {
                if (c == '#') {
                    if (!stack.isEmpty()) stack.pop();
                } else {
                    stack.push(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) sb.append(stack.pop());
            return sb.reverse().toString();
        }
    }

---


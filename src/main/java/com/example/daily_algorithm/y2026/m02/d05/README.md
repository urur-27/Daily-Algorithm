# 🧩 Remove All Adjacent Duplicates In String

**난이도:** Easy  
**플랫폼:** LeetCode  
**유형:** Stack, String  
**링크:** https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

---

## 📝 문제 설명

문자열 `s`가 주어질 때,  
인접한 두 문자가 같으면 그 두 문자를 제거한다.

이 과정을 더 이상 제거할 수 없을 때까지 반복한 뒤,  
최종 문자열을 반환하라.

---

## 🔍 예시

입력  
s = "abbaca"

출력  
"ca"

설명
- "abbaca" → "aaca" (bb 제거)
- "aaca" → "ca" (aa 제거)  
  더 이상 인접 중복이 없으므로 "ca" 반환

---

## 📋 제약 조건 (Constraints)

- `1 <= s.length <= 10^5`
- `s`는 소문자 영어 알파벳으로만 구성된다.

---

## 💡 접근 방식

인접 중복 제거는 문자열을 왼쪽부터 보면서  
**바로 직전에 들어온 문자**와 비교하면 된다.

- 현재 문자가 스택 top과 같으면 → 인접 중복이므로 pop (둘 다 제거 효과)
- 다르면 → push

이렇게 한 번 순회하면, “반복 제거”까지 자연스럽게 처리된다.

왜냐하면 pop으로 인해 이전 문자들이 다시 인접하게 되고,  
그 상태도 계속 top 비교로 해결되기 때문이다.

---

## 코드

    class Solution {
        public String removeDuplicates(String s) {
            Deque<Character> stack = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            return sb.reverse().toString();
        }
    }


## 🔗 관련 문제

- Valid Parentheses
- Backspace String Compare
- Remove All Adjacent Duplicates in String II

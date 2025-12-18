# 🧩 Length of Last Word

**난이도:** Easy  
**플랫폼:** LeetCode  
**유형:** String  
**링크:** https://leetcode.com/problems/length-of-last-word/

---

## 📝 문제 설명

문자열 `s`가 주어질 때, 문자열에 포함된 **마지막 단어의 길이**를 반환하라.

단어란 공백(`' '`)이 아닌 문자로 이루어진 최대 부분 문자열을 의미한다.

---

## 🔍 예시

입력  
s = "Hello World"

출력  
5

설명  
마지막 단어는 `"World"`이며 길이는 5이다.

---

## 📋 제약 조건 (Constraints)

- `1 <= s.length <= 10^4`
- `s`는 영문자와 공백 `' '`으로만 구성된다.
- 문자열에는 최소 하나 이상의 단어가 존재한다.

---

## 💡 접근 방식

- 문자열의 뒤에서부터 탐색한다.
- 문자열 끝에 있는 공백을 먼저 건너뛴다.
- 공백이 아닌 문자를 만나면 길이를 카운트한다.
- 다시 공백을 만나면 마지막 단어가 끝났으므로 종료한다.

이 방식은 문자열을 한 번만 순회하며,  
추가적인 배열이나 `split`을 사용하지 않아 효율적이다.

---

## 코드

    class Solution {
        public int lengthOfLastWord(String s) {
            int length = 0;
            int i = s.length() - 1;

            // 문자열 끝의 공백 제거
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // 마지막 단어 길이 계산
            while (i >= 0 && s.charAt(i) != ' ') {
                length++;
                i--;
            }

            return length;
        }
    }

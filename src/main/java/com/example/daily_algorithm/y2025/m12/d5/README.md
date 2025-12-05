# 🧩 125. Valid Palindrome

**난이도:** Easy  
**플랫폼:** LeetCode  
**유형:** Two Pointers, String  
**링크:** https://leetcode.com/problems/valid-palindrome/
---

## 📝 문제 설명

문자열 `s`가 주어졌을 때,  
알파벳과 숫자만 고려하여(영문 대소문자 무시),  
해당 문자열이 **회문(palindrome)** 인지 판별하는 문제이다.

회문이란 앞에서 읽어도 뒤에서 읽어도 동일한 문자열을 의미한다.

문자열 내부에는 공백, 콤마, 마침표 등 다양한 문자가 포함될 수 있으며,  
이러한 문자는 **완전히 무시해야 한다.**

예:
- `"A man, a plan, a canal: Panama"` → 회문
- `"race a car"` → 회문 아님

---

## 🔍 예시

### ✔ 예시 1
입력

    s = "A man, a plan, a canal: Panama"

출력

    true

설명:  
정제 후 문자열은 `"amanaplanacanalpanama"` → 앞뒤가 동일함.

---

### ✔ 예시 2
입력

    s = "race a car"

출력

    false

설명:  
정제 후 `"raceacar"` → 앞뒤가 다르므로 회문이 아님.

---

### ✔ 예시 3
입력

    s = " "

출력

    true

설명:  
빈 문자열은 회문으로 간주한다.

---

## 📋 제약 조건 (Constraints)

- `1 ≤ s.length ≤ 2 * 10⁵`
- 문자열은 ASCII 문자로 구성될 수 있다.
- 비교할 때 반드시 **영문자 대소문자는 동일하게 취급해야 한다.**
- 오직 알파벳(a~z), 숫자(0~9)만 회문 판단에 포함된다.

---
## 💡 접근 방식

이 문제는 문자열 `s`가 **영문자/숫자만 고려했을 때 회문(palindrome)인지** 판별하는 문제이다.  
따라서 아래 두 가지가 핵심이 된다:

1. **문자/숫자 여부를 판별해서 불필요한 문자는 건너뛰기**
2. **대소문자를 구분하지 않고 비교하기**

이 두 가지를 위해 투 포인터(two-pointer)를 사용한다.  
문자열의 양 끝에서 포인터 `left`, `right` 를 두고, 서로 가운데로 좁혀오면서 비교한다.

---

### ✔ 1. 문자가 맞는지 판단하기
Java에서는 `Character` 클래스가 제공하는 메서드를 이용해 문자가 알파벳 또는 숫자인지 쉽게 확인할 수 있다.

- `Character.isLetterOrDigit(c)`  
  → 알파벳(a~z, A~Z) 또는 숫자(0~9)면 true  
  → 이 문제에서 회문 판단에 포함되는 문자 조건

---

### ✔ 2. 대소문자 구분 없이 비교하기
문자 비교는 모두 **소문자로 통일**하면 된다.

- `Character.toLowerCase(c)`

예:  
`'A'` 와 `'a'`는 둘 다 `Character.toLowerCase()` 적용 시 `'a'`이므로 같은 문자로 판정된다.

---

### ✔ 3. 투 포인터 이동 규칙

- `left`가 가리키는 문자가 **문자/숫자가 아니면** → left++
- `right`가 가리키는 문자가 **문자/숫자가 아니면** → right--
- 두 포인터가 모두 문자/숫자를 가리킬 때:
    - 둘의 문자를 소문자로 변환하여 비교
    - 다르면 false
    - 같으면 → left++, right-- 이동

이 과정을 `left < right` 동안 반복했는데도 모두 통과하면 문자열은 회문이다.

---

## 코드

    class Solution {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {

                // 왼쪽 포인터: 문자/숫자 아닐 경우 건너뛰기
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }

                // 오른쪽 포인터: 문자/숫자 아닐 경우 건너뛰기
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }

                // 대소문자 구분 없이 비교
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }
    }

---

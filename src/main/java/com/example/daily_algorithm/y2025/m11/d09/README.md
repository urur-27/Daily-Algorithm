# 🧩 541. Reverse String II

**난이도:** Easy  
**플랫폼:** LeetCode  
**유형:** 문자열 (String), 구현 (Simulation)  
**링크:** [LeetCode 문제 링크](https://leetcode.com/problems/reverse-string-ii/)

---

## 📝 문제 설명

문자열 `s`와 정수 `k`가 주어진다.  
문자열의 시작부터 매 `2k` 문자마다 **앞의 k개 문자**를 뒤집어야 한다.

- 남은 문자가 `k`보다 적으면 → **모두 뒤집는다.**
- 남은 문자가 `2k`보다 적지만 `k` 이상이면 → **앞의 k개만 뒤집고 나머지는 그대로 둔다.**

---

## 🔍 예시

**예시 1**  
입력: `s = "abcdefg"`, `k = 2`  
출력: `"bacdfeg"`

**예시 2**  
입력: `s = "abcd"`, `k = 2`  
출력: `"bacd"`

---

## 📋 제약 조건 (Constraints)

- `1 <= s.length <= 10⁴`
- `s`는 오직 소문자 영어 알파벳으로 구성된다.
- `1 <= k <= 10⁴`




---

## 💡 접근 방식

이 문제는 문자열의 일부 구간만 뒤집어야 하므로,  
**문자열을 수정 가능한 배열(char[])로 변환한 뒤, 투 포인터로 처리**하는 것이 가장 직관적이다.

1️⃣ **2k 단위 블록 순회**
- `for (int i = 0; i < n; i += 2 * k)`
- i는 0 → 2k → 4k ... 식으로 증가하면서, 매 2k 블록의 시작 인덱스를 가리킨다.

2️⃣ **앞의 k개만 뒤집기**
- 각 블록마다 `left = i`, `right = Math.min(i + k - 1, n - 1)`로 두고  
  `while (left < right)`을 이용해 스왑한다.
- 남은 문자가 k보다 적으면 `Math.min` 덕분에 안전하게 남은 구간만 뒤집힌다.

3️⃣ **문자열 → 배열 → 문자열 변환**
- 문자열은 불변(immutable)이므로 `toCharArray()`로 `char[]` 배열로 변환해야 한다.
- 수정이 끝나면 `new String(arr)`로 다시 문자열을 반환한다.

---

## 코드

```java
public class Reverse_String_2 {
    public String reverseString(String s, int k) {

        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, len -1);

            while (left < right) {
                char tmp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = tmp;
            }
        }

        return new String(arr);
    }
}


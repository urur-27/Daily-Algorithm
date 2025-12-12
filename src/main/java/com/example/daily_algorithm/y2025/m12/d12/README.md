# 🧩 Unique Email Addresses

**난이도:** Easy  
**유형:** String, Hash Table (HashSet)  
**링크:** https://leetcode.com/problems/unique-email-addresses/

---

## 📝 문제 설명

이메일 주소 리스트 `emails`가 주어진다. 각 이메일은 `local@domain` 형태이며, **local** 부분에 아래 규칙이 적용된다.

- `local`에서 **'.' (점)** 은 무시된다.
    - 예: `"a.b"` → `"ab"`
- `local`에서 **'+' (플러스)** 가 나오면, **그 뒤는 전부 무시**한다.
    - 예: `"alice+spam"` → `"alice"`

단, **domain** 부분은 그대로 유지된다.

규칙을 적용해 실제로 동일한 이메일로 도착하는 주소들을 합쳤을 때,  
**서로 다른(unique) 이메일 주소의 개수**를 반환하라.

---

## 🔍 예시

**예시 1**
- 입력:
    - `emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@leetcode.com"]`
- 출력: `1`
- 이유:
    - `"test.email+alex@leetcode.com"` → `"testemail@leetcode.com"`
    - `"test.e.mail+bob.cathy@leetcode.com"` → `"testemail@leetcode.com"`
    - `"testemail+david@leetcode.com"` → `"testemail@leetcode.com"`
    - 모두 같은 주소로 정규화됨

**예시 2**
- 입력:
    - `emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]`
- 출력: `3`

---

## 📋 제약 조건 (Constraints)

- `1 <= emails.length <= 100`
- `1 <= emails[i].length <= 100`
- `emails[i]`는 유효한 이메일 형식이며, `@`는 정확히 한 번 포함된다.
- 모든 문자는 소문자 영문자, '+', '.', '@' 로 구성된다.

---

## 💡 접근 방식

**정규화(normalization) 후 HashSet으로 중복 제거**

1. 각 이메일을 `@` 기준으로 `local`, `domain`으로 분리한다.
2. `local`에 대해:
    - `+`가 있다면 `+` 이전까지만 사용
    - `.`은 제거
3. `normalized = cleanedLocal + "@" + domain` 을 만든다.
4. HashSet에 넣어 **중복을 자동 제거**한다.
5. 최종 Set의 크기가 unique 이메일 개수이다.

### 왜 HashSet인가?

- 이미 본 이메일인지 확인 + 중복 제거를 한 번에 처리 가능
- `add()` / `contains()` 평균 O(1)

---

## 코드
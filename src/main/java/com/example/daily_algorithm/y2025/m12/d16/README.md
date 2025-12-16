# 🧩 Word Pattern

**난이도:** Easy  
**유형:** Hash Table, String  
**링크:** https://leetcode.com/problems/word-pattern/

---

## 📝 문제 설명

문자열 `pattern`과 문자열 `s`가 주어진다.

`pattern`의 각 문자와  
`s`에 포함된 각 단어 사이에 **일대일 대응(one-to-one mapping)** 이 성립하면 `true`,  
그렇지 않으면 `false`를 반환하라.

### 일대일 대응 조건
- 하나의 문자는 하나의 단어에만 대응되어야 한다.
- 하나의 단어도 하나의 문자에만 대응되어야 한다.
- 순서 또한 일치해야 한다.

---

## 🔍 예시

**예시 1**
- 입력:
    - `pattern = "abba"`
    - `s = "dog cat cat dog"`
- 출력: `true`

**예시 2**
- 입력:
    - `pattern = "abba"`
    - `s = "dog cat cat fish"`
- 출력: `false`

**예시 3**
- 입력:
    - `pattern = "aaaa"`
    - `s = "dog cat cat dog"`
- 출력: `false`

**예시 4**
- 입력:
    - `pattern = "abba"`
    - `s = "dog dog dog dog"`
- 출력: `false`

---

## 📋 제약 조건 (Constraints)

- `1 <= pattern.length <= 300`
- `pattern`은 소문자 영문자로만 이루어져 있다.
- `s`는 공백으로 구분된 소문자 단어들로 이루어져 있다.
- `s`의 단어 개수는 `pattern`의 길이와 같아야 한다.

---

## 💡 접근 방식

### 처음 생각했던 흐름
- `HashMap<Character, String>`으로 **문자 → 단어** 매핑을 만든다.
- 매 위치 i에 대해:
    1) 알파벳 하나(pChar[i])와 단어 하나를 비교 대상으로 선택
    2) map에 해당 알파벳(key)이 있는지 확인
    3) 있다면 value가 현재 단어와 같은지 확인, 다르면 false
    4) 없다면 새로 등록
- 끝까지 문제 없으면 true


### 문제점

- “문자 → 단어” 일관성은 검증 가능
- 하지만 문제 요구사항은 **일대일 대응(양방향)** 이기 때문에
  추가 검증이 필요하다.


### 반례
- `pattern = "ab"`
- `s = "dog dog"`

단방향 검증만 하면:
- a → dog 저장
- b → dog 저장 (b는 새 key니까 그냥 등록됨)
- 끝까지 일관성 위반이 없어 보이므로 true가 나올 수 있다


---
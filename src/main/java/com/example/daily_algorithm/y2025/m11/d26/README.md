# 🧩 206. Reverse Linked List

**난이도:** Easy  
**플랫폼:** LeetCode  
**유형:** Linked List, Iterative, Two Pointers  
**링크:** https://leetcode.com/problems/reverse-linked-list/
---

## 📝 문제 설명

단일 연결 리스트의 head가 주어졌을 때,  
이 리스트를 **역순으로 뒤집은 새로운 리스트의 head**를 반환하는 문제이다.

예를 들어,

    1 → 2 → 3 → 4 → 5 → null

이 주어지면,

    5 → 4 → 3 → 2 → 1 → null

과 같이 방향이 완전히 반대로 된 리스트를 만들어야 한다.

리스트 노드의 값은 변경하지 않고,  
**next 포인터의 방향만 바꿔서** 리스트를 뒤집어야 한다.

---

## 🔍 예시

예시 1

입력:

    head = [1,2,3,4,5]

출력:

    [5,4,3,2,1]

---

예시 2

입력:

    head = [1,2]

출력:

    [2,1]

---

예시 3

입력:

    head = []

출력:

    []

---

## 📋 제약 조건 (Constraints)

- 노드 개수: 0 ≤ n ≤ 5000
- 노드 값 범위: -5000 ≤ Node.val ≤ 5000
- 리스트는 단일 연결 리스트(singly linked list)이다.

---

## 💡 접근 방식

1. 세 개의 포인터를 사용한다:
    - prev: 이전 노드를 가리킴 (처음에는 null)
    - curr: 현재 노드를 가리킴 (처음에는 head)
    - next: curr.next를 미리 저장해두는 용도

2. 리스트를 순회하면서 다음 과정을 반복한다:
    - next에 curr.next를 저장해 둔다 (끊기 전에 백업)
    - curr.next를 prev로 향하게 바꾼다 → 포인터 방향을 뒤집는 핵심 단계
    - prev를 curr로 이동한다 (prev = curr)
    - curr를 next로 이동한다 (curr = next)

3. curr가 null이 되면,  
   더 이상 뒤집을 노드가 없다는 뜻이고,  
   이때 prev가 새로 뒤집힌 리스트의 head가 된다.

4. prev를 반환한다.

시간 복잡도: O(n) (리스트를 한 번 순회)  
공간 복잡도: O(1) (추가 메모리 거의 사용하지 않음)

---

# 🧩 83. Remove Duplicates from Sorted List

**난이도:** Easy  
**플랫폼:** LeetCode  
**유형:** Linked List, Two Pointers  
**링크:** https://leetcode.com/problems/remove-duplicates-from-sorted-list/
---

## 📝 문제 설명
정렬된(오름차순) 단일 연결 리스트가 주어졌을 때,  
리스트 내에서 **중복된 값을 가진 노드를 제거**하여  
각 값이 하나만 남도록 리스트를 정리한 뒤 head를 반환하는 문제이다.

리스트가 정렬되어 있기 때문에  
중복된 값들은 **항상 연속해서 나타나는 특징**을 가진다.  
따라서 현재 노드와 다음 노드의 값을 비교하여  
같다면 next를 한 칸 건너뛰며 중복을 제거할 수 있다.

---

## 🔍 예시

### ✔ 예시 1
**입력**
head = [1,1,2]

**출력**
[1,2]

---

### ✔ 예시 2
**입력**
head = [1,1,2,3,3]

**출력**
[1,2,3]

---

## 📋 제약 조건 (Constraints)
- 노드 수: `0 ≤ n ≤ 300`
- 노드 값 범위: `-100 ≤ Node.val ≤ 100`
- **리스트는 항상 오름차순 정렬되어 있음**

---

## 💡 접근 방식

1. 현재 노드(`current`)를 head로 설정  
   리스트가 정렬되어 있으므로,  
   **중복된 값들은 항상 current 다음 노드에 연속으로 나타난다.**

2. current와 current.next의 값을 비교
    - 두 값이 같다면 → 중복이므로  
      `current.next = current.next.next` 를 통해 다음 노드를 건너뛰어 삭제한다.
    - 두 값이 다르다면 → current를 다음 노드로 이동한다.

3. current 또는 current.next가 null이 될 때까지 반복  
   모든 중복이 제거될 때까지 값 비교와 노드 삭제를 반복한다.

4. head 반환  
   별도의 dummy 노드가 필요하지 않기 때문에  
   중간에 head가 바뀌지 않으며, 최종적으로 head를 그대로 반환하면 된다.

---

## 코드

```java


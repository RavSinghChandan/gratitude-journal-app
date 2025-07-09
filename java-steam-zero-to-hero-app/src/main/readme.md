# 🌀 Master Java 8 Stream API in One Day – Interview-Focused Guide

📅 **Target Date:** Wednesday, 09 July 2025  
🕘 **Time Allocation:** 10–12 hours (Morning to Evening)

---

## 🎯 Goal
To **master Java 8 Stream API** from scratch to an expert level, ensuring:
- You can solve any practical DSL (Domain-Specific Language) or DSA problem using Streams
- You're confident during interviews
- Your muscle memory is built with hands-on practice

---

## 🧠 Learning Strategy

### Phase 1: **Foundation (2 hours)**
> Understand syntax, structure, pipeline concepts, and common operations.

#### ✅ Topics
- What is Stream API and why it's powerful
- Stream vs Collection
- Stream creation:
    - From List/Set/Map/Array
    - Using `Stream.of()`, `IntStream`, `Stream.iterate()`
- Intermediate Operations:
    - `filter()`
    - `map()`
    - `flatMap()`
    - `distinct()`
    - `sorted()`
    - `limit()` & `skip()`
- Terminal Operations:
    - `forEach()`
    - `collect()` (`Collectors.toList`, `toSet`, `joining`)
    - `count()`, `min()`, `max()`, `anyMatch()`, `allMatch()`, `noneMatch()`
- Optional & Stream chaining

📌 **Hands-On:** 10 simple transformation problems.

---

### Phase 2: **Interview DSL Patterns (6 hours)**
> Solve real-world problems using Stream API.

#### 🚀 Problem Sets
Each of the below questions must be solved using Stream only.

##### 🔹 Array/List/Collection Based
1. Remove duplicates from a list
2. Find second highest number in a list
3. Count occurrence of each element
4. Find frequency of characters in a String
5. Get only even/odd numbers from an integer list
6. Reverse each word in a sentence
7. Convert List<Integer> to comma-separated string
8. Sort list in reverse order
9. Find the first non-repeating character
10. Merge two lists and remove duplicates

##### 🔹 Map & Grouping
11. Group Employees by Department
12. Count employees in each department
13. Find highest salary employee in each department
14. Convert List<Employee> to Map<Id, Employee>
15. Sort a map by value (ascending/descending)

##### 🔹 Advanced Aggregation & Reduction
16. Sum of salaries
17. Average salary by department
18. Find employee with nth highest salary
19. Partition list into pass/fail
20. Custom Collector (e.g., merge strings, custom reduction logic)

##### 🔹 FlatMap Challenges
21. Flatten a List<List<String>> into a single List
22. Get all distinct characters from a List of words
23. Count total words from a List of sentences

##### 🔹 String-Based
24. Count vowels/consonants
25. Reverse a String using Stream
26. Check if a string is palindrome using Streams

---

### Phase 3: **Edge Case + Tricky Interview Qs (2 hours)**

#### 🎯 Topics
- Lazy evaluation & short-circuiting
- Parallel Streams – where to use, and dangers
- Stateful vs stateless operations
- Why order matters – with example
- Optional use inside Stream
- Collector vs reducing
- Stream with Exception handling (try-catch inside lambda)
- `peek()` use cases and debugging stream pipelines

---

## ⌨️ Practice Tip
Create your own `StreamUtils.java` and add all utility methods you practice. Reuse and refine them.

---

## 🔄 Bonus
- Implement a small CLI app that:
    - Takes input of 10 employees
    - Groups by department
    - Filters salary > 50K
    - Sorts by name
    - Returns a map of names vs designations

---

## ✅ Final Checklist
- [ ] Covered all intermediate + terminal operations
- [ ] Solved 20+ DSL questions
- [ ] Wrote 5 utility methods
- [ ] Read about pitfalls and anti-patterns
- [ ] Created one mini project

---

## 🧾 Output
📁 Folder Structure:

```
stream-api-one-day/
├── README.md
├── src/
│   ├── basics/
│   ├── intermediate/
│   ├── grouping/
│   ├── advanced/
│   └── cli_project/
```

---

🧘‍♂️ **Reminder:** Don't just read – code, test, fail, retry, and win.

🚀 Let's master Java Streams and smash that interview!


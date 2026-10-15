# Week 10 Practice — Quiz & Concept Answers

## Part B — Quiz (single best answer)

1. **D** — `s1 == s2` is false (two separate `new String(...)` objects); `s1.equals(s2)` is true (same characters).
2. **B** — `"Java" + " Lab"` = `"Java Lab"`, reversed character-by-character = `"baL avaJ"`.
3. **B** — `new Student("Ravi")` calls `Student(String name)` directly (which then internally chains to the two-arg constructor).
4. **D** — `w2 = w1` makes both references point to the same object, so `w2.add(200)` is visible through both: `w1 balance: 700, w2 balance: 700`.
5. **C** — Each constructor call increments the shared static `count`; 3 objects → 3.
6. **A** — A plain forward loop prints every element in order: `45 78 92 60 85`.
7. **B** — `continue` skips printing when `i == 3`, so output is `1 2 4 5`.
8. **A** — Java is pass-by-value for primitives; reassigning the parameter inside `change()` doesn't affect the caller's `x`, which stays `5`.
9. **C** — `int / double` promotes to double division: `250 / 3.0` = `83.33333333333333` (Java's default `double` string form).
10. **B** — `Card.pay()` overrides and adds a 2% fee: `500 + 10 = 510.0` → "Paid 510.0 by card".
11. **B** — Strings are immutable; `name` still holds `"java"`, and `toUpperCase()` returns a brand-new `"JAVA"` object assigned to `upperName`.
12. **B** — `s1` and `s2` share one pooled literal; `s3 = new String("hello")` forces a second, separate heap object — 2 objects total.
13. **A** — `"Campus".length()` is 6; `charAt(2)` is `'m'` (C-a-**m**-p-u-s) → `6 / m`.
14. **A** — `"user@domain.com".indexOf("@")` — `u`(0) `s`(1) `e`(2) `r`(3) `@`(4) → index 4.
15. **B** — The no-arg constructor sets `title = "Unknown"`, `price = 0.0` → "Title: Unknown, Price: 0.0".
16. **A** — The parameterized constructor sets the given values directly → "Title: Java Programming, Price: 450.0".
17. **B** — `w1` and `w2` share one object; `w3` is a second, separate object — 2 `Wallet` objects total.
18. **C** — Same shared-reference reasoning as Q4: both `w1.balance` and `w2.balance` read `700`.
19. **C** — `s1` and `s2` are separate objects; changing `s1`'s name doesn't touch `s2` → `s1 name: Anu / s2 name: Ravi`.
20. **C** — Three `Visitor` objects, each incrementing the shared static counter once → `Total visitors: 3`.

## Part C — Concept Questions

1. **String immutability:** Every "modification" (concatenation, `replace`, `toUpperCase`, etc.) actually creates a brand-new `String` object rather than changing the original, because `String` internals are `final`. Repeated modification in a loop (e.g. building a long string with `+=`) creates many discarded intermediate objects, which wastes memory and CPU on garbage collection. `StringBuilder`/`StringBuffer` mitigate this by mutating one internal buffer in place instead of allocating a new object per change.

2. **The `this` keyword:** When a constructor parameter shares a name with an instance field (shadowing it), `this.fieldName` explicitly refers to the object's field, while the bare `fieldName` refers to the parameter. Example: `public Student(String name) { this.name = name; }` — without `this.`, `name = name` would just assign the parameter to itself and leave the field untouched.

3. **Object vs reference variable:** The object is the actual data living on the heap; the reference variable is a pointer/handle stored on the stack (or in another object) that points to that heap location. Assigning one reference variable to another (`Wallet w2 = w1;`) copies the pointer, not the object — both variables now point to the same single object, so a change made through either one is visible through both.

4. **Static vs instance variables:** A static variable belongs to the class and is shared by every instance — appropriate for data like a running count of all objects created (`Visitor.count`). An instance variable belongs to each object individually — appropriate for data that differs per object, like a single visitor's own `name`.

5. **for vs while vs do-while:** `for` suits a known, fixed number of iterations (e.g. looping over an array by index). `while` suits a condition checked before each iteration where the number of repeats isn't known in advance (e.g. reading input until a sentinel value appears). `do-while` suits logic that must run at least once regardless of the condition (e.g. showing a menu and re-prompting until valid input is given).

6. **Pass-by-value in Java:** Java always passes a copy of the value held by a variable. For a primitive, that copy is the actual number — changes inside the method never reach the caller's variable. For an object reference, the copy is the *reference* (the pointer), not the object itself — so the method can still mutate the object's fields through that copied reference (both copies point to the same object), but reassigning the parameter to a new object inside the method has no effect on the caller's original reference.

7. **Integer division:** When both operands of `/` are integers, Java performs integer division and truncates (discards) any fractional part — `7 / 2` is `3`, not `3.5`. To get a precise fractional result, at least one operand must be a `double` (or explicitly cast), e.g. `7 / 2.0` or `(double) 7 / 2`, which forces floating-point division.

8. **Encapsulation:** Marking fields `private` prevents direct, uncontrolled access from outside the class. Public getter and setter methods become the only sanctioned way in or out, letting the class validate values on the way in (e.g. rejecting a negative balance) and control exactly what's exposed on the way out — keeping the object's internal state always valid.

9. **`==` vs `.equals()`:** `==` compares object *references* (are these two variables pointing at the exact same object in memory?), while `.equals()` compares *logical content* by whatever rule the class defines. For `String`/custom classes, `==` can be `false` even when the two objects hold identical data, if they're separate instances. Overriding `equals()` (e.g. comparing two `Point` objects by their x/y values) changes that comparison from "same object?" to "same meaningful content?".

10. **Overloading vs overriding:** Overloading is having multiple methods in the *same* class with the same name but different parameter lists — the compiler picks which one to call at compile time based on the arguments (compile-time/static polymorphism). Example: `add(int, int)` and `add(double, double)`. Overriding is a *subclass* replacing a method it inherited from its superclass, with the identical signature — the JVM picks the implementation to run at runtime based on the object's actual type (runtime/dynamic polymorphism). Example: `Dog.makeSound()` overriding `Animal.makeSound()`.

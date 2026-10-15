# Week 9 Practice — Quiz & Concept Answers

## Part B — Quiz (single best answer)

1. **C** — Abstraction means hiding how an object does something and exposing only what it does.
2. **C** — An abstract class cannot be instantiated directly.
3. **B** — If a concrete class doesn't implement every inherited abstract method, it must itself be declared abstract, or the code won't compile.
4. **C** — `private` is not allowed on an abstract method (it must be overridable by subclasses, which a private method cannot be).
5. **C** — Interface fields are implicitly `public, static, and final`.
6. **C** — A class can implement any number of interfaces.
7. **D** — Methods implemented from an interface must be declared `public`.
8. **C** — Interfaces carry no instance state, so multiple inheritance of interfaces doesn't create the ambiguous shared-state "diamond problem" that multiple class inheritance would.
9. **D** — If two implemented interfaces both provide a default method with the same signature and the class doesn't override it, that's a compile-time error.
10. **B** — Abstract classes can have constructors; they run when a subclass object is constructed (via the implicit or explicit `super()` call).

## Part C — Concept Questions

1. **Abstraction, real-life example:** A car's accelerator pedal is an abstraction — pressing it shows the driver "go faster" without exposing fuel injection timing, throttle body mechanics, or ECU calculations. The driver only needs the exposed interface (the pedal), not the hidden implementation.

2. **Abstraction vs encapsulation:** Abstraction hides *complexity* — it decides what operations a class exposes versus what it keeps internal. Encapsulation hides *data* — it protects a class's internal state behind private fields and controlled access methods. Together in one class: the public methods are the abstraction (what you can do), and the private fields they manage are the encapsulation (how that data stays protected).

3. **Constructor in an abstract class:** An abstract class can have a constructor to initialize the fields it declares (like a shared `name` or `id`) even though it can never be instantiated on its own. That constructor runs whenever a concrete subclass is instantiated, via the implicit `super()` call at the start of the subclass's own constructor.

4. **Why abstract methods can't be private/static/final:** `private` would make the method invisible to subclasses, so it could never be overridden. `static` methods are resolved at compile time by class, not dynamically dispatched by object — they can't be "abstract" because there's no instance-level override mechanism. `final` explicitly forbids overriding, which directly contradicts the entire purpose of declaring a method abstract (to force subclasses to provide one).

5. **The diamond problem:** It arises when a class inherits conflicting implementations of the same method from two different parent classes, and the compiler can't tell which one should win. Java sidesteps this by allowing a class to extend only one class (so there's only ever one source of inherited instance state and default behavior) while allowing multiple interfaces, which historically carried no implementation at all — and now that interfaces can have default methods, Java instead forces a compile-time error (see Q9) rather than silently picking one, so the ambiguity is never resolved in the dark.

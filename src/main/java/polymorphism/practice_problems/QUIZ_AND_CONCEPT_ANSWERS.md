# Week 8 Practice — Quiz & Concept Answers

## Part B — Quiz (single/multi-select)

1. **C** — Polymorphism (overriding `render()` lets each subtype supply its own behavior, removing the if-else chain).
2. **A, B** — `Car is-a Vehicle` and `Rectangle is-a Shape` are genuine is-a relationships. `DatabaseConnection` *uses* a `NetworkResource` (has-a), and `HelperUtility contains a Calculator` is composition, not inheritance.
3. **C** — Runtime method dispatch (dynamic binding) picks the overridden method that matches the object's actual type.
4. **C** — Inheritance-based polymorphism.
5. **A, C, D** — Book extends inherited behavior; LibraryItem defines the shared behavior; a DVD can be referenced as a LibraryItem. (B is wrong — DVD *overrides*, it doesn't share, the loan period.)
6. **A, C** — A Dog referenced as Animal still runs Dog's makeSound (dynamic dispatch); Dog's makeSound is overridden behavior. (B is wrong — Animal's method isn't "specialized"; D is wrong — overriding doesn't require prior declaration beyond the base method signature.)
7. **C** — new types can be added without touching the processing loop (Open/Closed Principle).
8. **A** — it creates tight coupling and a false is-a relationship.
9. **A, C** — a generic sender can dispatch without knowing concrete types, and new channels slot in without changing existing logic. (B is wrong — logic isn't centralized, each subtype keeps its own; D is wrong — implementations differ per channel.)
10. **A, B, C** — easier iteration, uniform processing, less casting. (D is false — adding new types is easier, not harder.)

## Part C — Concept Questions

1. **Inheritance reuse + extension:** A subclass inherits a base class's fields and methods, then adds new ones or overrides existing ones to specialize behavior. Example: a `SalariedEmployee` base class calculates `pay()` from a fixed salary; a `CommissionedEmployee` subclass reuses the employee's name/ID fields but overrides `pay()` to add a commission on top.

2. **Is-a relationship:** It means the subclass is a more specific kind of the base class and can be used anywhere the base class is expected (substitutability). Getting this wrong — using inheritance just to reuse code between unrelated classes — produces a class hierarchy that doesn't reflect reality and breaks if the base class changes.

3. **Method overriding:** A subclass provides its own implementation of a method already defined in its base class, with the same signature. Example: a base `Employee.calculateSalary()` returns a fixed amount; `SalesEmployee` overrides it to add commission, `Manager` overrides it to add a bonus.

4. **Runtime polymorphism:** When a base-type reference points to a derived-type object, Java looks up the method implementation to run based on the object's *actual* runtime type, not the reference's declared type — this lookup happens via the object's vtable at the moment the call executes, not at compile time.

5. **Polymorphic collections:** A `List<Shape>` can hold `Circle`, `Rectangle`, and `Triangle` objects simultaneously. Iterating and calling `shape.area()` on each runs the correct override for that object automatically, so the processing code never needs to know or check the concrete type.

6. **Polymorphism vs conditional logic:** With polymorphism, each type's behavior lives inside that type, and adding a new type means adding a new class — the dispatch code stays untouched. With if-else/switch chains, every new type requires editing the shared conditional block, which is more error-prone and violates the Open/Closed Principle.

7. **Adding types without changing processing logic:** Because the processing code only talks to the base type's interface, a brand-new subtype automatically works with existing loops/collections the moment it implements that interface. Example: adding `WalletPayment extends Payment` lets it flow through an existing `for (Payment p : payments)` loop with zero changes to that loop.

8. **Inherited vs overridden behavior:** A subclass inherits a method when it needs no change from the base class's implementation. It overrides when the base implementation is wrong or incomplete for that subtype. Example: `Employee.getId()` is inherited as-is by every subtype; `Employee.calculateSalary()` is overridden by each subtype with its own pay rule.

9. **Inheritance misuse:** Using inheritance purely for code reuse between classes with no real is-a relationship couples them tightly — a change to the "base" class can break unrelated subclasses, and the hierarchy misleads anyone reading the code about how the types actually relate. Composition (has-a) is usually the safer tool for pure code reuse.

10. **CarRental / TruckRental example:** Common behavior — both have a renter name, a rental period, and a `calculateTotalCost()` operation — belongs in a shared `VehicleRental` base class. Specialized behavior — a `TruckRental` adding a mileage surcharge, a `CarRental` adding an optional insurance fee — belongs in each subclass's override of `calculateTotalCost()`.

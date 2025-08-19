
<img width="1271" height="609" alt="state-machine(1)" src="https://github.com/user-attachments/assets/62612fd4-0fe7-4408-bd7d-067a1f0fe3e2" />

# State Machine Implementation in Java (State Pattern)

This project demonstrates a custom implementation of a state machine purely in Java using the **State design pattern**. Each state of the payment lifecycle is represented by a dedicated class, encapsulating the behavior and possible transitions for that state.

## Key Concepts

- **States as Classes**: Each payment state (e.g., Created, Processed, Failed, Completed, Cancelled) is implemented as a separate class, defining specific behaviors and allowed transitions.
- **State Transitions**: Transitions between states occur via methods that delegate control to the next appropriate state instance.
- **Encapsulation of Behavior**: By encapsulating logic within each state class, the design promotes clear separation of concerns and easier maintenance.
- **Exception Handling**: Invalid transitions are prevented by throwing custom exceptions such as `NotAllowedTransactionException`.
- **Unit Testing**: Tests verify the correct state transitions and proper exception handling for disallowed operations.

## Benefits

- Clear modeling of complex state-dependent behavior.
- Flexibility to add or modify states and transitions without impacting unrelated parts of the system.
- Avoids large conditional blocks by delegating logic to the state classes.

## Technologies Used

- Java 17+

## How to Use

1. Instantiate the initial state (e.g., `CreatedState`) with the context object (`Transaction` or `Payment`).
2. Invoke state transition methods on the current state instance.
3. Handle exceptions for disallowed transitions.
4. Observe the state changes via the context or state instance.

## Project Structure Overview

- `states/`: Contains classes for each payment state.
- `exceptions/`: Custom exceptions to enforce valid state transitions.
- `entities/`: Core domain classes like `Transaction`.
- `tests/`: Unit tests covering state transitions and validations.

---


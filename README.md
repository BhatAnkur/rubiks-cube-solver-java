# Rubik’s Cube Solver (Java)

A Java-based **2×2 Rubik’s Cube solver** that computes the **shortest sequence of moves** required to solve a scrambled cube using **Breadth-First Search (BFS)**.

This project demonstrates object-oriented design, graph traversal, and state-space search in Java.

---

## 📌 Features

- Models a **2×2 Rubik’s Cube** using an array-based state representation
- Uses **Breadth-First Search (BFS)** to guarantee the shortest solution
- Prevents revisiting states using hash-based visited tracking
- Clean separation of concerns:
  - Cube representation
  - Move definitions
  - Solving logic
- Random scramble generation for testing

---

## 🧠 How It Works

- Each cube configuration is treated as a **node in a graph**
- Each valid cube move represents an **edge**
- BFS explores the state space level-by-level
- The first time the solved state is reached, the solution is guaranteed to be optimal

---

## 🗂️ Project Structure


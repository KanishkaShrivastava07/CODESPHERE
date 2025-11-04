# CodeSphere

CodeSphere is a simple **Java-based interactive compiler and runner** built for the terminal. It allows users to write, compile, and execute Java code line by line — all within the same environment.

---

## Features

* Interactive line-by-line Java code input.
* Automatic saving of user code into `Main.java`.
* Real-time **compilation** using `javac`.
* **Runtime execution** and output display.
* Error handling for both compile-time and runtime errors.
* Retry or Exit options after each run.

---

## How It Works

1. The program welcomes the user to CodeSphere.
2. The user enters Java code line by line.
3. Typing `END` stops the input process.
4. Code is saved as `Main.java`.
5. The program compiles the file using `javac`.
6. If compilation is successful, it executes `java Main`.
7. If compilation fails, the user is notified of the errors.
8. The user can choose to `TRY` again or `EXIT`.

---

## Flow Diagram (draw.io)

<img width="844" height="722" alt="CODESPHERE" src="https://github.com/user-attachments/assets/3e9a5e30-d134-4db3-986a-5f9f0040e194" />

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/<your-username>/CodeSphere.git
   cd CodeSphere
   ```

2. Compile the program:

   ```bash
   javac CodeSphere.java
   ```

3. Run the program:

   ```bash
   java CodeSphere
   ```

# Debugging

---

## 1. Linux
<<<
GDB (GNU Debugger) is a powerful debugging tool for analyzing and troubleshooting C programs in Linux. Here's a comprehensive guide to using GDB:
GDB Basics
GDB allows developers to inspect program behavior, step through code, set breakpoints, and examine variable values in real-time. It supports debugging programs written in C, C++, Ada, and Fortran1
.
Installation
You can install GDB on Debian/Ubuntu systems using:

bash
```
sudo apt-get update
sudo apt-get install gdb
```
Debugging Workflow
1. Compile with Debugging Symbols
Compile your C program with the -g flag to include debugging information:

bash
```
gcc -g -o myprogram myprogram.c 
```

2. Launch GDB
Start the debugger with your executable:

bash
```
gdb ./myprogram
```
Key GDB Commands
```
    break: Set breakpoints
        break line_number: Stop at a specific line
        break function_name: Stop at the start of a function
    run: Execute the program
        run: Start program execution
        run arg1 arg2: Pass command-line arguments
    print: Examine variable values
        print variable_name: Display current value
        set variable_name = value: Modify variable value
    step/next: Navigate through code
        step: Step into function calls
        next: Step over function calls
```
Example Debugging Session
```
# Compile with debugging symbols
gcc -g -o fibonacci fibonacci.c

# Launch GDB
gdb ./fibonacci

# Set a breakpoint
(gdb) break main

# Run the program
(gdb) run

# Inspect variables
(gdb) print variable_name

# Continue execution
(gdb) continue
```
Best Practices
```
    Always compile with -g flag for full debugging information
    Use breakpoints strategically
    Examine variables at different execution points
    Understand program flow by stepping through code
```
GDB is an essential tool for developers, enabling deep insights into program behavior and helping to identify and resolve complex bugs efficiently1
5
.



## 2.Multiple files
---
When debugging a multi-file C project with undefined references, you need to ensure proper compilation and linking. Here are the key steps:
Compilation Strategy
1. Compile with Debugging Symbols
Compile each source file with the -g flag and create object files:

```
gcc -g -c file1.c
gcc -g -c file2.c
gcc -g -c file3.c
```
2. Link All Object Files
Link the object files together to create the executable:

```
gcc -g -o myprogram file1.o file2.o file3.o
```
Makefile Approach
Use a flexible Makefile to manage compilation:

makefile
CC = gcc
CFLAGS = -g -Wall

myprogram: file1.o file2.o file3.o
    $(CC) $(CFLAGS) -o myprogram file1.o file2.o file3.o

%.o: %.c
    $(CC) $(CFLAGS) -c $<

clean:
    rm -f *.o myprogram

Common Debugging Techniques

    Ensure function prototypes are declared in header files
    Check that all function definitions match their declarations
    Verify header file include guards
    Use -Wall flag to catch potential linking errors

GDB Multifile Debugging

```
# Launch GDB
gdb ./myprogram

# Set breakpoints across files
(gdb) break file2.c:linenum
(gdb) break function_name
```
By following these steps, you'll resolve undefined reference issues and set up a robust debugging environment for multi-file C projects

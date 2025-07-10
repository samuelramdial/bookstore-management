# Bookstore Management System 
A comprehensive, semester-long **Object-Oriented Java Application** for managing a bookstore's operations - from **inventory control** and **member management** to **purchase tracking** and *daily sales reporting**. This project was developed for ITSC 1213 and progressively enhanced through three major phases, incorporating **inheritance**, **abstraction**, **file I/O**, and **exception handling**.
---
## Features by Project Phase 
### Project 1: Core Bookstore Functionality
- Manage **inventory of three product types: `Book`, `CD`, and `DVD`
- Maintain records for both `Regular` and `Premium` members
  - Premium members include monthly payment tracking
- **Three main system functions**:
  1. Register a new member (Regular or Premium)
  2. Complete a purchase
  3. View purchase history by member
- Track total spending per customer and deduct purchased items from stock
- Built a **Test Harness** with a command-line interface and text menu option s
---
### Project 2: Inheritance, Abstraction & Interfaces 
- Introduced an **abstract `Product` class** with subclasses: `Book`, `CD`, `DVD`
- Implemented the **`Comparable` interface** for comparing products by stock quantity
- Introduced a **`BookstoreSpecification` interface**:
  - `restockProduct(int productID, int amount)`
  - `inventoryValue()` to compute total inventory value
- Update the Test Harness:
  - Compare products
  - Restock items
  - Calculate total inventory value
---
### Project 3: Persistant Inventory, Reporting & Exception Handling 
- **Loaded inventory dynamically** from a `.csv` file on application start
- Generated two files on exit:
  - **`EndOfDayReport.txt`** - summary of sales, members, and revenue
  - **`UpdatedInventory.csv`** - reflects end-of-day stock levels
- Added **exception handling** for:
  - `InputMismatchException` on invalid console input
  - `FileNotFoundException` and `IOException` for file operations
- Optional enhancements included:
  - Daily sales and discounts
  - Custom inventory filenames prompted on start
  - Flexible user interaction with error-tolerant flows
## Developed For 
**ITSC 1213 - Introduction to Computer Science II** 
University of North Carolina at Charlotte 
Instructor: Dr. Nadia Najjar 

© 2025 Samuel Ramdial

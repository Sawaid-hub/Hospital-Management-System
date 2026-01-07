# Software Re-Engineering: Hospital Management System

**Course:** Software Re-Engineering / Software Evolution  
**Project Type:** Legacy System Modernization & Evolution  
**Status:** Milestone 1 (Analysis & Reverse Engineering)  
**Technology Stack:** Java (Swing), MySQL, JDBC  

 Team Members
| Name | Student ID | Role |
|------|------------|------|
| [Student Name 1] | [ID 1] | Lead Developer / Refactoring |
| [Student Name 2] | [ID 2] | Database Architect / QA |
| [Student Name 3] | [ID 3] | Documentation / UI Design |

 Project Overview
The goal of this project is to take an existing **Legacy Hospital Management System**, analyze its architectural flaws, and re-engineer it into a modular, maintainable, and testable application.

This repository tracks the evolution of the software through three key phases:
1.  **Phase 1 (Current):** Analysis & Reverse Engineering of the legacy codebase.
2.  **Phase 2:** Refactoring (Extracting layers, cleaning code smells, adding tests).
3.  **Phase 3:** Evolution (Adding a new "Web Dashboard" or "Notification" module).

  The Legacy System (As-Is Analysis)
**Legacy Source:** [Link to original repo if applicable, or "Internal Student Project"]  
**Version:** `v1.0-LEGACY` (Committed "As-Is")

The current system acts as a monolithic desktop application. While functionally complete, it suffers from significant technical debt that hinders extensibility.

 Identified Code Smells & Issues
We have performed an initial audit and identified the following critical issues:

* **God Class Anti-Pattern:** The main class `HospitalDashboard.java` violates the Single Responsibility Principle (SRP). It handles UI rendering, event listeners, and database transactions simultaneously.
* **Hardcoded Dependencies:** Database credentials and `DriverManager.getConnection()` calls are scattered across multiple files, making the system fragile and difficult to configure.
* **Duplicate Code:** Logic for adding patients and doctors is copy-pasted with minor changes, leading to maintenance nightmares.
* **No Automated Testing:** The tight coupling between Swing (UI) components and logic makes unit testing impossible.
* **Magic Numbers:** Billing calculations use hardcoded scalars (e.g., `total = days * 500`) instead of named constants.

 Setup Instructions (Legacy Version)
*Note: These instructions apply to the legacy version. Refactored setup steps will be added in Milestone 2.*

 Prerequisites
* Java Development Kit (JDK) 8 or higher.
* MySQL Server (Localhost).
* Connector/J (MySQL JDBC Driver).

 Installation Steps
1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/Sawaid-hub/Hospital-Management-System.git
    ```
2.  **Database Setup:**
    * Open your MySQL Workbench or Command Line.
    * Create a database named `hms`.
    * Import the provided `hms_legacy_dump.sql` file (located in `/database` folder).
    * *Warning:* You may need to manually edit `src/HospitalDashboard.java` to match your local MySQL username/password.
3.  **Run the Application:**
    * Compile and run `Login.java` or `HospitalDashboard.java` as the main class.

 🗺️ Project Roadmap

 ✅ Milestone 1: Analysis & Reverse Engineering
- [x] Select Legacy System (>1,500 LOC).
- [x] Create "As-Is" Architecture Diagrams.
- [x] Identify Technical Debt & Code Smells.
- [x] Setup Git Repository with Legacy Baseline.

     Milestone 2: Refactoring
- [ ] Apply MVC Pattern (Separate UI from Logic).
- [ ] Create DAO Layer for Database access.
- [ ] Remove Duplicate Code.
- [ ] Implement JUnit Tests for core logic.

     Milestone 3: Evolution
- [ ] Develop New Module: **[Insert New Module Name, e.g., "Patient Discharge Email Notification"]**.
- [ ] Final System Presentation.

# Software Re-Engineering: Hospital Management System

**Course:** Software Re-Engineering / Software Evolution  
**Project Type:** Legacy System Modernization & Evolution  
**Status:** Milestone 2 (Refactoring Complete)  
**Technology Stack:** Java (Swing), MySQL, JDBC  

## Team Members
| Name | Student ID |
|------|------------|
| [M Sawaid Shah] | [ID 37559] |
| [Okamis Shah] | [ID 37844] |

## Project Overview
The goal of this project is to take an existing **Legacy Hospital Management System**, analyze its architectural flaws, and re-engineer it into a modular, maintainable, and testable application.

This repository tracks the evolution of the software through three key phases:
1.  **Phase 1 (Completed):** Analysis & Reverse Engineering of the legacy codebase.
2.  **Phase 2 (Completed):** Refactoring (Extracting layers, cleaning code smells, adding tests).
3.  **Phase 3:** Evolution (Adding a new "Web Dashboard" or "Notification" module).

## The Legacy System (As-Is Analysis)
**Legacy Source:** [Link to original repo if applicable, or "Internal Student Project"]  
**Version:** `v1.0-LEGACY` (Committed "As-Is")

The current system acts as a monolithic desktop application. While functionally complete, it suffers from significant technical debt that hinders extensibility.

## Identified Code Smells & Issues
We have performed an initial audit and identified the following critical issues:

* **God Class Anti-Pattern:** The main class `HospitalDashboard.java` violates the Single Responsibility Principle (SRP). It handles UI rendering, event listeners, and database transactions simultaneously.
* **Hardcoded Dependencies:** Database credentials and `DriverManager.getConnection()` calls are scattered across multiple files, making the system fragile and difficult to configure.
* **Duplicate Code:** Logic for adding patients and doctors is copy-pasted with minor changes, leading to maintenance nightmares.
* **No Automated Testing:** The tight coupling between Swing (UI) components and logic makes unit testing impossible.
* **Magic Numbers:** Billing calculations use hardcoded scalars (e.g., `total = days * 500`) instead of named constants.

## Refactoring Improvements (Milestone 2)
We have successfully re-engineered the application to address the identified issues:

### 1. Architecture (MVC & DAO Pattern)
*   **Model Layer**: Created `Doctor.java`, `Patient.java`, and `Appointment.java` to represent data entities.
*   **DAO Layer**: Implemented a robust Data Access Object layer with `GenericDAO` interface and concrete implementations (`DoctorDAO`, `PatientDAO`, `AppointmentDAO`).
*   **Decoupled UI**: Refactored `Table.java` to strict View responsibility, accepting data via constructor rather than fetching it.

### 2. Security & Configuration
*   **Centralized Configuration**: Moved hardcoded database credentials from code to a secure `src/db.properties` file.
*   **Git Protection**: Added `db.properties` to `.gitignore` to prevent sensitive data leaks.

### 3. Code Duplication Removal
*   **Base Page Abstraction**: Created `BaseEntityPage.java` to encapsulate common UI layout and logic.
*   **Refactored Pages**: `DoctorsPage`, `PatientsPage`, and `AppointmentsPage` now extend `BaseEntityPage`, reducing boilerplate code by ~60%.

### 4. Testing
*   **JUnit Integration**: Added `DoctorDAOTest.java` to verify database operations.
*   **Manual Testing**: Created `ManualTest.java` for quick verification of DAO layers without external dependencies.

## Setup Instructions (Refactored Version)

### Prerequisites
* Java Development Kit (JDK) 8 or higher.
* MySQL Server (Localhost).
* Connector/J (MySQL JDBC Driver).

### Installation Steps
1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/Sawaid-hub/Hospital-Management-System.git
    cd Hospital-Management-System
    git checkout okamis
    ```
2.  **Database Setup:**
    * Create a database named `hospital_db`.
    * Run the SQL scripts to create tables (Doctors, Patients, Appointments).
3.  **Configuration:**
    * Create a file `src/db.properties` with your local credentials:
      ```properties
      db.url=jdbc:mysql://localhost:3306/hospital_db
      db.user=root
      db.password=your_password
      ```
4.  **Run the Application:**
    * Compile and run `Auth.LoginPage` (or `Main.Main`) as the entry point.

## 🗺️ Project Roadmap

### ✅ Milestone 1: Analysis & Reverse Engineering
- [x] Select Legacy System (>1,500 LOC).
- [x] Create "As-Is" Architecture Diagrams.
- [x] Identify Technical Debt & Code Smells.
- [x] Setup Git Repository with Legacy Baseline.

### ✅ Milestone 2: Refactoring
- [x] Apply MVC Pattern (Separate UI from Logic).
- [x] Create DAO Layer for Database access.
- [x] Remove Duplicate Code.
- [x] Implement JUnit Tests for core logic.

### ⏳ Milestone 3: Evolution
- [ ] Develop New Module: **[Insert New Module Name, e.g., "Patient Discharge Email Notification"]**.
- [ ] Final System Presentation.

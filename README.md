# Personal Productivity Tracker

## Overview

The **Personal Productivity Tracker** is a Java-based application designed to help students and working individuals organize their tasks, track focused work sessions, analyze productivity, and generate productivity reports.

The application provides a simple command-line interface and uses **SQLite** for persistent data storage.

---

## Problem Statement

Students and working individuals often struggle to manage daily tasks and monitor how effectively they spend their time.

Without a structured productivity system, it can be difficult to:

- Keep track of pending and completed tasks
- Prioritize important work
- Record focused work sessions
- Monitor total focus time
- Measure productivity
- Review overall productivity performance

The Personal Productivity Tracker addresses these problems by providing a centralized application for task management, focus tracking, productivity analysis, and report generation.

---

## Objectives

The main objectives of the project are:

1. To provide an organized system for managing personal tasks.
2. To allow users to record focused work sessions.
3. To calculate task completion rates and focus time.
4. To calculate an overall productivity score.
5. To generate a summary productivity report.
6. To store task and focus-session data persistently using SQLite.
7. To demonstrate Java programming, OOP, JDBC, database handling, validation, and modular software design.

---

## Main Features

### 1. Task Management

Users can:

- Add new tasks
- View all tasks
- Update existing tasks
- Delete tasks
- Set task categories
- Set task priorities
- Set deadlines
- Track task status

### 2. Focus Time Tracking

Users can:

- Add focus sessions
- Associate a focus session with a task
- Record activities
- Record start and end times
- Store session duration
- View all focus sessions
- Calculate total focus time

### 3. Productivity Analytics

The system calculates:

- Total number of tasks
- Completed tasks
- Pending tasks
- Task completion rate
- Total focus time
- Productivity score

The productivity score is calculated using:

- 70% weight for task completion
- 30% weight for focus time

### 4. Productivity Reports

The application generates a productivity summary containing:

- Total tasks
- Completed tasks
- Pending tasks
- Completion rate
- Total focus time
- Productivity score

---

## Functional Requirements

### Task Management

- The system shall allow users to add tasks.
- The system shall allow users to view tasks.
- The system shall allow users to update tasks.
- The system shall allow users to delete tasks.

### Focus Tracking

- The system shall allow users to record focus sessions.
- Each focus session shall be associated with a valid task.
- The system shall store focus duration.
- The system shall display recorded focus sessions.

### Analytics

- The system shall calculate task completion rate.
- The system shall calculate total focus time.
- The system shall calculate completed and pending tasks.
- The system shall calculate a productivity score.

### Reporting

- The system shall generate a productivity report.
- The report shall summarize the user's productivity information.

---

## Non-Functional Requirements

### Usability

The application provides a simple command-line interface with clearly numbered menu options.

### Performance

Task operations and productivity calculations are lightweight and execute efficiently.

### Reliability

Database and input errors are handled without causing unexpected application termination.

### Maintainability

The project uses separate packages and classes for models, services, and utility functions.

### Error Handling

Invalid task IDs, priorities, statuses, durations, and database errors are detected and handled appropriately.

### Resource Efficiency

Database connections and statements are properly closed using Java's try-with-resources mechanism.

---

## Technologies Used

| Technology | Purpose |
|------------|---------|
| Java 17 | Application development |
| SQLite | Data storage |
| JDBC | Database connectivity |
| Maven | Project and dependency management |
| Git | Version control |
| GitHub | Source code hosting and collaboration |
| GitHub Actions | Automated build and testing |
| IntelliJ IDEA | Development and testing |

---

## Project Structure

```text
Personal-Productivity-Tracker/
│
├── .github/
│   └── workflows/
│       └── java-ci.yml
│
├── model/
│   ├── FocusSession.java
│   └── Task.java
│
├── service/
│   ├── Analytics.java
│   ├── FocusTracker.java
│   ├── ReportGenerator.java
│   └── TaskManager.java
│
├── util/
│   ├── DatabaseManager.java
│   └── Validator.java
│
├── screenshots/
│   ├── add-task.png
│   ├── view-tasks.png
│   ├── update-task.png
│   ├── delete-task.png
│   ├── add-focus-session.png
│   ├── view-focus-sessions.png
│   ├── productivity-statistics.png
│   ├── productivity-report.png
│   ├── automated-testing.png
│   ├── system-architecture.png
│   ├── workflow-diagram.png
│   ├── use-case-diagram.png
│   ├── class-diagram.png
│   ├── sequence-diagram.png
│   └── er-diagram.png
│
├── Main.java
├── TestRunner.java
├── README.md
├── statement.md
├── pom.xml
└── .gitignore

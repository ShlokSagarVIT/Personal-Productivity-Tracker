# Personal Productivity Tracker

## 1. Project Overview

Personal Productivity Tracker is a Java-based application designed to help users manage their daily tasks, record focused work sessions, analyze productivity, and generate productivity reports.

The project uses Java for application logic and SQLite for persistent data storage.

---

## 2. Problem Statement

Students and working individuals often struggle to organize tasks and understand how effectively they spend their time.

This project provides a simple productivity management system where users can:

- Manage their tasks
- Track focused work sessions
- Monitor task completion
- Calculate productivity scores
- Generate productivity reports

---

## 3. Objectives

The main objectives of the project are:

1. To provide a simple task management system.
2. To record and manage focus sessions.
3. To analyze productivity using task completion and focus time.
4. To calculate a productivity score.
5. To store productivity data using SQLite.
6. To generate useful productivity reports.

---

## 4. Main Features

### Task Management

- Add tasks
- View tasks
- Update tasks
- Delete tasks
- Set task priority
- Set task category
- Set deadlines
- Track task status

### Focus Tracking

- Add focus sessions
- Record activity
- Record start and end time
- Store focus duration
- Calculate total focus time

### Productivity Analytics

- Calculate completed tasks
- Calculate pending tasks
- Calculate task completion rate
- Calculate total focus time
- Calculate productivity score

### Productivity Reports

The application generates a report containing:

- Total tasks
- Completed tasks
- Pending tasks
- Completion rate
- Total focus time
- Productivity score

---

## 5. Technologies Used

- Java
- SQLite
- JDBC
- Maven
- GitHub

---

## 6. Project Structure

```text
Personal-Productivity-Tracker/
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
├── Main.java
├── README.md
├── statement.md
└── pom.xml

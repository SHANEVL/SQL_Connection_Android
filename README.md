# SQL Connection demo for Android App (java)

## Overview
This repository hosts a demo Android application designed to demonstrate the integration of a direct SQL Server connection. Developed in Java using Android Studio, the application serves as an educational tool, showcasing an approach that, while not typically recommended, is an interesting exploration into the capabilities of Android development.

## Warning
The application establishes a direct connection to a SQL Server database, a method generally advised against in production environments. Standard practice for Android applications is to utilize SQLite for local databases or interact with remote databases through web services (APIs). This direct integration approach may raise security and architectural concerns.

## Purpose
The project's primary goal is educational. It provides a hands-on example for those curious about direct database integration within an Android app, emphasizing the concept rather than the best practice.

## Getting Started
To run this project on your machine:

- Clone this repository.
- Open it in Android Studio.
- Ensure you have a SQL Server accessible with the appropriate details (server name, database, username, password) directly coded into the app (as per your implementation): 
put the credentials in the HelperConnection class + modify the queries with existing tables from your database. 
- Compile and run the application.

## Additional Setup Requirements

### Enabling TCP/IP in SQL Server

For this application to connect successfully to the SQL Server, TCP/IP must be enabled on the server. This is a crucial step, as the default configuration might have it disabled. For detailed instructions on how to enable TCP/IP in your SQL Server, refer to this guide: [Troubleshooting: Enabling TCP/IP in the SQL Server](https://help.dugeo.com/m/Insight/l/438913-troubleshooting-enabling-tcp-ip-in-the-sql-server).

## Prerequisites
- Android Studio
- Java SDK
- Access to a SQL Server
- Fundamental knowledge of Android app development and SQL database management.

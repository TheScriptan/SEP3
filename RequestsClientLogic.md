# Communication Client - LogicServer

---

1. [Overview](#overview)
2. [Goal](#goal)
3. [Example](#example)
4. [List of actions](#list-of-actions)
   - [Admin](#admin)
   - [User](#user)
  
5. [Error messages](#error-messages)

---

## Overview

This is a simple overview of actions/messages between client and logic server, requiremets for specific actions and possible responses. 

## Goal

Main goal is to achieve stable communication while using sockets during programming phase.

## Example

Here is an example pattern of request sent from client to server and server responses. System uses two external libraries JSON-SIMPLE and GSON. JSON message starts with code in order to identify action (add/edit/remove/...) or response (0 == ok, 0< error). Second part of JSON message are arguments required for specific request.

**Request**
First part of request starts with code represented by enum and second part contains all necessary arguments for specific request.
```json
// Client -> Server (request)
{
   "request-code" : "REQUEST_CODE_ENUM",
   "arguments" : ["ARGUMENT0" ,"ARGUMENT1" , ...]
}
```

**Response**
First part of response contains return code. Return value 0 represents only errorless value. When error code is returned, arguments also contains error message.
```json
// Server -> Client (response)
{
   "response-code" : "RESPONSE_CODE_ENUM",
   "arguments" : ["ARGUMENT0" ,"ARGUMENT1" , ...]
}
``` 

---

## List of actions

### Admin
   - [Log in](#log-in)

   **Shift related**

   - [Add new shift](#add-new-shift/employee/company/user)
   - [Edit shift](#edit-new-shift/employee/company/user)
   - [Remove shift](#remove-new-shift/employee/company/user)
   - [Assign shift](#assign-shift)
   - [Release shift](#release-shift)
  
   **User related**
  
   - [Add new user](#add-new-shift/employee/company/user)
   - [Edit user](#edit-new-shift/employee/company/user)
   - [Remove user](#remove-new-shift/employee/company/user)

   **Company related**

   - [Add company](#add-new-shift/employee/company/user)
   - [Edit company](#edit-new-shift/employee/company/user)
   - [Remove company](#remove-new-shift/employee/company/user)

   **Employee related**

   - [Add employee](#add-new-shift/employee/company/user)
   - [Edit employee](#edit-new-shift/employee/company/user)
   - [Remove employee](#remove-new-shift/employee/company/user)

### User

   - [Register](#register)
   - [Log in](#log-in)
   - [Edit info](#edit-info)
   - [Take shift](#take-shift)
   - [Report sickness](#report-sickness)
   - [Check worked hours](#check-worked-hours)
   - [Create schedule](#create-schedule)

---

## Detailed list of actions

### Admin 

#### Log in

**Requirements**
- cpr
- password
- admin token

**Response**
- valid
- invalid
  - [error message](#error-messages)


#### Add new shift/employee/company/user

**Requirements**
- serialized object to JSON (shift/employee/company/user)
  
**Response**
- added
- not added 
  - [error message](#error-messages)

#### Edit shift/employee/company/user

**Requirements**
- ID of changed object
- property of changed object
- new value of changed property
  
**Response**
- edited
- not edited
  - [error message](#error-messages)


#### Remove shift/employee/company/user

**Requirements**
- ID of removed object

**Response**
- removed
- not removed
  - [error message](#error-messages)


#### Assign shift

**Requirements**
- ID of shift
- ID of user
  
**Response**
- assigned
- not assigned
  - [error message](#error-messages)


#### Release shift

**Requirements**
- ID of shift
  

**Response**
- released
- not release
  - [error message](#error-messages)

### User

#### Register

**Requirements**
- all informations for registration
  

**Response**
- registered
- not registered
  - [error message](#error-messages)

#### Log in

**Requirements**
- cpr (id)
- password

**Response**
- valid
- invalid
  - [error message](#error-messages)

#### Edit info

**Requirements**
- property of change obj
- changed property
  
**Response**
- changed
- not changed
  - [error message](#error-messages)

#### Take shift

**Requirements**
- ID of shift
  
**Response**
- taken
- not taken
  - [error message](#error-messages)

#### Report sickness

**Requirements**
- ID of shift
  

**Response**
- reported
- not reported
  - [error message](#error-messages)

#### Check worked hours

**Requirements**
- nothing
  

**Response**
- ok
- not ok
  - [error message](#error-messages)

#### Create schedule

**Requirements**
- serialized schedule
  

**Response**
- created
- not created
  - [error message](#error-messages)


---

## Error messages

**Log in**
 1. Missing CPR or password.
 2. User not registered.
 3. Invalid CPR or Password
 4. 
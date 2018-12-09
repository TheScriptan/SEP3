# Communication Client - LogicServer

---

[1. Overview](#overview)
[2. Goal](#goal)
[3. Example](#example)
[4. List of actions](#list-of-actions)
   - [Admin](#admin)
   - [User](#user)
  
[5. Error messages](#error-messages)

---

## Overview

This is a simple overview of actions/messages between client and logic server, requiremets for specific actions and possible responses. 

## Goal

Main goal is to achieve stable communication while using sockets during programming phase.

## Example

Here is an example pattern of request sent from client to server and server responses. System uses two external libraries JSON-SIMPLE and GSON. JSON message starts with code in order to identify action (add/edit/remove/...) or response (0 == ok, 0< error). Second part of JSON message are arguments required for specific request.

```json
// Client -> Server (request)
{
   "request-code" : "REQUEST_CODE_ENUM",
   "arguments" : ["ARGUMENT0" ,"ARGUMENT1" , ...]
}

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

   - Add new shift
   - Edit shift
   - Remove shift
   - Assign shift
   - Release shift
  
   **User related**
  
   - Add new user
   - Edit user
   - Remove user

   **Company related**

   - Add company
   - Edit company
   - Remove company

### User

   - Register
   - Log in
   - Edit info
   - Take shift
   - Report sickness
   - Check worked hours
   - Create schedule

---



List of required things to get valid response.

### Admin 

#### Log in

**Requirements**
Login action requires from user to type both his <u>cpr</u> and <u>password</u>.
```json
{
   "request-code" : "LOGIN_CODE_ENUM",
   "arguments" : ["CPR" ,"PASSWORD"]
}
```

**Response**
Response contains validation part (<u>valid/invalid</u>) and possible error message (only invalid response).
```json
Authorized user:
{
   "response-code" : "VALID",
   "arguments" : []
}

Not Authorized user:
{
   "response-code" : "INVALID",
   "arguments" : ["ERR_MSG"]
}
```

**Possible Errors**
- [Login errors list 1-10](#error-messages)

---

## Error messages

**1-10 Log in**
 1. Missing CPR or password.
 2. User not registered.
 3. Invalid CPR or Password
 4. 
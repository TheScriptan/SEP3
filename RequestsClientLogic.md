# Communication Client - LogicServer

---

Here is the pattern of requests send from client to server and server`s responses. Project uses two external libraries JSON-SIMPLE and GSON. JSON message starts with code in order to identify request (add/edit/remove/...) or response (0 == ok, 0< error). Second part of JSON message are arguments required for specific request.

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
**Request codes**
   - [admin]()
   - [user]()
  
**Response codes**
   - admin
   - user

**Arguments types**
   - simple data types (int, long, string)
   - object (serialized in JSON format -> GSON)

---

List of all request/commands from client to logic server.

**Admin**
   - login
   - register new admin

   (to shifts)
   - add shift
   - delete shift
   - edit shift
   - assign shift
  
  (to students)
  - add user
  - edit user
  - remove user

**User**
   - register
   - login
   - change info ?
   - take shift
   - report sickness
   - check worked hours
   - create schedule

---

## Requirements for requests

List of required things to get valid response.

### Admin

**1. Log in** (as admin)

**Requirements**
In order to log in (as admin), user types both his <u>**cpr**</u> and <u>**password**</u> and press button login.
```json
{
   "request-code" : "LOGIN_CODE_ENUM",
   "arguments" : ["CPR" ,"PASSWORD"]
}
```

**Response**
Response contains 2 parts, validation (valid/invalid) and error message (0 == OK).
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
[1](#error-messager), 2, 3

---

## Error messages

**1-10 Log in**
 1. Missing CPR or password.
 2. User not registered.
 3. Invalid CPR or Password
 4. 
#Catalog

#####[1\. User login](#1)
#####[2\. User logout](#2)
#####[3\. User login status test](#3)
#####[4\. User register](#4)
#####[5\. SQL executor](#5)

---

<h4 id="1">1. User login</h4>

###### Api function
> Allow normal user and administrator to login and create session

###### URL
> ../user/getLogInfo

###### Support format
> JSON

###### HTTP request methode
> POST

###### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|username    |yes(or no if use email)    |string|Username for login                          |
|password    |yes    |string   |Password|
|email    |yes(or no if use username)    |string   |email address|
|groupid    |yes    |int   |1.Administrator 2.Normal user(defaut)|

###### Example request

``` javascript
{
    "uid":1,
    "username":"titi.toto"
    "password":"123456", 
    "email":"123456@gmail.com",
    "groupid":2,
}
```

###### Example response of succesful request

``` javascript
{
    "Data":{
        "email":"123456@gmail.com",
        "groupid":1,
        "password":"123456",
        "uid":1,
        "username":"titi.toto"},
    "ErrorCode":200
}
```

###### Example response of failing request
``` javascript
{
    "ErrorCode":401,
    "ErrorMessage":"Wrong user name or password!"
}
```
---
<h4 id="2">2. User logout</h4>

###### Api function
> Allow user to log out

###### URL
> ../user/logOut

###### HTTP request methode
> GET

###### Example response of succesful request

>this response will redirect user to the homepage or login page

---
<h4 id="3">3. User login status test</h4>
###### Api function
> Allow developper to test the status of login

###### URL
> ../user/testLogin

###### HTTP request methode
> GET

###### Example response of succesful request

``` javascript
{
    "success"
}
```

###### Example response of failing request
``` javascript
{
    "ErrorCode":400,
    "ErrorMessage":"You have not logged in yet!"
}
```
---
<h4 id="4">4. User register</h4>

###### Api function
> Allow normal users to create their accounts

###### URL
> ../user/registerInfo

###### Support format
> JSON

###### HTTP request methode
> POST

###### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|username    |yes    |string|Username for login                          |
|password    |yes    |string   |Password|
|email    |yes    |string   |email address|
|groupid    |yes    |int   |1.Administrator 2.Normal user(defaut)|

###### Example request

``` javascript
{
    "uid":1,
    "username":"titi.toto"
    "password":"123456", 
    "email":"123456@gmail.com",
    "groupid":2,
}
```

###### Example response of succesful request

``` javascript
{
    "Data":{
        "email":"123456@gmail.com",
        "groupid":1,
        "password":"123456",
        "uid":1,
        "username":"titi.toto"},
    "ErrorCode":200
}
```

###### Example response of failing request
``` javascript
{
    "ErrorCode":402,
    "ErrorMessage":"Username or email have already been used!"
}
```
---

<h4 id="5">5. SQL executor</h4>

###### Api function
> Allow normal user to execute their SQL query

###### URL
> ../sqlExecutor/testSql

###### Support format
> JSON

###### HTTP request methode
> POST

###### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|sqlQuery   |yes   |string|SQL query                       |

###### Example request

``` javascript
{
    "sqlQuery":"select * from emp"
}
```

###### Example response of succesful request

``` javascript
[
    {"id_emp":1,"nom_emp":"coucou"},
    {"id_emp":2,"nom_emp":"chouchou"}
]
```

###### Example response of failing request
``` javascript
{
    "RootCause":"You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'Enter your sql query' at line 1",
    "ErrorCode":1064
}
```
---


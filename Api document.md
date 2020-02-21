目录

1\. User login
2\. User register
3\. SQL executor
---

**1\. User login**
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

**2\. User register**
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
**3\. SQL executor**
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


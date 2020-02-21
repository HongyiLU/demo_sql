目录

1\. User login

---

**1\. User login**
###### Api function
> Allow normal user and administrator to login and create session

###### URL
> ../user/getloginfo

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
> ../user/registerinfo

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



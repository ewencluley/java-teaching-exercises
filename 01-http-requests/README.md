#Task

Add functionality to the http server so that for a POST request to the `/exaggerate` endpoint will read in a text 
request body and return it with every number in the text doubled.

Example request:
```
http://localhost:8000/exaggerate

BODY
Some text with some numbers in it: like 12
```

Example input/output
```
input                             ->            output

I am 33 yeard old                 ->            I am 66 years old
I have $100                       ->            I have $200
Edward makes $90000 a year        ->            Edward makes $180000 a year
```

* If a http request with any other method (e.g. GET, PUT) is received the response should have a 405 status code.
* If the text contains no numbers it should be returned unchanged
* We are only interested in digits, you can ignore word based numbers like `one`, `twelve`, etc.

Tip: These bullet points would make good conditions for unit tests :)

## Tests
If you can it would be great to have some unit tests for the class you create that implements HttpHandler. This will be 
a little fiddly (as you will have to use mocks that have methods that return mocks) but I have proivided an example for 
a test for a simple request handler.

##Stretch Goal
Allow the request to specify a query parameter called `factor` which will be a number that will determine how 
much the number in the request body will be multiplied by.
Example request:
```
http://localhost:8000/exaggerate?factor=7

BODY
Some text with some numbers in it: like 12
```

Example input/output
```
factor      input                             ->            output

2           I am 33 yeard old                 ->            I am 66 years old
7           I have $100                       ->            I have $700
100         Edward makes $90000 a year        ->            Edward makes $9000000 a year
```
* If the value passed in for the `factor` parameter is not a number (e.g. `http://localhost:8000/exaggerate?factor=cheese`) 
  the response should have a status code of `400`(Bad Request) and a response body of `Invalid factor, expected a number`
* If the value passed in for the `factor` parameter is not specified (e.g. `http://localhost:8000/exaggerate?factor=`) 
  the response should have a status code of `400`(Bad Request) and a response body of `Invalid factor, expected non empty`
* If no `factor` parameter is specified (e.g. `http://localhost:8000/exaggerate` then the factor should default to 2.

Tip: These bullet points would make good conditions for unit tests :)
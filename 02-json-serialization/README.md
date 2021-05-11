# Task

Add functionality to the http server so that for a POST request to the `/book` endpoint will read in a json
request body and return a json response indicating that the book has been stored.

Example request:
```
http://localhost:8000/book

BODY
{
    "title": "Dune",
    "author": "Frank Herbert",
    "pages": 235
}
```

Example response body
```
{
    "status": "ACCEPTED",
    "book": {
        "title": "Dune",
        "author": "Frank Herbert",
        "pages": 235
    },
    "recievedAt": "2021-05-11T12:23:00Z"
}
```

Then you should make the endpoint also process GET requests to `/book/<title>` where `<title>` is the name of the book.
* If the book has been submitted previously (using the POST endpoint) then the book should be returned
* if the book has not been submitted then the resonse should be 404 with the json body `{"error": "Not found"}`

# Tips:
* You will need two classes, one to represent the book and one to represent the response (with the status, receivedAt, and the book)
* Store the submitted books in a Map object with keys being the title and values beign the book.  
* For the GET endpoint you will need to get the book's name from the url using `exchange.getRequestURI().getPath()`


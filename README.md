# bookshop-api
Rest API for a bookshop

## Endpoints

All endpoints have admin query string for authorisation purposes. On true, additional fields are returned

#### GET /books{?admin=true}

returns all books.


#### GET /books/{id}{?admin=true}

returns book with id specified.


#### POST /books{?admin=true}

Adds a book. Admin must be true.
  
Sample payload: 

{

"id": "10",

"title": "Crime And Punishment",

"author": "Fyodor Dostoyevsky",

"categories": "Crime Fiction",

"isbn": "9788897572657"

}

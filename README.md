Spring full course - project #1
Task:

The local library wants to implement digital accounting of books. They ask to implement a web application for them. Librarians should be able to register readers, lend books to them, and release books (after the reader returns the book to the library).

Required functionality:

1.Pages for adding, changing and deleting a person.
2.Pages for adding, editing and deleting a book
3.A page with a list of all people (people are clickable - when you click, you go to the person's page).
4.A page with a list of all books (books are clickable - when you click, you go to the page of the book).
5.The person's page, which shows the values of his fields and the list of books he took. If the person has not taken any books, the list should be replaced by the text "Person has not borrowed any book yet.".
6.A page of a book showing the values of that book and the name of the person who took that book. If this book has not been taken by anyone, it should read "This book is free".
7.On the page of the book, if the book is taken by a person, next to his name there should be a button "Release book". This button is pressed by the librarian when the reader returns this book back to the library. After pressing this button, the book becomes free again and disappears from the list of the person's books.
8.On the page of the book, if the book is free, there should be a drop-down list (<select>) with all people and a button "Assign book". This button is pressed by the librarian when the reader wants to take this book home. After clicking on this button, the book should begin to belong to the selected person and should appear in his list books.
9.All fields must be validated - with @Valid and Spring Validator if required.
Used technologies:

• Spring MVC
• PostgreSQL
• Thymeleaf
• HTML
• Maven

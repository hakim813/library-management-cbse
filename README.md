!!REMINDER!!
Run LibApp file instead of LibraryManagement under library package folder to run the code successfully.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Book Management System has 4 functionalities provided; add new books into collection, handle borrowing books, searching books by title and display the list of books available.

![image](https://github.com/user-attachments/assets/b5d0fd65-4961-4dcc-af61-6b17a34c6644)

1. Add new book
   
![image](https://github.com/user-attachments/assets/d1d727ac-178f-473b-ba8d-b9a51c37ee0d)

The command line will ask for book ID, title and author to insert as input. Once all the informations have been inserted, the book will be added into the collection.

2. Borrow book
   
![image](https://github.com/user-attachments/assets/cd10e83c-ba78-4afa-ad32-839ce2cfe5ec)

To brrow the book, the user only need to input the book ID and the process is complete with either 3 cases:

2.1. Book is available to borrow (example is shown int the diagram above)

2.2. Book is available in the collection but is already borrowed

![image](https://github.com/user-attachments/assets/b65e995c-84a1-4845-b3ed-19b082c47e05)

The output will state the status of the book is borrowed.

2.3 No such book in collection

![image](https://github.com/user-attachments/assets/217b36aa-5889-40f1-bfd5-acf77a9543ae)

The output will state no such book is found in the record.

3. Search book
   
![image](https://github.com/user-attachments/assets/093c1fdd-a538-41e8-a614-1caf45591e7b)

To search a book, user only have to input the book title and such information about the book; ID, title, author and borrowed status will be shown as the image above.

If such book with the title doesn't exist, it will skip back to case selection as shown in the diagram below.

![image](https://github.com/user-attachments/assets/de2c1571-5675-4b90-88d8-e22cc1d335f0)

4. Display book
   
![image](https://github.com/user-attachments/assets/e8a3acb6-cd1c-4673-be44-f9fa168b038e)

This functionality will display all books existing in the collection list and also the detailed informations of all books.









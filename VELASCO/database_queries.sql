SHOW DATABASES;
DROP DATABASE IF EXISTS bookstore_db;
CREATE DATABASE bookstore_db;
USE bookstore_db;

DROP TABLE IF EXISTS book;

CREATE TABLE book (
    id INT NOT NULL auto_increment,
    title VARCHAR (250) NOT NULL,
    author VARCHAR (70) NOT NULL,
    isbn BIGINT NOT NULL,
    publisher VARCHAR (70) DEFAULT NULL,
    bookEdition INT NOT NULL,
    category VARCHAR (70) DEFAULT NULL,
    bookPages INT DEFAULT NULL,
    price DECIMAL(8, 2) NOT NULL,
    noOfCopiesStatus INT NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO book (id, title, author, isbn, publisher, bookEdition, category, bookPages, price, noOfCopiesStatus)
VALUES ( 77004, 'JAVA for somebody', 'Nikitas Karanikolas', 9789605780449, 'New Tech Pub', 1, 'Programming', 516, 22.40, 150 );

INSERT INTO book (title, author, isbn, publisher, bookEdition, category, bookPages, price, noOfCopiesStatus) VALUES 
('JAVA for everyone', 'Nikitas Karanikolas', 9789607235022, 'New Tech Pub', 1, 'Programming', 510, 22.40, 234),
('Computer Networking: A Top-Down Approach', 'James Kurose', 9780132856201,'Pearson', 7, 'Computer Networking', 832, 171.60, 120),
('Fundamentals of Database Systems', 'Ramez Elmasri', 9780133971224, 'Pearson', 7, 'Database', 1280,186.65, 64),
('Java Network Programming', 'Elliotte Rusty Harold', 9781449357672,'OReilly Media', 4, 'Programming', 506, 32.87, 74),
('Introduction to Algorithms', 'Thomas H. Cormen ', 9780262033848,'MIT Press', 3, 'Computer Algorithms', 1292 , 80.83, 60),
('Algorithm Design', 'Jon Kleinberg',9780321295354,'Pearson', 1, 'Computer Algorithms', 864, 167.54, 25),
('Data Structures and Algorithms in Java', 'Robert Lafore', 9780672324536,'Sams Publishing', 2, 'Data Structure and Algorithms', 800 , 36.64, 36),
('The C++ Programming Language', 'Bjarne Stroustrup', 9780321563842 ,'Addison-Wesley Professional', 4, 'Programming', 1376  , 54.99, 175),
('Modern Operating Systems', 'Andrew Tanenbaum', 9780133591620 ,'Pearson', 4,  'Computer Operating Systems Theory', 1136   , 166.80 , 111),
('Operating System Concepts', 'Abraham Silberschatz',  9781118063330 ,'Wiley', 9,  'Computer Operating Systems Theory', 976 , 192.92 , 231);

SELECT * FROM book; 


DROP user IF EXISTS 'Velasco' @'localhost';
CREATE user 'Velasco' @'localhost';
ALTER user Velasco@localhost identified BY 'cs161020';
GRANT ALL privileges ON bookstore_db.* TO 'Velasco' @'localhost';

QUIT;

# login
# mysql -u Velasco -p
SHOW DATABASES;
USE bookstore_db;
SHOW tables;
SELECT * FROM book; 

#1
#SELECT * FROM book where noOfCopiesStatus > 0; 

#2 select * from book where id = 77014;
#SELECT * FROM book WHERE id = ?;

#3 
#update book set noOfCopiesStatus = noOfCopiesStatus + 10 where id = 77011;
#UPDATE book SET noOfCopiesStatus = noOfCopiesStatus - ? WHERE id = ? AND noOfCopiesStatus > ? ;


#4 
INSERT INTO book (title, author, isbn, publisher, bookEdition, category, bookPages, price, noOfCopiesStatus) 
VALUES ('Discrete Mathematics and Its Applications', 'Kenneth Rosen',  9780073383095 ,'McGraw-Hill Education', 7,  'Applied Mathematics', 1072, 183.99 , 21);

#5
# UPDATE book SET title = ? , author =  ? , isbn = ? , publisher = ? , bookEdition = ? , category =  ?,
# bookPages =  ? , price = ? , noOfCopiesStatus = ?  WHERE id = ?; AVG

#6
#DELETE FROM book WHERE id = ?;
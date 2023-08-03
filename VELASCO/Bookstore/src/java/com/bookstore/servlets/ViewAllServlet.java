/* cs161020 - UniWa
 * Paola Velasco
 * JAVA Web Programming
 **************************************************************
 * Servlet that displays the table of all books
 **************************************************************
 */
package com.bookstore.servlets;

import com.bookstore.beans.Book;
import com.bookstore.dao.BookDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Message status display after some actions in the database
        String messageStatus = request.getParameter("message");

        //Set the response message's MIME type
        response.setContentType("text/html");

        // Allocate an output writer to write the Response Message Body
        PrintWriter out = response.getWriter();

        // Retrieve data from database and store it in a list
        List<Book> list = BookDao.getAllBooks();

        // Write the Response Message Body, which is a dynamic HTML page
        out.println("<head><title>Bookstore VLSC - All books</title></head>");
        out.println("<h1>Books List</h1>");
        if (messageStatus != null) {
            out.println(messageStatus);
        }
        out.print("<center><table border='1' width='100%'");
        out.println("<tr><th>Id</th><th>Title</th><th>Author</th><th>ISBN</th><th>Publisher</th><th>Edition</th><th>Category</th>"
                + "<th>Pages</th><th>Price</th><th>No. of copies</th>"
                + "<th>edit</th><th>delete</th></tr>");

        // display book details
        for (Book book : list) {
            out.print("<tr><td>"
                    + book.getId() + "</td><td>"
                    + book.getTitle() + "</td><td>"
                    + book.getAuthor() + "</td><td>"
                    + book.getIsbn() + "</td><td>"
                    + book.getPublisher() + "</td><td><center>"
                    + book.getBookEdition() + "</center></td><td>"
                    + book.getCategory() + "</td><td><center>"
                    + book.getBookPages() + "</center></td><td>"
                    + book.getPrice() + "</td><td><center>"
                    + book.getNoOfCopies() + "</center></td><td>"
                    + "<a href='EditServlet?id=" + book.getId() + "'>edit</a></td><td>"
                    + "<a href='DeleteServlet?id=" + book.getId() + "'>delete</a>");
        }
        
        out.print("</table></center>");
        
        // hyperlink to go back to main page
        out.print("<br/><a href=\"http://localhost:8080/Bookstore/\"><center>Go to main page</center></a>");
        // close PrintWriter
        out.close();

    }

}

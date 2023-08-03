/* cs161020 - UniWa
 * Paola Velasco
 * JAVA Web Programming
 **************************************************************
 * Servlet to display some details of books list and make an order
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

public class OrderServlet extends HttpServlet {

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
        out.println("<head><title>Bookstore VLSC - Order a book</title></head>");
        out.println("<h1>Books List</h1>");

        if (messageStatus != null) {
            out.println(messageStatus);
        }

        out.print("<center><table border='1' ");
        out.println("<tr><th>Title</th><th>Author</th><th>Edition</th><th>Price</th><th>order</th><th>Quantity</th></tr>");

        // display book details
        for (Book book : list) {
            out.print("<tr><td>"
                    + book.getTitle() + "</td><td>"
                    + book.getAuthor() + "</td><td><center>"
                    + book.getBookEdition() + "</center></td><td>"
                    + book.getPrice() + "</td><center>");

            // html form 
            out.print("<form name='insert' action='UpdateServletOrder' method='post'>"
                    + "<td><input type='hidden' name='id' value='" + book.getId() + "'/>"
                    + "<input type='submit' name='Order' value='purchase'>"
                    + "<td><input type ='text' name='quantity'</td>");
            out.print("</form></tr>");
        }

        out.print("</table></center>");

        // hyperlink to go back to main page
        out.print("<a href=\"http://localhost:8080/Bookstore/\"><center>Go to main page</center></a>");

        // close PrintWriter
        out.close();

    }

}

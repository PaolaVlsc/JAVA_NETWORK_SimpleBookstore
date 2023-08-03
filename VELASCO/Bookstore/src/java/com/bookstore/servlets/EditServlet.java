/* cs161020 - UniWa
 * Paola Velasco
 * JAVA Web Programming
 **************************************************************
 * Servlet that displays a form to edit a certain book entry 
 **************************************************************
 */
package com.bookstore.servlets;

import com.bookstore.beans.Book;
import com.bookstore.dao.BookDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Set the response message's MIME type
        response.setContentType("text/html");

        // Allocate an output writer to write the Response Message Body
        PrintWriter out = response.getWriter();

        // Wrapping id
        String stringId = request.getParameter("id");
        int id = Integer.parseInt(stringId);

        // Retrieve book details by id through the id parametere passed by request
        Book book = BookDao.getBookById(id);

        // Write the Response Message Body, which is a dynamic HTML page
        out.println("<head><title>Bookstore VLSC - Edit a book </title></head>");
        out.println("<h1>Edit a book</h1>"); // h header ths neas selidas pou tha dhmiourghtei 

        // html form 
        out.print("<form name='edit' action='UpdateServlet' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='" + book.getId() + "'/></td></tr>");
        out.print("<tr><td>Title:</td><td><input type='text' name='title' value='" + book.getTitle() + "'/></td></tr>");
        out.print("<tr><td>Author:</td><td><input type='text' name='author' value='" + book.getAuthor() + "'/></td></tr>");
        out.print("<tr><td>ISBN:</td><td><input type='text' name='isbn' value='" + book.getIsbn() + "'/></td></tr>");
        out.print("<tr><td>Publisher:</td><td><input type='text' name='publisher' value='" + book.getPublisher() + "'/></td></tr>");
        out.print("<tr><td>Edition:</td><td><input type='text' name='edition' value='" + book.getBookEdition() + "'/></td></tr>");
        out.print("<tr><td>Category:</td><td><input type='text' name='category' value='" + book.getCategory() + "'/></td></tr>");
        out.print("<tr><td>Pages:</td><td><input type='text' name='pages' value='" + book.getBookPages() + "'/></td></tr>");
        out.print("<tr><td>Price:</td><td><input type='text' name='price' value='" + book.getPrice() + "'/></td></tr>");
        out.print("<tr><td>No of copies:</td><td><input type='text' name='noOfCopies' value='" + book.getNoOfCopies() + "'/></td></tr>");
        out.print("<tr><td colspan='2'><center><input type='submit' value='Edit & Save '/></center></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.print("<p><a href='index.html'>Go back to main page</a></p>");
        out.print("<p><a href='http://localhost:8080/Bookstore/ViewAllServlet'>Cancel</a></p>");

        // close output stream
        out.close();
    }

}

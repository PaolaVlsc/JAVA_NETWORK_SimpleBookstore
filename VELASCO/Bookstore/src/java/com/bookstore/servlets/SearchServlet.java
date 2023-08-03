/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Velasco
 */
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean ok_ID = false;

        // ti content type tha exei apo edw kai katw
        response.setContentType("text/html");
        // Allocate an output writer to write the Response Message Body
        PrintWriter out = response.getWriter();

        // Wrapping id
        String stringId = request.getParameter("id");

        if (stringId != null && (stringId = stringId.trim()).length() != 0) {
            ok_ID = true;
        }

        if (!ok_ID) {
            out.println("<p style=\"font-family:verdana; color:Red; font-size: 14px;\">Please enter an ID number</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        } else {
            try {
                int id = Integer.parseInt(stringId);

                // Pairnw to vivlio me to id pou phra apo to request
                Book book = BookDao.getBookById(id);
                if (book.getId() == 0 && book.getTitle() == null) {
                    out.println("<b><p style=\"font-family:verdana; color:Red; font-size: 15px;\">Book was not found in database</p></b>");
                    request.getRequestDispatcher("index.html").include(request, response);
                } else {

                    // Write the Response Message Body, which is a dynamic HTML page
                    out.println("<head><title>Bookstore VLSC - Search by ID</title></head>");
                    out.println("<h1>Book details</h1>");

                    out.print("<center><table border='1' width='100%'");
                    out.println("<tr><th>Id</th><th>Title</th><th>Author</th><th>ISBN</th><th>Publisher</th><th>Edition</th><th>Category</th>"
                            + "<th>Pages</th><th>Price</th><th>No. of copies</th></tr></tr>");
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
                            + book.getNoOfCopies() + "</center></td></td>");

                    out.print("</table></center>");
                    out.print("<p>"
                            + ""
                            + ""
                            + ""
                            + ""
                            + "</p>");
                    out.print("<a href=\"http://localhost:8080/Bookstore/\"><center>Go to main page</center></a>");
                }
            } catch (NumberFormatException nfe) {
                out.println("<b><p style=\"font-family:verdana; color:Red; font-size: 15px;\">Error: Input value is not valid [int]ID</p></b>");
                request.getRequestDispatcher("index.html").include(request, response);
            }
        }
        out.close();

    }

}

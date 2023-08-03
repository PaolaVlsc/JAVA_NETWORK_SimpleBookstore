/* cs161020 - UniWa
 * Paola Velasco
 * JAVA Web Programming
 **************************************************************
 * Servlet responsible for 
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

public class InsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean ok_title = false, ok_author = false, ok_stringISBN = false,
                ok_publisher = false, ok_stringBookEdition = false, ok_category = false,
                ok_stringBookPages = false, ok_stringPrice = false, ok_stringCopies = false;

        //Set the response message's MIME type
        response.setContentType("text/html");

        // Allocate an output writer to write the Response Message Body
        PrintWriter out = response.getWriter();

        // Get data from NewEntry.html through the parameters
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String stringISBN = request.getParameter("isbn");
        String publisher = request.getParameter("publisher");
        String stringBookEdition = request.getParameter("edition");
        String category = request.getParameter("category");
        String stringBookPages = request.getParameter("pages");
        String stringPrice = request.getParameter("price");
        String stringCopies = request.getParameter("noOfCopies");

        // check if text fields are empty 
        if (title != null && (title = title.trim()).length() != 0) {
            ok_title = true;
        }
        if (author != null && (author = author.trim()).length() != 0) {
            ok_author = true;
        }
        if (stringISBN != null && (stringISBN = stringISBN.trim()).length() != 0) {
            ok_stringISBN = true;
        }
        if (publisher != null && (publisher = publisher.trim()).length() != 0) {
            ok_publisher = true;
        }
        if (stringBookEdition != null && (stringBookEdition = stringBookEdition.trim()).length() != 0) {
            ok_stringBookEdition = true;
        }
        if (category != null && (category = category.trim()).length() != 0) {
            ok_category = true;
        }
        if (stringBookPages != null && (stringBookPages = stringBookPages.trim()).length() != 0) {
            ok_stringBookPages = true;
        }
        if (stringPrice != null && (stringPrice = stringPrice.trim()).length() != 0) {
            ok_stringPrice = true;
        }
        if (stringCopies != null && (stringCopies = stringCopies.trim()).length() != 0) {
            ok_stringCopies = true;
        }

        // Insert new entry book 
        if (ok_title && ok_author && ok_category && ok_publisher && ok_stringBookEdition
                && ok_stringBookEdition && ok_stringBookPages && ok_stringCopies
                && ok_stringCopies && ok_stringISBN && ok_stringPrice) {

            try {

                long isbn = Long.parseLong(stringISBN);
                int bookEdition = Integer.parseInt(stringBookEdition);
                int bookPages = Integer.parseInt(stringBookPages);
                float price = Float.parseFloat(stringPrice);
                int noOfCopies = Integer.parseInt(stringCopies);

                Book book = new Book();

                book.setTitle(title);
                book.setAuthor(author);
                book.setIsbn(isbn);
                book.setPublisher(publisher);
                book.setBookEdition(bookEdition);
                book.setCategory(category);
                book.setBookPages(bookPages);
                book.setPrice(price);
                book.setNoOfCopies(noOfCopies);

                // get result of status after insert
                int status = BookDao.insert(book);

                if (status > 0) {
                    out.print("<p><b>Insert Completed (Record saved successfully!)<b></p>");
                } else {
                    out.println("Insert Error: Sorry! unable to save book entry in database");
                }
            } catch (NumberFormatException nfe) {
                out.println("<b><p style=\"font-family:verdana; color:Red;\">Error message - Wrong format<p></b>"
                        + "<p>Fields: [long]ISBN,  [int]Edition,  [int]Pages,  [float]Price  and  [int]No. of copies </p>");
            }
        } else {
            out.println("<b><p style=\"font-family:verdana; color:Red; font-size: 20px;\">Error: A field that must not be null is empty.</p></b>");
        }
        // Go back to NewEntry.html and include the response
        request.getRequestDispatcher("NewEntry.html").include(request, response);
        
        // close PrintWriter
        out.close();
    }
}

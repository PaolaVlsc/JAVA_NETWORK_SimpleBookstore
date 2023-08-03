/* cs161020 - UniWa
 * Paola Velasco
 * JAVA Web Programming
 **************************************************************
 * Servlet responsible for the update of a book 
 **************************************************************
 */
package com.bookstore.servlets;

import com.bookstore.beans.Book;
import com.bookstore.dao.BookDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {

    private static String messageStatus;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean ok_title = false, ok_author = false, ok_stringISBN = false,
                ok_publisher = false, ok_stringBookEdition = false, ok_category = false,
                ok_stringBookPages = false, ok_stringPrice = false, ok_stringCopies = false;

        //Set the response message's MIME type
        response.setContentType("text/html");

        // Allocate an output writer to write the Response Message Body
        PrintWriter out = response.getWriter();

        // Get data from EditServlet through the parameters
        String stringId = request.getParameter("id");
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

        // Update entry book 
        if (ok_title && ok_author && ok_category && ok_publisher && ok_stringBookEdition
                && ok_stringBookEdition && ok_stringBookPages && ok_stringCopies
                && ok_stringCopies && ok_stringISBN && ok_stringPrice) {

            try {

                int id = Integer.parseInt(stringId);
                long isbn = Long.parseLong(stringISBN);
                int bookEdition = Integer.parseInt(stringBookEdition);
                int bookPages = Integer.parseInt(stringBookPages);
                float price = Float.parseFloat(stringPrice);
                int noOfCopies = Integer.parseInt(stringCopies);

                Book book = new Book();

                book.setId(id);
                book.setTitle(title);
                book.setAuthor(author);
                book.setIsbn(isbn);
                book.setPublisher(publisher);
                book.setBookEdition(bookEdition);
                book.setCategory(category);
                book.setBookPages(bookPages);
                book.setPrice(price);
                book.setNoOfCopies(noOfCopies);

                // get result of status after update
                int status = BookDao.update(book);

                if (status > 0) {
                    messageStatus = ("<p><b>STATUS:</b> Update Completed (Changes saved successfully!)</p>");
                } else {
                    messageStatus = ("<p><b>STATUS:</b> Update Error - Sorry! unable to save changes in database");
                }
            } catch (NumberFormatException nfe) {
                messageStatus = ("<b>Update Error message</b> "
                        + "Fields: [long]ISBN,  [int]Edition,  [int]Pages,  [float]Price  and  [int]No. of copies <br/>" + nfe + "<p><br/></p>");
            }
        } else {
            messageStatus = ("<b><p style=\"font-family:verdana; color:Red; font-size: 16px;\">Update Error: A field is empty.</p></b>");
        }
        // Go back to ViewAllServlet and send the message
        response.sendRedirect("ViewAllServlet?message=" + URLEncoder.encode(messageStatus, "UTF-8"));

        // close PrintWriter
        out.close();
    }
}

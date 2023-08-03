/* cs161020 - UniWa
 * Paola Velasco
 * JAVA Web Programming
 **************************************************************
 * Servlet responsible for the update of no of copies of a book 
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

public class UpdateServletOrder extends HttpServlet {

    private static String messageStatus;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean ok_quantity = false;

        //Set the response message's MIME type
        response.setContentType("text/html; charset=UTF-8");

        // Allocate an output writer to write the Response Message Body
        PrintWriter out = response.getWriter();

        // Get data from OrderServlet through the parameters
        String stringId = request.getParameter("id");
        int id = Integer.parseInt(stringId);
        String strQuantity = request.getParameter("quantity");

        // check if text field for quantity is empty
        if (strQuantity != null && (strQuantity = strQuantity.trim()).length() != 0) {
            ok_quantity = true;
        }

        // Update number of copies of book 
        if (!ok_quantity) {
            // out.println("Error: Quantity Field is empty");
            messageStatus = ("<b><p style=\"font-family:verdana; color:Red; font-size: 12px;\">Error: Quantity Field is empty</p></b>");
        } else {
            try {

                int quantity = Integer.parseInt(strQuantity);
                
                // retrieve book details 
                Book book = BookDao.getBookById(id);
                
                // get result of status after update
                int status = BookDao.order(book, quantity);

                if (status > 0) {
                    messageStatus = ("<p><b>Status of order:</b> Successful Order</p>");
                } else {
                    messageStatus = ("<p><b>Status of order:</b> Out of stock</p>");
                }
            } catch (NumberFormatException nfe) {
                messageStatus = ("<b><p style=\"font-family:verdana; color:Red; font-size: 13px;\">Error: Input value is not valid [int]Quantity</p></b>");
            }
        }

        // Go back to OrderServlet and send the message
        response.sendRedirect("OrderServlet?message=" + URLEncoder.encode(messageStatus, "UTF-8"));
        // close PrintWriter
        out.close();
    }
}

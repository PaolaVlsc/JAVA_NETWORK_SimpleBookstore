/* cs161020 - UniWa
 * Paola Velasco
 * JAVA Web Programming
 **************************************************************
 * Servlet responsible to delete a book entry 
 **************************************************************
 */
package com.bookstore.servlets;

import com.bookstore.dao.BookDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

    private static String messageStatus;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieve parameter id from ViewAllServlet
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        // get result of status after delete
        int status = BookDao.delete(id);
        if (status > 0) {
            messageStatus = ("<p><b>STATUS:</b> Delete completed - book entry removed</p>");
        } else {
            messageStatus = ("<p><b>STATUS:</b> Delete Error - Sorry! unable to delete entry in database<p>");
        }
        // Redirect to ViewAllServlet
        response.sendRedirect("ViewAllServlet?message=" + URLEncoder.encode(messageStatus, "UTF-8"));
    }
}

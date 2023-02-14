/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author mdkul
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = (String) request.getParameter("action");
        if(action != null){
            if(action.equals("logout")){
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
            else{
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            }
        }
        else{
            if(session.getAttribute("username") != null){
                ArrayList<String> list = (ArrayList<String>)session.getAttribute("array");
                request.setAttribute("theStuff", list);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            }
            else{
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String action = request.getParameter("action");
            HttpSession session = request.getSession();
            
         if(action.equals("register")){
             String username = request.getParameter("username");
             session.setAttribute("username", username);
             ArrayList<String> array = new ArrayList<>();
             session.setAttribute("array", array);
             getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
         }
         else if(action.equals("add")){
             ArrayList<String> list = (ArrayList<String>)session.getAttribute("array");
             String theItem = request.getParameter("item");
             list.add(theItem);
             session.setAttribute("array", list);
             request.setAttribute("theStuff", list);
             getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
         }
         else if(action.equals("delete")){
             ArrayList<String> list = (ArrayList<String>)session.getAttribute("array");
             String remove = (String)request.getParameter("contents");
             list.remove(remove);
             session.setAttribute("array", list);
             request.setAttribute("theStuff", list);
             getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
         }
         else{
             getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
         }
         
         
    }

}

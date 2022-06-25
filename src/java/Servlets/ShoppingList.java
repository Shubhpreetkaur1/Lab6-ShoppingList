
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShoppingList extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = (String) session.getAttribute("username");
        if(action != null){
        if(action.equals("logout")){
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
       return;
        }
       if(username != null){
          getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
       return;  
       }}
       getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
       return;
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        ArrayList<String> itemsList = (ArrayList<String>)session.getAttribute("itemslist");
        
        if(itemsList == null){
            itemsList = new ArrayList<>();
        }
        if(action != null){
            if(action.equals("register")){
                String username = request.getParameter("username");
                session.setAttribute("username",username);
                  getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
       return;
            }
            else if(action.equals("add")){
             String item = request.getParameter("item");
             if(item==null || item.equals("")){
                 request.setAttribute("message1", "Please an an item");
                 getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
       return;
                 }
             itemsList.add(item);
                 session.setAttribute("itemsList", itemsList);
                   getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
       return;
                
            }
            else if (action.equals("delete")){
               String item2 = request.getParameter("Items");
            if(item2 == null || item2.equals("")){
                request.setAttribute("message2", "Please select an item");
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
       return;
                }
            itemsList.remove(item2);
            
            session.setAttribute("itemsList", itemsList);
                   getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
       return;
            }
        }  
    } 
}

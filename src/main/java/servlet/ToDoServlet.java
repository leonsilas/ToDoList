package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.ToDo;
import models.ToDoModel;

/**
 * Servlet implementation class ToDoServlet
 */
@WebServlet("/todo")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ToDo toDoTask = new ToDo();
    ToDoModel taskModel = new ToDoModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Gets called by the server
	 * note: the doGet() method is called by the server (via the service method) to 
	 * allow a servlet to handle a GET request. Generally, we use the doGet() method 
	 * for getting the information from the server.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("addTask")!=null){
            String todo = request.getParameter("task");
            toDoTask.setTask(todo);
            taskModel.create(toDoTask);
            RequestDispatcher rd = request.getRequestDispatcher("todoadd.jsp");
            rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Gets called by the server
	 * note: The doPost() method is called by the server (via the service method) to allow 
	 * a servlet to handle a POST request. Generally, we use the doPost() method for 
	 * sending information to the server like HTML form data.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// shows all the todo tasks
		if(request.getParameter("showAll") != null) {
			List<ToDo> todos = new ArrayList<>();
			todos = taskModel.findAll();
			request.setAttribute("todos", todos);
			RequestDispatcher rd = request.getRequestDispatcher("todoadd.jsp");
			rd.forward(request, response);
		}
		
		// deletes a todo task
		if(request.getParameter("deleteTask") != null) {
			int idNum = Integer.parseInt(request.getParameter("id"));
			toDoTask.setId(idNum);
			taskModel.delete(toDoTask);
			RequestDispatcher rd = request.getRequestDispatcher("todoadd.jsp");
			rd.forward(request, response);
		}
	}

}

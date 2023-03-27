package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.PostDAO;
import Model.PostVO;

/**
 * Servlet implementation class PostsController
 */
@WebServlet(value={"/posts", "/posts/insert", "/posts/read", "/posts/update"})
public class PostsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostDAO dao = new PostDAO();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		switch(request.getServletPath()) {
		case "/posts" :
			request.setAttribute("list", dao.list());
			request.setAttribute("pageName", "posts.jsp");
			dis.forward(request, response);
			break;
		case "/posts/insert" :
			request.setAttribute("pageName", "insert.jsp");
			dis.forward(request, response);
			break;
		case "/posts/read" :
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("vo", dao.read(id));
			request.setAttribute("pageName", "read.jsp");
			dis.forward(request, response);
			break;
		case "/posts/update" :
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("vo", dao.read(id));
			request.setAttribute("pageName", "update.jsp");
			dis.forward(request, response);
			break;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		switch(request.getServletPath()) {
		case "/posts/insert" :
//			System.out.println("insert post...");
			PostVO vo = new PostVO();
			vo.setTitle(request.getParameter("title"));
			vo.setBody(request.getParameter("body"));
			vo.setWriter(request.getParameter("writer"));
//			System.out.println(vo.toString());
			dao.insert(vo);
			response.sendRedirect("/posts");
		case "/posts/delete" :
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("id...." + id);
			dao.delete(id);
			break;
		case "/posts/update" :
			vo = new PostVO();
			vo.setId(Integer.parseInt(request.getParameter("id")));
			vo.setTitle(request.getParameter("title"));
			vo.setBody(request.getParameter("body"));
			vo.setWriter(request.getParameter("writer"));
//			System.out.println(vo.toString());
			dao.update(vo);
			response.sendRedirect("/posts");
		}
	}

}

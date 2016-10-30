package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TrainDao;
import entity.TrainInfo;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TrainDao trainDao = new TrainDao();
		List<TrainInfo> list = trainDao.getAllTrain();
		// request.setAttribute("list", list);
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		request.getRequestDispatcher("/trainList.jsp").forward(request, response);
		// response.sendRedirect(request.getContextPath() + "/trainList.jsp");
	}

}

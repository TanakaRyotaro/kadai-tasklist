package controllers; //データベースから複数のメッセージ情報を取得して一覧表示する

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;
import utils.DBUtil;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    EntityManager em = DBUtil.createEntityManager();

	    List<Tasks> tasks = em.createNamedQuery("getAllTasks", Tasks.class).getResultList();

	    em.close();

	    request.setAttribute("tasks", tasks);

	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/messages/index.jsp");
	    rd.forward(request, response);
	}
}
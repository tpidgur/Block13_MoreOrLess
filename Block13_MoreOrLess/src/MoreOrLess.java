
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MoreOrLess
 */
@WebServlet("/MoreOrLess")
public class MoreOrLess extends HttpServlet {
	Model model = new Model();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MoreOrLess() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.write("<form action=\"./MoreOrLess\" Method=\"POST\"><input type=\"text\" name=\"value\" value=\"\"/><input type=\"submit\"> ");

		// while(request.getParameter("value")==null){
		// }
		if (request.getParameter("value") == null) {

		} else {
			int value = 0;
			{
				try {
					value = Integer.valueOf(request.getParameter("value"));
				} catch (Exception ex) {
					out.write("<h3>Enter only digits!</h3>");
					return;
				}
			}

			if (value <= model.getMinBarrier()
					|| value >= model.getMaxBarrier()) {
				out.write("<h3>Wrong range</h3>");
			} else {
				HttpSession session = request.getSession();
				request.setAttribute("value", value);
				if (model.checkValue(value)) {
					out.println("<h3>Secret value</h3>");
					out.println(value);
					return;
				}
				Integer currentValue = (Integer) session
						.getAttribute("currentValue");
				currentValue = value;
				session.setAttribute("currentValue", currentValue);

				Integer min = (Integer) session.getAttribute("minValue");
				Integer max = (Integer) session.getAttribute("maxValue");
				min = model.getMinBarrier();
				max = model.getMaxBarrier();
				session.setAttribute("minValue", min);
				session.setAttribute("maxValue", max);
				request.getServletContext().getRequestDispatcher("/outServlet")
						.forward(request, response);

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

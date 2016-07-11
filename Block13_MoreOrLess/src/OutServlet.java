

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OutServlet
 */
@WebServlet("/outServlet")
public class OutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try( Writer out = response.getWriter() ){
			HttpSession session = request.getSession();
			int intValue=(Integer)request.getAttribute("value");
			//String secretValue = (String)session.getAttribute("currentValue");
			String value =""+intValue;
			out.write("<form action=\"./MoreOrLess\" Method=\"POST\"><input type=\"text\" name=\"value\" value=\"\"/><input type=\"submit\"> ");
			out.write("<h3>Entered value</h3>");
			out.write( value != null ? value : "null" );
			out.write("<h3>Lower bound:</h3>"+session.getAttribute("minValue"));
			out.write("<h3>Upper bound:</h3>"+session.getAttribute("maxValue"));
			
		

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				doGet(request,response);
	}

}

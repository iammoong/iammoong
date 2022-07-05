package tommy.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tommy.board.model.BoardDAO;
import tommy.board.model.BoardVO;

public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		BoardDAO dbPro = BoardDAO.getInstance();
		
		BoardVO article = dbPro.getArticle(num);
		
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/board/content.jsp";
	}

}

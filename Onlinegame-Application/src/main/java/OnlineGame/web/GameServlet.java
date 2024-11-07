package OnlineGame.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OnlineGame.dao.GameDao;
import OnlineGame.model.Game;



@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GameDao gameDao;
    
    public GameServlet() {
       this.gameDao = new GameDao();   
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/newGame":
                    showNewFormGame(request, response);
                    break;
                case "/insertGame":
                    insertGame(request, response);
                    break;
                case "/deleteGame":
                    deleteGame(request, response);
                    break;
                case "/editGame":
                    showEditFormGame(request, response);
                    break;
                case "/updateGame":
                    updateGame(request, response);
                    break;
                default:
                    listGames(request, response);
                    break;
            }  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void showNewFormGame(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("game-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertGame(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	  String gameName = request.getParameter("gameName");
          String Description = request.getParameter("Description");
          String price = request.getParameter("price");
          String Genre = request.getParameter("Genre");
          String Platform = request.getParameter("Platform");
          String Publisher = request.getParameter("Publisher");
          String Modes = request.getParameter("Modes");
          String userID = request.getParameter("userID");

          Game newGame = new Game(gameName, Description, price, Genre, Platform, Publisher, Modes, userID);
          gameDao.insertGames(newGame);
        response.sendRedirect("list_game");
    }

    private void deleteGame(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        gameDao.deleteGame(ID);
        response.sendRedirect("list_game");
    }

    private void showEditFormGame(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	int ID = Integer.parseInt(request.getParameter("ID"));
        Game existingGame = gameDao.selectGames(ID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("game-form.jsp");
        request.setAttribute("Game", existingGame);
        dispatcher.forward(request, response);
    }

    private void updateGame(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        String gameName = request.getParameter("gameName");
        String Description = request.getParameter("Description");
        String price = request.getParameter("price");
        String Genre = request.getParameter("Genre");
        String Platform = request.getParameter("Platform");
        String Publisher = request.getParameter("Publisher");
        String Modes = request.getParameter("Modes");
        String userID = request.getParameter("userID");
        
        Game game = new Game(ID,gameName, Description, price, Genre, Platform, Publisher, Modes, userID);
        gameDao.updateGames(game);
        response.sendRedirect("list_game");
    }

    private void listGames(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Game> listGames = gameDao.selectAllGames();
        request.setAttribute("listGames", listGames);
        RequestDispatcher dispatcher = request.getRequestDispatcher("game-list.jsp");
        dispatcher.forward(request, response);
    }
    
    

}

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



@WebServlet("/GameByUserServlet")
public class GameByUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameDao gameDao;   
    
    public GameByUserServlet() {
    	this.gameDao = new GameDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/newGameUser":
                    showNewFormGameUser(request, response);
                    break;
                case "/insertGameUser":
                    insertGameUser(request, response);
                    break;
                case "/deleteGameUser":
                    deleteGameUser(request, response);
                    break;
                case "/editGameUser":
                    showEditFormGameUser(request, response);
                    break;
                case "/updateGameUser":
                    updateGameUser(request, response);
                    break;
                case "/listAllGames":
                	listAllGames(request, response);
                    break;    
                
                default:
                    listGamesUser(request, response);
                    break;
            }  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void showNewFormGameUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("sell-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertGameUser(HttpServletRequest request, HttpServletResponse response)
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
        response.sendRedirect("sell_Item");
    }

    private void deleteGameUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        gameDao.deleteGame(ID);
        response.sendRedirect("sell_Item");
    }

    private void showEditFormGameUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	int ID = Integer.parseInt(request.getParameter("ID"));
        Game existingGame = gameDao.selectGames(ID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sell-form.jsp");
        request.setAttribute("Game", existingGame);
        dispatcher.forward(request, response);
    }

    private void updateGameUser(HttpServletRequest request, HttpServletResponse response)
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
        response.sendRedirect("sell_Item");
    }

    private void listGamesUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        // Get the userID from the session attribute
    	
        String userID = (String) request.getSession().getAttribute("userID");
        
        // Call the DAO method to fetch Games by userID
        List<Game> listGamesUser = gameDao.selectGamesByUserID(userID);

        // Set the attribute for the list of Games
        request.setAttribute("listGamesUser", listGamesUser);

        // Forward the request to the Game-list.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("sell-Item.jsp");
        dispatcher.forward(request, response);
    }


    private void listAllGames(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Game> listGames = gameDao.selectAllGames();
        request.setAttribute("listGames", listGames);
        RequestDispatcher dispatcher = request.getRequestDispatcher("all_games.jsp");
        dispatcher.forward(request, response);
    }
    
   
}


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
import OnlineGame.dao.PaymentDao;
import OnlineGame.model.Payment;

@WebServlet("/PaymentByUser")
public class PaymentByUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PaymentDao paymentDao;

    public PaymentByUser() {
        this.paymentDao = new PaymentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/newPaymentUser":
                    showNewFormPaymentUser(request, response);
                    break;
                case "/insertPaymentUser":
                    insertPaymentUser(request, response);
                    break;
                case "/deletePaymentUser":
                    deletePaymentUser(request, response);
                    break;
                case "/editPaymentUser":
                    showEditFormPaymentUser(request, response);
                    break;
                case "/updatePaymentUser":
                    updatePaymentUser(request, response);
                    break;
                default:
                    listPaymentsUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewFormPaymentUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("paymentUser-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPaymentUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String userID = request.getParameter("userID");
        String paymentMethod = request.getParameter("paymentMethod");
        String cardHolderName = request.getParameter("name");
        String emailAddress = request.getParameter("email-address");
        double amount = Double.parseDouble(request.getParameter("amount"));
        long cardNumber = Long.parseLong(request.getParameter("card-number"));
        String expiryDate = request.getParameter("expiry-date");
        int cvv = Integer.parseInt(request.getParameter("cvv"));

        Payment newPayment = new Payment(userID, paymentMethod, cardHolderName, emailAddress, amount, cardNumber, expiryDate, cvv);
        paymentDao.insertPayment(newPayment);
        response.sendRedirect("list_paymentUser");
    }

    private void deletePaymentUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int paymentID = Integer.parseInt(request.getParameter("paymentID"));
		
		        paymentDao.deletePayment(paymentID);
		        response.sendRedirect("list_paymentUser");
    }

    private void showEditFormPaymentUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int paymentID = Integer.parseInt(request.getParameter("paymentID"));
        Payment existingPayment = paymentDao.selectPayment(paymentID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("paymentUser-form.jsp");
        request.setAttribute("Payment", existingPayment);
        dispatcher.forward(request, response);
    }

    private void updatePaymentUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
       
        int paymentID = Integer.parseInt(request.getParameter("paymentID"));
        String userID = request.getParameter("userID");
        String paymentMethod = request.getParameter("paymentMethod");
        String cardHolderName = request.getParameter("name");
        String emailAddress = request.getParameter("email-address");
        double amount = Double.parseDouble(request.getParameter("amount"));
        long cardNumber = Long.parseLong(request.getParameter("card-number"));
        String expiryDate = request.getParameter("expiry-date");
        int cvv = Integer.parseInt(request.getParameter("cvv"));

        
        Payment payment = new Payment(paymentID, userID, paymentMethod, cardHolderName, emailAddress, amount, cardNumber, expiryDate, cvv);
        boolean isUpdated = paymentDao.updatePayment(payment);
        if (isUpdated) {
            response.sendRedirect("list_paymentUser");
        } else {
         
            response.getWriter().write("Error updating payment.");
        }
    }


    private void listPaymentsUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
      
        String userID = (String) request.getSession().getAttribute("userID");
        
        System.out.println("UserID from session: " + userID);

        List<Payment> listPaymentsUser = paymentDao.selectPaymentsByUserID(userID);
        System.out.println("Payments fetched: " + listPaymentsUser.size());

        request.setAttribute("listPaymentsUser", listPaymentsUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("paymentUser-list.jsp");
        dispatcher.forward(request, response);
    }
}

package OnlineGame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import OnlineGame.model.Payment;

public class PaymentDao {
    private static final String INSERT_PAYMENT_SQL = "INSERT INTO payment_user (userID, paymentMethod, cardHolderName, emailAddress, amount, cardNumber, expiryDate, cvv) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_PAYMENT_BY_ID = "SELECT * FROM payment_user WHERE paymentID = ?";
	/*
	 * private static final String SELECT_ALL_PAYMENT =
	 * "SELECT * FROM payment_user";
	 */    
    private static final String DELETE_PAYMENT_SQL = "DELETE FROM payment_user WHERE paymentID = ?";
    private static final String UPDATE_PAYMENT_SQL = "UPDATE payment_user SET userID = ?, paymentMethod = ?, cardHolderName = ?, emailAddress = ?, amount = ?, cardNumber = ?, expiryDate = ?, cvv = ? WHERE paymentID = ?";

    // Insert a new payment record
    public void insertPayment(Payment payment) {
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PAYMENT_SQL)) {
            preparedStatement.setString(1, payment.getuserID());
            preparedStatement.setString(2, payment.getPaymentMethod());
            preparedStatement.setString(3, payment.getCardHolderName());
            preparedStatement.setString(4, payment.getEmailAddress());
            preparedStatement.setDouble(5, payment.getAmount());
            preparedStatement.setLong(6, payment.getCardNumber());
            preparedStatement.setString(7, payment.getExpiryDate());
            preparedStatement.setInt(8, payment.getCvv());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update payment details
    public boolean updatePayment(Payment payment) {
        boolean rowUpdated = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PAYMENT_SQL)) {
            statement.setString(1, payment.getuserID());
            statement.setString(2, payment.getPaymentMethod());
            statement.setString(3, payment.getCardHolderName());
            statement.setString(4, payment.getEmailAddress());
            statement.setDouble(5, payment.getAmount());
            statement.setLong(6, payment.getCardNumber());
            statement.setString(7, payment.getExpiryDate());
            statement.setInt(8, payment.getCvv());
            statement.setInt(9, payment.getPaymentID());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    // Select payment by ID
    public Payment selectPayment(int paymentID) {
        Payment payment = null;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAYMENT_BY_ID)) {
            preparedStatement.setInt(1, paymentID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String userID = rs.getString("userID");
                String paymentMethod = rs.getString("paymentMethod");
                String cardHolderName = rs.getString("cardHolderName");
                String emailAddress = rs.getString("emailAddress");
                double amount = rs.getDouble("amount");
                long cardNumber = rs.getLong("cardNumber");
                String expiryDate = rs.getString("expiryDate");
                int cvv = rs.getInt("cvv");
                payment = new Payment(paymentID, userID, paymentMethod, cardHolderName, emailAddress, amount, cardNumber, expiryDate, cvv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    // Select all payments by user ID
    public List<Payment> selectPaymentsByUserID(String userID) throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payment_user WHERE userID = ?";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int paymentID = resultSet.getInt("paymentID");
                String paymentMethod = resultSet.getString("paymentMethod");
                String cardHolderName = resultSet.getString("cardHolderName");
                String emailAddress = resultSet.getString("emailAddress");
                double amount = resultSet.getDouble("amount");
                long cardNumber = resultSet.getLong("cardNumber");
                String expiryDate = resultSet.getString("expiryDate");
                int cvv = resultSet.getInt("cvv");
                payments.add(new Payment(paymentID, userID, paymentMethod, cardHolderName, emailAddress, amount, cardNumber, expiryDate, cvv));
            }
        }
        return payments;
    }
    
		// Delete a payment record by paymentID
		public boolean deletePayment(int paymentID) {
		    boolean rowDeleted = false;
		    try (Connection connection = DBConnect.getConnection();
		         PreparedStatement statement = connection.prepareStatement(DELETE_PAYMENT_SQL)) {
		        statement.setInt(1, paymentID);
		        rowDeleted = statement.executeUpdate() > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return rowDeleted;
		}
}

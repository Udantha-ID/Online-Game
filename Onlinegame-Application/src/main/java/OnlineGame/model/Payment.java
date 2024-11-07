package OnlineGame.model;

public class Payment {
	
	private int paymentID;
	private String userID; 
	private String paymentMethod;
    private String cardHolderName;
    private String emailAddress;
    private double amount;
    private long cardNumber;
    private String expiryDate;
    private int cvv;
	
	
	public Payment(int paymentID, String userID, String paymentMethod, String cardHolderName, String emailAddress,
			double amount, long cardNumber, String expiryDate, int cvv) {
		super();
		this.paymentID = paymentID;
		this.userID = userID;
		this.paymentMethod = paymentMethod;
		this.cardHolderName = cardHolderName;
		this.emailAddress = emailAddress;
		this.amount = amount;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}

	public Payment(String userID, String paymentMethod, String cardHolderName, String emailAddress, double amount, long cardNumber, String expiryDate, int cvv) {
		super();
		this.userID = userID;
		this.paymentMethod = paymentMethod;
		this.paymentMethod = paymentMethod;
		this.cardHolderName = cardHolderName;
		this.emailAddress = emailAddress;
		this.amount = amount;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public String getuserID() {
		return userID;
	}

	public void setuserID(String userID) {
		this.userID = userID;
	}



	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getUserID() {
		return userID;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public double getAmount() {
		return amount;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	
	
	
	
}

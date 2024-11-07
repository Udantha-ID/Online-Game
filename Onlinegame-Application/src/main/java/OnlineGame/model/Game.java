package OnlineGame.model;

public class Game {

    private int id;
    private String gameName;
    private String description;
    private String price;
    private String genre;
    private String platform;
    private String Publisher;
    private String modes;
    private String userID;
   
    

    public Game(int id, String gameName, String description,String price, String genre, String platform, String Publisher, String modes, String userID) {
        this.id = id;
        this.gameName = gameName;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.platform = platform;
        this.Publisher = Publisher;
        this.modes = modes;
        this.userID = userID;
     
    }

    public Game( String gameName, String description,String price, String genre, String platform, String Publisher, String modes, String userID) {
    	 this.gameName = gameName;
         this.description = description;
         this.price = price;
         this.genre = genre;
         this.platform = platform;
         this.Publisher = Publisher;
         this.modes = modes;
         this.userID = userID;
    }

    public int getID() {
        return id;
    }

    public String getgameName() {
        return gameName;
    }

    public String getDescription() {
        return description;
    }

    public String getprice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public String getPublisher() {
        return Publisher;
    }
    public String getModes() {
        return modes;
    }
    public String getuserID() {
        return userID;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setgameName(String gameName) {
        this.gameName = gameName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setprice(String price) {
        this.price = price;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }


    public void setModes(String modes) {
        this.modes = modes;
    }
    public void setuserID(String userID) {
        this.userID = userID;
    }
    
}


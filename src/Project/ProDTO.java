package Project;

public class ProDTO {
    
    private String userId;      
    private String userPw;          
    private String userName;    
    private String userAge;
    private String userEmail;
    
    private String userAccount;
    private int userBalance;
    
    private String gamGenre;
    private String gameName;
    private String gameGrade;
    private String gamePrice;
    
    private String gameSub;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }

    public String getGamGenre() {
        return gamGenre;
    }

    public void setGamGenre(String gamGenre) {
        this.gamGenre = gamGenre;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameGrade() {
        return gameGrade;
    }

    public void setGameGrade(String gameGrade) {
        this.gameGrade = gameGrade;
    }

    public String getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(String gamePrice) {
        this.gamePrice = gamePrice;
    }

    public String getGameSub() {
        return gameSub;
    }

    public void setGameSub(String gameSub) {
        this.gameSub = gameSub;
    }

    @Override
    public String toString() {
        return "ProDTO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userAge=" + userAge
                + ", userEmail=" + userEmail + ", userAccount=" + userAccount + ", userBalance=" + userBalance
                + ", gamGenre=" + gamGenre + ", gameName=" + gameName + ", gameGrade=" + gameGrade + ", gamePrice="
                + gamePrice + ", gameSub=" + gameSub + "]";
    }

    

    public ProDTO() {
        super();
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.userAccount = userAccount;
        this.userBalance = userBalance;
        this.gamGenre = gamGenre;
        this.gameName = gameName;
        this.gameGrade = gameGrade;
        this.gamePrice = gamePrice;
        this.gameSub = gameSub;
    }

    
    
    
    
    
}
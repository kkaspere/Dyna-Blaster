package kkkg;

/**
 * Describes the game user
 */
public class User  {

    /**Stores how much points user got */
    private int Score;
    /**Stores unique user's nickname */
    private String NickName;


    public User()
    {

        Score = 0;
        NickName = "";

    }
    public User(String NickName, int Score)
    {

        this.NickName = NickName;
        this.Score = Score;


    }
    public void setNick(String Nickname)
    {
        this.NickName = Nickname;
    }
    public void setScore(int Score)
    {
        this.Score = Score;

    }
    public int getScore()
    {
        return Score;

    }
    public String getNick()
    {
        return NickName;
    }
}

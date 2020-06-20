package kkkg;


/**
 * Describes the game user
 */
public class User {

    /**Stores how much points user got */
    private int Score;
    /**Stores unique user's nickname */
    private String NickName;
    /**Stores number of remaining lifes */
    private int Lifes;

    public User()
    {

        Score = 0;
        Lifes = 3;
        NickName = "";

    }
    public User(String NickName, int Score)
    {

        this.NickName = NickName;
        this.Score = Score;
        Lifes = 3;

    }
    public void setNick(String Nickname)
    {
        this.NickName = Nickname;
    }
    public void setLifes(int lifes){this.Lifes = lifes;}
    public void setScore(int Score)
    {
        this.Score = Score;

    }
    public int getScore()
    {
        return Score;

    }
    public int getLifes()
    {

        return Lifes;
    }
    public String getNick()
    {
        return NickName;
    }

    /**
     * Adds score when enemy is killed
     */
    public void EnemyKilledAddScore()
    {
        Score+=Config.EnemyKillScore;
    }
    /**
     * Multiply score depends on difficulty level
     */
    public void ScoreMultipier()
    {

        if(GameManager.Difficulty == DifficultyLevel.EASY)
            Score = Score * Config.MultEasy;
        else if(GameManager.Difficulty == DifficultyLevel.MEDIUM)
            Score = Score * Config.MultMedium;
        else
            Score = Score * Config.MultHard;

    }
    /**
     * Add score depends on how much time user needed to complete the game
     * @param minutes Conditions how much score will user gain
     */
    public void ScoreForTimeAdder(int minutes)
    {

        if(minutes < 1)
            Score+=Config.TimeBonus*10;
        else if(minutes < 2)
            Score+=Config.TimeBonus*9;
        else if(minutes < 3)
            Score+=Config.TimeBonus*8;
        else if(minutes < 4)
             Score +=Config.TimeBonus*7;
        else if (minutes < 5)
            Score+=Config.TimeBonus*6;

    }
    public void AddBonusPointsGold()
    {
        Score+=Config.Bonus_3;
    }
    public void AddBonusPointsSilver()
    {
        Score+=Config.Bonus_2;
    }
    public void AddBonusPointsBrown()
    {
        Score+=Config.Bonus_1;
    }

}

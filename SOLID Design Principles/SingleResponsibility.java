//Bad practice

// interface IUser{
//     public boolean Login(String username,String password);
//     public boolean Register(String username,String password,String email); 
//     public void LogError(String error);
//     public boolean SendEmail(String emailContent);
// }

/**
 * SingleResponsibility: In here we have separated The user login/Register from user log and sendEmail interfaces thus making it follow
 * Single Responsibility principle which states that each module or class should have a single
 * responsibility.
 */
interface IUser {
    public boolean Login(String username,String password);
    public boolean Register(String username,String password,String email); 
}

interface ILogger{
    public void LogError(String error);
}

interface IEmail{
    public boolean SendEmail(String emailContent);
}

public class SingleResponsibility {

}
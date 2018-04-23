package model;
 
import dao.DAOException;
import dao.MemberDao;
 
public class RegisterUserLogic {
  MemberDao memberDao = new MemberDao();
    public boolean exute(User user){
        boolean registCheck = false;
        //“o˜^ˆ—
        try {
            memberDao.insertMember(user);
            registCheck = true;
        } catch (DAOException e) {
            // TODO ©“®¶¬‚³‚ê‚½ catch ƒuƒƒbƒN
            e.printStackTrace();
        }
        return registCheck;
    }
}
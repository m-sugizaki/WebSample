package model;
 
import dao.DAOException;
import dao.MemberDao;
 
public class RegisterUserLogic {
  MemberDao memberDao = new MemberDao();
    public boolean exute(User user){
        boolean registCheck = false;
        //�o�^����
        try {
            memberDao.insertMember(user);
            registCheck = true;
        } catch (DAOException e) {
            // TODO �����������ꂽ catch �u���b�N
            e.printStackTrace();
        }
        return registCheck;
    }
}
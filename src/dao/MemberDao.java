package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import model.User;
 
public class MemberDao {
 
    private Connection con = null;  // �R�l�N�V�����I�u�W�F�N�g
    private Statement stmt = null;  // �X�e�[�g�����g�I�u�W�F�N�g
    private ConnectionManager cm; // �R�l�N�V�����}�l�[�W���[
 
    // Connection�̎擾
    private void getConnection() throws DAOException{
        if ( this.con != null ){ return;    }
        cm = ConnectionManager.getInstance();
        con = cm.getConnection(); // �f�[�^�x�[�X�ւ̐ڑ��̎擾
    }
 
    // Statement�̎擾
    private void createStmt() throws DAOException{
        if ( this.stmt != null){    return; }
        try {
            stmt =con.createStatement();
        } catch (SQLException e) {  // SQL�Ɋւ����O����
            throw new DAOException("[createStmt]�ُ�", e);
        }
    }
 
    // �f�[�^��ǉ�
    public int insertMember(User user) throws DAOException {
        getConnection();
        int count = 0;
        String sql = "INSERT INTO member (id, name, pass) VALUES(?, ?, ?)";
        int id = Integer.parseInt(user.getId());
        String name = user.getName();
        String pass = user.getPass();
 
        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, pass);
            count += pstmt.executeUpdate();
        } catch(SQLException e) {
            throw new DAOException("[UserDAO#insertMember]�ُ�", e);
        } finally {
            close();
        }
        return count;
    }
 
    private void close() throws DAOException {
        try {
            if (stmt != null) { stmt.close(); }
        } catch (SQLException e) {
            throw new DAOException("[closeStatement]�ُ�", e);
        } finally {
            this.stmt = null;
            this.cm = null;
        }
    }
}
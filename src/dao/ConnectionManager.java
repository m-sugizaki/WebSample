package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConnectionManager {
 
    // URL�E���[�U���E�p�X���[�h�̐ݒ�
    private final static String URL = "jdbc:mysql://localhost:3306/webdb?useSSL=false";
    private final static String USER = "root";
    private final static String PASSWORD = "root";
    // �R�l�N�V�����I�u�W�F�N�g
    private Connection connection = null;
 
     // ���̃N���X�ɗB��̃C���X�^���X
    private static ConnectionManager instance = new ConnectionManager();
 
    /*
     * static�������q
     */
    static {
        // JDBC�h���C�o�̃��[�h
        String drv = "com.mysql.jdbc.Driver";
        try {
            Class.forName(drv);
        } catch (ClassNotFoundException e) {
            System.out.println("�h���C�o������܂���" + e.getMessage());
        }
    }
 
    /**
     * �R���X�g���N�^
     */
    private ConnectionManager() {   }
    /*
     * �C���X�^���X�擾���\�b�h
     */
    public static ConnectionManager getInstance() { return instance; }
 
    /**
     * DB�̐ڑ�     *
     * @return �R�l�N�V����
     * @throws Exception
     */
    public synchronized Connection getConnection() throws DAOException {
        //  �R�l�N�V�����̊m��
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            connection = null;
            throw new DAOException("[conect]�ُ�", e);
        }
        return connection;
    }
 
    /**
     * DB�̐ؒf
     */
    public void closeConnection() throws DAOException{
        try {
            if (connection != null) {   connection.close(); }
        } catch (SQLException e) {
            throw new DAOException("[closeConnection]�ُ�", e);
        } finally {
            connection = null;
        }
    }
}
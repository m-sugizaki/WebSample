/*
 * JDBCSample02
 * DAOException.java
 */
 
package dao;
 
/**
 * �f�[�^�A�N�Z�X�I�u�W�F�N�g��O
 */
public class DAOException extends Exception {
    /**
     * @param str
     * @param th
     */
    public DAOException(String str, Throwable th) {
        super(str, th);
    }
}
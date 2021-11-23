package com.koreait.board.user;

import com.koreait.board.model.BoardVO;
import com.koreait.board.model.UserVO;
import com.koreait.board.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    static private Connection con = null;
    static private PreparedStatement ps = null;
    static private ResultSet rs = null;

    public static int login(UserVO param){
        String sql = "SELECT iuser, upd, nm FROM t_user WHERE uid = ?";

        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, param.getUid());
            rs = ps.executeQuery();

            if (rs.next()){
                String dbUpd = rs.getString("upd");
                if (dbUpd.equals(param.getUpd())){
                    param.setIuser(rs.getInt("iuser"));
                    param.setNm(rs.getString("nm"));
                    return 1; //성공
                }else {
                    return 3;//비번 실패
                }
            }else{
                return 2;//아이디 없음
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(con, ps, rs);
        }
        return 0;//로그인 실패
    }

    public static int join(UserVO param){
        String sql = "INSERT INTO t_user(uid, upd, nm, gender) VALUES(?, ?, ?, ?)";

        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, param.getUid());
            ps.setString(2, param.getUpd());
            ps.setString(3, param.getNm());
            ps.setInt(4, param.getGender());
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(con, ps);
        }
        return 0;
    }
}

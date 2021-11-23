package com.koreait.board.board;

import com.koreait.board.model.BoardVO;
import com.koreait.board.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    static private Connection con = null;
    static private PreparedStatement ps = null;
    static private ResultSet rs = null;

    public static List<BoardVO>BoardList(){
        List<BoardVO> list = new ArrayList<>();
        BoardVO param = null;
        String sql = "SELECT A.iboard, A.title, A.rdt, B.nm as writerNm FROM t_board A INNER JOIN t_user B " +
                "ON A.writer = B.iuser ORDER BY iboard DESC";

        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                param = new BoardVO();
                param.setIboard(rs.getInt("iboard"));
                param.setTitle(rs.getString("title"));
                param.setRdt(rs.getString("rdt"));
                param.setWriterNm(rs.getString("writerNm"));
                list.add(param);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(con, ps , rs);
        }
        return list;
    }

    public static int writeBoard(BoardVO param){
        String sql = "INSERT INTO t_board(title, ctnt ,writer) VALUE (?, ?, ?)";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, param.getTitle());
            ps.setString(2, param.getCtnt());
            ps.setInt(3, param.getWriter());
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(con, ps , rs);
        }
        return 0;
    }

    public static BoardVO selBoard(BoardVO param){
        String sql = "SELECT A.iboard, A.title, A.ctnt, A.rdt,A.mdt, B.nm AS writeNm FROM t_board A " +
                "INNER JOIN t_user B ON A.writer = B.iuser WHERE iboard = ?";
        BoardVO vo = null;
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getIboard());
            rs = ps.executeQuery();
            if (rs.next()){
               vo = new BoardVO();
               vo.setIboard(rs.getInt("iboard"));
               vo.setTitle(rs.getString("title"));
               vo.setCtnt(rs.getString("ctnt"));
               vo.setRdt(rs.getString("rdt"));
               vo.setMdt(rs.getString("mdt"));
               vo.setWriterNm(rs.getString("writeNm"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(con, ps , rs);
        }
        return vo;
    }

    public static int delBoard(BoardVO param){
        String sql = "DELETE FROM t_board WHERE iboard = ? AND writer = ?";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getIboard());
            ps.setInt(2, param.getWriter());
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(con, ps , rs);
        }
        return 0;
    }

}

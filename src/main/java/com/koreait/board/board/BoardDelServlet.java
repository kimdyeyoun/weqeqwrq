package com.koreait.board.board;

import com.koreait.board.model.BoardVO;
import com.koreait.board.model.UserVO;
import com.koreait.board.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/del")
public class BoardDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardVO vo = new BoardVO();
        vo.setIboard(Integer.parseInt(req.getParameter("iboard")));
        BoardVO pa = BoardDAO.selBoard(vo);
        req.setAttribute("data", pa);
        BoardDAO.delBoard(pa);
        res.sendRedirect("/board/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}

package com.koreait.board.board;

import com.koreait.board.model.BoardVO;
import com.koreait.board.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardVO vo = new BoardVO();
        vo.setIboard(Integer.parseInt(req.getParameter("iboard")));
        BoardVO pa = BoardDAO.selBoard(vo);
        req.setAttribute("data", pa);
        MyUtils.disForward(req, res, "board/mod");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");
        int iboard = Integer.parseInt(req.getParameter("iboard"));

        BoardVO vo = new BoardVO();
        vo.setTitle(title);
        vo.setCtnt(ctnt);
        vo.setIboard(iboard);
        vo.setWriter(MyUtils.getLoginUserPk(req));

        int result = BoardDAO.UpdBoard(vo);

        switch (result) {
            case 1:
                res.sendRedirect("/board/detail?iboard=" + vo.getIboard());
                break;
            default:
                req.setAttribute("data", vo);
                req.setAttribute("err", "글 수정 실패");
                doGet(req, res);
                break;
        }
    }
}

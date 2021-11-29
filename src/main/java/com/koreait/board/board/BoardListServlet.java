package com.koreait.board.board;

import com.koreait.board.model.BoardVO;
import com.koreait.board.model.PageVO;
import com.koreait.board.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int record = 5;
        PageVO pv = new PageVO();
        pv.setRecord(record);

        req.setAttribute("maxPage", BoardDAO.selMaxPage(pv));
        int page = MyUtils.getParamaterInt(req, "page", 1);
        if (page <= 0 || page>BoardDAO.selMaxPage(pv)){
            page = 1;
        }
        pv.setPage(page);

        req.setAttribute("list", BoardDAO.BoardList(pv));
        MyUtils.disForward(req, res, "/board/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}

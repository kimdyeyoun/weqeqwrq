package com.koreait.board.user;

import com.koreait.board.model.BoardVO;
import com.koreait.board.model.UserVO;
import com.koreait.board.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MyUtils.disForward(req, res, "user/join");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String upd = req.getParameter("upd");
        String nm = req.getParameter("nm");
        int gender = Integer.parseInt(req.getParameter("gender"));

        UserVO vo = new UserVO();
        vo.setUid(uid);
        vo.setUpd(upd);
        vo.setNm(nm);
        vo.setGender(gender);

        int result = UserDAO.join(vo);

        switch (result){
            case 1:
                res.sendRedirect("/user/login");
                break;
            case 0:
                req.setAttribute("errjoin", "회원가입실패");
                doGet(req, res);
                break;
        }
    }
}

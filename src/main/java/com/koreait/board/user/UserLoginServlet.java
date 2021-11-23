package com.koreait.board.user;

import com.koreait.board.model.UserVO;
import com.koreait.board.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MyUtils.disForward(req, res, "user/login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String uid = req.getParameter("uid");
        String upd = req.getParameter("upd");

        UserVO vo = new UserVO();
        vo.setUid(uid);
        vo.setUpd(upd);

        int result = UserDAO.login(vo);

        if (result == 1){
            vo.setUpd(null);
            HttpSession session = req.getSession();
            session.setAttribute("loginUser", vo);
            res.sendRedirect("/board/list");
            return;
        }
        String err = null;
        switch (result){
            case 0:
                err = "로그인 실패";
                break;
            case 2:
                err = "없는 아이디 입니다";
                break;
            case 3:
                err = "비밀번호 실패";
                break;
        }
        req.setAttribute("loginerr", err);
        doGet(req, res);
    }
}

package com.koreait.board.utils;

import com.koreait.board.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyUtils {

    public static void disForward(HttpServletRequest req, HttpServletResponse res, String path) throws ServletException, IOException{
        String path1 = "/WEB-INF/view/" + path + ".jsp";
        req.getRequestDispatcher(path1).forward(req, res);
    }

    public static int parseStringTOInt(String str){
        return parseStringTOInt(str, 0);
    }

    public static int parseStringTOInt(String str, int defVal){
        //Wrapper 클래스
        try {
            return Integer.parseInt(str);
        }catch (Exception e){

        }
        return defVal;
    }

    public static int getParamaterInt(HttpServletRequest req, String key, int drfval){
        return parseStringTOInt(req.getParameter(key), drfval);
    }

    public static int getParamaterInt(HttpServletRequest req, String key){
        return parseStringTOInt(req.getParameter(key));
    }

    public static int getLoginUserPk (HttpServletRequest req){
        UserVO login = getLogininUser(req);
        return login == null ? 0 : login.getIuser();
    }

    public static boolean isLogin (HttpServletRequest req){
        return getLogininUser(req) != null;
    }

    public static boolean isLogout (HttpServletRequest req){
        return getLogininUser(req) == null;
    }

    public static UserVO getLogininUser (HttpServletRequest req){
        HttpSession session = req.getSession();
        return (UserVO) session.getAttribute("loginUser");
    }
}

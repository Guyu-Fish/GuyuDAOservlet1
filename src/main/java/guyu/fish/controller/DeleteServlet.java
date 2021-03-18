package guyu.fish.controller;

import guyu.fish.dao.ItemDao;
import guyu.fish.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "DeleteServlet",urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        System.out.println("删除id="+id);
        //创建Dao并调用删除方法
        ItemDao dao = new ItemDao();
        dao.deleteById(id);
        //重定向到列表界面
        response.sendRedirect("findall");

    }
}

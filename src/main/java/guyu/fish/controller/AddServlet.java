package guyu.fish.controller;

import guyu.fish.dao.ItemDao;
import guyu.fish.entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddServlet",urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        request.setCharacterEncoding("utf8");

        String name = request.getParameter("name");
        String count = request.getParameter("count");
        String price = request.getParameter("price");
        String type = request.getParameter("type");
        System.out.println(name+" "+count+" "+price+" "+type);

        //把接收到的参数封装到实体类中
        Item item = new Item(0,name,Integer.parseInt(count),Integer.parseInt(price),type);
        //创建dao 把数据传递给dao 让dao里面去把数据保存到数据库
        ItemDao dao = new ItemDao();
        dao.insert(item);
        //给客户端返回数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print("添加成功");
        pw.close();

    }
}

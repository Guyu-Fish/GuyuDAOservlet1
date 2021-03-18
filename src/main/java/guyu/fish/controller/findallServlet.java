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
import java.util.List;

@WebServlet(name = "findallServlet",urlPatterns = "/findall")
public class findallServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemDao dao = new ItemDao();
        List<Item> list = dao.findAll();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print("<table border=1>");
        pw.print("<caption></caption>");
        pw.print("<tr>\n" +
                "    <th>id</th>\n" +
                "    <th>商品名</th>\n" +
                "    <th>库存</th>\n" +
                "    <th>价格</th>\n" +
                "    <th>类型</th>\n" +
                "    <th>操作</th>\n" +
                "</tr>");

        //遍历商品信息
        for(Item i : list){
            pw.print("<tr>\n" +
                    "    <td>"+i.getId()+"</td>\n" +
                    "    <td>"+i.getName()+"</td>\n" +
                    "    <td>"+i.getCount()+"</td>\n" +
                    "    <td>"+i.getPrice()+"</td>\n" +
                    "    <td>"+i.getType()+"</td>\n" +
                    "    <td><a href='delete?id="+i.getId()+"'>删除</a></td>" +
                    "</tr>");
        }
        pw.print("</table>");
        pw.close();
    }
}

package guyu.fish.dao;

import guyu.fish.entity.Item;
import guyu.fish.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    public void insert(Item item) {
        //获取连接
        try(Connection conn = DBUtils.getConn()) {
            String sql = "insert into item values(null,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,item.getName());
            ps.setInt(2,item.getCount());
            ps.setInt(3,item.getPrice());
            ps.setString(4,item.getType());
            ps.executeUpdate();
            System.out.println("添加完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Item> findAll() {
        //准备一个空集合 用来装Item对象
        ArrayList<Item> list = new ArrayList<>();

        //获取连接
        try(Connection conn = DBUtils.getConn()) {
            String sql = "select *from item";
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int count = rs.getInt("count");
                int price = rs.getInt("price");
                String type = rs.getString("type");
                //把数据封装到对象中 并添加到集合
                list.add(new Item(id,name,count,price,type));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteById(String id) {
        //获取连接
        try(Connection conn = DBUtils.getConn()) {
            String sql = "delete from item where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(id));
            ps.executeUpdate();
            System.out.println("删除完成");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

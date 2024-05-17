package com.echo.dao;

import com.echo.javabean.Clrk;
import com.echo.utils.JDBCUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CltzbDao {
    public int clrkCount(){
        Connection con = JDBCUtils.getConnection();
        PreparedStatement pstmt1 = null;
        ResultSet resultSet = null;
        int count = 0;
        String selectSQL = "select count(*) as total from `clrk`"; //查询clrk表记录总数
        try {
            pstmt1 = con.prepareStatement(selectSQL);
            // 执行查询语句并获取结果
            resultSet = pstmt1.executeQuery();

            while (resultSet.next()) {
                // 处理结果
                //打印数据信息
                count = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } finally {
            // 最后关闭连接资源
            JDBCUtils.close(con, pstmt1, resultSet);
        }
        return count;
    }

    public int clrkInsert(Clrk clrk) throws SQLException {
        Connection connection = null;
        ResultSet resultSet = null;
        CltzbDao cltzbDao = new CltzbDao();
        int id = 0;
        int i = 0;
        id = cltzbDao.clrkCount() + 1;
        String ckbh = clrk.getCkbh();
        String hh = clrk.getHh();
        Integer sl = clrk.getSl();
        Double dj =  clrk.getDj();
        Double je =  clrk.getJe();
        String ywlb = clrk.getYwlb();
        connection = JDBCUtils.getConnection();
        String sql = "insert into clrk(id,ckbh,hh,sl,dj,je,ywlb) values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        try {
            pstmt.setInt(1,id);
            pstmt.setString(2,ckbh);
            pstmt.setString(3,hh);
            pstmt.setInt(4,sl);
            pstmt.setDouble(5, dj);
            pstmt.setDouble(6,je);
            pstmt.setString(7,ywlb);
            i = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,pstmt,resultSet);
        }
        return i;
    }

    public static void main(String args[]) throws SQLException {
        CltzbDao cltzbDao = new CltzbDao();
        Clrk clrk = new Clrk();
        int count = 0;
        count = cltzbDao.clrkCount();
        System.out.println(count);
        System.out.println("完成");
    }
}

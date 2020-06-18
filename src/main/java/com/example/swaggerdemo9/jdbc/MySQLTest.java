package com.example.swaggerdemo9.jdbc;

import com.example.swaggerdemo9.entry.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class MySQLTest {
    private Connection con = null;
    private PreparedStatement pt = null;
    private ResultSet rt = null;
    public List<Student> getConnection() {
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
                con = DriverManager.getConnection(url, "root", "123456");
                List<Student> list=new ArrayList<>();
                String sql = "select * from students";
                pt = con.prepareStatement(sql);
                rt = pt.executeQuery();
                while (rt.next()) {
                    Student student=new Student();
                    student.setId(rt.getInt(1));
                    student.setName(rt.getString(2));
                    student.setAge(rt.getInt(3));
                    student.setSex(rt.getString(4));
                    list.add(student);
                    System.out.println(rt.getInt(1) + "\t" + rt.getString(2) + rt.getInt(3) + rt.getString(4));
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            finally {
                if (rt != null) {
                    try {
                        rt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    rt = null;
                }
                if (pt != null) {
                    try {
                        pt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    pt = null;
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    con = null;
                }
            }
        }
    }

    public Student getStudent(Integer id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            con = DriverManager.getConnection(url, "root", "123456");
            String sql = "select * from students where id=?";
            pt = con.prepareStatement(sql);
            pt.setInt(1,id);
            rt = pt.executeQuery();
            Student student=new Student();
            if (rt.next()) {
                student.setId(rt.getInt(1));
                student.setName(rt.getString(2));
                student.setAge(rt.getInt(3));
                student.setSex(rt.getString(4));
                System.out.println(rt.getInt(1) + "\t" + rt.getString(2) + rt.getInt(3) + rt.getString(4));
            }
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if (rt != null) {
                try {
                    rt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rt = null;
            }
            if (pt != null) {
                try {
                    pt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                pt = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                con = null;
            }
        }
    }
}

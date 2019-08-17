package JdbcTest;


import java.sql.*;

public class Jdbc {
    public static void main(String[] args) {
        Connection con;
        String driver="com.mysql.jdbc.Driver";
        //这里我的数据库是qcl
        String url="jdbc:mysql://localhost:3306/students";
        String user="debian-sys-maint";
        String password="123456";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (con.isClosed()) {
            } else {
                System.out.println("数据库连接成功");
            }
            Statement statement = con.createStatement();

            int i = 0;
            String sql = "insert into user(id,age,name) values(1,2,'3')";
            PreparedStatement pstmt;
            try {
                String name="1";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, 2);
               pstmt.setInt(2 ,1);
                pstmt.setString(3,name);

                i = pstmt.executeUpdate();
                System.out.println("----------------------------");
                System.out.println("我的sql:"+sql);
                System.out.println("----------------------------");
                pstmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

//
//            String sql = "select * from test3";//我的表格叫home
//            ResultSet resultSet = statement.executeQuery(sql);
//            String name;
//            while (resultSet.next()) {
//                name = resultSet.getString("name");
//                System.out.println("姓名：" + name);
//            }
//            resultSet.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
    }
}

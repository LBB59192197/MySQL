package DAO;

import MySQL.JDBCDemo;

import java.util.Scanner;

/**
 * Created by DELL on 2018/7/18.
 */
public class TestDao {
    public static void main(String[] args) {
       /* JDBCDemo demo = new JDBCDemo();
        demo.testConnection(23,"234","123");
    */
        String value = null;
        AccountDao dao=new AccountDao();


        while(true) {


            System.out.println("==============================");
            System.out.println("|    欢迎使用baba的人工智能    |");

            System.out.println("==============================");
            System.out.println("|*******1、添加数据***********|");
            System.out.println("|*******2、修改数据***********|");
            System.out.println("|*******3、查询数据***********|");
            System.out.println("|*******4、删除数据***********|");
            System.out.println("|*******5、退出系统***********|");
            System.out.println("请选择：");
            Scanner input = new Scanner(System.in);
            int select = input.nextInt();
            while (select < 1 || select > 5) {
                System.out.println("请重新选择");
                select = input.nextInt();


            }

            //jdbcDemo.findAllData();

 		  /*输入数字，选择菜单*/

            if (select == 1) {
                System.out.println("请输入添加的账号、密码，列如：zhangs，126386");
                value = input.next();

                String[] values = value.split(",");
                Account account=new Account();

                account.setUserAccount(values[0]);
                account.setUserPassword(values[1]);
                dao.Insert(account);
            } else if (select == 2) {
                System.out.println("请输入修改id的账号和密码。列如：287131279,626316");
                value=input.next();
                String[] values=value.split(",");
                Account account=new Account();
                account.setId(Integer.parseInt(values[0]));
                account.setUserAccount(values[1]);
                account.setUserPassword(values[2]);
                dao.update(account);
            } else if (select == 3) {
                dao.findALL();

            } else if (select == 4) {
//               System.exit(-2);
//                System.out.print("请输入查询的id：");
//                value=input.next();
//                dao.FindById(Integer.parseInt(value));
                System.out.print("请输入删除内容的id：");
                value=input.next();
                dao.Delect(Integer.parseInt(value));
            }else if(select==5){

            }


        }
    }

}

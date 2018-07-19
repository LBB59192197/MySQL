//package MySQL;
//
//import javax.swing.*;
//import java.awt.*;
//
///**
// * Created by DELL on 2018/7/17.
// */
//public class JTableDemo extends JFrame {
//
//    JScrollPane scrollPane=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//    public JTableDemo(){
//        //声明表头一维数组
//        String[] heads={"id","isCheck","color"};
//        Object[][]datas=new Object[100][3];
//        for(int i=0;i<datas.length;i++){
//            datas[i][0]=i;
//            datas[i][1]=(i%2==0);
//            datas[i][2]=new Color(i,i*2,i*2);
//        }
//        JTable table=new JTable();
//        //连接JDBCDemo的查询方法
//        datas=new JDBCDemo();
//
//        DefaultBoundedRangeModel tableModel=getTableModel(datas,heads);
//        tabel.set
//        scrollPane.getViewport().add(table);
//    }
//
//}

package DAO;

import MySQL.JDBCDemo;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by DELL on 2018/7/13.
 */
public class AccountFrame extends JFrame {
    private JPanel panelon=new JPanel();
    private JPanel panelcenter=new JPanel();
    private JPanel paneldown=new JPanel();
    private JPanel paneladd=new JPanel();
    //声明上部面板的变量
    private JTextField tfsearch=new JTextField();
    private Button btnsearch=new Button("Search");
    //声明中间面板的变量
//    private JLabel lbcenter=new JLabel("结果");
//    private JTextField tfcenter=new JTextField();
    private JScrollPane scrollPane=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private JTable table=new JTable();
    //声明下部面板的变量
    private  Button btnadd=new Button("Add");
    private  Button btndelete=new Button("Delete");
    private  Button btnmodify=new Button("Modify");
    //声明添加面板的变量
    private  JLabel lbaccount=new JLabel("账号");
    private JLabel lbpassword=new JLabel("密码");
    private JLabel lbother=new JLabel("其他信息");

    private JTextField tfon=new JTextField();
    private JTextField tfpassword=new JTextField();
    private JTextField tfdown=new JTextField();
   AccountDao dao=new AccountDao();

    public AccountFrame(){
        //设置界面
        this.setSize(800,700);
        this.setTitle("Day2");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置上部面板
        this.add(panelon, BorderLayout.NORTH);
        panelon.setLayout(new BorderLayout());
        panelon.add(tfsearch );
        panelon.add(btnsearch,BorderLayout.EAST);
        //设置中间面板
        this.add(panelcenter,BorderLayout.CENTER);
        panelcenter.setLayout(new BorderLayout());
        panelcenter.setVisible(true);
        //panelcenter.add(lbcenter);
        panelcenter.add(scrollPane);
        initTable("");
        scrollPane.getViewport().add(table);
//       panelcenter.add(lbcenter,BorderLayout.WEST);
       panelcenter.setVisible(true);
        //设置下部面板
        this.add(paneldown,BorderLayout.SOUTH);
        paneldown.add(btnadd,new FlowLayout());
        paneldown.add(btndelete,new FlowLayout());
        paneldown.add(btnmodify,new FlowLayout());
        //设置添加面板
        this.add(paneladd,BorderLayout.CENTER);
        paneladd.setLayout(new GridLayout(3,2));
        paneladd.add(lbaccount);
        paneladd.add(tfon);
        paneladd.add(lbpassword);
        paneladd.add(tfpassword);
        paneladd.add(lbother);
        paneladd.add(tfdown);
        paneladd.setVisible(false);
        //监听触发事件
         this.btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            String textadd=btnadd.getLabel();
            if(textadd.equals("add")){
                textadd="save";
              paneladd.setVisible(true);
              panelcenter.setVisible(false);
              btndelete.setLabel("cancel");
              btnmodify.setVisible(false);
            }else{
                textadd="add";
               panelcenter.setVisible(true);
               paneladd.setVisible(false);
               btndelete.setLabel("delete");
               btnmodify.setVisible(true);
            }
            btnadd.setLabel(textadd);
            }
        });
//         this.btndelete.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 String textdt=btndelete.getLabel();
//                 if(textdt.equals("cancel")){
//                     textdt="delete";
//                     panelcenter.setVisible(true);
//                     paneladd.setVisible(false);
//                     btnadd.setLabel("add");
//                     btnmodify.setVisible(true);
//                 }else {
//                     textdt="cancel";
//                     panelcenter.setVisible(false);
//                     paneladd.setVisible(true);
//                     btnadd.setLabel("save");
//                     btnmodify.setVisible(false);
//
//                 }
//                 btndelete.setLabel(textdt);
//             }
//         });
         //搜索按钮监听
        btnsearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                //1. 获得用户输入的文本内容
                String keyword =tfsearch.getText();
                initTable(keyword);
            }
        });
//键盘监听
//		 searchspace.addKeyListener(new KeyListener() {
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				initTable(searchspace.getText());
//			}
//
//			});

//模糊查询输入框监听
        tfsearch.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                // TODO Auto-generated method stub
                initTable(tfsearch.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                // TODO Auto-generated method stub
                initTable(tfsearch.getText());
            }

        });


        //删除监听
        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=table.getSelectedRow();
                if(row <0){
                    JOptionPane.showMessageDialog(null,JOptionPane.WARNING_MESSAGE);
                }else {
                    int option = JOptionPane.showConfirmDialog(AccountFrame.this,
                            "确定要删除选中的数据吗？","删除确认",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);


                    if(option == 0) {
                        // 删除操作. 1. 拿到用户选择的数据的id
                        Object value = table.getValueAt(row,0);
                        if(value != null && !(value + "").trim().equals("")) {
                            int id = Integer.parseInt(table.getValueAt(row,0) + "");
                           dao.Delect(id);
                            //删除后重新加载数据
                            initTable(tfsearch.getText());
                        }
                    }
                }
            }
        });


    }
    private void initTable(String keyword) {
                    List<Account> list=null;
                //2. 如果为空，这查询所有数据，否则按关键字搜索。
                    if(keyword == null || keyword.trim().equals("")) {
                                 list =dao.findALL();
                    } else {
                      list = dao.FindByLike(keyword);
                    }
                table.setModel(getTableModel(list));
            }
   private DefaultTableModel getTableModel(List<Account> list) {
                DefaultTableModel model = new DefaultTableModel();
               model.addColumn("id");
              model.addColumn("账号");
              model.addColumn("密码");
              for(Account account : list) {
                  Vector vector = new Vector();// ArrayList
                  vector.add(account.getId());
                  vector.add(account.getUserAccount());
                  vector.add(account.getUserPassword());
                 }
             return model;
           }

    public static void main(String [] args){
        new AccountFrame();
    }
}

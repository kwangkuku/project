/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_The_Code_Book;

import com.sun.glass.events.KeyEvent;
import com.sun.javafx.application.PlatformImpl;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import static javax.management.Query.value;
import static javax.management.Query.value;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import static javax.management.Query.value;
import static javax.management.Query.value;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author EijiD
 */
public class GUI extends javax.swing.JFrame {
    
    int xM;
    int yM;
    ArrayList<SharedCodeList> sharedList;
    private ArrayList<String> listTitleJava = new ArrayList<>();
    private ArrayList<String> listTitlePython = new ArrayList<>();
    private ArrayList<String> listTitleCSharp = new ArrayList<>();
    private ArrayList<String> listTitleVB = new ArrayList<>();
    
    public RSyntaxTextArea textAreaJava;
    public RSyntaxTextArea textAreaCsh;
    public RSyntaxTextArea textAreaPython;
    public RSyntaxTextArea textAreaVB;
    
   private  ArrayList<String> areaShared = new ArrayList<>();
   public RSyntaxTextArea textAreaSharedCode;
    
    private static final long serialVersionUID = 1L;
    
    public RTextScrollPane javaSP;
    public RTextScrollPane cshSP;
    public RTextScrollPane pythonSP;
    public RTextScrollPane vbSP;
    
    public RTextScrollPane sharedSP;
    
    public TestWeb tw;
    
    ;
    /**
     * Creates new form GUI
     */
    public GUI() {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        setGUI();
        
        
        setTextArea();
        MyJsonParser.getMyJsonParser();
        getTitleToList();
        setListBox(listTitleJava,java_jList);
        setListBox(listTitlePython,python_jList);
        setListBox(listTitleCSharp,csh_jList);
        setListBox(listTitleVB,vb_jList);
        
        
        //setListBox(areaShared,areaShared_jList); 
        
        this.back.setVisible(false);
        this.Drage.setHorizontalAlignment(JTextField.CENTER);
    }
    
   /* public void TestSharedCode() {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        ParserJsonSharedCode.getParserJsonSharedCode();
        setListBox(areaShared,areaShared_jList);
        getTitleToList();
    }*/

    private void setTextArea() {
        textAreaJava = new RSyntaxTextArea(20, 60);
        textAreaJava.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textAreaJava.setCodeFoldingEnabled(true);
        textAreaJava.setText("");
        textAreaJava.setEditable(false);
        
        System.out.println(textAreaJava.getFont());
        
        textAreaCsh = new RSyntaxTextArea(20, 60);
        textAreaCsh.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);
        textAreaCsh.setCodeFoldingEnabled(true);
        textAreaCsh.setText("");
        textAreaCsh.setEnabled(false);
        
        textAreaPython = new RSyntaxTextArea(20, 60);
        textAreaPython.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
        textAreaPython.setCodeFoldingEnabled(true);
        textAreaPython.setText("");
        textAreaPython.setEnabled(false);
        
        textAreaVB= new RSyntaxTextArea(20, 60);
        textAreaVB.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_VISUAL_BASIC);
        textAreaVB.setCodeFoldingEnabled(true);
        textAreaVB.setText("");
        textAreaVB.setEnabled(false);
       
        textAreaSharedCode = new RSyntaxTextArea(20,60);
        textAreaSharedCode.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textAreaSharedCode.setCodeFoldingEnabled(true);
        textAreaSharedCode.setText("");
        textAreaSharedCode.setEnabled(false);

        RTextScrollPane java = new RTextScrollPane(textAreaJava);
        RTextScrollPane csh = new RTextScrollPane(textAreaCsh);
        RTextScrollPane python = new RTextScrollPane(textAreaPython);
        RTextScrollPane vb = new RTextScrollPane(textAreaVB);
        
        RTextScrollPane shared = new RTextScrollPane(textAreaSharedCode);
        
        java_panel.add(java);
        csh_panel.add(csh);
        python_panel.add(python);
        vb_panel.add(vb);
        
        area_SharedCode.add(shared);
        
    }
    
    private void setGUI(){
        this.setSize(1200,700);
        this.setResizable(false);
        tab.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI(){
        @Override
        protected void paintContentBorder(Graphics g,int tabPlacement,int selectedIndex){}
        });
        this.java_tab.setOpaque(false);
        this.python_tab.setOpaque(false);
        this.csh_tab.setOpaque(false);
        this.vb_tab.setOpaque(false);
        this.jPanelSharedCode.setOpaque(false);
        this.jPanelStackEx.setOpaque(false);
    }
    
    
    public void getTitleToList(){
        ArrayList<CodeList> codelist = MyJsonParser.getMyJsonParser().codelist;
        for(int i=0 ; i<codelist.size();i++){
            String l = codelist.get(i).getType();
            String t = codelist.get(i).getTitle();
            if(l.equals("java")){
                listTitleJava.add(t);
            }else if(l.equals("python")){
                listTitlePython.add(t);
            }else if(l.equals("c#")){
                listTitleCSharp.add(t);
            }else if(l.equals("vb")){
                listTitleVB.add(t);
            }
        }
    }
    
    public void setListBox(ArrayList<String> title,JList listBox){
        DefaultListModel<String> model = new DefaultListModel<String>();
        for (String s : title) {
            model.addElement(s);
        }
        listBox.setModel(model);
    }
    
   /* public void getSharedCodeToList(){
       ArrayList<SharedCodeList> sharedList =  ParserJsonSharedCode.getParserJsonSharedCode().sharedList;
       for(int i=0;i<sharedList.size();i++){
           String t = sharedList.get(i).getTitle();
           String v= ""+sharedList.get(i).getViewcounter();
           areaShared.add(t);
           areaShared.add(v);
       }
   }*/
    
    public String getContentByTitle(String title,String language){
        String content = null;
        ArrayList<CodeList> codelist = MyJsonParser.getMyJsonParser().codelist;
        for(int i=0;i<codelist.size();i++){
            if(codelist.get(i).getTitle().equals(title)&&codelist.get(i).getType().equals(language)){
                content = codelist.get(i).getContent();
            }
        }
        return content;
    }
    
     public String getContentSharedByTitle(String title)
     {
     String content = null;
     
     for(int i =0;i< sharedList.size();i++)
     {
     if(sharedList.get(i).getTitle().equals(title)){
         content = sharedList.get(i).getContent();
     }
     }
     
     return content;
     }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        CloseButton = new javax.swing.JLabel();
        miniButton = new javax.swing.JLabel();
        Drage = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        java_tab = new javax.swing.JPanel();
        java_jTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        java_jList = new javax.swing.JList<>();
        java_panel = new javax.swing.JPanel();
        java_Button = new javax.swing.JButton();
        java_copy_bt = new javax.swing.JButton();
        cb_Size_java = new javax.swing.JComboBox<>();
        python_tab = new javax.swing.JPanel();
        python_jTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        python_jList = new javax.swing.JList<>();
        python_panel = new javax.swing.JPanel();
        python_Button = new javax.swing.JButton();
        python_copy_bt = new javax.swing.JButton();
        cb_sizePython = new javax.swing.JComboBox<>();
        csh_tab = new javax.swing.JPanel();
        csh_jTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        csh_jList = new javax.swing.JList<>();
        csh_panel = new javax.swing.JPanel();
        csh_Button = new javax.swing.JButton();
        csh_copy_bt = new javax.swing.JButton();
        cb_sizeCSharp = new javax.swing.JComboBox<>();
        vb_tab = new javax.swing.JPanel();
        vb_jTextField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        vb_jList = new javax.swing.JList<>();
        vb_panel = new javax.swing.JPanel();
        vb_Button = new javax.swing.JButton();
        vb_copy_bt = new javax.swing.JButton();
        cb_sizeVB = new javax.swing.JComboBox<>();
        jPanelStackEx = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        stackEx_tab = new javax.swing.JTabbedPane();
        page1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        stackEx_TextField = new javax.swing.JEditorPane();
        logo = new javax.swing.JLabel();
        search_TF = new javax.swing.JTextField();
        search_BT = new javax.swing.JButton();
        search_CB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        page2 = new javax.swing.JPanel();
        jPanelSharedCode = new javax.swing.JPanel();
        shared_page1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        list_SharedCode = new javax.swing.JList<>();
        bt_SearchShared = new javax.swing.JButton();
        TF_searchShared = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lb_title = new javax.swing.JLabel();
        jb_Star1 = new javax.swing.JButton();
        jb_Star2 = new javax.swing.JButton();
        jb_Star3 = new javax.swing.JButton();
        jb_Star5 = new javax.swing.JButton();
        jb_Star4 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        descrip_area = new javax.swing.JTextArea();
        area_SharedCode = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 90, 30));

        CloseButton.setText("        ");
        CloseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseButtonMouseClicked(evt);
            }
        });
        getContentPane().add(CloseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1167, 7, 20, 20));

        miniButton.setText("        ");
        miniButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miniButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miniButtonMouseClicked(evt);
            }
        });
        getContentPane().add(miniButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1131, 7, -1, 20));

        Drage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Drage.setForeground(new java.awt.Color(255, 255, 255));
        Drage.setText("  The Code Book");
        Drage.setToolTipText("");
        Drage.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        Drage.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                DrageMouseDragged(evt);
            }
        });
        Drage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DrageMousePressed(evt);
            }
        });
        getContentPane().add(Drage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 20));

        tab.setForeground(new java.awt.Color(255, 255, 255));
        tab.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        java_tab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        java_jTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java_jTextFieldActionPerformed(evt);
            }
        });
        java_jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                java_jTextFieldKeyPressed(evt);
            }
        });
        java_tab.add(java_jTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, -1));

        java_jList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        java_jList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                java_jListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(java_jList);

        java_tab.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 330, 590));

        java_panel.setLayout(new java.awt.BorderLayout());
        java_tab.add(java_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 840, 585));

        java_Button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        java_Button.setText("Search");
        java_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java_ButtonActionPerformed(evt);
            }
        });
        java_tab.add(java_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 10, -1, 28));

        java_copy_bt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        java_copy_bt.setText("Copy");
        java_copy_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java_copy_btActionPerformed(evt);
            }
        });
        java_tab.add(java_copy_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, -1, 28));

        cb_Size_java.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32" }));
        cb_Size_java.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_Size_javaActionPerformed(evt);
            }
        });
        java_tab.add(cb_Size_java, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, -1, -1));

        tab.addTab("  JAVA ", java_tab);

        python_tab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        python_jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                python_jTextFieldKeyPressed(evt);
            }
        });
        python_tab.add(python_jTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, -1));

        python_jList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        python_jList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                python_jListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(python_jList);

        python_tab.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 330, 590));

        python_panel.setLayout(new java.awt.BorderLayout());
        python_tab.add(python_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 42, 840, 585));

        python_Button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        python_Button.setText("Search");
        python_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                python_ButtonActionPerformed(evt);
            }
        });
        python_tab.add(python_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 10, -1, 28));

        python_copy_bt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        python_copy_bt.setText("Copy");
        python_copy_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                python_copy_btActionPerformed(evt);
            }
        });
        python_tab.add(python_copy_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, -1, 28));

        cb_sizePython.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "12", "14", "16", "18", "20", "22", "24", "26", "30", "32", "36" }));
        cb_sizePython.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sizePythonActionPerformed(evt);
            }
        });
        python_tab.add(cb_sizePython, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        tab.addTab("   PYTHON  ", python_tab);

        csh_tab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        csh_jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                csh_jTextFieldKeyPressed(evt);
            }
        });
        csh_tab.add(csh_jTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, -1));

        csh_jList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        csh_jList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                csh_jListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(csh_jList);

        csh_tab.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 330, 590));

        csh_panel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        csh_panel.setLayout(new java.awt.BorderLayout());
        csh_tab.add(csh_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 42, 840, 585));

        csh_Button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        csh_Button.setText("Search");
        csh_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csh_ButtonActionPerformed(evt);
            }
        });
        csh_tab.add(csh_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 10, -1, 28));

        csh_copy_bt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        csh_copy_bt.setText("Copy");
        csh_copy_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csh_copy_btActionPerformed(evt);
            }
        });
        csh_tab.add(csh_copy_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, -1, 28));

        cb_sizeCSharp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "12", "14", "16", "18", "20", "22", "24", "26", "30", "32", "36" }));
        cb_sizeCSharp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sizeCSharpActionPerformed(evt);
            }
        });
        csh_tab.add(cb_sizeCSharp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        tab.addTab("   C#  ", csh_tab);

        vb_tab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vb_jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vb_jTextFieldKeyPressed(evt);
            }
        });
        vb_tab.add(vb_jTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, -1));

        vb_jList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vb_jList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vb_jListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(vb_jList);

        vb_tab.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 330, 590));

        vb_panel.setLayout(new java.awt.BorderLayout());
        vb_tab.add(vb_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 42, 840, 585));

        vb_Button.setText("Search");
        vb_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vb_ButtonActionPerformed(evt);
            }
        });
        vb_tab.add(vb_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 10, -1, 28));

        vb_copy_bt.setText("Copy");
        vb_copy_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vb_copy_btActionPerformed(evt);
            }
        });
        vb_tab.add(vb_copy_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, -1, 28));

        cb_sizeVB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "12", "14", "16", "18", "20", "22", "24", "26", "30", "32", "36" }));
        cb_sizeVB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sizeVBActionPerformed(evt);
            }
        });
        vb_tab.add(cb_sizeVB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        tab.addTab("    VB   ", vb_tab);

        jPanelStackEx.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, -1));

        jPanelStackEx.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 6, 100, 30));

        page1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stackEx_TextField.setEditable(false);
        jScrollPane5.setViewportView(stackEx_TextField);

        page1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1160, 510));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_The_Code_Book/img/se-logo.png"))); // NOI18N
        page1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 60));
        page1.add(search_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 230, 30));

        search_BT.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        search_BT.setText("Search");
        search_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_BTActionPerformed(evt);
            }
        });
        page1.add(search_BT, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, 30));

        search_CB.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        search_CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "stackoverflow", "webapps", "gamedev", "programmers", "webmaster" }));
        search_CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_CBActionPerformed(evt);
            }
        });
        page1.add(search_CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 130, 30));

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        jLabel2.setText("Search : ");
        page1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        jLabel3.setText("Site : ");
        page1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));

        stackEx_tab.addTab("tab1", page1);

        page2.setLayout(new java.awt.BorderLayout());
        stackEx_tab.addTab("tab2", page2);

        jPanelStackEx.add(stackEx_tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1180, 620));

        tab.addTab("Stack Exchange", jPanelStackEx);

        jPanelSharedCode.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        shared_page1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 51));
        jLabel4.setText("SharedCode");
        shared_page1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 320, 30));

        jPanelSharedCode.add(shared_page1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 40));

        list_SharedCode.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        list_SharedCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_SharedCodeMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(list_SharedCode);

        jPanelSharedCode.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 320, 510));

        bt_SearchShared.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        bt_SearchShared.setText("Search");
        bt_SearchShared.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SearchSharedActionPerformed(evt);
            }
        });
        jPanelSharedCode.add(bt_SearchShared, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 90, 30));

        TF_searchShared.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jPanelSharedCode.add(TF_searchShared, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 250, 40));

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel5.setText("Search Title :");
        jPanelSharedCode.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(lb_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 220, 40));

        jb_Star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageStar/Star2.png"))); // NOI18N
        jPanel3.add(jb_Star1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 34, 32));

        jb_Star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageStar/Star2.png"))); // NOI18N
        jPanel3.add(jb_Star2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 34, 32));

        jb_Star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageStar/Star2.png"))); // NOI18N
        jPanel3.add(jb_Star3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 34, 32));

        jb_Star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageStar/Star2.png"))); // NOI18N
        jPanel3.add(jb_Star5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 34, 32));

        jb_Star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageStar/Star2.png"))); // NOI18N
        jPanel3.add(jb_Star4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 34, 32));

        descrip_area.setColumns(20);
        descrip_area.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        descrip_area.setRows(5);
        jScrollPane8.setViewportView(descrip_area);

        jPanel3.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 820, 70));

        area_SharedCode.setMaximumSize(new java.awt.Dimension(810, 390));
        area_SharedCode.setMinimumSize(new java.awt.Dimension(810, 390));
        area_SharedCode.setPreferredSize(new java.awt.Dimension(810, 390));
        area_SharedCode.setLayout(new java.awt.BorderLayout());
        jPanel3.add(area_SharedCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 810, 390));

        jPanelSharedCode.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1190, 620));

        tab.addTab("Shared Code", jPanelSharedCode);

        getContentPane().add(tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1200, 660));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file/gui1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_CloseButtonMouseClicked

    private void miniButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniButtonMouseClicked
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_miniButtonMouseClicked

    private void DrageMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrageMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xM, y - yM);
    }//GEN-LAST:event_DrageMouseDragged

    private void DrageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrageMousePressed
        xM = evt.getX();
        yM = evt.getY();
    }//GEN-LAST:event_DrageMousePressed

    private void python_jListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_python_jListMouseClicked
        // TODO add your handling code here:
        String title = python_jList.getSelectedValue();
        textAreaPython.setText(this.getContentByTitle(title,"python"));
    }//GEN-LAST:event_python_jListMouseClicked

    private void csh_jListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csh_jListMouseClicked
        // TODO add your handling code here:
        String title = csh_jList.getSelectedValue();
        textAreaCsh.setText(this.getContentByTitle(title,"c#"));
    }//GEN-LAST:event_csh_jListMouseClicked

    private void vb_jListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_jListMouseClicked
        // TODO add your handling code here:
        String title = vb_jList.getSelectedValue();
        textAreaVB.setText(this.getContentByTitle(title,"vb"));
    }//GEN-LAST:event_vb_jListMouseClicked

    private void java_jListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_java_jListMouseClicked
        String title = java_jList.getSelectedValue();
        textAreaJava.setText(this.getContentByTitle(title,"java"));
    }//GEN-LAST:event_java_jListMouseClicked

    private void search_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_BTActionPerformed
        String word = this.search_TF.getText().toString();
        String web = this.search_CB.getSelectedItem().toString();
        ArrayList<URLlist> listStackEx = ParserAPIStackEx.getParserAPIStackEx().getStackEx(word, web);
       
        this.stackEx_TextField.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
        StringBuilder content = new StringBuilder();
        content.append("<html><body>");
        //content.append("<TABLE widht= \"33%\" height=\"20%\">");
        //content.append("<tr><td>EVALUATION </td><td>Title</td><td>View</td></tr></TABLE>");
        for (int i = 0; i < listStackEx.size(); i++) {
           
            content.append("<FONT SIZE=5><b><br>View Count :" + listStackEx.get(i).getView_content() + "<br>");
            content.append("Answer Count :" + listStackEx.get(i).getAnswer_count() + "<br>");
            content.append("Title: <FONT COLOR=green>" + listStackEx.get(i).getTitle() + "</FONT>.<br>");
            content.append("URL :<a href=\""+listStackEx.get(i).getLink()+"\"");
            content.append(">" + listStackEx.get(i).getLink());
            content.append("</a>.<br></b></FONT SIZE>");
        }

        content.append("</body></html>");
        this.stackEx_TextField.setText(content.toString());
        this.stackEx_TextField.grabFocus();
        this.stackEx_TextField.setCaretPosition(20);
        
        this.stackEx_TextField.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    tw = new TestWeb(e.getURL().toString());
                    System.out.println(e.getURL());
                    tw.setVisible(true);
                    page2.add(tw);
                    back.setVisible(true);
                    stackEx_tab.setSelectedIndex(1);
                }
            }
     
        }
        
        );
    
    }//GEN-LAST:event_search_BTActionPerformed

    private void java_copy_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_java_copy_btActionPerformed
        // TODO add your handling code here:
        StringSelection stringSelection = new StringSelection(this.textAreaJava.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }//GEN-LAST:event_java_copy_btActionPerformed

    private void python_copy_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_python_copy_btActionPerformed
        // TODO add your handling code here:
        StringSelection stringSelection = new StringSelection(this.textAreaPython.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }//GEN-LAST:event_python_copy_btActionPerformed

    private void csh_copy_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csh_copy_btActionPerformed
        // TODO add your handling code here:
        StringSelection stringSelection = new StringSelection(this.textAreaCsh.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }//GEN-LAST:event_csh_copy_btActionPerformed

    private void vb_copy_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vb_copy_btActionPerformed
        // TODO add your handling code here:
        StringSelection stringSelection = new StringSelection(this.textAreaVB.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }//GEN-LAST:event_vb_copy_btActionPerformed

    private void java_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_java_ButtonActionPerformed
        // TODO add your handling code here:
        DefaultListModel<String> model = new DefaultListModel<String>();
        
        for (Object s : listTitleJava) {
            
            if (((String) s).contains(this.java_jTextField.getText().toString())) {
               
                model.addElement(s.toString());
            }

        }
        this.java_jList.setModel(model);
    }//GEN-LAST:event_java_ButtonActionPerformed

    private void python_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_python_ButtonActionPerformed
        // TODO add your handling code here:
        DefaultListModel<String> model = new DefaultListModel<String>();
        for (Object s : listTitlePython) {
            if (((String) s).contains(this.python_jTextField.getText().toString())) {
                model.addElement(s.toString());
            }

        }
        this.python_jList.setModel(model);
    }//GEN-LAST:event_python_ButtonActionPerformed

    private void csh_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csh_ButtonActionPerformed
        // TODO add your handling code here:
        DefaultListModel<String> model = new DefaultListModel<String>();
        for (Object s : listTitleCSharp) {
            if (((String) s).contains(this.csh_jTextField.getText().toString())) {
                model.addElement(s.toString());
            }

        }
        this.csh_jList.setModel(model);
    }//GEN-LAST:event_csh_ButtonActionPerformed

    private void vb_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vb_ButtonActionPerformed
        // TODO add your handling code here:
        DefaultListModel<String> model = new DefaultListModel<String>();
        for (Object s : listTitleVB) {
            if (((String) s).contains(this.vb_jTextField.getText().toString())) {
                model.addElement(s.toString());
            }

        }
        this.vb_jList.setModel(model);
    }//GEN-LAST:event_vb_ButtonActionPerformed

    private void java_jTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_java_jTextFieldKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER)
        {
           // String text1 = this.java_jTextField.getText();
            //String text2 = this.listTitleJava.toString();
        DefaultListModel<String> model = new DefaultListModel<String>();
        //String tf_java = this.java_jTextField.getText().toString();
        for (Object s : listTitleJava) {
            String bjs =(String)s;
            if (((String) s).contains(this.java_jTextField.getText().toString())) {
               
               model.addElement(s.toString());
            }

        }
        this.java_jList.setModel(model);
        }
          
    }//GEN-LAST:event_java_jTextFieldKeyPressed

    private void python_jTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_python_jTextFieldKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER)
        {
        DefaultListModel<String> model = new DefaultListModel<String>();
        for (Object s : listTitlePython) {
            if (((String) s).contains(this.python_jTextField.getText().toString())) {
                model.addElement(s.toString());
            }

        }
        this.python_jList.setModel(model);
        }
    }//GEN-LAST:event_python_jTextFieldKeyPressed

    private void csh_jTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csh_jTextFieldKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER)
        {
         DefaultListModel<String> model = new DefaultListModel<String>();
        for (Object s : listTitleCSharp) {
            if (((String) s).contains(this.csh_jTextField.getText().toString())) {
                model.addElement(s.toString());
            }

        }
        this.csh_jList.setModel(model);
        }
    }//GEN-LAST:event_csh_jTextFieldKeyPressed

    private void vb_jTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vb_jTextFieldKeyPressed
   DefaultListModel<String> model = new DefaultListModel<String>();
        for (Object s : listTitleVB) {
            if (((String) s).contains(this.vb_jTextField.getText().toString())) {
                model.addElement(s.toString());
            }

        }
        this.vb_jList.setModel(model);
    }//GEN-LAST:event_vb_jTextFieldKeyPressed

    private void java_jTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_java_jTextFieldActionPerformed
       
    }//GEN-LAST:event_java_jTextFieldActionPerformed

    private void cb_Size_javaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_Size_javaActionPerformed
           
           Font font = new Font("Consolas", Font.PLAIN, Integer.parseInt(cb_Size_java.getSelectedItem().toString()));
           textAreaJava.setFont(font);
        
      
    }//GEN-LAST:event_cb_Size_javaActionPerformed

    private void search_CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_CBActionPerformed
       
        
    }//GEN-LAST:event_search_CBActionPerformed

    private void bt_SearchSharedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SearchSharedActionPerformed
       String word = this.TF_searchShared.getText().toString();
       sharedList = ParserJsonSharedCode.getParserJsonSharedCode().parseShared(word);
       areaShared = new ArrayList<>();
       for(int i =0;i< sharedList.size();i++)
       {
       areaShared.add(sharedList.get(i).getTitle());
       
       }
         setListBox(areaShared,list_SharedCode);
         
         
         
         
      /*String word = this.TF_searchShared.getText().toString();
       ArrayList<SharedCodeList> sharedList = ParserJsonSharedCode.getParserJsonSharedCode().parseShared(word);
      this.area_SharedCode.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
      
       //this.area_SharedCode.setContentType("text/html");
        StringBuilder content = new StringBuilder();
        content.append("<html><body>");
        
        
        content.append("<pre><b><FONT SIZE =6>EVALUATION                             Title                                   View</FONT><b></pre>");
        for(int i=0;i<sharedList.size();i++){
           for(Double j=1.0;j<= sharedList.get(i).getEvaluation() ;j++){ 
           
           content.append("<FONT SIZE=6><FONT COLOR = yellow>★</FONT></FONT>");
           
           }
           
            content.append("<FONT SIZE = 6>");
            content.append("<br><b> <FONT SIZE=6><pre>                                <a href=\"" + sharedList.get(i).getTitle() + "\">"+sharedList.get(i).getTitle()+"</a></FONT> <FONT SIZE=6>                                     "+sharedList.get(i).getViewcounter()+"</FONT></b></pre>");
            content.append("<FONT>");
          
        content.append("<br>");
        content.append("</body></html>");
        this.area_SharedCode.setText(content.toString());
        //System.out.println(content.toString());
        
         this.area_SharedCode.addHyperlinkListener(new HyperlinkListener(){
         public void hyperlinkUpdate(HyperlinkEvent e){
           if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {

           }
         
         }
         });*/
       
       
            
       
    
        
    }//GEN-LAST:event_bt_SearchSharedActionPerformed

    private void cb_sizePythonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sizePythonActionPerformed
        Font font = new Font("Consolas", Font.PLAIN, Integer.parseInt(cb_sizePython.getSelectedItem().toString()));
           textAreaPython.setFont(font);
    }//GEN-LAST:event_cb_sizePythonActionPerformed

    private void cb_sizeCSharpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sizeCSharpActionPerformed
       Font font = new Font("Consolas", Font.PLAIN, Integer.parseInt(cb_sizeCSharp.getSelectedItem().toString()));
           textAreaCsh.setFont(font);
    }//GEN-LAST:event_cb_sizeCSharpActionPerformed

    private void cb_sizeVBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sizeVBActionPerformed
        Font font = new Font("Consolas",Font.PLAIN,Integer.parseInt(cb_sizeVB.getSelectedItem().toString()));
         textAreaVB.setFont(font);
    }//GEN-LAST:event_cb_sizeVBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "Do you want to update it?",
                "Update",
                JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            UpdateFile upfile = new UpdateFile();
            upfile.createFile();
            JOptionPane.showMessageDialog(this, "Update complete");
            listTitleJava = new ArrayList<>();
            listTitlePython = new ArrayList<>();
            listTitleCSharp = new ArrayList<>();
            listTitleVB = new ArrayList<>();
            MyJsonParser.getMyJsonParser();
            getTitleToList();
            setListBox(listTitleJava,java_jList);
            setListBox(listTitlePython,python_jList);
            setListBox(listTitleCSharp,csh_jList);
            setListBox(listTitleVB,vb_jList);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:

        stackEx_tab.setSelectedIndex(0);
      //  tw.dispose();
        //page2.removeAll();

        // back.setVisible(true);
        // back.removeAll();

    }//GEN-LAST:event_backActionPerformed

    private void list_SharedCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_SharedCodeMouseClicked
      String title = list_SharedCode.getSelectedValue(); 
      
      
      for(int i =0;i< sharedList.size();i++)
      {
        if(title == sharedList.get(i).getTitle())
        {
        sharedList.get(i).getDescription();
        descrip_area.setText(sharedList.get(i).getDescription());
        lb_title.setText(title);
        double eva = 5.0;
        Icon imageIcon = new ImageIcon("D:\\การเรียน\\project I\\Project\\GUI TheCodeBook\\TheCodeBook1\\TheCodeBook V 0.1\\src\\ImageStar\\Star1.png");
        Icon imageIcon2 = new ImageIcon("D:\\การเรียน\\project I\\Project\\GUI TheCodeBook\\TheCodeBook1\\TheCodeBook V 0.1\\src\\ImageStar\\Star2.png");
        for(double j = 0.9;j<sharedList.get(i).getEvaluation();j++){
            if(j==0.9){
                System.out.println("pass");
                this.jb_Star1.setIcon(imageIcon);
            }else if(j==1.9){
                System.out.println("pass");
                this.jb_Star2.setIcon(imageIcon);
            }else if(j==2.9){
                System.out.println("pass");
                this.jb_Star3.setIcon(imageIcon);
            }else if(j==3.9){
                System.out.println("pass");
                this.jb_Star4.setIcon(imageIcon);
            }else if(j==4.9){
                System.out.println("pass");
                this.jb_Star5.setIcon(imageIcon);
            }
            eva = eva-1.0;
        }
        for(double k = 0.9 ; k<eva;k++){
            if(k==0.9){
                this.jb_Star5.setIcon(imageIcon2);
            }else if(k==1.9){
                this.jb_Star4.setIcon(imageIcon2);
            }else if(k==2.9){
                this.jb_Star3.setIcon(imageIcon2);
            }else if(k==3.9){
                this.jb_Star2.setIcon(imageIcon2);
            }else if(k==4.9){
                this.jb_Star1.setIcon(imageIcon2);
            }
        }
            
        }
        textAreaSharedCode.setText(this.getContentSharedByTitle(title));

      }
//      double eva = 5.0;
//      for(int i = 0;i<)
//      for(int j=5;j <sharedList.get(j).getEvaluation();j--)
//      {
//      if(sharedList.get(j).getEvaluation().equals(j))
//      {
//       Icon imageIcon = new ImageIcon("ImageStar/Star1.png");
//      //JLabel label = new JLabel(imageIcon);
//      jb_Star1.setIcon(imageIcon);
//      }else{}
//      }
      
      
      
         
      
    }//GEN-LAST:event_list_SharedCodeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CloseButton;
    private javax.swing.JLabel Drage;
    private javax.swing.JTextField TF_searchShared;
    private javax.swing.JPanel area_SharedCode;
    public javax.swing.JButton back;
    private javax.swing.JButton bt_SearchShared;
    private javax.swing.JComboBox<String> cb_Size_java;
    private javax.swing.JComboBox<String> cb_sizeCSharp;
    private javax.swing.JComboBox<String> cb_sizePython;
    private javax.swing.JComboBox<String> cb_sizeVB;
    private javax.swing.JButton csh_Button;
    private javax.swing.JButton csh_copy_bt;
    private javax.swing.JList<String> csh_jList;
    private javax.swing.JTextField csh_jTextField;
    private javax.swing.JPanel csh_panel;
    private javax.swing.JPanel csh_tab;
    private javax.swing.JTextArea descrip_area;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelSharedCode;
    private javax.swing.JPanel jPanelStackEx;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JButton java_Button;
    private javax.swing.JButton java_copy_bt;
    private javax.swing.JList<String> java_jList;
    private javax.swing.JTextField java_jTextField;
    private javax.swing.JPanel java_panel;
    private javax.swing.JPanel java_tab;
    private javax.swing.JButton jb_Star1;
    private javax.swing.JButton jb_Star2;
    private javax.swing.JButton jb_Star3;
    private javax.swing.JButton jb_Star4;
    private javax.swing.JButton jb_Star5;
    private javax.swing.JLabel lb_title;
    private javax.swing.JList<String> list_SharedCode;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel miniButton;
    private javax.swing.JPanel page1;
    private javax.swing.JPanel page2;
    private javax.swing.JButton python_Button;
    private javax.swing.JButton python_copy_bt;
    private javax.swing.JList<String> python_jList;
    private javax.swing.JTextField python_jTextField;
    private javax.swing.JPanel python_panel;
    private javax.swing.JPanel python_tab;
    private javax.swing.JButton search_BT;
    private javax.swing.JComboBox<String> search_CB;
    private javax.swing.JTextField search_TF;
    private javax.swing.JPanel shared_page1;
    private javax.swing.JEditorPane stackEx_TextField;
    public javax.swing.JTabbedPane stackEx_tab;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JButton vb_Button;
    private javax.swing.JButton vb_copy_bt;
    private javax.swing.JList<String> vb_jList;
    private javax.swing.JTextField vb_jTextField;
    private javax.swing.JPanel vb_panel;
    private javax.swing.JPanel vb_tab;
    // End of variables declaration//GEN-END:variables
    
    
}

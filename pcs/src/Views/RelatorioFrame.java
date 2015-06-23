/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import BDConexao.criaConexao;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author riguco
 */
public class RelatorioFrame extends javax.swing.JFrame {
    Connection conn = new criaConexao().connect();
    /**
     * Creates new form RelatorioFrame
     */
    int idaluno;
    public void getid (int id){
        idaluno = id;
    }
    public void preenchertabela(){
    String sql = "select * from sessao where id_pessoa=?";
        String sql2 = "select count(*) as totaldequestoes from resposta where id_sessao=?";
        
        try {
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setInt(1, idaluno);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            while (rs.next()){                        
                int tipoint = rs.getInt("tipoquestao");
                int tiponivel = rs.getInt("nivel");
                int acertos = rs.getInt("acertos");
                
                String tipostring = "", nivelstring = "";
                
                if(tipoint == 0)
                    tipostring = "Potenciação";
                if(tipoint == 1)
                    tipostring = "Radiciação";
               
                if(tiponivel == 0)
                    nivelstring = "Fácil";
                if(tiponivel == 1)
                    nivelstring = "Médio";
                if(tiponivel == 2)
                    nivelstring = "Difícil";
                
                PreparedStatement ps2 =conn.prepareStatement(sql2);
                ps2.setInt(1, rs.getInt("id_sessao"));
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
                int totaldequestoes = rs2.getInt("totaldequestoes");
                float porcentagem;
                if (totaldequestoes >0){
                    porcentagem = ((acertos * 100)/totaldequestoes);
                }
                else 
                    porcentagem = 0;
                System.out.println("Porcentagem " + porcentagem);
                model.addRow(new Object[]{rs.getInt("id_sessao"), rs.getDate("data_inicio"), rs.getDate("data_fim"), "10", tipostring, nivelstring, rs2.getInt("totaldequestoes"), rs.getInt("acertos"), porcentagem});



            }

        }

        catch (Exception e){
        System.out.println(e.getMessage());        
        }
    
    }    
    public RelatorioFrame() {
        initComponents();
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        campoID = new javax.swing.JTextField();
        botaoConsultar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data Inicio", "Data Fim", "Tempo Total", "Tipo", "Nível", "Qtd.", "Acertos", "%"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Digite o ID:");

        botaoConsultar.setText("Consultar");

        botaoVoltar.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoVoltar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoConsultar)
                    .addComponent(botaoVoltar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(RelatorioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioFrame().setVisible(true);
                
                 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConsultar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoID;
    public javax.swing.JTextField campoNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
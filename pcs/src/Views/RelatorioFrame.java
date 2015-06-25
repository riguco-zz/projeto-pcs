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
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
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
    int idaluno,idsessao;
    public void getid (int id){
        idaluno = id;
    
    }
    String Nome;
    public void getnome (String nome){
        Nome = nome;
    
    }
    
   
    public void preenchertabela(){
    String sql = "SELECT *, timediff(data_fim, data_inicio) as tempo FROM sessao where id_pessoa=?";
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
                
                //String tempototal = DateUtils.getRelativeTimeSpanString();
                
                model.addRow(new Object[]{rs.getInt("id_sessao"), rs.getTimestamp("data_inicio"), rs.getTimestamp("data_fim"), new SimpleDateFormat("HH:mm:ss").format(rs.getTimestamp("tempo")), tipostring, nivelstring, rs2.getInt("totaldequestoes"), rs.getInt("acertos"), porcentagem});



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
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Sessao", "Data Inicio", "Data Fim", "Tempo Total", "Tipo", "Nível", "Qtd.", "Acertos", "%"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Digite o ID:");

        botaoConsultar.setText("Consultar");
        botaoConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultarActionPerformed(evt);
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        jLabel3.setText("Para Consultar a Sessão");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoConsultar)
                    .addComponent(botaoVoltar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarActionPerformed
        this.setVisible(false);
        int valor;
        String s = campoID.getText();
        if(s==null) 
            JOptionPane.showMessageDialog(null, "Por favor, insira um ID ");
        else{
            valor=Integer.parseInt(s);
            System.out.println("valor no campo" + valor);
            
            String sqlrelatorio = "select * from resposta where id_sessao=?";
            try {
                PreparedStatement ps =conn.prepareStatement(sqlrelatorio);
                ps.setInt(1, valor);
                ResultSet rs = ps.executeQuery();

            if (rs.next()){
                Resolucao2Frame mm = new Resolucao2Frame();
                mm.getid(idaluno);
                mm.getsessao(valor);
                mm.campoNome.setText(Nome);
                mm.campoNome.setEditable(false);
                mm.preenchertabela();
                mm.show();
                mm.setLocationRelativeTo(null);


            }
            }

            catch (Exception e){
            System.out.println(e.getMessage());        
            }
        }
    }//GEN-LAST:event_botaoConsultarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
        AlunoFrame mm = new AlunoFrame();
        mm.getid(idaluno);
        mm.setResizable(false);
        mm.setLocationRelativeTo(null);
        mm.show();
    }//GEN-LAST:event_botaoVoltarActionPerformed

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

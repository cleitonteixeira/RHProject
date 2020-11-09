package br.com.nutribemrefeicoescoletivas.view;

import br.com.nutribemrefeicoescoletivas.bean.UsuarioBean;
import br.com.nutribemrefeicoescoletivas.control.UsuarioController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RHPrincipal extends javax.swing.JFrame {

    private UsuarioBean user = null;
    
    public RHPrincipal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(this);
    }

    
    public void RecebeDados(Object ob) throws SQLException{
        UsuarioBean obj = (UsuarioBean) ob;
        user = (UsuarioBean) new UsuarioController().busca(obj);
        Saudacao.setText("Bem vindo "+user.getNome()+"!");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Saudacao = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        BTUsuarios1 = new javax.swing.JMenu();
        FuncCadastro = new javax.swing.JMenuItem();
        BTArquivos = new javax.swing.JMenu();
        FileUp = new javax.swing.JMenuItem();
        FileDown = new javax.swing.JMenuItem();
        BTUsuarios = new javax.swing.JMenu();
        CadastroUser = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RH-Online");

        BTUsuarios1.setText("Funcionários");

        FuncCadastro.setText("Cadastrar");
        FuncCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FuncCadastroActionPerformed(evt);
            }
        });
        BTUsuarios1.add(FuncCadastro);
        FuncCadastro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));

        jMenuBar1.add(BTUsuarios1);

        BTArquivos.setText("Arquivos");

        FileUp.setText("Upload");
        FileUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileUpActionPerformed(evt);
            }
        });
        BTArquivos.add(FileUp);
        FileUp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));

        FileDown.setText("Download");
        FileDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileDownActionPerformed(evt);
            }
        });
        BTArquivos.add(FileDown);
        FileDown.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));

        jMenuBar1.add(BTArquivos);

        BTUsuarios.setText("Usuários");

        CadastroUser.setText("Cadastrar");
        CadastroUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroUserActionPerformed(evt);
            }
        });
        BTUsuarios.add(CadastroUser);
        FileUp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));

        jMenuBar1.add(BTUsuarios);

        jMenu1.setText("Fomulários");

        jMenu2.setText("Férias");

        jMenuItem1.setText("Solicitar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Aprovar");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Acompanhar");
        jMenu2.add(jMenuItem3);

        jMenu1.add(jMenu2);

        jMenu3.setText("Admissão");

        jMenuItem4.setText("Solicitar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Aprovar");
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Acompanhar");
        jMenu3.add(jMenuItem6);

        jMenu1.add(jMenu3);

        jMenu4.setText("Demissão");

        jMenuItem7.setText("Solicitar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Aprovar");
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Acompanhar");
        jMenu4.add(jMenuItem9);

        jMenu1.add(jMenu4);

        jMenu5.setText("Promoção");

        jMenuItem10.setText("Solicitar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem11.setText("Aprovar");
        jMenu5.add(jMenuItem11);

        jMenuItem12.setText("Acompanhar");
        jMenu5.add(jMenuItem12);

        jMenu1.add(jMenu5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Saudacao, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(411, Short.MAX_VALUE)
                .addComponent(Saudacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FileUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileUpActionPerformed
       FileUpload fu = new FileUpload(this, true);
       fu.getInfor(user.getID(), this);
       fu.setVisible(true);
    }//GEN-LAST:event_FileUpActionPerformed

    private void FileDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileDownActionPerformed
       new FileDownload(this, true).setVisible(true);
    }//GEN-LAST:event_FileDownActionPerformed

    private void CadastroUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroUserActionPerformed
        try {
            new CadastroUsuario(this, true).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(RHPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CadastroUserActionPerformed

    private void FuncCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FuncCadastroActionPerformed
        try {
            new FuncionarioCadastro(this, true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(RHPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FuncCadastroActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

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
            java.util.logging.Logger.getLogger(RHPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RHPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RHPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RHPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RHPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu BTArquivos;
    private javax.swing.JMenu BTUsuarios;
    private javax.swing.JMenu BTUsuarios1;
    private javax.swing.JMenuItem CadastroUser;
    private javax.swing.JMenuItem FileDown;
    private javax.swing.JMenuItem FileUp;
    private javax.swing.JMenuItem FuncCadastro;
    private javax.swing.JLabel Saudacao;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}

package br.com.nutribemrefeicoescoletivas.view;

import br.com.nutribemrefeicoescoletivas.bean.PermissaoBean;
import br.com.nutribemrefeicoescoletivas.bean.UsuarioBean;
import br.com.nutribemrefeicoescoletivas.control.UsuarioController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RHPrincipal extends javax.swing.JFrame {

    private UsuarioBean user = null;
    
    public RHPrincipal() throws SQLException {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(this);
    }

    
    public void RecebeDados(Object ob) throws SQLException{
        UsuarioBean obj = (UsuarioBean) ob;
        user = (UsuarioBean) new UsuarioController().busca(obj);
        Saudacao.setText("Bem vindo "+user.getNome()+"!");
        
        PermissaoBean pb = (PermissaoBean) new UsuarioController().verificarPermissao(user);
        
        /*Libera os Campos*/
        switch (pb.getFerias()){
            case "APR":
                SoFerias.setEnabled(true);
                ApFerias.setEnabled(true);
                AcFerias.setEnabled(true);
                break;
            case "SOL":
                SoFerias.setEnabled(true);
                ApFerias.setEnabled(false);
                AcFerias.setEnabled(true);
                break;
            case "ACO":
                SoFerias.setEnabled(false);
                ApFerias.setEnabled(false);
                AcFerias.setEnabled(true);
                break;
            default:
                SoFerias.setEnabled(false);
                ApFerias.setEnabled(false);
                AcFerias.setEnabled(false);
                break;
        }
        switch (pb.getAdmissao()){
            case "APR":
                SoAdmissao.setEnabled(true);
                ApAdmissao.setEnabled(true);
                AcAdmissao.setEnabled(true);
                break;
            case "SOL":
                SoAdmissao.setEnabled(true);
                ApAdmissao.setEnabled(false);
                AcAdmissao.setEnabled(true);
                break;
            case "ACO":
                SoAdmissao.setEnabled(false);
                ApAdmissao.setEnabled(false);
                AcAdmissao.setEnabled(true);
                break;
            default:
                SoAdmissao.setEnabled(false);
                ApAdmissao.setEnabled(false);
                AcAdmissao.setEnabled(false);
                break;
        }
        switch (pb.getDemissao()){
            case "APR":
                SoDemissao.setEnabled(true);
                ApDemissao.setEnabled(true);
                AcDemissao.setEnabled(true);
                break;
            case "SOL":
                SoDemissao.setEnabled(true);
                ApDemissao.setEnabled(false);
                AcDemissao.setEnabled(true);
                break;
            case "ACO":
                SoDemissao.setEnabled(false);
                ApDemissao.setEnabled(false);
                AcDemissao.setEnabled(true);
                break;
            default:
                SoDemissao.setEnabled(false);
                ApDemissao.setEnabled(false);
                AcDemissao.setEnabled(false);
                break;
        }
        switch (pb.getPromocao()){
            case "APR":
                SoPromocao.setEnabled(true);
                ApPromocao.setEnabled(true);
                AcPromocao.setEnabled(true);
                break;
            case "SOL":
                SoPromocao.setEnabled(true);
                ApPromocao.setEnabled(false);
                AcPromocao.setEnabled(true);
                break;
            case "ACO":
                SoPromocao.setEnabled(false);
                ApPromocao.setEnabled(false);
                AcPromocao.setEnabled(true);
                break;
            default:
                SoPromocao.setEnabled(false);
                ApPromocao.setEnabled(false);
                AcPromocao.setEnabled(false);
                break;
        }
        /*Fim Libera os Campos*/

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
        SoFerias = new javax.swing.JMenuItem();
        ApFerias = new javax.swing.JMenuItem();
        AcFerias = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        SoAdmissao = new javax.swing.JMenuItem();
        ApAdmissao = new javax.swing.JMenuItem();
        AcAdmissao = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        SoDemissao = new javax.swing.JMenuItem();
        ApDemissao = new javax.swing.JMenuItem();
        AcDemissao = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        SoPromocao = new javax.swing.JMenuItem();
        ApPromocao = new javax.swing.JMenuItem();
        AcPromocao = new javax.swing.JMenuItem();

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

        SoFerias.setText("Solicitar");
        SoFerias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoFeriasActionPerformed(evt);
            }
        });
        jMenu2.add(SoFerias);

        ApFerias.setText("Aprovar");
        jMenu2.add(ApFerias);

        AcFerias.setText("Acompanhar");
        jMenu2.add(AcFerias);

        jMenu1.add(jMenu2);

        jMenu3.setText("Admissão");

        SoAdmissao.setText("Solicitar");
        SoAdmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoAdmissaoActionPerformed(evt);
            }
        });
        jMenu3.add(SoAdmissao);

        ApAdmissao.setText("Aprovar");
        jMenu3.add(ApAdmissao);

        AcAdmissao.setText("Acompanhar");
        jMenu3.add(AcAdmissao);

        jMenu1.add(jMenu3);

        jMenu4.setText("Demissão");

        SoDemissao.setText("Solicitar");
        SoDemissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoDemissaoActionPerformed(evt);
            }
        });
        jMenu4.add(SoDemissao);

        ApDemissao.setText("Aprovar");
        jMenu4.add(ApDemissao);

        AcDemissao.setText("Acompanhar");
        jMenu4.add(AcDemissao);

        jMenu1.add(jMenu4);

        jMenu5.setText("Promoção");

        SoPromocao.setText("Solicitar");
        SoPromocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoPromocaoActionPerformed(evt);
            }
        });
        jMenu5.add(SoPromocao);

        ApPromocao.setText("Aprovar");
        jMenu5.add(ApPromocao);

        AcPromocao.setText("Acompanhar");
        jMenu5.add(AcPromocao);

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

    private void SoFeriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoFeriasActionPerformed
        try{
            FormularioFerias ff = new FormularioFerias(this, true);
            ff.getInfor(user.getID(), this);
            ff.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_SoFeriasActionPerformed

    private void SoAdmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoAdmissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SoAdmissaoActionPerformed

    private void SoDemissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoDemissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SoDemissaoActionPerformed

    private void SoPromocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoPromocaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SoPromocaoActionPerformed

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
            try {
                new RHPrincipal().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(RHPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AcAdmissao;
    private javax.swing.JMenuItem AcDemissao;
    private javax.swing.JMenuItem AcFerias;
    private javax.swing.JMenuItem AcPromocao;
    private javax.swing.JMenuItem ApAdmissao;
    private javax.swing.JMenuItem ApDemissao;
    private javax.swing.JMenuItem ApFerias;
    private javax.swing.JMenuItem ApPromocao;
    private javax.swing.JMenu BTArquivos;
    private javax.swing.JMenu BTUsuarios;
    private javax.swing.JMenu BTUsuarios1;
    private javax.swing.JMenuItem CadastroUser;
    private javax.swing.JMenuItem FileDown;
    private javax.swing.JMenuItem FileUp;
    private javax.swing.JMenuItem FuncCadastro;
    private javax.swing.JLabel Saudacao;
    private javax.swing.JMenuItem SoAdmissao;
    private javax.swing.JMenuItem SoDemissao;
    private javax.swing.JMenuItem SoFerias;
    private javax.swing.JMenuItem SoPromocao;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}

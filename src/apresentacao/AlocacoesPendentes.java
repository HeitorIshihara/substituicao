package apresentacao;

import auxiliar.Perfil;
import dominio.EstadoAusencia;
import modelo.AusenciaModel;
import servico.ListaAlocacoesPendentesService;
import servico.NotificacaoService;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ProfessorModel;
import modelo.UsuarioModel;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import servico.AdministrarUsuariosService;
import servico.ListaProfessoresService;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiago Lima
 */
public class AlocacoesPendentes extends javax.swing.JFrame {

    private JFrame previousFrame;
    
    private String professorParaAlocacao;
    
    private String professorAusente;
    
    private Interval periodoAusencia;
    
    private UsuarioModel usuario;
    
    /**
     * Creates new form AlocacoesPendentes
     */
    public AlocacoesPendentes(UsuarioModel usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.usuario = usuario;
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/Thiago/Documents/NetBeansProjects/ProSub/mack_icon.jpg"));
        this.populateGrid(usuario);
    }

    public AlocacoesPendentes(JFrame previous, UsuarioModel usuario) {
        initComponents();
        previousFrame = previous;
        this.usuario = usuario;
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/Thiago/Documents/NetBeansProjects/ProSub/mack_icon.jpg"));
        
        //if (isPending) {
        btn_RejeitarAlocacao.setEnabled(false);
        this.populateGrid(usuario);

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Alocacoes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_RejeitarAlocacao = new javax.swing.JToggleButton();
        btn_Cancelar = new javax.swing.JToggleButton();
        btnCancelarAusencia = new javax.swing.JButton();
        btnCancelarAulas = new javax.swing.JButton();
        btnAlocacao = new javax.swing.JButton();
        btnEleger = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alocações Pendentes");
        setName("frm_AlocacoesPendentes"); // NOI18N
        setResizable(false);

        tbl_Alocacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Professor", "Início", "Fim", "Substituto", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_Alocacoes);

        jLabel1.setText("Ações:");

        btn_RejeitarAlocacao.setLabel("Rejeitar Alocação");
        btn_RejeitarAlocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RejeitarAlocacaoActionPerformed(evt);
            }
        });

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        btnCancelarAusencia.setText("Cancelar Ausência");
        btnCancelarAusencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAusenciaActionPerformed(evt);
            }
        });

        btnCancelarAulas.setText("Cancelar Aulas");
        btnCancelarAulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAulasActionPerformed(evt);
            }
        });

        btnAlocacao.setText("Efetuar Alocação");
        btnAlocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlocacaoActionPerformed(evt);
            }
        });

        btnEleger.setText("Eleger-se Substituto");
        btnEleger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1))
                    .addComponent(btn_RejeitarAlocacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarAusencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarAulas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlocacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEleger))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addComponent(btn_RejeitarAlocacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlocacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarAusencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarAulas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEleger)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Cancelar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        try {
            this.dispose(); 
            previousFrame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Erro ao retornar para janela anterior!");
        }   
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_RejeitarAlocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RejeitarAlocacaoActionPerformed
        MotivoRejeitarAlocacao motivoRejeitarAlocacao = new MotivoRejeitarAlocacao(this);
        motivoRejeitarAlocacao.setVisible(true);
    }//GEN-LAST:event_btn_RejeitarAlocacaoActionPerformed

    private void btnCancelarAusenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAusenciaActionPerformed
        
        if(tbl_Alocacoes.getSelectedRow() != -1){
            
            String estado = (String)tbl_Alocacoes.getValueAt(tbl_Alocacoes.getSelectedRow(), 5);
                        
            String codigo = (String)tbl_Alocacoes.getValueAt(tbl_Alocacoes.getSelectedRow(), 0);
            
            if(estado.equals("Ausência cancelada")){
                
                JOptionPane.showMessageDialog(null, "Ausência nº " + codigo + " já foi cancelada." , "Administrar Alocação", JOptionPane.INFORMATION_MESSAGE);
                
            }
            else{
                NotificacaoService notifService = new NotificacaoService();

                notifService.cancelarAusencia(codigo);

               this.populateGrid(this.usuario); 
            }
        

        }
        

    }//GEN-LAST:event_btnCancelarAusenciaActionPerformed

    private void btnCancelarAulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAulasActionPerformed
        
        if(tbl_Alocacoes.getSelectedRow() != -1){
            
            String estado = (String)tbl_Alocacoes.getValueAt(tbl_Alocacoes.getSelectedRow(), 5);
                        
            String codigo = (String)tbl_Alocacoes.getValueAt(tbl_Alocacoes.getSelectedRow(), 0);
            
            if(estado.equals("Aulas canceladas")){
                
                JOptionPane.showMessageDialog(null, "Aulas da ausência nº " + codigo + " já foram canceladas." , "Administrar Alocação", JOptionPane.INFORMATION_MESSAGE);
                
            }
        
             NotificacaoService notifService = new NotificacaoService();
         
             notifService.cancelarAulas(codigo);
         
            this.populateGrid(this.usuario);
        }
        
    }//GEN-LAST:event_btnCancelarAulasActionPerformed

    private void btnAlocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlocacaoActionPerformed
        if(tbl_Alocacoes.getSelectedRow() != -1){
            
            this.setProfessorAusente((String)tbl_Alocacoes.getValueAt(tbl_Alocacoes.getSelectedRow(), 1));
            
            String dataInicio = (String)tbl_Alocacoes.getValueAt(tbl_Alocacoes.getSelectedRow(), 2);
            String dataFim = (String)tbl_Alocacoes.getValueAt(tbl_Alocacoes.getSelectedRow(), 3);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        
            DateTime inicio = null;
            DateTime fim = null;
            try {
                inicio = new DateTime(sdf.parse(dataInicio));
                fim = new DateTime(sdf.parse(dataFim));
            } catch (ParseException ex) {
                Logger.getLogger(NotificarAusencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.setPeriodoAusencia(new Interval(inicio, fim));

            ListaProfessores listaProfessores = new ListaProfessores(this);
            listaProfessores.setVisible(true);
        }
    }//GEN-LAST:event_btnAlocacaoActionPerformed

    private void btnElegerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegerActionPerformed

        String codigo = (String)tbl_Alocacoes.getValueAt(tbl_Alocacoes.getSelectedRow(), 0);
        String nomeProfessor = (String)tbl_Alocacoes.getValueAt(tbl_Alocacoes.getSelectedRow(), 1);
        
        ListaProfessoresService profService = new ListaProfessoresService();
        
        ProfessorModel professor = profService.obterProfessorPorUsername(this.usuario.Usuario);
        
        if(nomeProfessor.equals(professor.Nome)){
            
            JOptionPane.showMessageDialog(null, "Não é possivel cobrir a própria ausência." , "Administrar Alocação", JOptionPane.INFORMATION_MESSAGE);
            
        } else{
            NotificacaoService notifService = new NotificacaoService();

            notifService.definirSubstituto(codigo, professor.Nome);

            this.populateGrid(usuario);
        }
    }//GEN-LAST:event_btnElegerActionPerformed

    public void populateGrid(){
        this.populateGrid(this.usuario);
    }
    
    private void populateGrid(UsuarioModel usuario){
        
            DefaultTableModel dm = (DefaultTableModel)tbl_Alocacoes.getModel();
            dm.getDataVector().removeAllElements();
        
            NotificacaoService listaAlocacoesPendentes = new NotificacaoService();
            List<AusenciaModel> listaAusencias = null;
                    
            Perfil perfil = usuario.profile;
            
            if(perfil.equals(Perfil.ADMINISTRADOR)){
                listaAusencias = listaAlocacoesPendentes.listarAusencias();
            }
            else if(perfil.equals(Perfil.FUNCIONARIO)){
                listaAusencias = listaAlocacoesPendentes.listarAusencias();
            }
            else if(perfil.equals(Perfil.PROFESSOR)){
                listaAusencias = listaAlocacoesPendentes.listarAusenciasPorProfessor(usuario.Usuario);
                listaAusencias.addAll(listaAlocacoesPendentes.listarAusenciasPorIndicacaoDeSubstituto(usuario.Usuario));
            }
            else{
                //Algum erro
            }
            
            for (AusenciaModel model : listaAusencias) {
                //if (model.estado.equals("Alocação pendente")) {
                    DefaultTableModel tableModel = (DefaultTableModel) tbl_Alocacoes.getModel();
                    tableModel.addRow(new Object[]{model.codigo, model.professorAusente, model.dataInicio, model.dataFim, model.professorSubstituto, model.estado});
                //}
            }
    }
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
            java.util.logging.Logger.getLogger(AlocacoesPendentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlocacoesPendentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlocacoesPendentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlocacoesPendentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                AdministrarUsuariosService userService = new AdministrarUsuariosService();

                UsuarioModel usuarioLogando = userService.obterUsuario("admin");
                
                new AlocacoesPendentes(usuarioLogando).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlocacao;
    private javax.swing.JButton btnCancelarAulas;
    private javax.swing.JButton btnCancelarAusencia;
    private javax.swing.JButton btnEleger;
    private javax.swing.JToggleButton btn_Cancelar;
    private javax.swing.JToggleButton btn_RejeitarAlocacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Alocacoes;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the professorParaAlocacao
     */
    public String getProfessorParaAlocacao() {
        return professorParaAlocacao;
    }

    /**
     * @param professorParaAlocacao the professorParaAlocacao to set
     */
    public void setProfessorParaAlocacao(String professorParaAlocacao) {
        this.professorParaAlocacao = professorParaAlocacao;
    }

    /**
     * @return the professorAusente
     */
    public String getProfessorAusente() {
        return professorAusente;
    }

    /**
     * @param professorAusente the professorAusente to set
     */
    public void setProfessorAusente(String professorAusente) {
        this.professorAusente = professorAusente;
    }
    
    public void efetuarAlocacao(String nomeProfessor){
        
        NotificacaoService notifService = new NotificacaoService();
        
        String codigo = (String)tbl_Alocacoes.getValueAt(tbl_Alocacoes.getSelectedRow(), 0);
        
        notifService.definirSubstituto(codigo, nomeProfessor);
        
    }

    /**
     * @return the periodoAusencia
     */
    public Interval getPeriodoAusencia() {
        return periodoAusencia;
    }

    /**
     * @param periodoAusencia the periodoAusencia to set
     */
    public void setPeriodoAusencia(Interval periodoAusencia) {
        this.periodoAusencia = periodoAusencia;
    }
}

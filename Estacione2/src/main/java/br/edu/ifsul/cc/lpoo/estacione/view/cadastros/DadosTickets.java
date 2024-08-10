/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.estacione.view.cadastros;

import br.edu.ifsul.cc.lpoo.estacione.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.estacione.dao.TicketAtualizadoListner;
import br.edu.ifsul.cc.lpoo.estacione.model.Carro;
import br.edu.ifsul.cc.lpoo.estacione.model.Ticket;
import br.edu.ifsul.cc.lpoo.estacione.model.Vaga;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mili
 */
public class DadosTickets extends javax.swing.JFrame {

    /**
     * Creates new form DadosTickets
     */
    PersistenciaJPA persistencia;
    private Ticket ticket;
    public DadosTickets() {
        initComponents();
        persistencia = new PersistenciaJPA();
        listarCarros();
        listarVagas();
    }
    
    private TicketAtualizadoListner listener;

    public void setListener(TicketAtualizadoListner listener) {
        this.listener = listener;
    }

    private void fecharTelaCadastro() {
        if (listener != null) {
            listener.onTicketAtualizado();
        }
        dispose();
    }
    
    public void listarCarros() {
        listCarro.removeAll();
        persistencia = new PersistenciaJPA();
        persistencia.conexaoAberta();
        List<Carro> list = persistencia.listaCarros();
        for (Carro p : list) {
            listCarro.addItem(p);
        }

        persistencia.fecharConexao();
    }
    
    public void listarVagas() {
        listVaga.removeAll();
        persistencia = new PersistenciaJPA();
        persistencia.conexaoAberta();
        List<Vaga> list = persistencia.listaVagas();
        for (Vaga p : list) {
            listVaga.addItem(p);
        }

        persistencia.fecharConexao();
    }
    
    public void setTickets(Ticket ticket) {
        this.ticket = ticket;
        carregarDadosTickets();
    }

    private void carregarDadosTickets() {
        if (ticket != null) {
            nTicket.setText(Integer.toString(ticket.getNumero()));
            dataSaida.setText(Integer.toString(ticket.getHoraSaida()));
            listCarro.setSelectedItem(ticket.getCarro());
            listVaga.setSelectedItem(ticket.getVaga());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nTicket = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        dataSaida = new javax.swing.JTextArea();
        listCarro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        listVaga = new javax.swing.JComboBox<>();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Dados Tickets");

        jLabel2.setText("N° Ticket:");

        jLabel3.setText("Hora Saída: ");

        jLabel4.setText("Carro:");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        nTicket.setColumns(20);
        nTicket.setRows(5);
        jScrollPane1.setViewportView(nTicket);

        dataSaida.setColumns(20);
        dataSaida.setRows(5);
        jScrollPane4.setViewportView(dataSaida);

        listCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listCarroActionPerformed(evt);
            }
        });

        jLabel5.setText("Vaga:");

        listVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listVagaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                    .addComponent(listCarro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(listVaga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(listCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(listVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            persistencia.conexaoAberta();
            Ticket a;
            if(ticket != null){
               a = (Ticket) persistencia.find(Ticket.class, ticket.getId()); 
            }else{
                a = new Ticket();
            }
            if(nTicket.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Insira o número do ticket!");
                return;
            }
            a.setNumero(Integer.parseInt(nTicket.getText()));
            Calendar calendarInicio = Calendar.getInstance();
            int horaInicioFiesta = calendarInicio.get(Calendar.HOUR_OF_DAY);
            a.setHoraEntrada(horaInicioFiesta);
            a.setValorHora(3.50);
            
            if(dataSaida.getText().isEmpty()){
                
            }else{
                a.setHoraSaida(Integer.parseInt(dataSaida.getText()));
                a.setValorTotal(a.calcularValorTotalTicket());  
            }
            
            Carro car = (Carro) listCarro.getSelectedItem();
            Vaga vag = (Vaga) listVaga.getSelectedItem();
            a.setCarro(car);
            a.setVaga(vag);
            vag.setTicket(a);
            
            
            persistencia.persist(a);
            if(ticket != null){
                JOptionPane.showMessageDialog(rootPane, "Ticket editado!");
            }else{
                JOptionPane.showMessageDialog(rootPane, "Ticket cadastrado!");
            }
            
        } catch (Exception ex) {
          Logger.getLogger(DadosVaga.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        persistencia.fecharConexao();

        fecharTelaCadastro();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void listCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listCarroActionPerformed

    private void listVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listVagaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listVagaActionPerformed

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
            java.util.logging.Logger.getLogger(DadosTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DadosTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DadosTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DadosTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DadosTickets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JTextArea dataSaida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JComboBox<Carro> listCarro;
    private javax.swing.JComboBox<Vaga> listVaga;
    private javax.swing.JTextArea nTicket;
    // End of variables declaration//GEN-END:variables
}

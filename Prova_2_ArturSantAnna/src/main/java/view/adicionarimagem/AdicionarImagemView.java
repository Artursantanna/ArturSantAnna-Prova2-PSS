/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.adicionarimagem;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author artur
 */
public class AdicionarImagemView extends javax.swing.JFrame {

    /**
     * Creates new form EnviarImagem
     */
    
    public AdicionarImagemView() {
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

        selecionarImagem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LabelImagem = new javax.swing.JLabel();
        Enviar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);

        selecionarImagem.setText("Selecionar Imagem");
        selecionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarImagemActionPerformed(evt);
            }
        });

        jLabel1.setText("Imagem");

        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(selecionarImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(151, 151, 151))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(LabelImagem))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(selecionarImagem))
                .addGap(18, 18, 18)
                .addComponent(LabelImagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Enviar)
                    .addComponent(Cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selecionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarImagemActionPerformed
        // TODO add your handling code here:
        /*JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);

                LabelImagem.setIcon(new ImageIcon(imagem));
                System.out.println(arquivo.toString());
            } catch (Exception ex) {
               // System.out.println(ex.printStackTrace().toString());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }*/
    }//GEN-LAST:event_selecionarImagemActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed

    }//GEN-LAST:event_EnviarActionPerformed

    public JButton getEnviar() {
        return Enviar;
    }

    public JButton getCancelar() {
        return Cancelar;
    }

    public JButton getSelecionarImagem() {
        return selecionarImagem;
    }

    public JLabel getLabelImagem() {
        return LabelImagem;
    }

    public void setLabelImagem(JLabel lblImagem) {
        this.LabelImagem = lblImagem;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Enviar;
    private javax.swing.JLabel LabelImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton selecionarImagem;
    // End of variables declaration//GEN-END:variables
}

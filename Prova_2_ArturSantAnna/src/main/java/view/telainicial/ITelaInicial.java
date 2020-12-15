/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.telainicial;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author artur
 */
public interface ITelaInicial {
    
    public JButton getBotaoAddImagem();
    
    public JButton getBotaoRemoverImagem();
    
    public JButton getBotaoCompartilhar();
    
    public JButton getBotaoNotificacoes();
    
    public JButton getjLabelFoto1();
    public void setjLabelFoto1(JButton jLabelFoto1);
    
    public JButton getjLabelFoto2();
    public void setjLabelFoto2(JButton jLabelFoto1);
    
    public JButton getjLabelFoto3();
    public void setjLabelFoto3(JButton jLabelFoto1);
    
    public JButton getjLabelFoto4();
    public void setjLabelFoto4(JButton jLabelFoto1);
    
    public JButton getjLabelFoto5();
    public void setjLabelFoto5(JButton jLabelFoto1);
    
    public JButton getjLabelFoto6();
    public void setjLabelFoto6(JButton jLabelFoto1);
    
    public JButton getjLabelFoto7();
    public void setjLabelFoto7(JButton jLabelFoto1);
    
    public JButton getjLabelFoto8();
    public void setjLabelFoto8(JButton jLabelFoto1);
    
    public JLabel getLabelNomeUsuario();
    public void setLabelNomeUsuario(JLabel labelNomeUsuario);
    
    public JLabel getLabelPermissao();
    public void setLabelPermissao(JLabel labelPermissao);
    
    public JButton getBotaoDesfazer();    
    
    public void desligaTela();
    
}

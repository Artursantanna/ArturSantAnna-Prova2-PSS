/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Imagem;
import model.Usuario;
import presenter.telaprincipaladministrador.PresenterTelaPrincipalAdministrador;
import presenter.telaprincipalusuario.PresenterTelaPrincipalUsuario;
import view.adicionarimagem.AdicionarImagemView;

/**
 *
 * @author artur
 */
public class ManipularAdicionarImagem {

    public MeiaImagem selecionar(AdicionarImagemView enviarImagem) {
        File arquivo = null;
        BufferedImage imagem = null;
        BufferedImage imagemMiniatura = null;
        MeiaImagem resultado = new MeiaImagem(imagem, imagemMiniatura);
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);
                imagemMiniatura = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 60, 60);
                resultado.setArquivo(arquivo);
                resultado.setImagem(imagem);
                resultado.setImagemMiniatura(imagemMiniatura);

                enviarImagem.getLabelImagem().setIcon(new ImageIcon(imagem));
            } catch (Exception ex) {
            }

        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
        return resultado;
    }

    public void enviar(MeiaImagem resultado, AdicionarImagemView enviarImagem, Usuario usuarioLogado) {
        File arquivo = resultado.getArquivo();
        BufferedImage imagem = resultado.getImagem();
        BufferedImage imagemMiniatura = resultado.getImagemMiniatura();
        if (arquivo != null) {
            try {
                String caminho = ".\\src\\main\\java\\imagens\\";
                int code = ArrayListImagem.getInstance().getUltimoCodigo();
                code++;
                String nomeImagem = "imagem-" + code + ".jpg";
                String nomeMiniatura = "miniatura-" + code + ".jpg";
                String caminhoCompletoImagem = caminho + nomeImagem;
                String caminhoCompletoMiniatura = caminho + nomeMiniatura;
                File outputfileImagem = new File(caminhoCompletoImagem);
                File outputfileMiniatura = new File(caminhoCompletoMiniatura);
                ImageIO.write(imagem, "jpg", outputfileImagem);
                ImageIO.write(imagemMiniatura, "jpg", outputfileMiniatura);
                JOptionPane.showMessageDialog(null, "Imagem enviada com sucesso");
                Imagem imagemCriada = this.criarImagem(nomeImagem, outputfileImagem, outputfileMiniatura, imagem, imagemMiniatura);
                ArrayListUsuario.getInstance().getUsuario(usuarioLogado.getNome()).addFotosPermitidas(imagemCriada);
                enviarImagem.dispose();
                if (usuarioLogado.isAdministrador() == true) {
                    new PresenterTelaPrincipalAdministrador().inicial(usuarioLogado);
                } else {
                    new PresenterTelaPrincipalUsuario().inicial(usuarioLogado);
                }
            } catch (IOException ex) {
                Logger.getLogger(AdicionarImagemView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void cancelar(AdicionarImagemView enviarImagem, Usuario usuarioLogado) {
        if (usuarioLogado.isAdministrador() == true) {
            new PresenterTelaPrincipalAdministrador().inicial(usuarioLogado);
        } else {
            new PresenterTelaPrincipalUsuario().inicial(usuarioLogado);
        }
        enviarImagem.dispose();
    }

    private Imagem criarImagem(String nome, File arquivo, File arquivoMiniatura, BufferedImage imagem, BufferedImage imagemMiniatura) {
        Imagem imagemCriada = new Imagem(nome, arquivo, arquivoMiniatura, imagem, imagemMiniatura);
        ArrayListImagem.getInstance().adicionarImagem(imagemCriada);
        return imagemCriada;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.telaprincipalusuario;

import business.ArrayListImagem;
import business.ArrayListUsuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import model.Imagem;
import model.Usuario;
import presenter.imagemaberta.PresenterImagemAberta;
import view.telainicial.ITelaInicial;

/**
 *
 * @author artur
 */
public class ImagemClickUsuario {

    public void doisClics(ITelaInicial telaInicial, Usuario usuarioLogado) {
        ArrayList<Imagem> imagensPermitidas = ArrayListUsuario.getInstance().getUsuario(usuarioLogado.getNome()).getFotosPermitidas();

        telaInicial.getjLabelFoto1().addMouseListener(new MouseAdapter() {
            int numeroImagem = 1;

            @Override
            public void mouseClicked(MouseEvent evt) {
                if (ArrayListImagem.getInstance().getImagem(numeroImagem) != null) {
                    if (imagensPermitidas.isEmpty()) {
                    } else {
                        for (Imagem imagemPermitida : imagensPermitidas) {
                            if (imagemPermitida.getCodigo() != ArrayListImagem.getInstance().getImagem(numeroImagem).getCodigo()) {
                            } else {
                                if (evt.getClickCount() == 2) {
                                    new PresenterImagemAberta().inicial(numeroImagem);
                                }
                            }
                        }
                    }
                }
            }
        });

        telaInicial.getjLabelFoto2().addMouseListener(new MouseAdapter() {
            int numeroImagem = 2;

            @Override
            public void mouseClicked(MouseEvent evt) {
                if (ArrayListImagem.getInstance().getImagem(numeroImagem) != null) {
                    if (imagensPermitidas.isEmpty()) {
                    } else {
                        for (Imagem imagemPermitida : imagensPermitidas) {
                            if (imagemPermitida.getCodigo() != ArrayListImagem.getInstance().getImagem(numeroImagem).getCodigo()) {
                            } else {
                                if (evt.getClickCount() == 2) {
                                    new PresenterImagemAberta().inicial(numeroImagem);
                                }
                            }
                        }
                    }
                }
            }
        });

        telaInicial.getjLabelFoto3().addMouseListener(new MouseAdapter() {
            int numeroImagem = 3;

            @Override
            public void mouseClicked(MouseEvent evt) {
                if (ArrayListImagem.getInstance().getImagem(numeroImagem) != null) {
                    if (imagensPermitidas.isEmpty()) {
                    } else {
                        for (Imagem imagemPermitida : imagensPermitidas) {
                            if (imagemPermitida.getCodigo() != ArrayListImagem.getInstance().getImagem(numeroImagem).getCodigo()) {
                            } else {
                                if (evt.getClickCount() == 2) {
                                    new PresenterImagemAberta().inicial(numeroImagem);
                                }
                            }
                        }
                    }
                }
            }
        });

        telaInicial.getjLabelFoto4().addMouseListener(new MouseAdapter() {
            int numeroImagem = 4;

            @Override
            public void mouseClicked(MouseEvent evt) {
                if (ArrayListImagem.getInstance().getImagem(numeroImagem) != null) {
                    if (imagensPermitidas.isEmpty()) {
                    } else {
                        for (Imagem imagemPermitida : imagensPermitidas) {
                            if (imagemPermitida.getCodigo() != ArrayListImagem.getInstance().getImagem(numeroImagem).getCodigo()) {
                            } else {
                                if (evt.getClickCount() == 2) {
                                    new PresenterImagemAberta().inicial(numeroImagem);
                                }
                            }
                        }
                    }
                }
            }
        });

        telaInicial.getjLabelFoto5().addMouseListener(new MouseAdapter() {
            int numeroImagem = 5;

            @Override
            public void mouseClicked(MouseEvent evt) {
                if (ArrayListImagem.getInstance().getImagem(numeroImagem) != null) {
                    if (imagensPermitidas.isEmpty()) {
                    } else {
                        for (Imagem imagemPermitida : imagensPermitidas) {
                            if (imagemPermitida.getCodigo() != ArrayListImagem.getInstance().getImagem(numeroImagem).getCodigo()) {
                            } else {
                                if (evt.getClickCount() == 2) {
                                    new PresenterImagemAberta().inicial(numeroImagem);
                                }
                            }
                        }
                    }
                }
            }
        });

        telaInicial.getjLabelFoto6().addMouseListener(new MouseAdapter() {
            int numeroImagem = 6;

            @Override
            public void mouseClicked(MouseEvent evt) {
                if (ArrayListImagem.getInstance().getImagem(numeroImagem) != null) {
                    if (imagensPermitidas.isEmpty()) {
                    } else {
                        for (Imagem imagemPermitida : imagensPermitidas) {
                            if (imagemPermitida.getCodigo() != ArrayListImagem.getInstance().getImagem(numeroImagem).getCodigo()) {
                            } else {
                                if (evt.getClickCount() == 2) {
                                    new PresenterImagemAberta().inicial(numeroImagem);
                                }
                            }
                        }
                    }
                }
            }
        });

        telaInicial.getjLabelFoto7().addMouseListener(new MouseAdapter() {
            int numeroImagem = 7;

            @Override
            public void mouseClicked(MouseEvent evt) {
                if (ArrayListImagem.getInstance().getImagem(numeroImagem) != null) {
                    if (imagensPermitidas.isEmpty()) {
                    } else {
                        for (Imagem imagemPermitida : imagensPermitidas) {
                            if (imagemPermitida.getCodigo() != ArrayListImagem.getInstance().getImagem(numeroImagem).getCodigo()) {
                            } else {
                                if (evt.getClickCount() == 2) {
                                    new PresenterImagemAberta().inicial(numeroImagem);
                                }
                            }
                        }
                    }
                }
            }
        });

        telaInicial.getjLabelFoto8().addMouseListener(new MouseAdapter() {
            int numeroImagem = 8;

            @Override
            public void mouseClicked(MouseEvent evt) {
                if (ArrayListImagem.getInstance().getImagem(numeroImagem) != null) {
                    if (imagensPermitidas.isEmpty()) {
                    } else {
                        for (Imagem imagemPermitida : imagensPermitidas) {
                            if (imagemPermitida.getCodigo() != ArrayListImagem.getInstance().getImagem(numeroImagem).getCodigo()) {
                            } else {
                                if (evt.getClickCount() == 2) {
                                    new PresenterImagemAberta().inicial(numeroImagem);
                                }
                            }
                        }
                    }
                }
            }
        });
    }

}

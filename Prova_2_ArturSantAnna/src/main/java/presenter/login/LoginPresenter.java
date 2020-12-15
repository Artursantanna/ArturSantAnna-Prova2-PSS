package presenter.Login;

import business.ArrayListUsuario;
import business.VerificaLogin;
import java.awt.event.ActionEvent;
import view.login.LoginView;

public class LoginPresenter {

    private LoginView view = new LoginView();

    public void iniciar() {
        this.view.setVisible(true);
        this.view.getBotaosalvar().addActionListener((ActionEvent e) -> {
            new VerificaLogin().verifica(view, ArrayListUsuario.getInstance());
        });

    }
}

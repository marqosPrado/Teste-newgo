package br.com.marcosprado;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Senha {
    private String conteudo;

    public Senha(String conteudo) {
        setSenha(conteudo);
    }

    public String getSenha() {
        return this.conteudo;
    }

    public void setSenha(String conteudo) {
        if (!validaSenha(conteudo)) {
            throw new RuntimeException("Padrao de senha incorreta");
        }
        this.conteudo = conteudo;
    }
    public boolean validaSenha(String senha) {
        String regex = "(?=.[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$/])(?=.[a-zA-Z\\d]){10,30}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }
}

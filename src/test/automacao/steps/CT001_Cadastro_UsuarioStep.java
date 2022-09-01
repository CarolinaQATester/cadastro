public class CT001_Cadastro_UsuarioStep {
    public CT001_Cadastro_UsuarioStep() {
        Dado("^clico no botao comecar a automação web$", () -> {
        });
        E("^clico no menu formulario$", () -> {
        });
        E("^clico no criar usuario$", () -> {
        });
        Quando("^preencho todos os campos: <nome> <ultimoNome> <email> <endereco> <universidade> <profissao> <genero> <idade>$", () -> {
        });
        E("^clico em criar$", () -> {
        });
        Entao("^verifico se o usuario foi cadastrado no sistema$", () -> {
        });
    }
}

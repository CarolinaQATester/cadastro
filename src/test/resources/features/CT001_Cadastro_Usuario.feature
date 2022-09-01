#language: pt

@CT001
Funcionalidade: Realizar o cadastro do usuario no sistema

Esquema do Cenario: Validar se o sisemta está cadastrando o usuario com sucesso

    Dado clico no botao comecar a automação web
    E clico no menu formulario
    E clico no criar usuario
    Quando preencho todos os campos: <nome> <ultimoNome> <email> <endereco> <univercidade> <profissao> <genero> <idade>
    E clico em criar
    Entao verifico se o usuario foi cadastrado no sistema "Usuário Criado com sucesso"
    #E verificos se os dados estao corretos: <nome> <ultimoNome> <email> <endereco> <univercidade> <profissao> <genero> <idade>

Exemplos:
    |nome      |ultimoNome |email            |endereco        |univercidade|profissao              |genero    |idade|
    |"Carolina"|"Mesquita" |"carol@qa.com.br"|"rua dos sonhos"|"uniasselvi"|"analista de qualidade"|"feminino"|"39" |
# Projeto: Lista de Compras
## Informações do Projeto
- Feito para a matéria de POO 2024.1.
- Demais comentários e anotações da equipe estarão aqui para que possamos gerenciar bem o que estamos fazendo.
- Comentários rápidos colocar quando fizer commit.

## Estrutura Geral

`src`: Pasta contendo o código (separada em pastas que são os package).

`lib`: Pasta contendo as bibliotecas usadas.

`bin`: Executáveis.

> Qualquer coisa fora dessa estrutura (como o próprio README.md) não interfere diretamente no projeto, então não é necessário modificar

## Estrutura de Pacotes (packages)

`principal`: Pacote com o que vai ser mostrado na tela (antes do front-end).

## Comandos Rápidos do Git

> Para configurar, consultar o guia que a professora disponibilizou (mas vai usar `git config`).

> Para checar a configuração, use `git config --list` e para sair da visualização do comando, use `Shift + Q`

`git init`: Inicializa a pasta atual para que o Git considere como um novo "espaço de trabalho".

`git add .`: Adiciona os arquivos no repositório local.

`git commit -m "mensagem do commit"`: Adiciona as mudanças no repositório local.

> Os próximos dois comandos só precisam ser feitos uma vez na pasta usada para o repositório.

`git branch -M main`: Diz qual será o "branch" que será editado.

`git remote add origin https://github.com/username/repo.git`: Diz qual repositório no **Github** será modificado (para combinar com o repositório local), que no nosso caso é `git remote add origin https://github.com/Jeasiel/listadecompras_poo.git`.

> Os seguintes comandos usam o repositório remoto (do Github).

`git push -u origin main`: Publica o repositório para o Github.

`git pull origin main`: Atualiza o "branch" atual caso esteja atrasado em relação ao publicado no Github.

## Outras ferramentas que poderão ser utilizadas
**Maven**

**Spring**
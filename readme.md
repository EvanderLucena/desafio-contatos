# Desafio Evander

Este é o projeto Desafio Evander, um aplicativo desenvolvido para cadastros de contatos.

## Pré-requisitos

Certifique-se de ter os seguintes requisitos instalados em sua máquina:

- JDK 1.8 ou superior
- Maven 3.6.3 ou superior
- Banco de dados H2 Database
- IDE de sua preferência (recomendado: IntelliJ IDEA)

## Instalação

1. Clone este repositório em sua máquina local:

    git clone https://github.com/EvanderLucena/desafio-contatos
2. Importe o projeto em sua IDE.

3. Configure as informações do banco de dados no arquivo `application.properties`.

4. Execute a classe `DesafioEvanderApplication.java` para iniciar o aplicativo.

## Documentação da API

A documentação da API é fornecida usando o Swagger. Para acessar a documentação, siga estas etapas:

1. Inicie o aplicativo.

2. Abra o navegador e acesse o seguinte URL:
 http://localhost:8080/swagger-ui.html

3. A documentação da API será exibida, mostrando todos os endpoints disponíveis e suas descrições.
## Endpoints

### Listar todos os contatos

Endpoint: `GET /contacts`

Retorna uma lista de todos os contatos cadastrados.

### Obter um contato específico

Endpoint: `GET /contacts/{id}`

Parâmetros:
- `{id}`: O ID do contato a ser obtido.

### Criar um novo contato

Endpoint: `POST /contacts`

Cria um novo contato com base nos dados fornecidos no corpo da solicitação.

### Atualizar um contato existente

Endpoint: `PUT /contacts/{id}`

Parâmetros:
- `{id}`: O ID do contato a ser atualizado.

Atualiza um contato existente com base nos dados fornecidos no corpo da solicitação.

### Excluir um contato

Endpoint: `DELETE /contacts/{id}`

Parâmetros:
- `{id}`: O ID do contato a ser excluído.

Exclui um contato existente com base no ID fornecido.


## Contribuição

Se você deseja contribuir para este projeto, siga as etapas abaixo:

1. Faça um fork deste repositório.

2. Crie uma nova branch: `git checkout -b minha-branch`.

3. Faça as alterações necessárias e commit: `git commit -m "Minha contribuição"`.

4. Envie as alterações para o repositório remoto: `git push origin minha-branch`.

5. Crie um pull request para a branch principal.

## Contato

Se você tiver alguma dúvida ou sugestão, sinta-se à vontade para entrar em contato:

Email: evander.willian@gmail.com

GitHub: EvanderLucena

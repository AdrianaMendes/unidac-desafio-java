[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE) ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white) ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![Heroku](https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white) ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white) ![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

# Nosso Café

O presente projeto é uma aplicação web composta por backend em Java com Spring Boot e frontend desenvolvido em Angular. Durante o desenvolvimento, foram utilizadas as bibliotecas Lombok e Swagger, além do banco de dados em memória H2 para testes. A aplicação está hospedada na plataforma Heroku, utilizando o banco de dados PostgreSQL.

O contexto da aplicação envolve o gerenciamento de colaboradores de uma empresa que devem levar um ou mais itens para o café da manhã, evitando repetições.

![Nosso Café](images/print-frontend.png)

## Heroku

O projeto está instanciado no Heroku e está disponível nos links abaixo:

### Frontend

<https://unidac-nosso-cafe-frontend.herokuapp.com/>

### Backend

<https://unidac-nosso-cafe-backend.herokuapp.com/>

É importante ressaltar que a conta utilizada é gratuita, portanto ao acessar pela primeira vez irá demorar um pouco para iniciar (devido às limitações da conta grátis).

## Swagger

O projeto foi desenvolvido com a documentação Swagger, que está disponível no aquivo ```swagger.json```.

## Deploy

1. Clone o repositório:
   ```bash
   git clone git clone https://github.com/AdrianaMendes/unidac-desafio-java.git
   ```

2. Navegue até o diretório do projeto e execute:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Acesse o sistema em:
   ```
   http://localhost:8080/swagger-ui/index.html

Para testar localmente o Swagger e a aplicação com o H2 apenas alterar o arquivo properties do backend conforme mostrado abaixo.

```
# Database configuration
spring.datasource.url=jdbc:h2:mem:spring
spring.datasource.username=admin
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

#spring.jpa.generate-ddl=true
#spring.jpa.hibernate.ddl-auto=create
```

![Swagger](images/swagger-home.png)

## Banco de dados

- O projeto utiliza o **H2 Database** em memória.
  ```
  http://localhost:8080/h2-console
  ```
  - JDBC URL: `jdbc:h2:mem:spring`
  - Usuário: `admin`

## Licença

Este projeto está sob licença Apache 2.0 © 2022 Adriana Mirian Mendes Cardoso.
Para mais informações acesse o arquivo :scroll: `LICENSE`.

## Contato

**Adriana Cardoso**  
Desenvolvedora Java | Spring Boot | Angular  

- [LinkedIn](https://www.linkedin.com/in/amendescardoso/)  
- 📧 adrianamirianmc@gmail.com

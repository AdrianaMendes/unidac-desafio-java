[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE) ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white) ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![Heroku](https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white) ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white) ![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

# Nosso Café

O presente projeto é uma aplicação WEB com backend em java spring e angular no frontend. No desenvolvimento foi empregado Lombok, Swagger e servidor H2. A infraestrutura empregada para hospedar o servidor foi o Heroku utilizando o banco de dados Postgresql. O contexto da aplicação é sobre os colaboradores de uma empresa que tem que levar um ou mais itens para o café da manhã que não seja repetido. A aplicação WEB tem suporte de regionalização e responsividade.

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

## Teste localhost

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

Para acessar a documentação swagger acesse esta URL: http://localhost:8080/swagger-ui/index.html

![Swagger](images/swagger-home.png)

Para acessar o banco de dados H2: http://localhost:8080/h2-console/

![H2](images/h2.png)

## Licença

Este projeto está sob licença Apache 2.0 © 2022 Adriana Mirian Mendes Cardoso.
Para mais informações acesse o arquivo :scroll: `LICENSE`.

## Contato

:email: E-Mail: ​[adrianamirianmc@gmail.com](adrianamirianmc@gmail.com)

:clipboard: Linkedin: ​[https://www.linkedin.com/in/adriana-mirian-mendes-cardoso](https://www.linkedin.com/in/adriana-mirian-mendes-cardoso)

:package: GitHub:  [https://github.com/AdrianaMendes](https://github.com/AdrianaMendes)

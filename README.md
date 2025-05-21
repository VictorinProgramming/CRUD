# CRUD
Esse repositório é um teste para a HEPTA tecnologia

🚀 Tecnologias Utilizadas:
Java 17
Spring Boot 3
Spring Web
Spring Data JPA
Spring Validation
Springdoc OpenAPI (Swagger)
H2 Database (banco de dados em memória)
Lombok
JUnit 5 + Mockito (para testes)
Maven

📝 Requisitos:
Java 17+
Maven 3.8+
IntelliJ IDEA (recomendado)

🌐 Ambiente com Proxy (Corporativo):
Devido ao uso em rede corporativa, foi necessária a configuração do proxy no Maven:
Configuração do settings.xm
Crie/edite o arquivo ~/.m2/settings.xml com o seguinte conteúdo:

<?xml version="1.0"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">

    <proxies>
        <proxy>
            <id>proxy-corporativo</id>
            <active>true</active>
            <protocol>http</protocol>
            <host>192.168.28.20</host>
            <port>3128</port>
            <username>vhlse.terceirizado</username>
            <password>Victor@842867</password>
            <nonProxyHosts>localhost|127.0.0.1|*.trt10.jus.br</nonProxyHosts>
        </proxy>
    </proxies>

    <servers>
        <server>
            <id>central</id>
            <username>vhlse.terceirizado</username>
            <password>Victor@842867</password>
        </server>
    </servers>
</settings>

⚙️ Como Executar o Projeto:
Clone o repositório:
cd projeto-crud
Compile o projeto
Rode a aplicação:
Acesse a documentação da API: http://localhost:8080/swagger-ui.html ou dependendo da versão do Springdoc: http://localhost:8080/swagger-ui/index.html
O Springdoc já vem configurado com os endpoints a partir do momento em que você anota seus controladores com @RestController e usa @Operation, @Parameter etc. (essas anotações são opcionais, mas ajudam na personalização).


💡 Funcionalidades da API:
CRUD de Cargos
POST /cargos
GET /cargos
GET /cargos/{id}
PUT /cargos/{id}
DELETE /cargos/{id}
CRUD de Empregados
POST /empregados
GET /empregados
GET /empregados/{id}
PUT /empregados/{id}
DELETE /empregados/{id}
Filtros e Paginação
GET /empregados?nome=João&cargo=Gerente&page=0&size=5

✍️ Testes Automatizados:
Testes unitários implementados com
EmpregadoServiceTest
Mockito para mocks
Executar testes com: mvn test

O arquiv setting.xml foi adicionado ao arquivo;

Visto que trabalho atualmente no TRT de Brasília, o desenvolvimento foi feito no local de trabalho, onde ultilizava-se a rede do Tribunal. 

🚧 Melhorias Futuras:
Autenticação JWT
Integração com banco PostgreSQL
Deploy com Docker

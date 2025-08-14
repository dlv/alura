# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.3/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.3/gradle-plugin/packaging-oci-image.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.5.3/reference/using/devtools.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.3/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Flyway Migration](https://docs.spring.io/spring-boot/3.5.3/how-to/data-initialization.html#howto.data-initialization.migration-tool.flyway)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)



### Insert User

* insert into usuarios(id, login, senha) values(1,'ana.souza@voll.med','$2a$12$WPUUGbrWezFxL.gf5TKRM.dpRF.Tbx1gr7Vm9C7x2xp8uuyfUIW.6');

* update usuarios set senha = '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.';


### Deploy

* No maven

```
mvn clean package
```

* Executar o bootBuildImage no gradle
* java -Dspring.profiles.active=prod -DDATASOURCE_URL=jdbc:mysql://localhost/vollmed_api -DDATASOURCE_USERNAME=root -DDATASOURCE_PASSWORD=root -jar build/libs/api-0.0.1-SNAPSHOT.jar

### Native Image com Spring Boot 3

* Adicionar no pom.xml

```xml
<plugin>
  <groupId>org.graalvm.buildtools</groupId>
  <artifactId>native-maven-plugin</artifactId>
</plugin>
```

* Executar no terminal
  * Necessário a instalação do [GraalVM](https://www.graalvm.org/)

```bash
./mvnw -Pnative native:compile
```

* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/reference/packaging/native-image/index.html)
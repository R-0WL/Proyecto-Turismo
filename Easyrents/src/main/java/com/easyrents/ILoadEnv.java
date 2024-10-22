package com.easyrents;

import io.github.cdimascio.dotenv.Dotenv;

//carga el archivo .env, el cual contiene las variables de entorno
public interface ILoadEnv{
    Dotenv dotenv = Dotenv.load();
    String URL = dotenv.get("DB_URL");
    String USER = dotenv.get("DB_USER");
    String PASSWORD = dotenv.get("DB_PASSWORD");
}
// <dependency>
//   <groupId>io.github.cdimascio</groupId>
//   <artifactId>dotenv-java</artifactId>
//   <version>5.2.2</version>
// </dependency>

//agregar a pom.xml
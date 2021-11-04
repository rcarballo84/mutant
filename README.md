# Examen de MercadoLibre

El objetivo del problema es poder detectar a traves de una API REST, si un ADN es Mutante o Humano.

## Tecnologias utilizadas 🛠️

* [NetBeans IDE](https://netbeans.apache.org/download/index.html) - IDE Desarrollo
* [SparkJava](http://sparkjava.com/) - Framework para crear aplicaciones web en JAVA
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Gson](https://github.com/google/gson)

## Ejecutando las pruebas ⚙️

* [Postman](https://www.postman.com/home) - Para el testeo de los servicios
* [Jacoco](https://www.eclemma.org/jacoco/trunk/doc/maven.html) - Para el coverage de las pruebas

## Aplicacion 🚀

Consta de 2 servicios desplegados en [Amazon Elastic Beanstalk](https://docs.aws.amazon.com/elastic-beanstalk/index.html)

URL: http://mutantsparkapp-env.eba-3mnzytqq.us-east-2.elasticbeanstalk.com/

### 1) Servicio Mutant
  - **URL**: http://mutantsparkapp-env.eba-3mnzytqq.us-east-2.elasticbeanstalk.com/mutant/
  
    **Objetivo**
    Procesar una cadena de ADN y determinar si es mutante o humano
    
    **Request**
    - HTTP Method: POST
    - Content-Type: Application/JSON
    
    **JSON ejemplo**
    ```
    {
     "dna":[
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
     ]
    }
    ```
    
    **Response**
    - HTTP 200-OK si es mutante
    - HTTP 403-Forbbiden en caso contrario
  

### 2) Servicio Stats
  - **URL**: http://mutantsparkapp-env.eba-3mnzytqq.us-east-2.elasticbeanstalk.com/stats/
  
    **Objetivo**
    Solicitar las estadisticas de los resultados de adn determinando mutantes y humanos
    
    **Request**
    - HTTP Method: GET
    - Content-Type: No requerido
    
    **Response**
    
    **JSON salida**
    ```
    {
       "count_mutant_dna":40,
       "count_human_dna":100,
       "ratio":0.4
    }
    ```

### Instalación / Actualización 🔧

_Para Instalar / Actualizar la API, se debera hacer lo siguiente:

1) Si tiene el IDE instalado, dentro del mismo se debera aplicar la opcion "Clean and Build" sobre el proyecto.
Otra forma es abrir el simbolo del sistema, y dentro de la carpeta del proyecto donde se encuentra el archivo POM.XML ejecutar:

```
$ mvn clean install
```
De esta forma se empaqueta el archivo .JAR ubicado en la carpeta ..MutantSpark\target

2) El proximo paso es subir el archivo .JAR en el cloud [Amazon Elastic Beanstalk](https://docs.aws.amazon.com/elastic-beanstalk/index.html).
Se debe generar una instancia del servidor y habilitar el puerto 8080 que es el que usa SparkJava.


## Coverage 📖

Todavia no se implemento, pero se realizaran con Jacoco

## Autor ✒️

* **Rodolfo Carballo** - *Trabajo Inicial* - [rcarballo84](https://github.com/rcarballo84/)



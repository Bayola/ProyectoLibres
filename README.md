# ProyectoLibres
#Sistema Estudiantil - Aula virtual

Tiene como objetivo implementar un sistema que actue como aula virtual, para ello se cuenta con 5 entidades dispuestas en el modelo del proyecto.
La aplicación Web desarrollada permite al usuario, sea este estudiante, profesor o administrador realizar diferentes acciones dependiendo del tipo de usuario.
La aplicación permite realizar las operaciones de consulta, listado, eliminación, edición, actualización de datos de las entidades, cabe recalcar que depende del tipo de usuario.
La aplicación web trabaja con PostgreSQL.

A continuación se describe la estructura de carpetas.

En la rama master principal se tiene:
- Primer nivel
La carpeta root con nombre ProyectoIIB
Licencia GNU GLP v3.0

    - Segundo nivel
    WebContent cuyo contenido es la vista del MVC
    
        --Tercer nivel
        META-INF

            ---Cuarto nivel
            Archivo MANIFEST.MF de la aplicación
  
        --Tercer nivel
        WEB-INF
            ---Cuarto nivel
            Archivo Beans.xml cuyo contenido perite realizar anotaciones para el manejo de JPA

        --Tercer nivel
        img: contiene los archivos tipo jpg, jpeg, png que se incluyen en las servlet para dar vista amigable al usuario

        --Tercer nivel
        Archivos.jsp: que actuan como vista de la aplicacion para la interaccion con el usuario

  - Segundo nivel
  build/classes cuyo contenido es el controlador y el modelo del MVC
    
        --Tercer nivel
        META-INF
    
            ---Cuarto nivel
            persistence.xml contiene la información que permite la conexión entre el Wildfly con la base de datos 

        --Tercer nivel
        ec/epn/proyecto
    
            ---Cuarto nivel
            controlador: esta carpeta contiene todos los Servlet que actuan como controladores en el MVC
            ---Cuarto nivel
            modelo: esta carpeta contiene todas las clases .java que representan el modelo de datos de las diferentes entidades
            ---Cuarto nivel
            Proyecto.class: clase java que resulta de la ejecución como servidor
  
   - Segundo nivel
  doc contiene la documentacion realizada con los comentarios en Javadoc
    
        --Tercer nivel
        ec/epn/proyecto/modelo: contienen los archivos .html que permiten crear la documentación java
    
        --Tercer nivel
        index-files: contiene los archivos para la visualización del javadoc

- Segundo nivel
src contiene el contenido java 
      -- Tercer nivel 
      META-INF
  
          ---Cuarto nivel
          persistence.xml: este archivo permite la conexion entre la base de datos y Wildfly
  
      --Tercer nivel
      ec/epn/proyecto

          ---Cuarto nivel
          controlador: esta carpeta contiene todos los Servlet que actuan como controladores en el MVC
      
          ---Cuarto nivel
          modelo: esta carpeta contiene todas las clases .java que representan el modelo de datos de las diferentes entidades
      
          ---Cuarto nivel
          Proyecto.class: clase java que resulta de la ejecución como servidor



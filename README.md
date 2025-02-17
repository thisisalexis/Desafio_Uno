Alexis Bravo - http://thisisalexis.herokuapp.com
             - alexis.ve@gmail.com
             - https://www.linkedin.com/in/alexis-jose-bravo-llovera/

# Aplicación para obtener períodos o fechas faltantes (NIVEL 3)

Esta aplicación se conecta a un servicio externo (especificado en el archivo application.properties) y obtiene del mismo
una secuencia ascendente de fechas con algunos períodos faltantes.

Esta aplicación ofrece un API pública que expone un endpoint que, al consultarse, devuelve las fechas mostradas por el
endpoint antes mencionado y, adicionalmente, devuelve las fechas faltantes en la secuencia original generada por éste.


Pre requisitos:

Debe tener instalada y desplegada localmente la aplicación Generador_Datos_Desafio_Uno (https://github.com/previred/Generador_Datos_Desafio_Uno)

Si no tiene dicha aplicación, puede descargar el código fuente de la misma y seguir las instrucciones de instalación y despliegue.

Una vez instalada la aplicación, verifique que la misma esté funcionando en la siguiente URL http://127.0.0.1:8080/periodos/api.

SI es que dicha aplicación está funcionando en otro servidor o puerto, debe entrar al archivo application.properties de este proyecto y reemplazar el valor actual de la propiedad application.external-resources.ws.incomplete-periods-url por la nueva URL

Instalación:

1 - Descargue el código fuente de esta aplicación
2 - Desde la consola de comandos de su equipo, ingrese al directorio raíz del proyecto.
3 - Ejecute el siguiente comando en la consola: gradlew bootJar. Esta acción debería haber creado el archivo build/libs/periods-0.0.1-SNAPSHOT.jar en el proyecto
4 - Desde la consola de comandos (en el directorio raíz del proyecto) ejecute el siguiente comando: java -jar build/libs/periods-0.0.1-SNAPSHOT.jar
5 - Con esto la aplicación debería haber iniciado en el puerto 8087 (puede cambiar el puerto desde el archivo application.properties)
6 - Siga los pasos de la siguiente sección, Utilizando el Servicio, para poder utilizar el API expuesta por esta aplicación

Utilizando el servicio
1 - Para consumir el servicio ejecute la siguiente petición Http: curl -X GET --header 'Accept: application/json' 'http://localhost:8087/challenge/periods/missing-periods'
2 - Si es que el puerto 8087 de su equipo estuviese ocupado, puede ingresar al archivo application.properties de este proyecto y modificar la propiedad server.port, reemplazando el valor actual por algún puerto que no tenga en uso
3 - Puede revisar el archivo swagger.yaml desde Swagger Editor para verificar la documentación del API
4 -Una vez ejecutado el servicio, debería poder ver una respuesta en el cuerpo de la respuesta http, como la siguiente (puede encontrar una respuesta de ejemplo en el archivo example-response.json en la raíz del proyecto):

{
    "id": 1,
    "from": "2000-10-01",
    "to": "2014-06-01",
    "received_dates": [
        "2000-10-01",
        "2000-11-01",
        "2000-12-01",
        "2001-01-01",
        "2001-03-01",
        "2001-04-01",
        "2001-06-01",
        "2001-09-01",
        "2001-11-01",
        "2001-12-01",
        "2002-01-01",
        "2002-02-01",
        "2002-06-01",
        "2002-08-01",
        "2002-10-01",
        "2002-11-01",
        "2002-12-01",
        "2003-05-01",
        "2003-06-01",
        "2003-09-01",
        "2003-10-01",
        "2003-11-01",
        "2004-01-01",
        "2004-02-01",
        "2004-04-01",
        "2004-06-01",
        "2004-07-01",
        "2004-08-01",
        "2004-10-01",
        "2004-12-01",
        "2005-01-01",
        "2005-02-01",
        "2005-04-01",
        "2005-05-01",
        "2005-11-01",
        "2005-12-01",
        "2006-01-01",
        "2006-03-01",
        "2006-04-01",
        "2006-06-01",
        "2006-07-01",
        "2006-08-01",
        "2006-10-01",
        "2006-12-01",
        "2007-01-01",
        "2007-03-01",
        "2007-04-01",
        "2007-05-01",
        "2007-07-01",
        "2007-09-01",
        "2007-11-01",
        "2007-12-01",
        "2008-01-01",
        "2008-02-01",
        "2008-05-01",
        "2008-07-01",
        "2008-10-01",
        "2008-11-01",
        "2009-03-01",
        "2009-04-01",
        "2009-06-01",
        "2009-09-01",
        "2009-12-01",
        "2010-01-01",
        "2010-02-01",
        "2010-03-01",
        "2010-05-01",
        "2010-06-01",
        "2010-07-01",
        "2010-10-01",
        "2010-11-01",
        "2011-01-01",
        "2011-02-01",
        "2011-03-01",
        "2011-06-01",
        "2011-07-01",
        "2011-08-01",
        "2011-09-01",
        "2011-10-01",
        "2011-12-01",
        "2012-01-01",
        "2012-02-01",
        "2012-03-01",
        "2012-06-01",
        "2012-07-01",
        "2012-08-01",
        "2012-09-01",
        "2012-10-01",
        "2012-11-01",
        "2012-12-01",
        "2013-01-01",
        "2013-02-01",
        "2013-03-01",
        "2013-04-01",
        "2013-09-01",
        "2014-01-01",
        "2014-02-01",
        "2014-04-01"
    ],
    "missing_periods": [
        "2001-02-01",
        "2001-05-01",
        "2001-07-01",
        "2001-08-01",
        "2001-10-01",
        "2002-03-01",
        "2002-04-01",
        "2002-05-01",
        "2002-07-01",
        "2002-09-01",
        "2003-01-01",
        "2003-02-01",
        "2003-03-01",
        "2003-04-01",
        "2003-07-01",
        "2003-08-01",
        "2003-12-01",
        "2004-03-01",
        "2004-05-01",
        "2004-09-01",
        "2004-11-01",
        "2005-03-01",
        "2005-06-01",
        "2005-07-01",
        "2005-08-01",
        "2005-09-01",
        "2005-10-01",
        "2006-02-01",
        "2006-05-01",
        "2006-09-01",
        "2006-11-01",
        "2007-02-01",
        "2007-06-01",
        "2007-08-01",
        "2007-10-01",
        "2008-03-01",
        "2008-04-01",
        "2008-06-01",
        "2008-08-01",
        "2008-09-01",
        "2008-12-01",
        "2009-01-01",
        "2009-02-01",
        "2009-05-01",
        "2009-07-01",
        "2009-08-01",
        "2009-10-01",
        "2009-11-01",
        "2010-04-01",
        "2010-08-01",
        "2010-09-01",
        "2010-12-01",
        "2011-04-01",
        "2011-05-01",
        "2011-11-01",
        "2012-04-01",
        "2012-05-01",
        "2013-05-01",
        "2013-06-01",
        "2013-07-01",
        "2013-08-01",
        "2013-10-01",
        "2013-11-01",
        "2013-12-01",
        "2014-03-01",
        "2014-05-01",
        "2014-06-01"
    ]
}
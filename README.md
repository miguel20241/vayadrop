# vayadrop

## Iniciar servidor MySql dockerizado
#### 1 - Levantar el contenedor
Desde la carpeta raíz del proyecto ejecutar el siguiente comando:
~~~
docker-compose up
~~~
#### 2 - Obtener la ip del contenedor
Buscar los contenedores que están levantados de MySQL 
~~~
docker ps | grep mysql
~~~
De aquí obtenemos el id del contenedor: "835f0d467bb4"
~~~
    835f0d467bb4   vayadrop_mysql   "docker-entrypoint.s…"   3 minutes ago   Up 3 minutes   0.0.0.0:3306->3306/tcp, :::3306->3306/tcp, 33060/tcp   vayadrop_mysql_1
~~~
Averiguamos la ip de este contenedor
~~~
docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' 835f0d467bb4
~~~
~~~
    172.19.0.2
~~~
#### 3 - Conectarse al servidor MySQL
~~~
mysql -h 172.19.0.2 -P 3306 --protocol=tcp -u root -p
~~~
~~~
    Enter password: 
    Welcome to the MySQL monitor.  Commands end with ; or \g.
    Your MySQL connection id is 11
    Server version: 9.0.0 MySQL Community Server - GPL
~~~
~~~
mysql> show databases;
~~~
~~~
    +--------------------+
    | Database           |
    +--------------------+
    | information_schema |
    | mysql              |
    | performance_schema |
    | sys                |
    | vayadrop_db        |
    +--------------------+
~~~
Si no se muestra la base de datos vayadrop_db, es necesario crearla:
~~~
create dabase vayadrop_db;
~~~
Una vez creada hay que decirle que utilize esa base de datos:
~~~
use vayadrop_db;
~~~

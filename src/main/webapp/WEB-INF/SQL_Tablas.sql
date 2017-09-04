drop table GONZALO.CARRITO;
drop table GONZALO.USUARIOS;
drop table GONZALO.ARTICULOS;
drop table GONZALO.ROLES;

create table Usuarios
(
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    NOMBRE VARCHAR(50) NOT NULL,
    NOMBRE_USUARIO VARCHAR(50) NOT NULL ,
    CORREO VARCHAR(50) NOT NULL,
    PUNTOS INTEGER NOT NULL ,
    CONECTADO BOOLEAN NOT NULL,
    PASSWORD VARCHAR(30) NOT NULL,

   PRIMARY KEY(NOMBRE_USUARIO)
   
);

create table Roles
(
    NOMBRE_USUARIO VARCHAR(50) NOT NULL,
    ROL VARCHAR(50) NOT NULL


);


create table Articulos
(
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    NOMBRE VARCHAR(50) NOT NULL,
    PRECIO FLOAT NOT NULL,
    DESCRIPCION VARCHAR(100),
    IMAGEN VARCHAR(50),
    CATEGORIA VARCHAR(15) NOT NULL CHECK(CATEGORIA='Ordenadores' OR CATEGORIA='Componentes' OR CATEGORIA='Smartphones'),
    NUMERO_UNIDADES INTEGER NOT NULL CHECK(NUMERO_UNIDADES>=0),

    PRIMARY KEY(ID)
   
);

create table Carrito(
    
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    ID_ARTICULO INTEGER CONSTRAINT fk_id_articulo REFERENCES GONZALO.ARTICULOS,
    NOMBRE_USUARIO VARCHAR(50) CONSTRAINT fk_nombre_usuario REFERENCES GONZALO.USUARIOS ON DELETE CASCADE,
    FECHA DATE,
    
    PRIMARY KEY(ID)
);


-- -------------      USUARIOS      --------------------------------
insert into Usuarios (NOMBRE,NOMBRE_USUARIO,CORREO,PUNTOS,CONECTADO,PASSWORD) values ('Pepe Romero','Pepito','pepe@correo.com',0,false,'123456');
insert into Usuarios (NOMBRE,NOMBRE_USUARIO,CORREO,PUNTOS,CONECTADO,PASSWORD) values ('Ana Jimenez','Anita','Ana@correo.com',50,false,'123456');


-- -------------      ROLES DE USUARIOS      --------------------------------

insert into Roles(NOMBRE_USUARIO,ROL) values ('Pepito','Usuario');
insert into Roles(NOMBRE_USUARIO,ROL) values ('Anita','Usuario');



-- -------------      ARTICULOS      --------------------------------
insert into Articulos (NOMBRE,PRECIO,DESCRIPCION,CATEGORIA,NUMERO_UNIDADES) 
                    values ('MSI GE70',1000,'Aqui va la descripcion','Ordenadores',15);

insert into Articulos (NOMBRE,PRECIO,DESCRIPCION,CATEGORIA,NUMERO_UNIDADES) 
                    values ('AlienWare',800,'Aqui va la descripcion','Ordenadores',0);

insert into Articulos (NOMBRE,PRECIO,DESCRIPCION,CATEGORIA,NUMERO_UNIDADES) 
                    values ('Mac',3000,'Aqui va la descripcion','Ordenadores',0);

insert into Articulos (NOMBRE,PRECIO,DESCRIPCION,CATEGORIA,NUMERO_UNIDADES) 
                    values ('Samsung',300,'Aqui va la descripcion','Smartphones',2);

insert into Articulos (NOMBRE,PRECIO,DESCRIPCION,CATEGORIA,NUMERO_UNIDADES) 
                    values ('Memoria RAM',20,'Aqui va la descripcion','Componentes',2);


-- -------------      CARRITO      --------------------------------

insert into Carrito (ID_ARTICULO,NOMBRE_USUARIO,FECHA) 
              values(1,'Pepito',CURRENT_DATE);

insert into Carrito (ID_ARTICULO,NOMBRE_USUARIO,FECHA) 
              values(2,'Pepito',CURRENT_DATE);
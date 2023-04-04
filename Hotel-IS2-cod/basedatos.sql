tabla cliente: Id, telefono, Correo
CREATE TABLE cliente (
  Id INT PRIMARY KEY,
  telefono VARCHAR(20),
  Correo VARCHAR(100)
);

CREATE TABLE cliente_Particular (
  nombre VARCHAR(50),
  apellidos VARCHAR(100),
  NIF VARCHAR(20),
  cliente_Id INT,
  FOREIGN KEY (cliente_Id) REFERENCES cliente(Id)
);

CREATE TABLE cliente_Empresa (
  Nombre VARCHAR(100),
  CIF VARCHAR(20),
  cliente_Id INT,
  FOREIGN KEY (cliente_Id) REFERENCES cliente(Id)
);

CREATE TABLE reserva (
  Id INT PRIMARY KEY,
  Total DECIMAL(10,2),
  Fecha_entreada DATE,
  Nombre VARCHAR(100),
  cliente_Id INT,
  FOREIGN KEY (cliente_Id) REFERENCES cliente(Id)
);

CREATE TABLE habitacion (
  Numero INT PRIMARY KEY,
  Precio DECIMAL(10,2),
  Piso INT,
  Tamano VARCHAR(20)
);

CREATE TABLE empleado (
  Id INT PRIMARY KEY,
  sueldo DECIMAL(10,2),
  nombre VARCHAR(100),
  apellidos VARCHAR(100),
  activo BOOLEAN,
  correo VARCHAR(100),
  telefono VARCHAR(20)
);

CREATE TABLE tareas (
  Id INT PRIMARY KEY,
  Descripcion VARCHAR(500),
  Lugar VARCHAR(100),
  Nombre VARCHAR(100),
  empleado_Id INT,
  FOREIGN KEY (empleado_Id) REFERENCES empleado(Id)
);

CREATE TABLE Departamentos (
  Id INT PRIMARY KEY,
  jefe VARCHAR(100),
  nombre VARCHAR(100),
  activo BOOLEAN
);
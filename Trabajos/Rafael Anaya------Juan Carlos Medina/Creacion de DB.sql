--===========================================================--
--===========    BASE DE DATOS REGISTRO DE NOTAS    =========--
--===========================================================--

DECLARE
	N INT;
	COMMAND VARCHAR2(200);
BEGIN
	COMMAND := 'DROP USER manager CASCADE';
	SELECT COUNT(*) INTO N
	FROM DBA_USERS
	WHERE USERNAME = 'MANAGER';
	IF ( N = 1 ) THEN
		EXECUTE IMMEDIATE COMMAND;
	END IF;
END;
/
CREATE USER manager IDENTIFIED BY password;

GRANT CONNECT, RESOURCE TO manager;

ALTER USER MANAGER
QUOTA UNLIMITED ON USERS;

GRANT CREATE VIEW TO manager;

--==============================================================

CONNECT manager/password

--===============================================================

CREATE TABLE Alumno (
		DNI	CHAR(8)	NOT NULL,
		Nombre	VARCHAR(30)	NOT NULL,
		ApePaterno	VARCHAR(20)	NOT NULL,
		ApeMaterno	VARCHAR(20)	NOT NULL,
		Direccion	VARCHAR(100)	NOT NULL,
		Telefono	VARCHAR(9)	NULL,
		CONSTRAINT PKAlumno
				PRIMARY KEY (DNI)
);
/
CREATE TABLE Curso(
		Codigo		CHAR(4)			NOT NULL,
		Nom_Curso	VARCHAR(100)	NOT NULL,
		Costo		NUMBER(6,2)		NOT NULL,
		CONSTRAINT PKCurso
				PRIMARY KEY (Codigo)
);

CREATE TABLE Profesor(
		DNI_P		CHAR(8) 		NOT NULL,
		Nombre		VARCHAR(30)		NOT NULL,
		ApePaterno	VARCHAR(20)		NOT NULL,
		ApeMaterno	VARCHAR(20)		NOT NULL,
		Codigo		CHAR(4)			NOT NULL,
		CONSTRAINT PKProfesor
				PRIMARY KEY (DNI_P),
		CONSTRAINT FKCurso
				FOREIGN KEY (Codigo)
							REFERENCES Curso
				
);

CREATE TABLE Notas(
		Parcial_1	NUMBER(4,2)		NOT NULL,
		Parcial_2	NUMBER(4,2)		NOT NULL,
		Cuaderno	NUMBER(4,2)		NOT NULL,
		Prom_Tar	NUMBER(4,2)		NOT NULL,
		Ex_Final	NUMBER(4,2)		NOT NULL,
		DNI			CHAR(8)			NOT NULL,
		Codigo		CHAR(4)			NOT NULL,
		CONSTRAINT FKAlumno
				FOREIGN KEY	(DNI)
							REFERENCES Alumno,
		CONSTRAINT FK2Curso
				FOREIGN KEY (Codigo)
							REFERENCES Curso	
);

CREATE TABLE Usuario(
	DNI_U 			CHAR(8) 		NOT NULL,
	Nombre			VARCHAR(30)		NOT NULL,
	ApePaterno		VARCHAR(20)		NOT NULL,
	Cuenta			VARCHAR(10)		NOT NULL,
	Clave			VARCHAR(10)		NOT NULL,
	CONSTRAINT PKUsuarios
				PRIMARY KEY (DNI_U)
);
/


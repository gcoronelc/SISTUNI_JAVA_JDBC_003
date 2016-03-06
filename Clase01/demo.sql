
CREATE USER demo IDENTIFIED BY admin;

GRANT CONNECT, RESOURCE, UNLIMITED TABLESPACE TO demo;

create table mensaje(
  de varchar2(20),
  para varchar2(20),
  texto varchar2(200)
);


update sucursal
set int_sucucontcuenta = 
(select count(*) from cuenta 
where cuenta.chr_sucucodigo=sucursal.chr_sucucodigo);
/*select ' drop table ' || table_name || ';'
  from dba_tables
 where table_name like '%HTK%';*/

CREATE TABLE T_HTK_PLANO(codPlano numeric(2),
                         plano varchar2(20),
                         constraint T_HTK_PLANO_PK primary key(codPlano));

create table T_HTK_USU(codUsuario numeric(7),
                       nome VARCHAR2(20),
                       sobrenome VARCHAR2(30),
                       cpf varchar (11),
                       sexo varchar2(1),
                       email varchar(30),
                       senha varchar2(500),
                       dt_nascismento date,
                       dt_registro date,
                       dt_assinatura date,
                       telefone numeric(13),
                       codPlano numeric(2),
                       constraint PK_T_HTK_USU primary key(codUsuario),
                       constraint FK_T_HTK_USU foreign key(codPlano)
                       references T_HTK_PLANO(codPlano));

-- Create table
create table T_HTK_TIPOREF(codTipoRefeicao NUMBER(2),
                           tipoRefeicao VARCHAR2(10),
                           constraint PK_T_HTK_TIPOREF primary
                           key(codTipoRefeicao));

-- Create table
create table T_HTK_REFCONSU(codRefeicao NUMBER(9),
                            tipoRefeicao varchar(11),
                            dtRefeicao DATE,
                            codUsuario NUMBER(7),
                            constraint FK_T_HTK_REFCONSU foreign
                            key(codUsuario) references T_HTK_USU(codUsuario),
                            constraint FK2_T_HTK_REFCONSU foreign
                            key(tipoRefeicao) references
                            T_HTK_TIPOREF(tipoRefeicao));


create table T_HTK_ALIM(codAlimento NUMBER(7),
                        nome varchar2(30),
                        qtConsumida NUMBER(5, 2),
                        qtCalorias NUMBER(4, 2),
                        dtConsumida date,
                        constraint PK_T_HTK_ALIM primary key(codAlimento);

create table T_HTK_PESO(codPeso NUMBER(9),
                        dtPesagem DATE,
                        valor NUMBER(3, 2),
                        codUsuario NUMBER(7),
                        constraint PK_T_HTK_PESO primary key(codPeso),
                        constraint T_HTK_USU foreign key(codUsuario) references
                        T_HTK_USU(codUsuario));


create table T_HTK_ATIV(codTipoAtividade NUMBER(3),
                        tipoAtividade VARCHAR2(30),
                        caloriasGastasHora NUMBER(2),
                        constraint PK_T_HTK_ATIV primary key(codTipoAtividade));

create table T_HTK_BATIMPROVA(codBatimentoCardiaco NUMBER(9),
                              batimentoMinimo NUMBER(3),
                              batimentoMaximo NUMBER(3),
                              batimentoMedio NUMBER(3),
                              dtMedicao date ,
                              codUsuario NUMBER(9),
                              constraint PK_T_HTK_BATIMPROVA primary
                              key(codBatimentoCardiaco),
                              constraint FK_T_HTK_BATIMPROVA foreign
                              key(codUsuario) references T_HTK_USU(codUsuario);

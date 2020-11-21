/*select ' drop table ' || table_name || ';'
  from dba_tables
 where table_name like '%HTK%';*/

CREATE TABLE T_HTK_PLANO(cd_plano numeric(2),
                         ds_plano varchar2(20),
                         constraint T_HTK_PLANO_PK primary key(cd_plano));

create table T_HTK_USU(cd_usu numeric(7),
                       nm_nome VARCHAR2(20),
                       nm_sobrenome VARCHAR2(30),
                       nr_cpf numeric(11),
                       ds_sexo varchar2(1),
                       ds_email varchar(30),
                       ds_senha varchar2(500),
                       dt_nasc date,
                       dt_regis date,
                       nr_contato numeric(13),
                       dt_assinatura date,
                       cd_plano numeric(2),
                       constraint PK_T_HTK_USU primary key(cd_usu),
                       constraint FK_T_HTK_USU foreign key(cd_plano)
                       references T_HTK_PLANO(cd_plano));

-- Create table
create table T_HTK_TIPOREF(cd_tipo_ref NUMBER(2),
                           ds_tipo_ref VARCHAR2(10),
                           constraint PK_T_HTK_TIPOREF primary
                           key(cd_tipo_ref));

-- Create table
create table T_HTK_REFCONSU(cd_ref_consu NUMBER(9),
                            dt_ref_consul DATE,
                            cd_tipo_ref NUMBER(2),
                            cd_usu NUMBER(7),
                            constraint PK_T_HTK_REFCONSU primary
                            key(cd_ref_consu),
                            constraint FK_T_HTK_REFCONSU foreign
                            key(cd_usu) references T_HTK_USU(cd_usu),
                            constraint FK2_T_HTK_REFCONSU foreign
                            key(cd_tipo_ref) references
                            T_HTK_TIPOREF(cd_tipo_ref));

create table T_HTK_ALIMCONSU(cd_alim_consu NUMBER(9),
                             qt_proporc_consu numeric(5, 2),
                             cd_ref_consu NUMBER(9),
                             cd_alim NUMBER(7),
                             cd_usu NUMBER(7),
                             constraint PK_T_HTK_ALIMCONSU primary
                             key(cd_alim_consu),
                             constraint FK_T_HTK_ALIMCONSU foreign
                             key(cd_ref_consu) references
                             T_HTK_REFCONSU(cd_ref_consu),
                             constraint FK2_T_HTK_ALIMCONSU foreign
                             key(cd_usu) references T_HTK_USU(cd_usu));

create table T_HTK_UNMED(cd_un_med numeric(2),
                         ds_un_med varchar2(30),
                         constraint PK_HTK_UNMED primary key(cd_un_med));

create table T_HTK_ALIM(cd_alim NUMBER(7),
                        ds_alim varchar2(30),
                        qt_proporc_base NUMBER(5, 2),
                        qt_calorias NUMBER(4, 2),
                        qt_carb NUMBER(4, 2),
                        qt_prot NUMBER(4, 2),
                        qt_gord number(4, 2),
                        cd_un_med number(2),
                        constraint PK_T_HTK_ALIM primary key(cd_alim),
                        constraint FK_T_HTK_ALIM foreign key(cd_un_med)
                        references T_HTK_UNMED(cd_un_med));

create table T_HTK_PESO(cd_peso NUMBER(9),
                        dt_peso DATE,
                        vl_peso NUMBER(3, 2),
                        cd_un_med NUMBER(2),
                        cd_usu NUMBER(7),
                        constraint PK_T_HTK_PESO primary key(cd_peso),
                        constraint FK_T_HTK_UNMED foreign key(cd_un_med)
                        references T_HTK_UNMED(cd_un_med),
                        constraint T_HTK_USU foreign key(cd_usu) references
                        T_HTK_USU(cd_usu));

create table T_HTK_ATIVREALI(cd_ativ_reali number(9),
                             nr_durac_minu numeric(3),
                             dt_ativ date,
                             cd_ativ numeric(3),
                             cd_usu numeric(7),
                             constraint PK_T_HTK_ATIVREALI primary
                             key(cd_ativ_reali),
                             constraint FK2_T_HTK_ATIVREAL foreign
                             key(cd_usu) references T_HTK_USU(cd_usu));

create table T_HTK_ATIV(cd_ativ NUMBER(3),
                        ds_ativ VARCHAR2(30),
                        nr_calorias_hora NUMBER(2),
                        constraint PK_T_HTK_ATIV primary key(cd_ativ));

create table T_HTK_BATIMPROVA(cd_batim_prova NUMBER(9),
                              nr_batim_medio NUMBER(3),
                              nr_batim_max NUMBER(3),
                              nr_batim_min NUMBER(3),
                              cd_ativ_reali NUMBER(9),
                              cd_usu NUMBER(9),
                              constraint PK_T_HTK_BATIMPROVA primary
                              key(cd_batim_prova),
                              constraint FK_T_HTK_BATIMPROVA foreign
                              key(cd_usu) references T_HTK_USU(cd_usu),
                              constraint FK2_T_HTK_BATIMPROVA foreign
                              key(cd_ativ_reali) references
                              T_HTK_ATIVREALI(cd_ativ_reali));

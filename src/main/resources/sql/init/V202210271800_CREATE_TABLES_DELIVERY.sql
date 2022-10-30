CREATE TABLE DELIVERY.FUNCIONARIOS(
FUNCIONARIO_UID NUMBER(10,0) NOT NULL,
CPF VARCHAR2(11) NOT NULL,
NOME VARCHAR2(200) NOT NULL,
MATRICULA NUMBER(10,0) NOT NULL,
ADMISSAO_DT DATE NOT NULL,
PERIODO_TRABALHO VARCHAR2(1) NOT NULL,
DT_CRIACAO DATE NOT NULL,
USUARIO_CRIACAO VARCHAR2(100) NOT NULL,

CONSTRAINT PK_FUNCIONARIOS PRIMARY KEY (FUNCIONARIO_UID)
) TABLESPACE SYSTEM;

CREATE SEQUENCE DELIVERY.SQ_FUNCIONARIOS
	INCREMENT BY 1
	START WITH 1
	MAXVALUE 9999999999999999999999999999
	MINVALUE 1
	NOCYCLE
	CACHE 20
	NOORDER;


CREATE TABLE DELIVERY.CLIENTES(
CLIENTE_UID NUMBER(10,0) NOT NULL,
CPF VARCHAR2(11) NOT NULL,
NOME VARCHAR2(200) NOT NULL,
ENDERECO VARCHAR2(1000) NOT NULL,
BAIRRO VARCHAR2(100) NOT NULL,
CIDADE VARCHAR2(100) NOT NULL,
ESTADO VARCHAR2(2) NOT NULL,
PAIS VARCHAR2(100) NOT NULL,
DT_CRIACAO DATE NOT NULL,
USUARIO_CRIACAO VARCHAR2(100) NOT NULL,

CONSTRAINT PK_CLIENTES PRIMARY KEY (CLIENTE_UID)
);

CREATE SEQUENCE DELIVERY.SQ_CLIENTES
	INCREMENT BY 1
	START WITH 1
	MAXVALUE 9999999999999999999999999999
	MINVALUE 1
	NOCYCLE
	CACHE 20
	NOORDER;

CREATE TABLE DELIVERY.ENTREGAS(
ENTREGA_UID NUMBER(10,0) NOT NULL,
CLIENTE_UID NUMBER(10,0) NOT NULL,
NUM_PEDIDO NUMBER(10,0) NOT NULL,
ENDERECO VARCHAR2(2000) NOT NULL,
DT_CRIACAO DATE NOT NULL,
USUARIO_CRIACAO VARCHAR2(100) NOT NULL,

CONSTRAINT PK_ENTREGAS PRIMARY KEY (ENTREGA_UID),
CONSTRAINT FK_ENTREGAS_CLIENTES FOREIGN KEY (CLIENTE_UID) REFERENCES DELIVERY.CLIENTES(CLIENTE_UID)
) TABLESPACE SYSTEM;

CREATE SEQUENCE DELIVERY.SQ_ENTREGAS
	INCREMENT BY 1
	START WITH 1
	MAXVALUE 9999999999999999999999999999
	MINVALUE 1
	NOCYCLE
	CACHE 20
	NOORDER;

CREATE TABLE DELIVERY.AGENDAMENTO_ENTREGAS(
AGENDAMENTO_ENTREGA_UID NUMBER(10,0) NOT NULL,
ENTREGA_UID NUMBER(10,0) NOT NULL,
FUNCIONARIO_UID NUMBER(10,0) NOT NULL,
DATA_ENTREGA DATE NOT NULL,
DT_CRIACAO DATE NOT NULL,
USUARIO_CRIACAO VARCHAR2(100) NOT NULL,

CONSTRAINT PK_AGENDAMENTO_ENTREGAS PRIMARY KEY (AGENDAMENTO_ENTREGA_UID),
CONSTRAINT FK_AGENDAMENTO_ENTREGAS_ENTREG FOREIGN KEY (ENTREGA_UID) REFERENCES DELIVERY.ENTREGAS(ENTREGA_UID),
CONSTRAINT FK_AGENDAMENTO_ENTREGAS_FUNC FOREIGN KEY (FUNCIONARIO_UID) REFERENCES DELIVERY.FUNCIONARIOS(FUNCIONARIO_UID)
) TABLESPACE SYSTEM;

CREATE SEQUENCE DELIVERY.SQ_AGENDAMENTO_ENTREGAS
	INCREMENT BY 1
	START WITH 1
	MAXVALUE 9999999999999999999999999999
	MINVALUE 1
	NOCYCLE
	CACHE 20
	NOORDER;
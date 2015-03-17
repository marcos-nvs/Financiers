-- http://stackoverflow.com/questions/17825782/how-to-convert-html-to-pdf-using-itext


-- Table: ln_modulo

-- DROP TABLE ln_modulo;

CREATE TABLE ln_modulo
(
  mod_in_codigo integer NOT NULL, -- Define o ID do modulo, utilizar a sequence
  mod_st_descricao character varying(50) NOT NULL, -- Define o nome do módulo do sistema
  mod_ch_incluir character(1) NOT NULL, -- Define se o módulo tem a função de incluir
  mod_ch_alterar character(1) NOT NULL, -- Define se o módulo tem a função de alterar
  mod_ch_excluir character(1) NOT NULL, -- Define se o módulo tem a função de excluir
  mod_ch_pesquisar character(1) NOT NULL, -- Define se o módulo tem a função de pesquisar ou consultar
  mod_ch_ativo character(1) NOT NULL, -- Define se o módulo está ativo ou inativo
  CONSTRAINT pk_mod_in_codigo PRIMARY KEY (mod_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_modulo
  OWNER TO postgres;
COMMENT ON TABLE ln_modulo
  IS 'Tabela geral de modulo de sistemas';
COMMENT ON COLUMN ln_modulo.mod_in_codigo IS 'Define o ID do modulo, utilizar a sequence';
COMMENT ON COLUMN ln_modulo.mod_st_descricao IS 'Define o nome do módulo do sistema';
COMMENT ON COLUMN ln_modulo.mod_ch_incluir IS 'Define se o módulo tem a função de incluir';
COMMENT ON COLUMN ln_modulo.mod_ch_alterar IS 'Define se o módulo tem a função de alterar';
COMMENT ON COLUMN ln_modulo.mod_ch_excluir IS 'Define se o módulo tem a função de excluir';
COMMENT ON COLUMN ln_modulo.mod_ch_pesquisar IS 'Define se o módulo tem a função de pesquisar ou consultar';
COMMENT ON COLUMN ln_modulo.mod_ch_ativo IS 'Define se o módulo está ativo ou inativo';

-- Sequence: seq_modulo

-- DROP SEQUENCE seq_modulo;

CREATE SEQUENCE seq_modulo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_modulo
  OWNER TO postgres;

insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('seq_modulo'), 'Usuário','S','S','S','S','S')
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('seq_modulo'), 'Perfil','S','S','S','S','S')
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('seq_modulo'), 'Cliente','S','S','S','S','S')


-- Table: ln_usuario

-- DROP TABLE ln_usuario;

CREATE TABLE ln_usuario
(
  usu_st_codigo character varying(30) NOT NULL, -- Define o código do usuário para acessar o sistema
  usu_st_nome character varying(50) NOT NULL, -- Define o nome do usuário
  usu_st_senha character varying(30) NOT NULL, -- Define a senha do usuário para acesso ao sistema
  usu_st_email character varying(100), -- Define o e-mail do usuário
  usu_ch_ativo character(1) NOT NULL, -- Define se o usuário está ativo ou inativo
  usu_in_dia integer, -- Define o período em dias para a troca da senha
  usu_ch_alterasenha character(1) NOT NULL, -- Define se o usuário pode ou não trocar a senha
  usu_ch_expirasenha character(1) NOT NULL, -- Define se a senha do usuário expira
  usu_dt_expiracao date, -- Define quando expira a senha do usuário
  usu_dt_cadastro date, -- Define a data do cadastro do usuário
  per_in_codigo integer NOT NULL, -- Define o perfil de acesso do usuario
  CONSTRAINT pk_usu_st_codigo PRIMARY KEY (usu_st_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_usuario
  OWNER TO postgres;
GRANT ALL ON TABLE ln_usuario TO postgres;
GRANT ALL ON TABLE ln_usuario TO public;
COMMENT ON COLUMN ln_usuario.usu_st_codigo IS 'Define o código do usuário para acessar o sistema';
COMMENT ON COLUMN ln_usuario.usu_st_nome IS 'Define o nome do usuário';
COMMENT ON COLUMN ln_usuario.usu_st_senha IS 'Define a senha do usuário para acesso ao sistema';
COMMENT ON COLUMN ln_usuario.usu_st_email IS 'Define o e-mail do usuário';
COMMENT ON COLUMN ln_usuario.usu_ch_ativo IS 'Define se o usuário está ativo ou inativo';
COMMENT ON COLUMN ln_usuario.usu_in_dia IS 'Define o período em dias para a troca da senha';
COMMENT ON COLUMN ln_usuario.usu_ch_alterasenha IS 'Define se o usuário pode ou não trocar a senha';
COMMENT ON COLUMN ln_usuario.usu_ch_expirasenha IS 'Define se a senha do usuário expira';
COMMENT ON COLUMN ln_usuario.usu_dt_expiracao IS 'Define quando expira a senha do usuário';
COMMENT ON COLUMN ln_usuario.usu_dt_cadastro IS 'Define a data do cadastro do usuário';
COMMENT ON COLUMN ln_usuario.per_in_codigo IS 'Define o perfil de acesso do usuario';


insert into public."ln_usuario" ("usu_st_codigo","usu_st_nome","usu_st_senha","usu_st_email","usu_ch_ativo","usu_in_dia","usu_ch_alterasenha","usu_ch_expirasenha",
                                 "usu_dt_cadastro", "per_in_codigo" ) values 
                                ('Marcos', 'Marcos Naves','Kareta448','m-nvs@uol.com.br','S','0','S','S',CURRENT_DATE, 1)


-- Table: ln_menu

-- DROP TABLE ln_menu;

-- Table: ln_menu

-- DROP TABLE ln_menu;

CREATE TABLE ln_menu
(
  men_in_codigo integer NOT NULL, -- Define a sequencia do menu
  men_st_descricao character varying(50) NOT NULL, -- Define o nome do menu.
  men_ch_ativo character(1) NOT NULL, -- Define se o menu está ativo ou inativo
  CONSTRAINT pk_men_in_codigo PRIMARY KEY (men_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_menu
  OWNER TO postgres;
COMMENT ON TABLE ln_menu
  IS 'Define o menu principal';
COMMENT ON COLUMN ln_menu.men_in_codigo IS 'Define a sequencia do menu';
COMMENT ON COLUMN ln_menu.men_st_descricao IS 'Define o nome do menu.';
COMMENT ON COLUMN ln_menu.men_ch_ativo IS 'Define se o menu está ativo ou inativo';


insert into public."ln_menu" ("men_in_codigo","men_st_descricao","men_ch_ativo") values (1,'Cadastros','S')
insert into public."ln_menu" ("men_in_codigo","men_st_descricao","men_ch_ativo") values (2,'Pedido','S')


-- Table: ln_menumodulo

-- DROP TABLE ln_menumodulo;

-- Table: ln_menumodulo

-- DROP TABLE ln_menumodulo;

CREATE TABLE ln_menumodulo
(
  men_in_codigo integer NOT NULL, -- Código do Menu
  mod_in_codigo integer NOT NULL, -- Código do menu
  CONSTRAINT "pk_menuModulo" PRIMARY KEY (men_in_codigo, mod_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_menumodulo
  OWNER TO postgres;
COMMENT ON COLUMN ln_menumodulo.men_in_codigo IS 'Código do Menu';
COMMENT ON COLUMN ln_menumodulo.mod_in_codigo IS 'Código do menu';


insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (1,1)
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (1,2)
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (1,3)


-- Table: ln_perfil

-- DROP TABLE ln_perfil;

CREATE TABLE ln_perfil
(
  per_in_codigo integer NOT NULL, -- Define através de sequence o id do perfil
  per_st_descricao character varying(50) NOT NULL, -- Descrição do perifl
  per_ch_ativo character(1) NOT NULL, -- Define se está ativo ou inativo
  per_ch_alterasenha character(1) NOT NULL, -- Define se o usuário pode alterar a senha de outros usuários
  CONSTRAINT pk_perfil PRIMARY KEY (per_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_perfil
  OWNER TO postgres;
COMMENT ON TABLE ln_perfil
  IS 'Tabela contendo o nome do perfil';
COMMENT ON COLUMN ln_perfil.per_in_codigo IS 'Define através de sequence o id do perfil';
COMMENT ON COLUMN ln_perfil.per_st_descricao IS 'Descrição do perifl';
COMMENT ON COLUMN ln_perfil.per_ch_ativo IS 'Define se está ativo ou inativo';
COMMENT ON COLUMN ln_perfil.per_ch_alterasenha IS 'Define se o usuário pode alterar a senha de outros usuários';


-- Sequence: seq_perfil

-- DROP SEQUENCE seq_perfil;

CREATE SEQUENCE seq_perfil
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_perfil
  OWNER TO postgres;


insert into public."ln_perfil" ("per_in_codigo","per_st_descricao","per_ch_ativo","per_ch_alterasenha") values (nextval('seq_perfil'),'Perfil de Administrador Master','S','S')


-- Table: ln_perfilacesso

-- DROP TABLE ln_perfilacesso;

-- Table: ln_perfilacesso

-- DROP TABLE ln_perfilacesso;

CREATE TABLE ln_perfilacesso
(
  per_in_codigo integer NOT NULL, -- Define o perfil ao qual pertence
  mod_in_codigo integer NOT NULL, -- Define o módulo de acesso
  pac_ch_incluir character(1) NOT NULL, -- Define a função
  pac_ch_alterar character(1) NOT NULL, -- Define a função
  pac_ch_excluir character(1) NOT NULL, -- Define a função
  pac_ch_pesquisar character(1) NOT NULL, -- Define a função
  CONSTRAINT pc_perfilacesso PRIMARY KEY (per_in_codigo, mod_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_perfilacesso
  OWNER TO postgres;
COMMENT ON TABLE ln_perfilacesso
  IS 'Define os acessos do perfil';
COMMENT ON COLUMN ln_perfilacesso.per_in_codigo IS 'Define o perfil ao qual pertence';
COMMENT ON COLUMN ln_perfilacesso.mod_in_codigo IS 'Define o módulo de acesso';
COMMENT ON COLUMN ln_perfilacesso.pac_ch_incluir IS 'Define a função';
COMMENT ON COLUMN ln_perfilacesso.pac_ch_alterar IS 'Define a função';
COMMENT ON COLUMN ln_perfilacesso.pac_ch_excluir IS 'Define a função';
COMMENT ON COLUMN ln_perfilacesso.pac_ch_pesquisar IS 'Define a função';


insert into public."ln_perfilacesso" ("per_in_codigo","mod_in_codigo","pac_ch_incluir","pac_ch_alterar","pac_ch_excluir","pac_ch_pesquisar") values (1,1,'S','S','S','S')
insert into public."ln_perfilacesso" ("per_in_codigo","mod_in_codigo","pac_ch_incluir","pac_ch_alterar","pac_ch_excluir","pac_ch_pesquisar") values (1,2,'S','S','S','S')
insert into public."ln_perfilacesso" ("per_in_codigo","mod_in_codigo","pac_ch_incluir","pac_ch_alterar","pac_ch_excluir","pac_ch_pesquisar") values (1,3,'S','S','S','S')

-- Table: ln_historico

-- DROP TABLE ln_historico;

CREATE TABLE ln_historico
(
  his_in_codigo integer NOT NULL,
  mod_in_codigo integer NOT NULL, -- Modulo de onde originou a transação
  his_dt_data timestamp without time zone NOT NULL, -- Data da transação
  usu_st_codigo character varying(30) NOT NULL, -- Usuario que gerou a transação
  his_st_descricao character varying(200), -- Descrição da transação.
  CONSTRAINT pk_historico PRIMARY KEY (his_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_historico
  OWNER TO postgres;
COMMENT ON TABLE ln_historico
  IS 'Rastreabilidade e Historico de todas as transações do sistema';
COMMENT ON COLUMN ln_historico.mod_in_codigo IS 'Modulo de onde originou a transação';
COMMENT ON COLUMN ln_historico.his_dt_data IS 'Data da transação';
COMMENT ON COLUMN ln_historico.usu_st_codigo IS 'Usuario que gerou a transação';
COMMENT ON COLUMN ln_historico.his_st_descricao IS 'Descrição da transação.';


-- Sequence: seq_historico

-- DROP SEQUENCE seq_historico;

CREATE SEQUENCE seq_historico
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_historico
  OWNER TO postgres;


-- Table: ln_cliente

-- DROP TABLE ln_cliente;

CREATE TABLE ln_cliente
(
  cli_in_codigo integer NOT NULL, -- codigo ID do cliente
  cli_st_cpf character varying(11), -- CPF para cliente pessoa
  cli_st_cnpj character varying(14), -- CNPJ para Empresa
  cli_st_rg character varying(10), -- RG do cliente
  cli_st_ie character varying(10), -- Inscrição Estadual
  cli_st_nome character varying(60) NOT NULL, -- Nome ou Razão social do cliente
  cli_st_email character varying(60),
  cli_st_contato character varying(40),
  cli_ch_tipo character(1) NOT NULL, -- Tipo 1-Cliente 2-Fornecedor
  CONSTRAINT pk_cliente PRIMARY KEY (cli_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_cliente
  OWNER TO postgres;
COMMENT ON TABLE ln_cliente
  IS 'Cadastro de Cliente';
COMMENT ON COLUMN ln_cliente.cli_in_codigo IS 'codigo ID do cliente';
COMMENT ON COLUMN ln_cliente.cli_st_cpf IS 'CPF para cliente pessoa';
COMMENT ON COLUMN ln_cliente.cli_st_cnpj IS 'CNPJ para Empresa';
COMMENT ON COLUMN ln_cliente.cli_st_rg IS 'RG do cliente';
COMMENT ON COLUMN ln_cliente.cli_st_ie IS 'Inscrição Estadual';
COMMENT ON COLUMN ln_cliente.cli_st_nome IS 'Nome ou Razão social do cliente';
COMMENT ON COLUMN ln_cliente.cli_ch_tipo IS 'Tipo 1-Cliente 2-Fornecedor';

-- Sequence: seq_cliente

-- DROP SEQUENCE seq_cliente;

CREATE SEQUENCE seq_cliente
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_cliente
  OWNER TO postgres;

-- Table: ln_endereco

-- DROP TABLE ln_endereco;

CREATE TABLE ln_endereco
(
  end_in_codigo integer NOT NULL, -- Código do Endereco
  cli_in_codigo integer NOT NULL, -- código do cliente
  end_st_tipo character varying(20) NOT NULL, -- Tipo comercial...
  end_st_logradouro character varying(60) NOT NULL, -- Endereço
  end_st_numero character varying(6) NOT NULL,
  end_st_complemento character varying(30), 
  end_st_bairro character varying(40) NOT NULL,
  end_st_cidade character varying(50) NOT NULL,
  end_st_estado character varying(2) NOT NULL,
  end_st_cep character varying(8) NOT NULL,
  CONSTRAINT pk_endereco PRIMARY KEY (end_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_endereco
  OWNER TO postgres;
COMMENT ON TABLE ln_endereco
  IS 'Endereço dos Clientes';
COMMENT ON COLUMN ln_endereco.end_in_codigo IS 'Código do Endereco';
COMMENT ON COLUMN ln_endereco.cli_in_codigo IS 'código do cliente';
COMMENT ON COLUMN ln_endereco.end_st_tipo IS 'Tipo comercial
Tipo Entrega
';
COMMENT ON COLUMN ln_endereco.end_st_logradouro IS 'Endereço ';

-- Sequence: seq_endereco

-- DROP SEQUENCE seq_endereco;

CREATE SEQUENCE seq_endereco
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_endereco
  OWNER TO postgres;

-- Table: ln_telefone

-- DROP TABLE ln_telefone;

CREATE TABLE ln_telefone
(
  tel_in_codigo integer NOT NULL, -- código do telefone
  cli_in_codigo integer NOT NULL, -- Codigo cliente
  tel_st_tipo character varying(20) NOT NULL, -- Tipo de telefone (residencial, vivo, claro, oi, tim
  tel_st_ddd character varying(3) NOT NULL, -- DDD
  tel_st_telefone character varying(10) NOT NULL, -- Telefone
  CONSTRAINT pk_telefone PRIMARY KEY (tel_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_telefone
  OWNER TO postgres;
COMMENT ON TABLE ln_telefone
  IS 'Cadastro de telefone';
COMMENT ON COLUMN ln_telefone.tel_in_codigo IS 'código do telefone';
COMMENT ON COLUMN ln_telefone.cli_in_codigo IS 'Codigo cliente';
COMMENT ON COLUMN ln_telefone.tel_st_tipo IS 'Tipo de telefone (residencial, vivo, claro, oi, tim';
COMMENT ON COLUMN ln_telefone.tel_st_ddd IS 'DDD';
COMMENT ON COLUMN ln_telefone.tel_st_telefone IS 'Telefone';

-- Sequence: seq_telefone

-- DROP SEQUENCE seq_telefone;

CREATE SEQUENCE seq_telefone
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_telefone
  OWNER TO postgres;

-- http://stackoverflow.com/questions/17825782/how-to-convert-html-to-pdf-using-itext

-- Schema: acessocontrol

-- DROP SCHEMA acessocontrol;

CREATE SCHEMA acessocontrol
  AUTHORIZATION postgres;

-- Table: acessocontrol.ln_cliente

-- DROP TABLE acessocontrol.ln_cliente;

CREATE TABLE acessocontrol.ln_cliente
(
  cli_in_codigo integer NOT NULL,
  cli_st_documento character varying(20) NOT NULL, -- Documento de identificação único.
  cli_st_nome character varying(50) NOT NULL, -- Nome do cliente ou razão social
  cli_ch_ativo character(1) NOT NULL, -- Identifica se o cliente está ativo
  cli_st_banco character varying(20) NOT NULL,
  cli_st_email character varying(100),
  CONSTRAINT ln_cliente_pkey PRIMARY KEY (cli_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE acessocontrol.ln_cliente
  OWNER TO postgres;
COMMENT ON COLUMN acessocontrol.ln_cliente.cli_st_documento IS 'Documento de identificação único.';
COMMENT ON COLUMN acessocontrol.ln_cliente.cli_st_nome IS 'Nome do cliente ou razão social';
COMMENT ON COLUMN acessocontrol.ln_cliente.cli_ch_ativo IS 'Identifica se o cliente está ativo';

-- Sequence: acessocontrol.seq_cliente

-- DROP SEQUENCE acessocontrol.seq_cliente;

CREATE SEQUENCE acessocontrol.seq_cliente
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE acessocontrol.seq_cliente
  OWNER TO postgres;

-- insert into acessocontrol.ln_cliente("cli_in_codigo","cli_st_documento","cli_st_nome","cli_ch_ativo","cli_st_banco","cli_st_email")
-- values (nextval('acessocontrol.seq_cliente'),'12684146896','Marcos Naves','S','public','m-nvs@uol.com.br');

-- Table: acessocontrol.ln_endereco

-- DROP TABLE acessocontrol.ln_endereco;

CREATE TABLE acessocontrol.ln_endereco
(
  end_in_codigo integer NOT NULL,
  cli_in_codigo integer NOT NULL,
  end_ch_tipo character(1) NOT NULL, 
  end_st_endereco character varying(50) NOT NULL,
  end_st_complemento character varying(50), 
  end_st_bairro character varying(50) NOT NULL,
  end_st_cidade character varying(50) NOT NULL,
  end_st_estado character varying(20) NOT NULL,
  end_st_cep character varying(10) NOT NULL,
  CONSTRAINT ln_endereco_pkey PRIMARY KEY (end_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE acessocontrol.ln_endereco
  OWNER TO postgres;

-- Index: acessocontrol.ln_endereco_cli_in_codigo_idx

-- DROP INDEX acessocontrol.ln_endereco_cli_in_codigo_idx;

CREATE INDEX ln_endereco_cli_in_codigo_idx
  ON acessocontrol.ln_endereco
  USING btree
  (cli_in_codigo);

-- Sequence: acessocontrol.seq_endereco

-- DROP SEQUENCE acessocontrol.seq_endereco;

CREATE SEQUENCE acessocontrol.seq_endereco
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE acessocontrol.seq_endereco
  OWNER TO postgres;

-- insert into acessocontrol.ln_endereco("end_in_codigo","cli_in_codigo","end_ch_tipo","end_st_endereco","end_st_complemento","end_st_bairro","end_st_cidade","end_st_estado","end_st_cep")
-- values (nextval('acessocontrol.seq_endereco'),1, '1','Rua Diógenes Ribeiro de Lima, 801', null, 'Jardim Belval','Barueri','São Paulo','06420250');

-- Table: acessocontrol.ln_telefone

-- DROP TABLE acessocontrol.ln_telefone;

CREATE TABLE acessocontrol.ln_telefone
(
  tel_in_codigo integer NOT NULL,
  cli_in_codigo integer NOT NULL,
  tel_ch_tipo character(1) NOT NULL, -- 1-Residêncial...
  tel_st_pais character varying(3),
  tel_st_ddd character varying(5),
  tel_st_telefone character varying(14),
  CONSTRAINT ln_telefone_pkey PRIMARY KEY (tel_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE acessocontrol.ln_telefone
  OWNER TO postgres;
COMMENT ON COLUMN acessocontrol.ln_telefone.tel_ch_tipo IS '1-Residêncial
2-Comercial
3-Celular';

-- Sequence: acessocontrol.seq_telefone

-- DROP SEQUENCE acessocontrol.seq_telefone;

CREATE SEQUENCE acessocontrol.seq_telefone
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE acessocontrol.seq_telefone
  OWNER TO postgres;

-- insert into acessocontrol.ln_telefone ("tel_in_codigo","cli_in_codigo","tel_ch_tipo","tel_st_pais","tel_st_ddd","tel_st_telefone")
-- values (nextval('acessocontrol.seq_telefone'), 1, '3', null, '011','995046236');

-- Table: acessocontrol.ln_usuario

-- DROP TABLE acessocontrol.ln_usuario;

CREATE TABLE acessocontrol.ln_usuario
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
  usu_st_cpf character varying(11) NOT NULL, -- Define o cpf do usuário para poder resgatar a senha de acesso
  cli_in_codigo integer,
  usu_ch_admin character(1) NOT NULL,
  usu_in_dependente integer,
  CONSTRAINT pk_usustcodigo PRIMARY KEY (usu_st_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE acessocontrol.ln_usuario
  OWNER TO postgres;
GRANT ALL ON TABLE acessocontrol.ln_usuario TO postgres;
COMMENT ON COLUMN acessocontrol.ln_usuario.usu_st_codigo IS 'Define o código do usuário para acessar o sistema';
COMMENT ON COLUMN acessocontrol.ln_usuario.usu_st_nome IS 'Define o nome do usuário';
COMMENT ON COLUMN acessocontrol.ln_usuario.usu_st_senha IS 'Define a senha do usuário para acesso ao sistema';
COMMENT ON COLUMN acessocontrol.ln_usuario.usu_st_email IS 'Define o e-mail do usuário';
COMMENT ON COLUMN acessocontrol.ln_usuario.usu_ch_ativo IS 'Define se o usuário está ativo ou inativo';
COMMENT ON COLUMN acessocontrol.ln_usuario.usu_in_dia IS 'Define o período em dias para a troca da senha';
COMMENT ON COLUMN acessocontrol.ln_usuario.usu_ch_alterasenha IS 'Define se o usuário pode ou não trocar a senha';
COMMENT ON COLUMN acessocontrol.ln_usuario.usu_ch_expirasenha IS 'Define se a senha do usuário expira';
COMMENT ON COLUMN acessocontrol.ln_usuario.usu_dt_expiracao IS 'Define quando expira a senha do usuário';
COMMENT ON COLUMN acessocontrol.ln_usuario.usu_dt_cadastro IS 'Define a data do cadastro do usuário';
COMMENT ON COLUMN acessocontrol.ln_usuario.per_in_codigo IS 'Define o perfil de acesso do usuario';
COMMENT ON COLUMN acessocontrol.ln_usuario.usu_st_cpf IS 'Define o cpf do usuário para poder resgatar a senha de acesso';


-- Index: acessocontrol.ind_usuariocpf

-- DROP INDEX acessocontrol.ind_usuariocpf;

CREATE INDEX ind_usuariocpf
  ON acessocontrol.ln_usuario
  USING btree
  (usu_st_codigo COLLATE pg_catalog."default", usu_st_cpf COLLATE pg_catalog."default");

-- insert into acessocontrol."ln_usuario" ("usu_st_codigo","usu_st_nome","usu_st_senha","usu_st_email","usu_ch_ativo","usu_in_dia","usu_ch_alterasenha","usu_ch_expirasenha",
--                                  "usu_dt_expiracao", "usu_dt_cadastro", "per_in_codigo", "usu_st_cpf", "cli_in_codigo", "usu_ch_admin") values 
--                                 ('Naves', 'Marcos Naves','Kareta448','m-nvs@uol.com.br','S','0','S','N',CURRENT_DATE,CURRENT_DATE, 1, '12684146896',1,'S');

--------------------------------------------------------------------------------------------------------------------------------------------------------
-- Schema: public

-- DROP SCHEMA public;

-- CREATE SCHEMA public
--   AUTHORIZATION postgres;

GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;
COMMENT ON SCHEMA public
  IS 'standard public schema';

-- Table: ln_perfil

-- DROP TABLE ln_perfil;

CREATE TABLE public.ln_perfil
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
ALTER TABLE public.ln_perfil
  OWNER TO postgres;
COMMENT ON TABLE public.ln_perfil
  IS 'Tabela contendo o nome do perfil';
COMMENT ON COLUMN public.ln_perfil.per_in_codigo IS 'Define através de sequence o id do perfil';
COMMENT ON COLUMN public.ln_perfil.per_st_descricao IS 'Descrição do perifl';
COMMENT ON COLUMN public.ln_perfil.per_ch_ativo IS 'Define se está ativo ou inativo';
COMMENT ON COLUMN public.ln_perfil.per_ch_alterasenha IS 'Define se o usuário pode alterar a senha de outros usuários';


-- Sequence: seq_perfil

-- DROP SEQUENCE seq_perfil;

CREATE SEQUENCE public.seq_perfil
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.seq_perfil
  OWNER TO postgres;


insert into public."ln_perfil" ("per_in_codigo","per_st_descricao","per_ch_ativo","per_ch_alterasenha") values (nextval('public.seq_perfil'),'Perfil de Administrador Master','S','S');

-- Table: ln_modulo

-- DROP TABLE ln_modulo;

CREATE TABLE public.ln_modulo
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
ALTER TABLE public.ln_modulo
  OWNER TO postgres;
COMMENT ON TABLE public.ln_modulo
  IS 'Tabela geral de modulo de sistemas';
COMMENT ON COLUMN public.ln_modulo.mod_in_codigo IS 'Define o ID do modulo, utilizar a sequence';
COMMENT ON COLUMN public.ln_modulo.mod_st_descricao IS 'Define o nome do módulo do sistema';
COMMENT ON COLUMN public.ln_modulo.mod_ch_incluir IS 'Define se o módulo tem a função de incluir';
COMMENT ON COLUMN public.ln_modulo.mod_ch_alterar IS 'Define se o módulo tem a função de alterar';
COMMENT ON COLUMN public.ln_modulo.mod_ch_excluir IS 'Define se o módulo tem a função de excluir';
COMMENT ON COLUMN public.ln_modulo.mod_ch_pesquisar IS 'Define se o módulo tem a função de pesquisar ou consultar';
COMMENT ON COLUMN public.ln_modulo.mod_ch_ativo IS 'Define se o módulo está ativo ou inativo';

-- Sequence: seq_modulo

-- DROP SEQUENCE seq_modulo;

CREATE SEQUENCE public.seq_modulo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.seq_modulo
  OWNER TO postgres;

insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Usuário','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Perfil','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Tabelas','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Categoria','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Plano de Contas','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Favorecidos','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Orçamento','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Lançamento Diário','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Fluxo de Caixa','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Contas à Receber','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Contas à Pagar','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Cartão Crédito','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Fechamento','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Análise de Contas','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Orçamento x Realizado','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Receitas x Despesas','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Despesas por Favorecidos','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Curva ABC Despesas','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Resumo Patrimônio','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Saldo das Contas','S','S','S','S','S');
insert into public."ln_modulo" ("mod_in_codigo","mod_st_descricao","mod_ch_incluir","mod_ch_alterar","mod_ch_excluir","mod_ch_pesquisar","mod_ch_ativo")
values (nextval('public.seq_modulo'), 'Comparação de Movimentação entre Meses','S','S','S','S','S');

-- Table: ln_menu

-- DROP TABLE ln_menu;

-- Table: ln_menu

-- DROP TABLE ln_menu;

CREATE TABLE public.ln_menu
(
  men_in_codigo integer NOT NULL, -- Define a sequencia do menu
  men_st_descricao character varying(50) NOT NULL, -- Define o nome do menu.
  men_ch_ativo character(1) NOT NULL, -- Define se o menu está ativo ou inativo
  CONSTRAINT pk_men_in_codigo PRIMARY KEY (men_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.ln_menu
  OWNER TO postgres;
COMMENT ON TABLE public.ln_menu
  IS 'Define o menu principal';
COMMENT ON COLUMN public.ln_menu.men_in_codigo IS 'Define a sequencia do menu';
COMMENT ON COLUMN public.ln_menu.men_st_descricao IS 'Define o nome do menu.';
COMMENT ON COLUMN public.ln_menu.men_ch_ativo IS 'Define se o menu está ativo ou inativo';

insert into public."ln_menu" ("men_in_codigo","men_st_descricao","men_ch_ativo") values (1,'Controle Acesso','S');
insert into public."ln_menu" ("men_in_codigo","men_st_descricao","men_ch_ativo") values (2,'Cadastros','S');
insert into public."ln_menu" ("men_in_codigo","men_st_descricao","men_ch_ativo") values (3,'Movimentação','S');
insert into public."ln_menu" ("men_in_codigo","men_st_descricao","men_ch_ativo") values (4,'Relatórios','S');


-- Table: ln_menumodulo

-- DROP TABLE ln_menumodulo;

-- Table: ln_menumodulo

-- DROP TABLE ln_menumodulo;

CREATE TABLE public.ln_menumodulo
(
  men_in_codigo integer NOT NULL, -- Código do Menu
  mod_in_codigo integer NOT NULL, -- Código do menu
  CONSTRAINT "pk_menuModulo" PRIMARY KEY (men_in_codigo, mod_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.ln_menumodulo
  OWNER TO postgres;
COMMENT ON COLUMN public.ln_menumodulo.men_in_codigo IS 'Código do Menu';
COMMENT ON COLUMN public.ln_menumodulo.mod_in_codigo IS 'Código do menu';

insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (1,1);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (1,2);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (2,3);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (2,4);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (2,5);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (2,6);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (2,7);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (3,8);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (3,9);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (3,10);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (3,11);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (3,12);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (3,13);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (4,14);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (4,15);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (4,16);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (4,17);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (4,18);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (4,19);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (4,20);
insert into public."ln_menumodulo" ("men_in_codigo","mod_in_codigo") values (4,21);


-- Table: ln_perfilacesso

-- DROP TABLE ln_perfilacesso;

-- Table: ln_perfilacesso

-- DROP TABLE ln_perfilacesso;

CREATE TABLE public.ln_perfilacesso
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
ALTER TABLE public.ln_perfilacesso
  OWNER TO postgres;
COMMENT ON TABLE public.ln_perfilacesso
  IS 'Define os acessos do perfil';
COMMENT ON COLUMN public.ln_perfilacesso.per_in_codigo IS 'Define o perfil ao qual pertence';
COMMENT ON COLUMN public.ln_perfilacesso.mod_in_codigo IS 'Define o módulo de acesso';
COMMENT ON COLUMN public.ln_perfilacesso.pac_ch_incluir IS 'Define a função';
COMMENT ON COLUMN public.ln_perfilacesso.pac_ch_alterar IS 'Define a função';
COMMENT ON COLUMN public.ln_perfilacesso.pac_ch_excluir IS 'Define a função';
COMMENT ON COLUMN public.ln_perfilacesso.pac_ch_pesquisar IS 'Define a função';


insert into public."ln_perfilacesso" ("per_in_codigo","mod_in_codigo","pac_ch_incluir","pac_ch_alterar","pac_ch_excluir","pac_ch_pesquisar") values (1,1,'S','S','S','S');
insert into public."ln_perfilacesso" ("per_in_codigo","mod_in_codigo","pac_ch_incluir","pac_ch_alterar","pac_ch_excluir","pac_ch_pesquisar") values (1,2,'S','S','S','S');

-- Table: ln_historico

-- DROP TABLE ln_historico;

CREATE TABLE public.ln_historico
(
  his_in_codigo integer NOT NULL,
  mod_in_codigo integer, -- Modulo de onde originou a transação
  his_dt_data timestamp without time zone NOT NULL, -- Data da transação
  usu_st_codigo character varying(30) NOT NULL, -- Usuario que gerou a transação
  his_st_descricao character varying(200), -- Descrição da transação.
  CONSTRAINT pk_historico PRIMARY KEY (his_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.ln_historico
  OWNER TO postgres;
COMMENT ON TABLE public.ln_historico
  IS 'Rastreabilidade e Historico de todas as transações do sistema';
COMMENT ON COLUMN public.ln_historico.mod_in_codigo IS 'Modulo de onde originou a transação';
COMMENT ON COLUMN public.ln_historico.his_dt_data IS 'Data da transação';
COMMENT ON COLUMN public.ln_historico.usu_st_codigo IS 'Usuario que gerou a transação';
COMMENT ON COLUMN public.ln_historico.his_st_descricao IS 'Descrição da transação.';


-- Sequence: seq_historico

-- DROP SEQUENCE seq_historico;

CREATE SEQUENCE public.seq_historico
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.seq_historico
  OWNER TO postgres;


-- Table: ln_tipoconta

-- DROP TABLE ln_tipoconta;

CREATE TABLE public.ln_tipoconta
(
  tip_in_codigo integer NOT NULL, -- Código do tipo de conta
  tip_st_descricao character varying(50) NOT NULL,
  tip_st_tipo character(1) NOT NULL, -- Define o tipo de conta D-Débito e C-Crédito
  CONSTRAINT ln_tipoconta_pkey PRIMARY KEY (tip_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.ln_tipoconta
  OWNER TO postgres;
COMMENT ON COLUMN public.ln_tipoconta.tip_in_codigo IS 'Código do tipo de conta';
COMMENT ON COLUMN public.ln_tipoconta.tip_st_tipo IS 'Define o tipo de conta D-Débito e C-Crédito';

insert into public."ln_tipoconta" ("tip_in_codigo", "tip_st_descricao", "tip_st_tipo") values (1,'ATIVO','D');
insert into public."ln_tipoconta" ("tip_in_codigo", "tip_st_descricao", "tip_st_tipo") values (2,'PASSIVO','C');
insert into public."ln_tipoconta" ("tip_in_codigo", "tip_st_descricao", "tip_st_tipo") values (3,'BANCO','D');
insert into public."ln_tipoconta" ("tip_in_codigo", "tip_st_descricao", "tip_st_tipo") values (4,'CARTÃO DE CRÉDITO','C');
insert into public."ln_tipoconta" ("tip_in_codigo", "tip_st_descricao", "tip_st_tipo") values (5,'DINHEIRO','D');
insert into public."ln_tipoconta" ("tip_in_codigo", "tip_st_descricao", "tip_st_tipo") values (6,'EMPRÉSTIMO','C');
insert into public."ln_tipoconta" ("tip_in_codigo", "tip_st_descricao", "tip_st_tipo") values (7,'FINANCIAMENTO','C');
insert into public."ln_tipoconta" ("tip_in_codigo", "tip_st_descricao", "tip_st_tipo") values (8,'OUTROS PASSIVOS','C');
insert into public."ln_tipoconta" ("tip_in_codigo", "tip_st_descricao", "tip_st_tipo") values (9,'RECEITAS','D');
insert into public."ln_tipoconta" ("tip_in_codigo", "tip_st_descricao", "tip_st_tipo") values (10,'DESPESAS','C');
insert into public."ln_tipoconta" ("tip_in_codigo", "tip_st_descricao", "tip_st_tipo") values (11,'CONTAS À RECEBER','D');
insert into public."ln_tipoconta" ("tip_in_codigo", "tip_st_descricao", "tip_st_tipo") values (12,'CONTAS À PAGAR','C');

-- Table: ln_categoria

-- DROP TABLE ln_categoria;

CREATE TABLE public.ln_categoria
(
  cat_in_codigo integer NOT NULL,
  cat_st_descricao character varying(50),
  tip_in_codigo integer, -- Tipo de categoria Débito ou Crédito
  cat_ch_ativo character(1),
  CONSTRAINT ln_categoria_pkey PRIMARY KEY (cat_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.ln_categoria
  OWNER TO postgres;
COMMENT ON TABLE public.ln_categoria
  IS 'Define a categoria das contas para filtros no sistema';
COMMENT ON COLUMN public.ln_categoria.tip_in_codigo IS 'Tipo de categoria Débito ou Crédito';

-- Sequence: seq_categoria

-- DROP SEQUENCE seq_categoria;

CREATE SEQUENCE public.seq_categoria
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.seq_categoria
  OWNER TO postgres;

-- Table: ln_tipotabela

-- DROP TABLE ln_tipotabela;

CREATE TABLE public.ln_tipotabela
(
  ttb_in_codigo integer NOT NULL, -- Código da tabela
  ttb_st_descricao character varying NOT NULL, -- Descrição da tabela
  CONSTRAINT ln_tipotabela_pkey PRIMARY KEY (ttb_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.ln_tipotabela
  OWNER TO postgres;
COMMENT ON TABLE public.ln_tipotabela
  IS 'Tipo de table para cálculos específicos';
COMMENT ON COLUMN public.ln_tipotabela.ttb_in_codigo IS 'Código da tabela';
COMMENT ON COLUMN public.ln_tipotabela.ttb_st_descricao IS 'Descrição da tabela';

insert into public."ln_tipotabela" ("ttb_in_codigo","ttb_st_descricao") values (1,'IRRF');
insert into public."ln_tipotabela" ("ttb_in_codigo","ttb_st_descricao") values (2,'INSS');
insert into public."ln_tipotabela" ("ttb_in_codigo","ttb_st_descricao") values (3,'IPVA');
insert into public."ln_tipotabela" ("ttb_in_codigo","ttb_st_descricao") values (4,'IOF');
insert into public."ln_tipotabela" ("ttb_in_codigo","ttb_st_descricao") values (5,'JUROS');
insert into public."ln_tipotabela" ("ttb_in_codigo","ttb_st_descricao") values (6,'ISS');
insert into public."ln_tipotabela" ("ttb_in_codigo","ttb_st_descricao") values (7,'COFINS');


-- Table: ln_tabela

-- DROP TABLE ln_tabela;

CREATE TABLE ln_tabela
(
  tab_in_codigo integer NOT NULL,
  ttb_in_codigo integer NOT NULL, -- Tipo de Impostos, Taxas...
  tab_st_descricao character varying(50) NOT NULL, -- Descrição para identificação da tabela para o usuario
  tab_dt_inicio date NOT NULL, -- Data inicial
  tab_dt_final date NOT NULL, -- Data Final
  CONSTRAINT ln_tabela_pkey PRIMARY KEY (tab_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_tabela
  OWNER TO postgres;
COMMENT ON TABLE ln_tabela
  IS 'Tabela de impostos, juros e taxas para cálculos de IR, INS, IOF, Juros, entre outor
';
COMMENT ON COLUMN ln_tabela.ttb_in_codigo IS 'Tipo de Impostos, Taxas...';
COMMENT ON COLUMN ln_tabela.tab_st_descricao IS 'Descrição para identificação da tabela para o usuario';
COMMENT ON COLUMN ln_tabela.tab_dt_inicio IS 'Data inicial';
COMMENT ON COLUMN ln_tabela.tab_dt_final IS 'Data Final';

-- Index: ln_tabela_ttb_in_codigo_tab_in_codigo_idx

-- DROP INDEX ln_tabela_ttb_in_codigo_tab_in_codigo_idx;

CREATE INDEX ln_tabela_ttb_in_codigo_tab_in_codigo_idx
  ON ln_tabela
  USING btree
  (ttb_in_codigo, tab_in_codigo);

-- Sequence: seq_tabela

-- DROP SEQUENCE seq_tabela;

CREATE SEQUENCE seq_tabela
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_tabela
  OWNER TO postgres;

-- Table: ln_tabelaitem

-- DROP TABLE ln_tabelaitem;

CREATE TABLE ln_tabelaitem
(
  tai_in_codigo integer NOT NULL,
  tab_in_codigo integer NOT NULL,
  tai_fl_inicio double precision,
  tai_fl_final double precision,
  tai_fl_percentual double precision,
  tai_fl_desconto double precision,
  tai_fl_dependente double precision,
  tai_st_origem character varying(50),
  tai_st_tipo character varying(50),
  CONSTRAINT ln_tabelaitem_pkey PRIMARY KEY (tai_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_tabelaitem
  OWNER TO postgres;
COMMENT ON TABLE ln_tabelaitem
  IS 'Item da tabela de impostos, taxas, juros entre outros';

-- Index: ln_tabelaitem_tab_in_codigo_tai_in_codigo_idx

-- DROP INDEX ln_tabelaitem_tab_in_codigo_tai_in_codigo_idx;

CREATE INDEX ln_tabelaitem_tab_in_codigo_tai_in_codigo_idx
  ON ln_tabelaitem
  USING btree
  (tab_in_codigo, tai_in_codigo);

CREATE SEQUENCE seq_tabelaitem
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_tabelaitem
  OWNER TO postgres;

-- Table: ln_tipofavorecido

-- DROP TABLE ln_tipofavorecido;

CREATE TABLE ln_tipofavorecido
(
  tfa_in_codigo integer NOT NULL,
  tfa_st_descricao character varying(50) NOT NULL,
  tfa_ch_ativo character(1) NOT NULL,
  CONSTRAINT pk_tipofavorecido PRIMARY KEY (tfa_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_tipofavorecido
  OWNER TO postgres;
COMMENT ON TABLE ln_tipofavorecido
  IS 'Tabela que define o tipo de pessoas, lojas, bancos';

-- Sequence: seq_tipofavorecido

-- DROP SEQUENCE seq_tipofavorecido;

CREATE SEQUENCE seq_tipofavorecido
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_tipofavorecido
  OWNER TO postgres;

insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Amigo', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Banco', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Cartório', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Chaveiro', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Contabilidade', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Construção', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Empresa', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Farmácia', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Governo', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Lazer', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Loja', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Mecânico', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Médico/Dentista', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Outro', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Parente', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Posto de Combustível', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Restaurantes', 'S');
insert into "ln_tipofavorecido" ("tfa_in_codigo", "tfa_st_descricao", "tfa_ch_ativo") values (nextval('seq_tipofavorecido'), 'Supermercado', 'S');

-- Table: ln_favorecido

-- DROP TABLE ln_favorecido;

CREATE TABLE ln_favorecido
(
  fav_in_codigo integer NOT NULL,
  fav_st_descricao character varying(50) NOT NULL,
  fav_ch_ativo character(1) NOT NULL,
  fav_st_documento character varying(15), -- CPF/CNPJ
  tfa_in_codigo integer NOT NULL,
  CONSTRAINT pk_favorecido PRIMARY KEY (fav_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_favorecido
  OWNER TO postgres;
COMMENT ON COLUMN ln_favorecido.fav_st_documento IS 'CPF/CNPJ';

-- Sequence: seq_favorecido

-- DROP SEQUENCE seq_favorecido;

CREATE SEQUENCE seq_favorecido
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_favorecido
  OWNER TO postgres;

-- Table: ln_planoconta

-- DROP TABLE ln_planoconta;

CREATE TABLE ln_planoconta
(
  cta_in_codigo integer NOT NULL,
  cat_in_codigo integer NOT NULL,
  cta_st_descricao character varying(50) NOT NULL,
  cta_ch_ativo character(1) NOT NULL,
  cta_fl_saldoinicial double precision NOT NULL,
  cta_st_configuracao character varying(1000),
  cta_st_alerta character varying(1000),
  cta_dt_criacao date,
  usu_st_codigo character varying(30),
  CONSTRAINT pk_conta PRIMARY KEY (cta_in_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_planoconta
  OWNER TO postgres;

-- Sequence: seq_planoconta

-- DROP SEQUENCE seq_planoconta;

CREATE SEQUENCE seq_planoconta
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_planoconta
  OWNER TO postgres;

-- Table: ln_saldoconta

-- DROP TABLE ln_saldoconta;

CREATE TABLE ln_saldoconta
(
  cta_in_codigo integer NOT NULL,
  sac_dt_data date NOT NULL,
  sac_fl_debito double precision,
  sac_fl_credito double precision,
  sac_fl_saldo double precision,
  CONSTRAINT ln_saldoconta_pkey PRIMARY KEY (cta_in_codigo, sac_dt_data)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ln_saldoconta
  OWNER TO postgres;

------------------------------------------------------------------------------------------------------------------------

-- insert into acessocontrol.ln_cliente("cli_in_codigo","cli_st_documento","cli_st_nome","cli_ch_ativo","cli_st_banco","cli_st_email")
-- values (nextval('acessocontrol.seq_cliente'),'12684146896','Marcos Naves','S','naves','m-nvs@uol.com.br');
-- insert into acessocontrol.ln_endereco ("end_in_codigo","cli_in_codigo", "end_ch_tipo","end_st_endereco","end_st_complemento","end_st_bairro","end_st_cidade","end_st_estado","end_st_cep")
-- values (nextval('acessocontrol.seq_endereco'), 2, '1','Rua Diógenes Ribeiro de Lima ,801',null,'Jardim Belval','Barueri','São Paulo','06420250');
-- insert into acessocontrol.ln_telefone ("tel_in_codigo","cli_in_codigo","tel_ch_tipo","tel_st_pais","tel_st_ddd","tel_st_telefone")
-- values (nextval('acessocontrol.seq_telefone'), 2, '3', null, '011','995046236');
-- insert into acessocontrol."ln_usuario" ("usu_st_codigo","usu_st_nome","usu_st_senha","usu_st_email","usu_ch_ativo","usu_in_dia","usu_ch_alterasenha","usu_ch_expirasenha",
--                                  "usu_dt_expiracao", "usu_dt_cadastro", "per_in_codigo", "usu_st_cpf", "cli_in_codigo", "usu_st_admin") values 
--                                 ('Marcos', 'Marcos Naves','Kareta448','m-nvs@uol.com.br','S','0','S','N',CURRENT_DATE,CURRENT_DATE, 1, '12684146896',2,'N');
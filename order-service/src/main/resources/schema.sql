CREATE SEQUENCE IF NOT EXISTS public.accounts_seq;

CREATE TABLE IF NOT EXISTS public.accounts (
    id bigint NOT NULL DEFAULT nextval('accounts_seq'),
    email_address varchar(255) NOT NULL,
    name varchar(100) NOT NULL,
    primary key (id)
);

CREATE SEQUENCE IF NOT EXISTS public.account_settings_seq;

CREATE TABLE IF NOT EXISTS public.account_settings (
    id bigint not null DEFAULT nextval('account_settings_seq'),
    name varchar(255) not null,
    value varchar(255) not null,
    account_id bigint not null,
    primary key (id)
);

ALTER TABLE public.account_settings
   add constraint FKaccounts
   foreign key (account_id)
   references accounts (id);
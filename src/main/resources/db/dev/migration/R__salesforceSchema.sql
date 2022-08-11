
-- ===========================================================
-- CREATE SALESFORCE
-- ===========================================================    

CREATE SEQUENCE IF NOT EXISTS salesforce.account_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;
   
CREATE TABLE IF NOT EXISTS salesforce.account
(
    name character varying(255) COLLATE pg_catalog."default",
    phone character varying(40) COLLATE pg_catalog."default",
    isdeleted boolean,
    systemmodstamp timestamp without time zone,
    createddate timestamp without time zone,
    type character varying(255) COLLATE pg_catalog."default",
    website character varying(255) COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    active__c character varying(255) COLLATE pg_catalog."default",
    sfid character varying(18) COLLATE pg_catalog.ucs_basic,
    id integer NOT NULL DEFAULT nextval('salesforce.account_id_seq'::regclass),
    _hc_lastop character varying(32) COLLATE pg_catalog."default",
    _hc_err text COLLATE pg_catalog."default",
    CONSTRAINT account_pkey PRIMARY KEY (id)
);


-- Index: hc_idx_account_systemmodstamp
-- DROP INDEX IF EXISTS salesforce.hc_idx_account_systemmodstamp;

CREATE INDEX IF NOT EXISTS hc_idx_account_systemmodstamp
    ON salesforce.account USING btree
    (systemmodstamp ASC NULLS LAST);

-- Index: hcu_idx_account_sfid
-- DROP INDEX IF EXISTS salesforce.hcu_idx_account_sfid;

CREATE UNIQUE INDEX IF NOT EXISTS hcu_idx_account_sfid
    ON salesforce.account USING btree
    (sfid COLLATE pg_catalog.ucs_basic ASC NULLS LAST);

DELETE FROM salesforce.account;    

INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('United Oil & Gas, Singapore', '(650) 450-8810', false, '2022-08-07 22:14:20', '2022-08-06 20:26:48', 'Customer - Direct', 'http://www.uos.com', NULL, 'Yes', '0018V00002PJyE3QAL', 3, NULL, NULL);
INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('Burlington Textiles Corp of America', '(336) 222-7000', false, '2022-08-07 22:14:20', '2022-08-06 20:26:48', 'Customer - Direct', 'www.burlington.com', NULL, NULL, '0018V00002PJyDvQAL', 5, NULL, NULL);
INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('Cuenta de ejemplo para asignaciones', NULL, false, '2022-08-07 22:14:20', '2022-08-06 20:30:10', NULL, NULL, NULL, NULL, '0018V00002PJyGhQAL', 7, NULL, NULL);
INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('Express Logistics and Transport', '(503) 421-7800', false, '2022-08-07 22:14:20', '2022-08-06 20:26:48', 'Customer - Channel', 'www.expressl&t.net', 'Commerical logistics and transportation company.', 'Yes', '0018V00002PJyE0QAL', 8, NULL, NULL);
INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('University of Arizona', '(520) 773-9050', false, '2022-08-07 22:14:20', '2022-08-06 20:26:48', 'Customer - Direct', 'www.universityofarizona.com', 'Leading university in AZ offering undergraduate and graduate programs in arts and humanities, pure sciences, engineering, business, and medicine.', 'Yes', '0018V00002PJyE1QAL', 9, NULL, NULL);
INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('United Oil & Gas Corp.', '(212) 842-5500', false, '2022-08-07 22:14:20', '2022-08-06 20:26:48', 'Customer - Direct', 'http://www.uos.com', 'World''s third largest oil and gas company.', 'Yes', '0018V00002PJyDzQAL', 10, NULL, NULL);
INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('Dickenson plc', '(785) 241-6200', false, '2022-08-07 22:14:20', '2022-08-06 20:26:48', 'Customer - Channel', 'dickenson-consulting.com', NULL, 'Yes', '0018V00002PJyDxQAL', 12, NULL, NULL);
INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('Grand Hotels & Resorts Ltd', '(312) 596-1000', false, '2022-08-07 22:14:20', '2022-08-06 20:26:48', 'Customer - Direct', 'www.grandhotels.com', 'Chain of hotels and resorts across the US, UK, Eastern Europe, Japan, and SE Asia.', 'Yes', '0018V00002PJyDyQAL', 13, NULL, NULL);
INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('GenePoint', '(650) 867-3450', false, '2022-08-11 00:02:38', '2022-08-06 20:26:48', 'Customer - Channel', 'www.genepoint.com', 'Genomics company engaged in mapping and sequencing of the human genome and developing gene-based drugs', 'Yes', '0018V00002PJyE4QAL', 1, 'SYNCED', NULL);
INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('Edge Communications', '(512) 757-6000', false, '2022-08-11 00:48:22', '2022-08-06 20:26:48', 'Customer - Direct', 'http://edgecomm.com', 'Edge, founded in 1998, is a start-up based in Austin, TX. The company designs and manufactures a device to convert music from one digital format to another. Edge sells its product through retailers and its own website.', 'Yes', '0018V00002PJyDuQAL', 4, 'SYNCED', NULL);
INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('sForce', '(415) 901-7000', false, '2022-08-11 00:50:16', '2022-08-06 20:26:48', NULL, 'www.sforce.com', NULL, NULL, '0018V00002PJyE5QAL', 11, 'SYNCED', NULL);
INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('Pyramid Construction Inc.', '(014) 427-4427', false, '2022-08-11 01:11:44', '2022-08-06 20:26:48', 'Customer - Channel', 'www.pyramid.com', NULL, 'Yes', '0018V00002PJyDwQAL', 6, 'SYNCED', NULL);
INSERT INTO salesforce.account (name, phone, isdeleted, systemmodstamp, createddate, type, website, description, active__c, sfid, id, _hc_lastop, _hc_err) VALUES ('United Oil & Gas, UK', '+44 191 4956203', false, '2022-08-11 01:12:00', '2022-08-06 20:26:48', 'Customer - Direct', 'http://www.uos.com', NULL, 'Yes', '0018V00002PJyE2QAL', 2, 'SYNCED', NULL);

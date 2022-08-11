delete from person;

--
-- Data for Name: person; Type: TABLE DATA; Schema: conciliator; Owner: conciliator
--

INSERT INTO conciliator.person VALUES (1, '1992-08-11', 'John Doe', '{"ojos": "marrones", "pelo": "rojo"}', 'ALIVE');
INSERT INTO conciliator.person VALUES (2, '1942-08-11', 'John Senior Doe', '{"ojos": "azules", "pelo": "marron claro"}', 'DEATH');


--
-- Data for Name: person_alias; Type: TABLE DATA; Schema: conciliator; Owner: conciliator
--

INSERT INTO conciliator.person_alias VALUES (5, 'me@family.com', 'EMAIL', 1);
INSERT INTO conciliator.person_alias VALUES (6, '1111', 'DNI', 1);
INSERT INTO conciliator.person_alias VALUES (7, 'granpa@family.com', 'EMAIL', 2);
INSERT INTO conciliator.person_alias VALUES (8, '9999', 'DNI', 2);


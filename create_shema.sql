CREATE SCHEMA IF NOT EXISTS slb AUTHORIZATION slb;

DROP TABLE IF EXISTS detail CASCADE;

CREATE TABLE slb.detail (
		id serial NOT NULL UNIQUE PRIMARY KEY,
		name_ru varchar(50) NOT NULL,
		name_en varchar(50) NOT NULL,
		weight_average decimal(7,2),
		weight_max decimal(7,2),
		weight_min decimal(7,2),
		nomenclature_number varchar(50) NOT NULL,
		part_number varchar(50) NOT NULL,
		description varchar(50),
		category varchar(50) NOT NULL
		);

INSERT INTO detail (id,	name_ru, name_en, weight_average, weight_max, weight_min,
					nomenclature_number, part_number, description, category)
	VALUES (1, 'деталь #1', 'detail #1', 10, 20, 5, '111', '11_01', '', 'category_1');
INSERT INTO detail (id,	name_ru, name_en, weight_average, weight_max, weight_min,
					nomenclature_number, part_number, description, category)
	VALUES (2, 'деталь #2', 'detail #2', 70, 200, 11, '222', '1721_01', '', 'category_1');
INSERT INTO detail (id,	name_ru, name_en, weight_average, weight_max, weight_min,
					nomenclature_number, part_number, description, category)
	VALUES (3, 'деталь #3', 'detail #3', 12, 70,18, '333', '13_01', '', 'category_3');
INSERT INTO detail (id,	name_ru, name_en, weight_average, weight_max, weight_min,
					nomenclature_number, part_number, description, category)
	VALUES (4, 'деталь #4', 'detail #4', 42, 75, 13, '444', '14_01', '', 'category_1');
INSERT INTO detail (id,	name_ru, name_en, weight_average, weight_max, weight_min,
					nomenclature_number, part_number, description, category)
	VALUES (5, 'деталь #5', 'detail #5', 17, 40, 2, '555', '15_01', '', 'category_3');
INSERT INTO detail (id,	name_ru, name_en, weight_average, weight_max, weight_min,
					nomenclature_number, part_number, description, category)
	VALUES (6, 'деталь #6', 'detail #6', 47, 86, 4, '666', '16_01', '', 'category_1');
INSERT INTO detail (id,	name_ru, name_en, weight_average, weight_max, weight_min,
					nomenclature_number, part_number, description, category)
	VALUES (7, 'деталь #7', 'detail #7', 47, 57, 15, '777', '17_01', '', 'category_7');
INSERT INTO detail (id,	name_ru, name_en, weight_average, weight_max, weight_min,
					nomenclature_number, part_number, description, category)
	VALUES (8, 'деталь #7', 'detail #7', 47, 57, 10, '777', '17_01', '', 'category_3');
INSERT INTO detail (id,	name_ru, name_en, weight_average, weight_max, weight_min,
					nomenclature_number, part_number, description, category)
	VALUES (9, 'деталь #7', 'detail #7', 47, 57, 15, '777', '17_01', '', 'category_7');

DROP TABLE IF EXISTS history;

CREATE TABLE slb.history (
		id serial NOT NULL UNIQUE PRIMARY KEY,
		weight decimal(7,2) NOT NULL,
		nomenclature_number varchar(50) NOT NULL,
		detail_fk serial REFERENCES detail
		);

INSERT INTO history (id, weight, nomenclature_number, detail_fk)
	VALUES (1, 75, '111', 1);

DROP TABLE IF EXISTS image;

CREATE TABLE slb.image (
		id serial NOT NULL UNIQUE PRIMARY KEY,
		image bytea NOT NULL,
		point json NOT NULL,
		description varchar(50) NOT NULL,
		detail_fk serial REFERENCES detail
		);


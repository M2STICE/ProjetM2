--Création de la base M2STICE:
create if not exists database M2STICE character 'utf-8';

-- Création de la table diplome
create table diplome(
	code_diplome int primary key, 
	nom_diplome varchar(255), 
	description_diplome varchar(255)
);

--Creation de la table domaine
	create table domaine(
	code_domaine int primary key, 
	nom_domaine varchar(255), 
	code_diplome int foreign key
);

--Création de la table compétences
create table competence(
	code_competence int primary key, 
	nom_competence varchar(255),
	code_domaine int, 
	code_EC int,
	foreign key(code_domaine, code_EC)
);

--Création de la table item
create table item(
	code_item int primary key, 
	nom_item varchar(255),
	code_competence int, 
	code_evaluation int,
	foreign key(code_competence, code_evaluation)
);

--Création de la table sous-item
create table sous_item(
	code_sous_item int primary key, 
	nom_sous_item varchar(255), 
	code_item int foreign key
);

--Création de la table evaluation
create table evaluation(
	code_evaluation int primary key, 
	nom_evaluation varchar(255), 
	note_maximale float, 
	coefficient_evaluation float, 
	type_epreuve varchar(255),
	code_sous_item int
);

--Création de la table année
create table annee(
code_annee int primary key, 
nom_annee varchar(255)
);

--Création de la table 
create table diplome_annee(
	code_diplome int primary key, 
	code_annee int foreign key 
);

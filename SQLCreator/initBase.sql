--Création de la base M2STICE:
create database M2STICE character 'utf8';

-- Création de la table diplome
create table diplome(
	code_diplome int primary key, 
	nom_diplome varchar(255), 
	description_diplome varchar(255)
	
)
ENGINE=INNODB;

--Creation de la table domaine
create table domaine( 
code_domaine int primary key, 
nom_domaine varchar(255), 
code_diplome int, 
foreign key(code_diplome) references diplome(code_diplome) 
) 
ENGINE=INNODB;

--Création table intervenant
create table intervenant(
code_intervenant int primary key,
nom_intervenant varchar(100),
mot_de_passe varchar(100)
)ENGINE=INNODB;



--Création de la table compétences
create table competence(
	code_competence int primary key, 
	nom_competence varchar(255),
	code_domaine int, 
	code_EC int,
	foreign key(code_domaine, code_EC)
)
engine=INNODB;

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

--Création table semestre
create table semestre(
code_semestre int primary key,
nom_semestre varchar(100),
code_annee int foreign key
);



--Création table UC
create table uc(
code_ue int primary key,
nom_ue varchar(100),
nombre_ects int,
resume_ue varchar(1000),
code_semestre int,
code_intervenant int,
foreign key(code_semestre, code_intervenant),
);

--Création table EC
create table ec(
code_ec int,
nom_ec varchar(255),
coefficient_ec float,
nom_ects int,
volume_heure_cours float,
volume_heure_TD float,
volume_heure_TP float,
volume_heure_BE float,
volume_heure_TPERSO float,
resume_ec varchar(1000),
code_ue int,
responsable_ec int,
primary key(code_ec),
foreign key(code_ue,responsable_ec),
);

--Création table etudiant
create table etudiant(
code_etudiant int,
nom_etudiant varchar(100),
prenom_etudiant varchar(100),
mot_de_passe_etudiant varchar(100)
primary key(code_etudiant);
);

--Création table etudiant_evaluation
create table etudiant_evaluation(
code_etudiant int,
code_evaluation int,
date_evaluation date,
note_evaluation float,
primary key(code_etudiant,code_evaluation,date_evaluation);
foreign key(code_etudiant,code_evaluation,date_evaluation);
);


--Création table intervenant_ec
create table intervenant_ec (
code_intervenant int,
code_ec int,
primary key(code_intervenant,code_ec),
foreign key(code_intervenant,code_ec)
);

--Création table etudiant_diplome
create table etudiant_diplome (
code_etudiant int, 
code_diplome int , 
primary key(code_etudiant,code_diplome),
foreign key(code_etudiant,code_diplome)
);
/*Création de la base M2STICE:*/
/*Attention le nom de la base de données en ligne est u960093295_stice*/
create database M2STICE character 'utf8';

/*Création de la table diplome*/
create table diplome(
	code_diplome int not null auto_increment, 
	nom_diplome varchar(255), 
	description_diplome varchar(255),
	primary key(code_diplome)
)
ENGINE=INNODB;

/*Creation de la table domaine*/
create table domaine( 
code_domaine int not null auto_increment, 
nom_domaine varchar(255), 
code_diplome int, 
foreign key(code_diplome) references diplome(code_diplome),
primary key(code_domaine)
) 
ENGINE=INNODB;

/*Création table intervenant*/
create table intervenant(
code_intervenant int not null auto_increment,
nom_intervenant varchar(100),
mot_de_passe varchar(100),
primary key(code_intervenant)
)
ENGINE=INNODB;

/*Création de la table année*/
create table annee(
code_annee int not null auto_increment, 
nom_annee varchar(255),
primary key(code_annee)
)
ENGINE=INNODB;

/*Création de la table*/ 
create table diplome_annee(
	code_diplome int not null auto_increment, 
	code_annee int,
	foreign key(code_annee) references annee(code_annee),
	primary key(code_diplome)
)
ENGINE=INNODB;

/*Création table semestre*/
create table semestre(
code_semestre int not null auto_increment,
nom_semestre varchar(100),
code_annee int,
foreign key(code_annee) references annee(code_annee),
primary key(code_semestre)
)
ENGINE=INNODB;

/*Création table UE*/
create table ue(
code_ue int not null auto_increment,
nom_ue varchar(100),
nombre_ects int,
resume_ue varchar(1000),
code_semestre int,
code_intervenant int,
coefficient_ue float,
code_diplome,
primary key(code_ue),
foreign key(code_semestre) references semestre(code_semestre),
foreign key(code_intervenant) references intervenant(code_intervenant),
foreign key(code_diplome) reference diplome(code_diplome)
)
ENGINE=INNODB;

/*Création table EC*/
create table ec(
code_ec int not null auto_increment,
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
code_semestre,
primary key(code_ec),
foreign key(code_ue) references ue(code_ue),
foreign key(responsable_ec) references intervenant(code_intervenant)
foreign key(code_semestre) references semestre(code_semestre)
)
ENGINE=INNODB;

/*Création de la table compétences*/
create table competence(
	code_competence int not null auto_increment, 
	nom_competence varchar(255),
	code_domaine int,
	primary key(code_competence),
	foreign key(code_domaine) references domaine(code_domaine)
)
ENGINE=INNODB;

/*Création table etudiant*/
create table etudiant(
code_etudiant int not null auto_increment,
nom_etudiant varchar(100),
prenom_etudiant varchar(100),
mot_de_passe_etudiant varchar(100),
primary key(code_etudiant)
)
ENGINE=INNODB;

/*Création table intervenant_ec*/
create table intervenant_ec(
code_intervenant int,
code_ec int,
primary key(code_intervenant,code_ec),
foreign key(code_intervenant) references intervenant(code_intervenant),
foreign key(code_ec) references ec(code_ec)
)
ENGINE=INNODB;

/*Création table etudiant_diplome*/
create table etudiant_diplome(
code_etudiant int, 
code_diplome int,
primary key (code_etudiant,code_diplome),
foreign key(code_etudiant)references etudiant(code_etudiant),
foreign key(code_diplome)references diplome(code_diplome)
)
ENGINE=INNODB;

/*Création de la table item*/
create table item(
	code_item int not null auto_increment, 
	nom_item varchar(255),
	code_competence int, 
	code_evaluation int,
	primary key(code_item),
	foreign key(code_competence) references competence(code_competence) 
)
ENGINE=INNODB;

/*Création de la table sous-item*/
create table sous_item(
	code_sous_item int not null auto_increment, 
	nom_sous_item varchar(255), 
	primary key(code_sous_item)
)
ENGINE=INNODB;


/*Création de la table evaluation*/
create table evaluation(
	code_evaluation int not null auto_increment, 
	nom_evaluation varchar(255), 
	note_maximale float, 
	coefficient_evaluation float, 
	type_epreuve varchar(255),
	code_sous_item int,
	primary key(code_evaluation),
	foreign key(code_sous_item) references sous_item(code_sous_item)
)
ENGINE=INNODB;

/*Création table etudiant_evaluation*/
create table etudiant_evaluation(
code_etudiant int,
code_evaluation int,
date_evaluation date,
note_evaluation float,
foreign key(code_etudiant) references etudiant(code_etudiant),
foreign key(code_evaluation) references evaluation(code_evaluation)
)
ENGINE=INNODB;

/*Création table ec_sous_item*/
create table ec_sous_item(
code_ec int,
code_sous_item int,
primary key(code_ec,code_sous_item),
foreign key(code_ec) references ec(code_ec),
foreign key(code_sous_item) references sous_item(code_sous_item)
)
ENGINE=INNODB;

/*Création table ec_item*/
create table ec_item(
code_ec int
code_item int
primary key(code_ec,code_item),
foreign key(code_ec) references ec(code_ec),
foreign key(code_item) references sous_item(code_item)
)ENGINE=INNODB;

/*Création table promotion*/
create table promotion(
code_promotion int not null auto_increment,
nom_promotion varchar(100),
annee_debut_promotion int,
annee_fin_promotion int,
code_annee int,
code_diplome int,
primary key(code_promotion),
foreign key(code_annee) references annee(code_annee),
foreign key(code_diplome) references diplome(code_diplome)
)
ENGINE=INNODB;

/*Création table etudiant_promotion*/
create table etudiant_promotion(
code_etudiant int,
code_promotion int,
primary key(code_etudiant,code_promotion),
foreign key(code_etudiant,code_promotion)
)
ENGINE=INNODB;

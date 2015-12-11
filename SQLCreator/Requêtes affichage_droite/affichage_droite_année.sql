/*************Affichage au niveau annn�e de l'application**************/


/*Liste des �tudiants dans la promotion du diplome recherché pour l'ann�e */

select code_etudiant
from etudiant, promotion
where etudiant.code_etudiant = etudiant_promotion.code_etudiant 
and promotion.code_promotion = etudiant_promotion.code_promotion
and promotion.code_promotion =/*code promotion récupéré*/
and promotion.code_diplome =/*code diplome récupéré*/
and promotion.code_annee =/* code année récupéré*/;

/*Nombres dans la promotion du diplome recherché*/
select count(code_etudiant) as nb_etudiant
from etudiant, promotion
where etudiant.code_etudiant = etudiant_promotion.code_etudiant 
and promotion.code_promotion = etudiant_promotion.code_promotion
and promotion.code_promotion =/*code promotion récupéré*/
and promotion.code_diplome =/*code diplome récupéré*/
and promotion.code_annee =/* code ann�e récupéré*/;

/*Moyenne des notes des evaluations pour chaque sous_item */ 
select sum(evaluation_etudiant.note_evaluation)
from evaluation, evaluation_etudiant
where evaluation.code_evaluation = etudiant_evaluation.code_evaluation
and evaluation.code_sous_item = /*sous_item.code_sous_item pour un sous_item */
and etudiant_evaluation.code_etudiant = (select code_etudiant
from etudiant, promotion
where etudiant.code_etudiant = etudiant_promotion.code_etudiant 
and promotion.code_promotion = etudiant_promotion.code_promotion
and promotion.code_promotion =/*code promotion récupéré*/
and promotion.code_diplome =/*code diplome récupéré*/
and promotion.code_annee =/* code ann�e récupéré*/);


/*Liste des ec*/
select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome r�cup�r�*/
and annee.code_annee = /*code annee r�cup�r�e*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue;

/*Liste des items*/
select item.nom_item
from item,ec_item
where item.code_item = ec_item.code_item and ec_item.code_ec = 
(select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome r�cup�r�*/
and annee.code_annee = /*code annee r�cup�r�e*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue);

/*Liste des competences*/
select competence.nom_competence
from competence
where competence.code_competence =(select item.code_comptence
from item,ec_item
where item.code_item = ec_item.code_item and ec_item.code_ec = 
(select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome r�cup�r�*/
and annee.code_annee = /*code annee r�cup�r�e*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue));

/*Liste des domaines de comp�tence*/
select domaine.nom_domaine
from domaine
where domaine.code_domaine =(select competence.code_domaine
from competence
where competence.code_competence =(select item.code_comptence
from item,ec_item
where item.code_item = ec_item.code_item and ec_item.code_ec = 
(select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome r�cup�r�*/
and annee.code_annee = /*code annee r�cup�r�e*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue)));

/*Liste des sous-item*/
select sous_item.nom_sous_item
from sous_item,ec_sous_item
where sous_item.code_sous_item = ec_sous_item.code_sous_item 
and ec_sous_item.code_ec = (select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome r�cup�r�*/
and annee.code_annee = /*code annee r�cup�r�e*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue));

/*Liste des evaluations */
select evaluation.nom_evaluation
from evaluation
where evaluation.code_evaluation = evaluation_sous_item.code_evaluation and
evaluation_sous_item = select sous_item.code_sous_item
from sous_item,ec_sous_item
where sous_item.code_sous_item = ec_sous_item.code_sous_item 
and ec_sous_item.code_ec = (select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome r�cup�r�*/
and annee.code_annee = /*code annee r�cup�r�e*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue)));

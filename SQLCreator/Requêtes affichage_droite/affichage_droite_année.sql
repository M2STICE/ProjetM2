/*************Affichage au niveau annn�e de l'application**************/


/*Liste des �tudiants dans la promotion du diplome recherché pour l'ann�e */

select etudiant.code_etudiant
from etudiant, promotion, etudiant_promotion
where etudiant.code_etudiant = etudiant_promotion.code_etudiant 
and promotion.code_promotion = etudiant_promotion.code_promotion
and promotion.code_promotion =/*code promotion récupéré*/
and promotion.code_diplome =/*code diplome récupéré*/
and promotion.code_annee =/* code année récupéré*/;
Ex:
SELECT etudiant.code_etudiant
FROM etudiant, promotion, etudiant_promotion
WHERE etudiant.code_etudiant = etudiant_promotion.code_etudiant
AND promotion.code_promotion = etudiant_promotion.code_promotion
AND promotion.code_promotion =1
AND promotion.code_diplome =28
AND promotion.code_annee =1;

/*Nombres dans la promotion du diplome recherché*/
select count(etudiant.code_etudiant) as nb_etudiant
from etudiant, promotion, etudiant_promotion
where etudiant.code_etudiant = etudiant_promotion.code_etudiant 
and promotion.code_promotion = etudiant_promotion.code_promotion
and promotion.code_promotion =/*code promotion récupéré*/
and promotion.code_diplome =/*code diplome récupéré*/
and promotion.code_annee =/* code ann�e récupéré*/;
Ex:
SELECT COUNT( etudiant.code_etudiant ) AS nb_etudiant
FROM etudiant, promotion, etudiant_promotion
WHERE etudiant.code_etudiant = etudiant_promotion.code_etudiant
AND promotion.code_promotion = etudiant_promotion.code_promotion
AND promotion.code_promotion =1
AND promotion.code_diplome =28
AND promotion.code_annee =1

/*Moyenne des notes des evaluations pour chaque sous_item */ 
select sum(etudiant_evaluation.note_evaluation)
from evaluation, etudiant_evaluation
where evaluation.code_evaluation = etudiant_evaluation.code_evaluation
and etudiant_evaluation.code_etudiant in (select code_etudiant
from etudiant, promotion, etudiant_promotion
where etudiant.code_etudiant = etudiant_promotion.code_etudiant 
and promotion.code_promotion = etudiant_promotion.code_promotion
and promotion.code_promotion =/*code promotion récupéré*/
and promotion.code_diplome =/*code diplome récupéré*/
and promotion.code_annee =/* code ann�e récupéré*/);
Ex:
select sum(etudiant_evaluation.note_evaluation)
from evaluation, etudiant_evaluation 
where evaluation.code_evaluation = etudiant_evaluation.code_evaluation
and etudiant_evaluation.code_etudiant in (select etudiant.code_etudiant
from etudiant, promotion, etudiant_promotion
where etudiant.code_etudiant = etudiant_promotion.code_etudiant 
and promotion.code_promotion = etudiant_promotion.code_promotion
and promotion.code_promotion = 1
and promotion.code_diplome = 28
and promotion.code_annee = 1)


/*Liste des ec*/
select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome r�cup�r�*/
and annee.code_annee = /*code annee r�cup�r�e*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue;
Ex:
SELECT ec.code_ec
FROM ue, ec, diplome, semestre, annee
WHERE ue.code_diplome =28
AND annee.code_annee =1
AND semestre.code_annee = annee.code_annee
AND ue.code_semestre = semestre.code_semestre
AND ec.code_ue = ue.code_ue


/*Liste des items*/
select item.nom_item
from item,ec_item
where item.code_item = ec_item.code_item and ec_item.code_ec in 
(select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome r�cup�r�*/
and annee.code_annee = /*code annee r�cup�r�e*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue);
Ex: select item.nom_item
from item,ec_item
where item.code_item = ec_item.code_item and ec_item.code_ec in 
(select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = 28
and annee.code_annee = 1
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue)



/*Liste des competences*/
select competence.nom_competence
from competence
where competence.code_competence in (select item.code_competence
from item,ec_item
where item.code_item = ec_item.code_item and ec_item.code_ec in 
(select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome r�cup�r�*/
and annee.code_annee = /*code annee r�cup�r�e*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue));
Ex:
select competence.nom_competence
from competence
where competence.code_competence in (select item.code_competence
from item,ec_item
where item.code_item = ec_item.code_item and ec_item.code_ec in 
(select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = 28
and annee.code_annee = 1
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue))



/*Liste des domaines de comp�tence*/
select domaine.nom_domaine
from domaine
where domaine.code_domaine in (select competence.code_domaine
from competence
where competence.code_competence in (select item.code_competence
from item,ec_item
where item.code_item = ec_item.code_item and ec_item.code_ec in 
(select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome r�cup�r�*/
and annee.code_annee = /*code annee r�cup�r�e*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue)));
Ex:
select domaine.nom_domaine
from domaine
where domaine.code_domaine in (select competence.code_domaine
from competence
where competence.code_competence in (select item.code_competence
from item,ec_item
where item.code_item = ec_item.code_item and ec_item.code_ec in 
(select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = 28
and annee.code_annee = 1
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue)))



/*Liste des sous-item*/
select sous_item.nom_sous_item
from sous_item,ec_sous_item
where sous_item.code_sous_item = ec_sous_item.code_sous_item 
and ec_sous_item.code_ec in (select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome r�cup�r�*/
and annee.code_annee = /*code annee r�cup�r�e*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue);
Ex: 
select sous_item.nom_sous_item
from sous_item,ec_sous_item
where sous_item.code_sous_item = ec_sous_item.code_sous_item 
and ec_sous_item.code_ec in (select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = 28
and annee.code_annee = 1
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue)



/*Liste des evaluations */
select evaluation.nom_evaluation
from evaluation, sous_item_evaluation
where evaluation.code_evaluation = sous_item_evaluation.code_evaluation and
sous_item_evaluation.code_sous_item in (select sous_item.code_sous_item
from sous_item,ec_sous_item
where sous_item.code_sous_item = ec_sous_item.code_sous_item 
and ec_sous_item.code_ec in (select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome r�cup�r�*/
and annee.code_annee = /*code annee r�cup�r�e*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue));
Ex: 
select evaluation.nom_evaluation
from evaluation, sous_item_evaluation
where evaluation.code_evaluation = sous_item_evaluation.code_evaluation and
sous_item_evaluation.code_sous_item in (select sous_item.code_sous_item
from sous_item,ec_sous_item
where sous_item.code_sous_item = ec_sous_item.code_sous_item 
and ec_sous_item.code_ec in (select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = 28
and annee.code_annee = 1
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue))

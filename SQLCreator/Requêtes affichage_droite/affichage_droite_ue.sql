/*************Affichage au niveau UE**************/

/*Liste des ec*/
select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome récupéré*/
and annee.code_annee = /*code annee récupérée*/
and semestre.code_semestre =/*semestre récupéré*/
and ue.code_ue = /*ue récupérée*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue;

/*Liste des items*/
select item.nom_item
from item,ec_item
where item.code_item = ec_item.code_item and ec_item.code_ec = 
(select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome récupéré*/
and annee.code_annee = /*code annee récupérée*/
and semestre.code_semestre =/*semestre récupéré*/
and ue.code_ue = /*ue récupérée*/
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
where ue.code_diplome = /*code diplome récupéré*/
and annee.code_annee = /*code annee récupérée*/
and semestre.code_semestre =/*semestre récupéré*/
and ue.code_ue = /*ue récupérée*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue));

/*Liste des domaines de compétence*/
select domaine.nom_domaine
from domaine
where domaine.code_domaine =(select competence.code_domaine
from competence
where competence.code_competence =(select item.code_comptence
from item,ec_item
where item.code_item = ec_item.code_item and ec_item.code_ec = 
(select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome récupéré*/
and annee.code_annee = /*code annee récupérée*/
and semestre.code_semestre =/*semestre récupéré*/
and ue.code_ue = /*ue récupérée*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue)));

/*Liste des sous-item*/
select sous_item.nom_sous_item
from sous_item,ec_sous_item
where sous_item.code_sous_item = ec_sous_item.code_sous_item 
and ec_sous_item.code_ec = (select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome récupéré*/
and annee.code_annee = /*code annee récupérée*/
and semestre.code_semestre =/*semestre récupéré*/
and ue.code_ue = /*ue récupérée*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue));

/*Liste des evaluations */
select evaluation.nom_evaluation
from evaluation
where evaluation.code_sous_item = select sous_item.code_sous_item
from sous_item,ec_sous_item
where sous_item.code_sous_item = ec_sous_item.code_sous_item 
and ec_sous_item.code_ec = (select ec.code_ec
from ue,ec,diplome,semestre,annee
where ue.code_diplome = /*code diplome récupéré*/
and annee.code_annee = /*code annee récupérée*/
and semestre.code_semestre =/*semestre récupéré*/
and ue.code_ue = /*ue récupérée*/
and semestre.code_annee = annee.code_annee
and ue.code_semestre = semestre.code_semestre
and ec.code_ue = ue.code_ue)));

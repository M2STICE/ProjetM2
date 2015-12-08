/*************Affichage au niveau diplome de l'application**************/

/*Pour affichage*/
select nom_domaine
from domaine,diplome
where domaine.code_diplome = diplome.code_diplome;

/*Pour la suite du traitement*/
select code_domaine
from domaine
where nom_domaine = /*domaine selectionn�*/

/*Pour l'affichage*/
select nom_competence
from competence,domaine
where competence.code=/*code domaine selectionn�*/

/*Pour la suite du traitement*/
select code_competence
from competence
where nom_competence = /*competence s�lectionn�e*/

/*Pour l'affichage*/
select nom_item
from item,competence
where item.code_competence = /*code comp�tence s�lectionn�e*/;

/*Pour la suite du traitement*/
select code_item
from item
where item.nom_item = /*item selectionn�*/

/*Pour l'affichage*/
select nom_ec
from item,ec
where item.code_item = /*code de l'item s�lectionn�*/
and item.code_item = ec_item.code_item
and ec.code_ec = ec_item.code_ec;

/*Pour la suite du traitement*/
select code_ec
from ec 
where ec.nom_ec = /*nom ec s�lectionn�*/

/*Pour l'affichage*/
select nom_sous_item
from ec,sous_item
where ec.code_ec = /*code ec selectionn�*/

/*Pour la suite du traitement*/
select code_sous_item
from sous_item
where sous_item.nom = /*nom item selectionn�*/

/*Pour l'affichage*/
select nom_evaluation
from evaluation, sous_item
where evaluation.code_sous_item = /*code sous item selectionn�*/


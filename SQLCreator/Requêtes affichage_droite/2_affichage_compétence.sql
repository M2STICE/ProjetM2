/*Pour l'affichage*/
select nom_competence
from competence,domaine
where competence.code=/*code domaine selectionn�*/

/*Pour la suite du traitement*/
select code_competence
from competence
where nom_competence = /*competence s�lectionn�e*/


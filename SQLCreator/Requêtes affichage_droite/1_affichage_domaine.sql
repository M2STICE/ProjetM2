/*Pour affichage*/
select nom_domaine
from domaine,diplome
where domaine.code_diplome = diplome.code_diplome;

/*Pour la suite du traitement*/
select code_domaine
from domaine
where nom_domaine = /*domaine selectionné*/

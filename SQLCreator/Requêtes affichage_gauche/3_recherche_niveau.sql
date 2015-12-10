/*Pour l'affichage */
select nom_annee
from annee,promotion,diplome
where promotion.code_annee = annee.code_annee 
and diplome.code_diplome = promotion.code_diplome;

/*Pour la suite du traitement*/
select code_annee
from annee
where annee.nom_annee = /*nom annee selectionner*/;
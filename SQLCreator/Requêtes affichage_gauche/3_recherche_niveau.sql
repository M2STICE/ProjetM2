/*Pour l'affichage */
select nom_annee
from annee,diplome
where annee.code_annee = diplome_annee.code_annee 
and diplome.code_diplome = diplome_annee.code_diplome
and diplome.code_diplome =/*code diplome sélectionner*/;

/*Pour la suite du traitement*/
select code_annee
from annee
where annee.nom_annee = /*nom annee selectionner*/;
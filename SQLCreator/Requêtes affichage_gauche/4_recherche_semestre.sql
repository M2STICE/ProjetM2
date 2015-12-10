/*Pour l'affichage*/
select nom_semestre
from semestre
where semestre.code_annee = /*code ann�e s�lectionn�e*/;

/*Pour la suite du traitement*/
select code_semestre
from semestre
where semestre.nom_semestre = /*nom semestre  s�lectionn�e*/;


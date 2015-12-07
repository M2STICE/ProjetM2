/*Pour l'affichage*/
select nom_semestre
from semestre,annee
where semestre.code_annee = /*code année sélectionnée*/;

/*Pour la suite du traitement*/
select code_semestre
from semestre
where semestre.nom_semestre = /*nom semestre  sélectionnée*/;


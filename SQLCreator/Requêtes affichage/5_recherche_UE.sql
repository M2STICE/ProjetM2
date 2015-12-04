/*Pour l'affichage */
select nom_ue
from diplome,promotion,annee,semestre,ue
where diplome.code_diplome = ue.code_diplome 
and semestre.code_semestre = ue.code_semestre

/*Pour la suite du traitement */

select code_ue
from ue
where ue.nom_ue =/*ue sélectionnée*/
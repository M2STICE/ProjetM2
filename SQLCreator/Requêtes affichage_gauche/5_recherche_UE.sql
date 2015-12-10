/*Pour l'affichage */
SELECT nom_ue
FROM diplome, annee, semestre, ue
WHERE diplome.code_diplome = ue.code_diplome
AND semestre.code_semestre = ue.code_semestre
AND annee.code_annee = 1
AND semestre.code_semestre =1
AND diplome.code_diplome = 23

/*Pour la suite du traitement */

select code_ue
from ue
where ue.nom_ue =/*ue s�lectionn�e*/
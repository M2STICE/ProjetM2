/*Pour l'affichage */
select annee_promotion
from promotion, diplome
where promotion.code_diplome = diplome.code_diplome 
and diplome.code=/* code diplome selectionné*/;

/*Pour la suite du traitement */
select code_promotion
from promtiom, diplome
where promotion.code_diplome = diplome.code_diplome
and annee_promotion=/*annee selectionnée*/
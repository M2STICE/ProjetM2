/*Pour l'affichage*/
select nom_evaluation
from evaluation, sous_item
where evaluation.code_sous_item = /*code sous item selectionné*/
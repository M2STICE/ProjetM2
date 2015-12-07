/*Pour l'affichage*/
select nom_item
from item,competence
where item.code_competence = /*code compétence sélectionnée*/;

/*Pour la suite du traitement*/
select code_item
from item
where item.nom_item = /*item selectionné*/
/*Pour l'affichage*/
select nom_item
from item,competence
where item.code_competence = /*code comp�tence s�lectionn�e*/;

/*Pour la suite du traitement*/
select code_item
from item
where item.nom_item = /*item selectionn�*/
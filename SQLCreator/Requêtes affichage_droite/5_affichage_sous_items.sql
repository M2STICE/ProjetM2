/*Pour l'affichage*/
select nom_sous_item
from ec,sous_item
where ec.code_ec = /*code ec selectionné*/

/*Pour la suite du traitement*/
select code_sous_item
from sous_item
where sous_item.nom = /*nom item selectionné*/
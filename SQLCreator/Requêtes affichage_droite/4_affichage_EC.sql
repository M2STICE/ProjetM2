/*Pour l'affichage*/
select nom_ec
from item,ec
where item.code_item = /*code de l'item sélectionné*/
and item.code_item = ec_item.code_item
and ec.code_ec = ec_item.code_ec;

/*Pour la suite du traitement*/
select code_ec
from ec 
where ec.nom_ec = /*nom ec sélectionné*/
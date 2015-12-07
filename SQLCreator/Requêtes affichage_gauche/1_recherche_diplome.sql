/*Pour l'affichage*/

select nom_diplome
from diplome
where nom_diplome like upper("%nom_variable%")
group by nom_diplome;

/*Pour la suite du traitement */
select code_diplome
from diplome
where nom_diplome = /*diplome choisi*/
group by nom_diplome;
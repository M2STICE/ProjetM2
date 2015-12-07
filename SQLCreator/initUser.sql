/*Creation d'un utilisateur*/
/*Attention la base en ligne à pour user = u960093295_m2 et mot_de_passe = pm2_2015*/
create user 'M2STICE'@'%' identified by 'pm2_2015';

/*Attribution de privilège pour la table diplome*/
grant select,update,delete,insert on M2STICE.diplome to 'M2STICE';

/*Attribution de privilège pour la table domaine*/
grant select,update,delete,insert on M2STICE.domaine to 'M2STICE';

/*Attribution de privilège pour la table intervenant*/
grant select,update,delete,insert on M2STICE.intervenant to 'M2STICE';

/*Attribution de privilège pour la table annee*/
grant select,update,delete,insert on M2STICE.annee to 'M2STICE';

/*Attribution de privilège pour la table diplome_annee*/
grant select,update,delete,insert on M2STICE.diplome_annee to 'M2STICE';

/*Attribution de privilège pour la table semestre*/
grant select,update,delete,insert on M2STICE.semestre to 'M2STICE';

/*Attribution de privilège pour la table ue*/
grant select,update,delete,insert on M2STICE.ue to 'M2STICE';

/*Attribution de privilège pour la table ec*/
grant select,update,delete,insert on M2STICE.ec to 'M2STICE';

/*Attribution de privilège pour la table competence*/
grant select,update,delete,insert on M2STICE.competence to 'M2STICE';

/*Attribution de privilège pour la table etudiant*/
grant select,update,delete,insert on M2STICE.etudiant to 'M2STICE';

/*Attribution de privilège pour la table intervenant*/
grant select,update,delete,insert on M2STICE.intervenant_ec to 'M2STICE';

/*Attribution de privilège pour la table etudiant_diplome*/
grant select,update,delete,insert on M2STICE.etudiant_diplome to 'M2STICE';

/*Attribution de privilège pour la table item*/
grant select,update,delete,insert on M2STICE.item to 'M2STICE';

/*Attribution de privilège pour la table sous_item*/
grant select,update,delete,insert on M2STICE.sous_item to 'M2STICE';

/*Attribution de privilège pour la table evaluation*/
grant select,update,delete,insert on M2STICE.evaluation to 'M2STICE';

/*Attribution de privilège pour la table etudiant_evaluation*/
grant select,update,delete,insert on M2STICE.etudiant_evaluation to 'M2STICE';

/*Attribution de privilège pour la table ec_sous_item*/
grant select,update,delete,insert on M2STICE.ec_sous_item to 'M2STICE';

/*Attribution de privilège pour la table promotion*/
grant select,update,delete,insert on M2STICE.promotion to 'M2STICE';

/*Attribution de privilège pour la table etudiant_promotion*/
grant select,update,delete,insert on M2STICE.etudiant_promotion to 'M2STICE';

/*Attribution de privilège pour la table ec_item*/
grant select,update,delete,insert on M2STICE.ec_item to 'M2STICE';







--Creation d'un utilisateur
create user 'M2STICE'@'%' identified by 'pm2_2015';

--Attribution de privilège pour la table diplome
grant select,
update,delete,insert on M2STICE.diplome to 'M2STICE';
--Creation d'un utilisateur
create user 'M2STICE'@'%' identified by 'pm2_2015';

--Attribution de privil�ge pour la table diplome
grant select,
update,delete,insert on M2STICE.diplome to 'M2STICE';
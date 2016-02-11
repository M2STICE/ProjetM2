#ProjetM2

 - Pour créer la base de données il faut exécuter les fichiers SQL de création de la base qui se trouve dans le répertoire SQLCreator.

 - Pour remplir le base de données il faut exécuter la méthode main de la classe "Lire_XML", celle-ci va chercher les informations dans le diagramme freeplane qui est en fait un fichier XML et les insérer dans la base de données.

/!\ Attention: Pour configurer l'accès à la base de données aller voir le fichier "config.db" qui se trouve dans le répertoire suivant:
	res/
	
 - Pour executer l'application il faut  lancer les méthodes init() et start() de la classe "Interface" c'est une applet qui se trouve dans le package suivant:
 	com.m2stice.graphics
 
(!) Notez bien: L'application va chercher les coordondées de la base dans le fichier "config.db" si velui-ci a été éffacé le système va vous proposer une interface graphique pour saisir ces informations afin de regénérer un fichier "config.db".
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

/*
une classe pour le gestion de la souris et des touches
une classe pour l'affichage des menus 

Une classe pour la gestion ds "objets graphiques" - FunGraphics

Une classe pour l'exécution du jeu

Gestion un ou deux joueurs

1. Lancement - Init
2. Ecran d'accueil - paramètres, choix du mode (1 ou 2 joueur) / classement
3. Séléction avec la sourie du mode / paramètre
4. Jeu (avec bord physique serpent - se tue tout seul (touche la queue) - serpent touche un bord) -  
    layout - Rectangle, taille à définir (paramètre prog) - taille d'un pixel du serpent => taille du tableau qui 
    représente le terrain de jeu
    Score = nombre de pommes mangées - affiché dans le jeu
5. Fin du jeu - Perdu = mort, écran de mort - possibilité enregistrement du score AVEC 3 lettres si 5 top scores 
                                                        - retour menu principal après enregistrement.
                

Variables :
            Durant le jeu
            - int score (de la partie en cours)
            - int longueur_snake
            -  
            
            Variables pour les touches
            - int up1
            - int up2
            - int down1
            - int down2
            - int right1
            - int right2
            - int left1
            - int left2
    
*/
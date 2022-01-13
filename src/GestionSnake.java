import hevs.utils.Input;
import java.util.Random;


/*
Notre snake est représenté par plusieurs carré de 5x5 pixel
*/

public class GestionSnake {
    public static void main(String[] args) {
        int longueur = 4;
        int headX = 3;
        int headY = 1;
        int[][] game = new int[10][10];
        Random rand = new Random();

        // initialisation du tableau avec que des 0
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                game[i][j] = 0;
            }
        }
        for (int i = 0; i < game.length; i++) {
            game[i][0] = -2;
            game[i][game.length - 1] = -2;
        }

        for (int i = 0; i < game[0].length; i++) {
            game[0][i] = -2;
            game[game[0].length - 1][i] = -2;
        }

        // Initialisation du snake de début
        for (int i = 1; i < longueur; i++) {
            game[1][i] = longueur - i;
        }


        // affichage de la situation de départ
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
        char dir='d';
        boolean pomme=false;
        int pommeY=1;
        int pommeX=7;


        while (true) {

           pomme=false;


            // lecture de la direction
            System.out.println("Entrez la prohaine direction:");
            
            char dirPrev = dir;
             dir = Input.readChar();
            // Déplacememnt de la tete
            if((dirPrev=='s' && dir=='w')||(dirPrev=='w' && dir=='s')||(dirPrev=='a' && dir=='d')||(dirPrev=='d' && dir=='a')){
                dir=dirPrev;
            }

            switch (dir) {
                case 'w':
                    headY--;
                    break;
                case 'a':
                    headX--;
                    break;
                case 's':
                    headY++;
                    break;
                case 'd':
                    headX++;
                    break;
                default:
                    break;
            }
            
            // Gestion de la case qui vient
            if (game[headY][headX] == -1) {
                longueur++;
                game[headY][headX] = 0;
            }
            if (game[headY][headX] == -2 ){
                System.out.println("YOU LOSE");
                break;
            }
            if (game[headY][headX] > 0 ){
                System.out.println("YOU LOSE");
                break;
            }


            // gestion du mouvement du snake
            for (int i = 1; i < game.length-1; i++) {
                for (int j = 1; j < game[0].length-1; j++) {
                    if (game[i][j] > 0) {
                        game[i][j] += 1;
                    }
                }
            }

            game[headY][headX] = 1;

            for (int i = 1; i < game.length - 1; i++) {
                for (int j = 1; j < game[0].length - 1; j++) {
                    if (game[i][j] > longueur) {
                        game[i][j] = 0;
                    }
                }
            }

             // Gestion des pommes
                //Est-ce qu'il reste une pomme sur l'écran
               
                for (int i = 0; i < game.length; i++) {
                    for (int j = 0; j < game[0].length; j++) {
                        if(game[i][j]==-1)
                        pomme=true;}
                    }
                //Placer une pomme de manière aléatoire
                do{
                    pommeY=rand.nextInt(game.length-2)+1;
                    pommeX=rand.nextInt(game[0].length-2)+1;
                      
                }while(game[pommeY][pommeX]!=0);
                if (!pomme)
                {game[pommeY][pommeX]=-1;}


            for (int i = 0; i < game.length ; i++) {
                for (int j = 0; j < game[0].length ; j++) {
                    System.out.print(game[i][j] + " ");
                }
                System.out.println();
            }
        }

    }
}

import hevs.utils.Input;

/*
Notre snake est représenté par plusieurs carré de 5x5 pixel
*/

public class GestionSnake {
    public static void main(String[] args) {
        int longueur = 4;
        int headX = 3;
        int headY = 1;
        int[][] game = new int[10][10];

        // initialisation du tableau avec que des 0
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                game[i][j] = 0;
            }
        }
        for (int i = 0; i < game.length; i++) {
            game[i][0] = 9;
            game[i][game.length - 1] = 9;
        }

        for (int i = 0; i < game[0].length; i++) {
            game[0][i] = 9;
            game[game[0].length - 1][i] = 9;
        }

        // Initialisation du snake de début
        for (int i = 1; i < longueur; i++) {
            game[1][i] = longueur - i;
        }

        game[1][7] = -1;

        // affichage de la situation de départ
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }

        while (true) {
            // lecture de la direction
            System.out.println("Entrez la prohaine direction:");
            char dir = Input.readChar();
            // Déplacememnt de la tete
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
            if (((headY == (game.length - 1)) || (headX == (game[0].length - 1))) || ((headY == 0) || (headX == 0))) {
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

            for (int i = 0; i < game.length ; i++) {
                for (int j = 0; j < game[0].length ; j++) {
                    System.out.print(game[i][j] + " ");
                }
                System.out.println();
            }
        }

    }
}

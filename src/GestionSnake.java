import hevs.graphics.FunGraphics;
import hevs.utils.Input;

import java.awt.Color;
import java.util.Random;

/*
Notre snake est représenté par plusieurs carré de 5x5 pixel
*/

public class GestionSnake {
    private int game[][];
    int longueur;
    int headX;
    int headY;
    boolean endGame = false;
    enum direction {UP, DOWN, LEFT, RIGHT};


    public GestionSnake(int height, int width, int initialLength, int headX, int headY) {
        game = new int[height][width];
        longueur = initialLength;
        this.headX = headX;
        this.headY = headY;
        direction foo = direction.UP;

        if (checkValue(this.headX, this.headY)) {
            // initialisation du tableau avec que des 0
            for (int i = 0; i < game.length; i++) {
                for (int j = 0; j < game[0].length; j++) {
                    game[i][j] = 0;
                }
            }
            // Initialisation des bordures à -2
            for (int i = 0; i < game.length; i++) {
                game[i][0] = -2;
                game[i][game.length - 1] = -2;
            }

            for (int i = 0; i < game[0].length; i++) {
                game[0][i] = -2;
                game[game[0].length - 1][i] = -2;
            }
            // Initialisation du snake de début
            for (int i = headX - longueur; i < headX; i++) {
                game[headY][i + 1] = headX - i;
            }
        }
    }

    public boolean checkValue(int x, int y) {
        // Vérification que les valeurs choisies sont corrects
        if (y < 1 || y > game.length - 1) {
            System.out.println("This is not the right value for headY");
            return false;
        }
        if (x - (longueur - 1) < 1 || x > game[0].length - 1) {
            System.out.println("This is not the right value for headX");
            return false;
        }
        return true;
    }

    public int[] coordPomme(int[][] game) {
        int[] temp = new int[2];
        Random rand = new Random();
        temp[0] = rand.nextInt(game.length - 2) + 1;
        temp[1] = rand.nextInt(game[0].length - 2) + 1;
        return temp;
    }

    public void gestionPomme() {
        int[] temp = new int[2];
        boolean pomme = false;

        // Est-ce qu'il reste une pomme sur l'écran
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                if (game[i][j] == -1) {
                    pomme = true;
                }
            }
        }
        // Placer une pomme de manière aléatoire
        if (pomme == false) {
            do {
                temp = coordPomme(game);
            } while (game[temp[0]][temp[1]] != 0);
            game[temp[0]][temp[1]] = -1;
        }

    }

    public void deplacementSnake(char direction) {
        switch (direction) {
            case 'w':
                this.headY--;
                break;
            case 'a':
                this.headX--;
                break;
            case 's':
                this.headY++;
                break;
            case 'd':
                this.headX++;
                break;
            default:
                break;
        }
        // Gestion de la case qui vient
        if (this.game[this.headY][this.headX] == -1) {
            longueur++;
            this.game[headY][headX] = 0;
        }
        if (this.game[this.headY][this.headX] == -2) {
            System.out.println("YOU LOSE");
            endGame = true;
        }
        if (this.game[this.headY][this.headX] > 0) {
            System.out.println("YOU LOSE");
            endGame = true;
        }

        // gestion du mouvement du snake
        for (int i = 1; i < this.game.length - 1; i++) {
            for (int j = 1; j < this.game[0].length - 1; j++) {
                if (this.game[i][j] > 0) {
                    this.game[i][j] += 1;

                }
            }
        }

        this.game[headY][headX] = 1;

        for (int i = 1; i < this.game.length - 1; i++) {
            for (int j = 1; j < this.game[0].length - 1; j++) {
                if (this.game[i][j] > longueur) {
                    this.game[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
         * int longueur = 4;
         * int headX = 8;
         * int headY = 1;
         * int[][] game = new int[10][10];
         * Random rand = new Random();
         */
        FunGraphics a = new FunGraphics(100, 100);
        a.setColor(Color.BLACK);
        GestionSnake s = new GestionSnake(20, 20, 4, 4, 1);
        char dir;
        for (int i = 0; i < s.game.length; i++) {
            for (int j = 0; j < s.game[0].length; j++) {
                System.out.print(s.game[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < s.game.length; i++) {
            for (int j = 0; j < s.game[0].length; j++) {
                if (s.game[i][j] == -2) {
                    a.drawFillRect(j*5, i*5, 5, 5);
                }
            }
        }

        while (!s.endGame) {
            System.out.println("Entrez la prohaine direction:");
            dir = Input.readChar();
            s.deplacementSnake(dir);
            s.gestionPomme();
            // s.game[s.gestionPomme(s.game)[0]][s.gestionPomme(s.game)[1]] = -1;

            for (int i = 0; i < s.game.length; i++) {
                for (int j = 0; j < s.game[0].length; j++) {
                    System.out.print(s.game[i][j] + " ");
                }
                System.out.println();
            }
            a.clear();
            for (int i = 0; i < s.game.length; i++) {
                for (int j = 0; j < s.game[0].length; j++) {
                    if (s.game[i][j] == -2 || s.game[i][j] > 0 || s.game[i][j] == -1) {
                        a.drawFillRect(j*5, i*5, 5, 5);
                    }
                }
            }
        }

        // initialisation du tableau avec que des 0
        /*
         * for (int i = 0; i < game.length; i++) {
         * for (int j = 0; j < game[0].length; j++) {
         * game[i][j] = 0;
         * }
         * }
         * for (int i = 0; i < game.length; i++) {
         * game[i][0] = -2;
         * game[i][game.length - 1] = -2;
         * }
         * 
         * for (int i = 0; i < game[0].length; i++) {
         * game[0][i] = -2;
         * game[game[0].length - 1][i] = -2;
         * }
         * 
         * // Initialisation du snake de début
         * 
         * for (int i = 1; i < longueur + 1; i++) {
         * game[1][i] = longueur - i + 1;
         * }
         * 
         * for (int i = headX - longueur; i <= headX; i++) {
         * game[headY][i] = headX - i+1;
         * }
         * 
         * // affichage de la situation de départ
         * for (int i = 0; i < game.length; i++) {
         * for (int j = 0; j < game[0].length; j++) {
         * System.out.print(game[i][j] + " ");
         * }
         * System.out.println();
         * }
         * char dir = 'd';
         * boolean pomme = false;
         * int pommeY = 1;
         * int pommeX = 7;
         * 
         * while (true) {
         * 
         * pomme = false;
         * 
         * // lecture de la direction
         * System.out.println("Entrez la prohaine direction:");
         * 
         * char dirPrev = dir;
         * dir = Input.readChar();
         * // Déplacememnt de la tete
         * if ((dirPrev == 's' && dir == 'w') || (dirPrev == 'w' && dir == 's') ||
         * (dirPrev == 'a' && dir == 'd')
         * || (dirPrev == 'd' && dir == 'a')) {
         * dir = dirPrev;
         * }
         * 
         * switch (dir) {
         * case 'w':
         * headY--;
         * break;
         * case 'a':
         * headX--;
         * break;
         * case 's':
         * headY++;
         * break;
         * case 'd':
         * headX++;
         * break;
         * default:
         * break;
         * }
         * 
         * // Gestion de la case qui vient
         * if (game[headY][headX] == -1) {
         * longueur++;
         * game[headY][headX] = 0;
         * }
         * if (game[headY][headX] == -2) {
         * System.out.println("YOU LOSE");
         * break;
         * }
         * if (game[headY][headX] > 0) {
         * System.out.println("YOU LOSE");
         * break;
         * }
         * 
         * // gestion du mouvement du snake
         * for (int i = 1; i < game.length - 1; i++) {
         * for (int j = 1; j < game[0].length - 1; j++) {
         * if (game[i][j] > 0) {
         * game[i][j] += 1;
         * }
         * }
         * }
         * 
         * game[headY][headX] = 1;
         * 
         * for (int i = 1; i < game.length - 1; i++) {
         * for (int j = 1; j < game[0].length - 1; j++) {
         * if (game[i][j] > longueur) {
         * game[i][j] = 0;
         * }
         * }
         * }
         * 
         * // Gestion des pommes
         * // Est-ce qu'il reste une pomme sur l'écran
         * 
         * for (int i = 0; i < game.length; i++) {
         * for (int j = 0; j < game[0].length; j++) {
         * if (game[i][j] == -1)
         * pomme = true;
         * }
         * }
         * // Placer une pomme de manière aléatoire
         * do {
         * pommeY = rand.nextInt(game.length - 2) + 1;
         * pommeX = rand.nextInt(game[0].length - 2) + 1;
         * 
         * } while (game[pommeY][pommeX] != 0);
         * if (!pomme) {
         * game[pommeY][pommeX] = -1;
         * }
         */

    }

}

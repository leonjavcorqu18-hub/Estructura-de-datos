public class ElJuegoDeLaVida {
    
    public static void main(String[] args) {
        JuegoVida game = new JuegoVida(20, 20);   
        //establecí algunas células como vivas para ver cómo se desarrollan, estas pueden ser modificadas para ver diferentes formaciones.
        game.setCell(2, 2, true);
        game.setCell(3, 2, true);
        game.setCell(4, 2, true);
        game.setCell(4, 3, true);
        game.setCell(4, 4, true);
        game.setCell(10, 2, true);
        game.setCell(11, 2, true);
        game.setCell(12, 2, true);
        game.setCell(12, 3, true);
        game.setCell(12, 4, true);
        game.setCell(2, 2, true);
        game.setCell(2, 15, true);
        game.setCell(3, 15, true);
        game.setCell(4, 15, true);
        game.setCell(3, 14, true);
        game.setCell(10, 17, true);
        game.setCell(11, 18, true);
        game.setCell(12, 17, true);
        game.setCell(12, 16, true);
        game.setCell(12, 5, true);
        game.setCell(6, 6, true);
        game.setCell(6, 7, true);
        game.setCell(7, 6, true);
        game.setCell(7, 8, true);
        game.setCell(17, 11, true);
        game.setCell(16, 11, true);
        game.setCell(17, 13, true);
        game.setCell(10, 17, true);
        game.setCell(9, 17, true);
        game.setCell(10, 19, true);
        game.setCell(10, 10, true);
        game.setCell(9, 11, true);
        game.setCell(10, 9, true);
        game.setCell(11, 9, true);
        game.setCell(13, 9, true);
        game.setCell(12, 8, true);
   
        System.out.println("J U E G O  D E  L A  V I D A");
        System.out.println("=====================================\n");
        System.out.println("Estado inicial:");
        game.printGrid();      
        for (int gen = 1; gen <= 10; gen++) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            game.nextGeneration();
            System.out.println("Generación " + gen + ":");
            game.printGrid();
            if (game.isEmpty()) {
                System.out.println(" Todas las células murieron");
                break;
            }
        }    
        System.out.println("        F I N  D E L  J U E G O.");
        System.out.println("=====================================\n");
    }
}
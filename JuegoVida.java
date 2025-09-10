public class JuegoVida {
    private boolean[][] grid;
    private int rows;
    private int cols;
    
    public JuegoVida(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new boolean[rows][cols];
    }
    private int contarVecinosV(int row, int col) {
        int count = 0;        
        // vemos los vecinos que rodean la célula
        // (-1,-1) (-1,0) (-1,1)
        // (0,-1)  celula   (0,1)
        // (1,-1)  (1,0)  (1,1)     
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }            
                int filaVecinos = row + i;
                int columnaVecinos = col + j;
                if (posicionValida(filaVecinos, columnaVecinos)) {
                    if (grid[filaVecinos][columnaVecinos]) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    private boolean posicionValida(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
    public boolean celulaVive(int row, int col) {
        if (!posicionValida(row, col)) {
            return false;
        }    
        boolean vivos = grid[row][col];
        int vecinosVivos = contarVecinosV(row, col);      
        if (vivos) {
            if (vecinosVivos < 2) {
                //la célula muere por soledad
                return false;
            } else if (vecinosVivos == 2 || vecinosVivos == 3) {
                //la célula vive
                return true;
            } else {
                //la célula está sobrepoblada (muere)
                return false;
            }
        } else {
            if (vecinosVivos == 3) {
                //la célula pasa a estar activa
                return true;
            } else {
                return false;
            }
        }
    }
    
    // esta parte fue la que menos entendí y si busqué ayuda y lo copié de otros códigos.

    public void nextGeneration() {
        // Creamos un nuevo grid para la siguiente generación
        boolean[][] nextGrid = new boolean[rows][cols];
        
        // Evaluamos cada célula y determinamos su estado futuro
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nextGrid[i][j] = celulaVive(i, j);
            }
        }
        
        // Reemplazamos el grid actual con el nuevo grid
        this.grid = nextGrid;
    }
    /**
     * Evoluciona el grid múltiples generaciones
     * @param generations número de generaciones a evolucionar
     */
    public void evolve(int generations) {
        for (int gen = 0; gen < generations; gen++) {
            nextGeneration();
        }
    } 
    /**
     * Limpia el grid (todas las células muertas)
     */
    public void clear() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = false;
            }
        }
    } 
    /**
     * Cuenta el total de células vivas en el grid
     * @return número de células vivas
     */
    public int contarCelulasV() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]) {
                    count++;
                }
            }
        }
        return count;
    } 
    /**
     * Verifica si el grid está vacío (sin células vivas)
     * @return true si no hay células vivas
     */
    public boolean isEmpty() {
        return contarCelulasV() == 0;
    }  
    /**
     * Crea una copia del grid actual
     * @return copia del grid
     */
    public boolean[][] getGridCopy() {
        boolean[][] copy = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }   
    /**
     * Compara si dos grids son iguales (útil para detectar estados estables)
     * @param otherGrid grid a comparar
     * @return true si son iguales
     */
    public boolean isEqual(boolean[][] otherGrid) {
        if (otherGrid.length != rows || otherGrid[0].length != cols) {
            return false;
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != otherGrid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }  
    /**
     * Método para establecer el estado de una célula (útil para testing)
     */
    public void setCell(int row, int col, boolean alive) {
        if (posicionValida(row, col)) {
            grid[row][col] = alive;
        }
    }    
    /**
     * Método para obtener el estado de una célula (útil para testing)
     */
    public boolean getCell(int row, int col) {
        if (posicionValida(row, col)) {
            return grid[row][col];
        }
        return false;
    }    
    /**
     * Método para imprimir el grid (útil para debugging)
     */
    public void printGrid() {
        System.out.println("Células vivas: " + contarCelulasV());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] ? "█ " : "· ");
            }
            System.out.println();
        }
        System.out.println();
    }
    // Getters útiles
    public int getRows() { return rows; }
    public int getCols() { return cols; }
}
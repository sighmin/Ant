/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmicModel;

/**
 *
 * @author stuart
 */
public class AntAlgorithm {

    private Grid grid;
    private Ant[] ants;
    private Item[] items;

    AntAlgorithm(int gridSize, int numItems, int numAnts) {
        grid = new Grid(gridSize);
        ants = new Ant[numAnts];
        for (int i = 0; i < numAnts; ++i)
            ants[i] = new Ant(grid);
        items = new Item[numItems];
        for (int i = 0; i < numItems; ++i)
            items[i] = new Item(grid);
        placeAnts(numAnts);
        placeItems(numItems);
    }

    public void placeAnts(int numAnts) throws NullPointerException {
        for (int i = 0; i < numAnts; i++) {
            int xCoord = (int) (Math.random() * grid.getGridSize());
            int yCoord = (int) (Math.random() * grid.getGridSize());
            if (grid.getObjectType(xCoord, yCoord).equals("E")) {
                grid.getGrid()[xCoord][yCoord] = ants[i];
                ants[i].setLocationX(xCoord);
                ants[i].setLocationY(yCoord);
            } else {
                i--;
            }
        }
    }

    public void placeItems(int numItems) throws NullPointerException {
        for (int i = 0; i < numItems; i++) {
            int xCoord = (int) (Math.random() * grid.getGridSize());
            int yCoord = (int) (Math.random() * grid.getGridSize());
            if (grid.getObjectType(xCoord, yCoord).equals("E")) {
                grid.getGrid()[xCoord][yCoord] = items[i];
                items[i].setLocationX(xCoord);
                items[i].setLocationY(yCoord);
            } else {
                i--;
            }
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    
    public void run(int iterations) {
        grid.printGrid();
        
        // for each iteration
        for (int i = 0; i < iterations; ++i){
            // print grid at some resolution
            if (i % 1 == 0){
                grid.printGrid();
                System.out.println();
            }
            // for each ant
            for (int j = 0; j < ants.length; ++j){
                // get valid move position
                int[] pos = ants[j].getValidMove();
                 
                // if ant is unladen and the site is occupied by item Ya
                if (!ants[j].gotItem){
                    // compute gamma(Ya) using equation 17.45
                    // compute Pp(Ya) using equation 17.46

                    // if U(0,1) <= Pp(Ya) then pickup item Ya
                    if (true){
                        ants[j].pickup();
                    }
                // ant carries item Ya and site is empty
                } else if (ants[j].gotItem) {
                    // compute gamma(Ya) using equation 17.45
                    // compute Pd(Ya) using equation 17.47

                    // if U(0,1) <= Pd(Ya) then drop item Ya
                    if (true) {
                        ants[j].drop();
                    }
                }
                ants[j].move(pos);
            }
        }
        
        grid.printGrid();
    }
}

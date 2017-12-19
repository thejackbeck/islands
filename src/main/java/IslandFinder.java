import java.util.*;

/**
 * Application that finds all of the 'islands' in a two dimensional array.
 * In the following array, the 'islands' are all of the groups of x that
 * are adjacent either vertically, horizontally, or diagonally.
 *
 *  0,0,0,0,0,X,X,0,X
 *  X,0,X,0,0,X,0,0,X
 *  X,0,X,0,0,0,0,0,X
 *  0,X,0,0,X,X,X,0,X
 *  0,X,0,0,X,0,X,0,0
 *  0,0,0,0,X,X,X,0,0
 *
 *  There are four islands in this array.
 */
public class IslandFinder {
    /**
     * Takes a set of islets and returns a map where each entry is a contiguous island.
     *
     * @param islets
     * @return MAP of islands
     */
    public Map<Integer, Set<Islet>> findIslands(Set<Islet> islets) {
        int islandCount = 0;
        Map<Integer, Set<Islet>> islandMap = new HashMap<>();

        //Iterate through all of the islets
        for (Islet islet: islets) {
            //Ignore those that are already part of an island
            if(!islet.isInIsland()) {
                Set<Islet> island = new HashSet<>();
                addIsletToIsland(islet, island);

                islandMap.put(islandCount,findAdjacentIslets(islets, islet));
                islandCount++;
            }
        }
        return islandMap;
    }

    /**
     * Recursively called method that finds all islets transitively adjacent to the one under consideration.
     *
     * @param islets - A structure containing all islets
     * @param that - The islet under consideration
     * @return - A set of islets that are transitively adjacent to the one under consideration
     */
    protected Set<Islet> findAdjacentIslets(Set<Islet> islets, Islet that) {
        Set<Islet> adjacentIslets = new HashSet<>();
        adjacentIslets.add(that);

        //Find immediate neighbors
        for(Islet adjacentCandidate: islets) {
            if(!adjacentCandidate.isInIsland() && adjacentCandidate.isAdjacentTo(that)) {
                addIsletToIsland(adjacentCandidate, adjacentIslets);

                //Find next level adjacent
                adjacentIslets.addAll(findAdjacentIslets(islets, adjacentCandidate));
            }
        }

        return adjacentIslets;
    }

    /**
     * Simple helper method to keep me from forgetting to call setInIsland when an islet is added to an island.
     * @param islet
     * @param island
     */
    protected void addIsletToIsland(Islet islet, Set<Islet> island) {
        island.add(islet);
        islet.setInIsland(Boolean.TRUE);
    }
}
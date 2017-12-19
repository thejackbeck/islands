/**
 * This class represents an atomic bit of an island.
 */
public class Islet {
    private Integer x;
    private Integer y;
    private Boolean inIsland = false;

    public Islet(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    /**
     * This is a crude implementation of the quadradic formula.  Things that are adjacent have a distance that is less than 2.
     * Horizontal and vertical neighors have a distance of 1.  Diagonal neighbors have a distance of ~1.4
     * @param that - The islet that may or may not be adjacent to this one
     * @return Boolean - true if it is adjacent, false otherwise.
     */
    public Boolean isAdjacentTo(Islet that) {
        final double dist = Math.sqrt((that.getX()-this.getX())*(that.getX()-this.getX())
                +(that.getY()-this.getY())*(that.getY()-this.getY()));
        return dist<2;
    }

    public Boolean isInIsland() {
        return inIsland;
    }

    public void setInIsland(Boolean inIsland) {
        this.inIsland = inIsland;
    }

    @Override
    public String toString() {
        return "{x:" + x + ", y:" + y + "}";
    }
}

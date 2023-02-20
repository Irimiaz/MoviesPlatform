package input;


public class FilterInput {
    /**
     * returns what a filter contains
     * @return
     */
    public ContainsInput getContains() {
        return contains;
    }
    /**
     * returns sort conditions
     * @return
     */
    public SortInput getSort() {
        return sort;
    }

    private ContainsInput contains;
    private SortInput sort;
}

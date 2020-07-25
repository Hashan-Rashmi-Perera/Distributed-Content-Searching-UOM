package lk.uom.cse.fusion.distributedcontentsearchingnode.exceptions;

public class NoResultsFound extends RuntimeException {

    public NoResultsFound(){
        super(String.format("No Results Found"));
    }
}

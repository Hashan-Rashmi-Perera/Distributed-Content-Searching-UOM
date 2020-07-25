package lk.uom.cse.fusion.distributedcontentsearchingnode.exceptions;

public class InvalidInput extends RuntimeException {

    public InvalidInput(){
        super(String.format("Invalid Input"));
    }
}

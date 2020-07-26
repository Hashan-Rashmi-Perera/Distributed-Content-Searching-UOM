package lk.uom.cse.fusion.distributedcontentsearchingnode.handlers;

public interface TimeoutCallback {
    void onTimeout(String messageId);
    void onResponse(String messageId);
}

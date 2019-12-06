package com.SelfDefineCompleteFuture.listeners;

import com.SelfDefineCompleteFuture.future.IFuture;

public interface IFutureListener<V> {
    public void operationCompleted(IFuture<V> future) throws Exception;
}

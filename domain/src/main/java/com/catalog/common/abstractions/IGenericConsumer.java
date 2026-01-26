package com.catalog.common.abstractions;

public interface IGenericConsumer<TMessaege> {

    void startAsync(String topic);

}

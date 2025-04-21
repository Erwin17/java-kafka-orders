package com.app.stream.producer.event;

import java.util.Date;

public class Event<K, T> {

    public enum Type {
        CREATED,
        UPDATE,
        DELETE;
    }

    private final Type typeEvent;
    private final K key;
    private final T data;
    private final Date date;

    public Event(){
        this.typeEvent = null;
        this.key = null;
        this.data = null;
        this.date = null;
    }

    public Event(Type eventType, K key,  T data){
        this.typeEvent = eventType;
        this.key = key;
        this.data = data;
        this.date = new Date();
    }

    public Type getTypeEvent(){
        return typeEvent;
    }
    public T getData(){
        return data;
    }
    public Date getDate(){
        return date;
    }
}

package com.example.arabistic.util;

public class CallBack {
    public static void addCallback(com.example.arabistic.util.CallbackInterface callback){
        com.example.arabistic.util.CallbackInterface.callbacks.add(callback);
    }
    public static void runAllCallbacks(){
        for(com.example.arabistic.util.CallbackInterface c : com.example.arabistic.util.CallbackInterface.callbacks){
            c.call();
        }
    }
}
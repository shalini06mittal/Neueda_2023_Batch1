package com.demo.boot.SpringBootProject.basic02.output;

import com.demo.boot.SpringBootProject.basic02.providers.IMessageProvider;

public interface IMessageOutput {
    public void render();
    public IMessageProvider getiMessageProvider();
    public void setiMessageProvider(IMessageProvider iMessageProvider) ;
}

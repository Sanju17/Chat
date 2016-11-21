/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.features;

import com.leapfrog.chat.entity.Client;
import com.leapfrog.chat.entity.ClientHandler;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author cSangharsha
 */
public abstract class ChatFeatures {
    protected ClientHandler handler;
    public abstract List<Client> execute(Client client,String msg) throws IOException;

    public ClientHandler getHandler() {
        return handler;
    }

    public void setHandler(ClientHandler handler) {
        this.handler = handler;
    }
}
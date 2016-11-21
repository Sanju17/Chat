/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.features;

import com.leapfrog.chat.entity.Client;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author cSangharsha
 */
public class ListFeatures extends ChatFeatures {

    @Override
    public List<Client> execute(Client client, String msg) throws IOException {
        return handler.getClients();
    }
    
}

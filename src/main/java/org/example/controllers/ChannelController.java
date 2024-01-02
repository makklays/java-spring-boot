package org.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.http.HttpClient;

@Controller
public class ChannelController {

    @Autowired
    private HttpClient httpClient;

    /*@PostMapping("/channels/add")
    public void register(ChannelForm form) {
        validate(form);
        httpClient.send(riskRequest, responseHandler());
        addChannel(form);
        // etc..
    }*/
}


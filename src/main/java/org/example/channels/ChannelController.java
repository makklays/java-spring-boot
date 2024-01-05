package org.example.channels;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.http.HttpClient;

@RestController
public class ChannelController {

    @GetMapping("/")
    public String index() {
        return "Hello!";
    }

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


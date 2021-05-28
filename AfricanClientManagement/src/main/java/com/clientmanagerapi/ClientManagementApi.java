package com.clientmanagerapi;

/*
  @author Utkarsh Awasthi

 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.clientmanagerapi"})
public class ClientManagementApi {

    public static void main(String[] args) {
        SpringApplication.run(ClientManagementApi.class, args);
    }
}

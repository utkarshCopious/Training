package com.clientmanagerapi.service;

/*
  @author Utkarsh Awasthi

 */

import com.clientmanagerapi.model.Client;

import java.util.List;

public interface ClientserviceRepository {

    Client findById(long id);

    Client findByFirstName(String firstname);

    Client findByPhone(long phone);

    void saveClient(Client client);

    Client updateClient(long id, Client client);

    void deleteClientById(long id);

    List<Client> findAllClients();

    void deleteAllClients();

    boolean isClientExist(Client client);

}

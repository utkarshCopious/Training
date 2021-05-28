package com.clientmanagerapi.service;

/*
  @author Utkarsh Awasthi

 */

import com.clientmanagerapi.model.Client;
import com.clientmanagerapi.repository.ClientServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("ClientService")
public class ClientserviceRepositoryImpl implements ClientserviceRepository {

    @Autowired
    private ClientServiceRepo clientrepo;

    public List<Client> findAllClients() {
        List<Client> ClientList = clientrepo.findAll();

        if(ClientList.size() > 0) {
            return ClientList;
        } else {
            return new ArrayList<>();
        }
    }


    public Client findById(long id) {
       return clientrepo.findOne(id);
    }

    public Client findByFirstName(String firstname) {

        return clientrepo.findByFirstname(firstname);
    }

    public Client findByPhone(long phone) {
        return clientrepo.findByPhone(phone);
    }

    public void saveClient(Client client) {

        clientrepo.save(client);

    }
    public Client updateClient(long id, Client client) {
        Client clientdata = clientrepo.findOne(id);
        clientdata.setFName(client.getFName());
        clientdata.setLName(client.getLName());
        clientdata.setPhone(client.getPhone());
        clientdata.setAddress(client.getAddress());
        return clientrepo.save(clientdata);
    }

    public void deleteClientById(long id) {

       clientrepo.delete(id);
    }

    public boolean isClientExist(Client client) {
        return findByFirstName(client.getFName()) != null;
    }

    public void deleteAllClients() {
        clientrepo.deleteAll();
    }

}

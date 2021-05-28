package com.clientmanagerapi.controller;

/*
  @author Utkarsh Awasthi

 */

import com.clientmanagerapi.exceptions.ClientNotFoundException;
import com.clientmanagerapi.model.Client;
import com.clientmanagerapi.service.ClientserviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    public static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientserviceRepository clientServiceRepository;

    @RequestMapping(value = "/client/", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> listAllClients()  {
        List<Client> clients = clientServiceRepository.findAllClients();
        if ( clients.isEmpty() ) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }


    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getClientbyId(@PathVariable("id") long id) throws ClientNotFoundException {
        logger.info("Fetching Client with id {}", id);
        Client client = clientServiceRepository.findById(id);
        if ( client == null ) {
            logger.error("Client with id {} not found.", id);
            return new ResponseEntity(new ClientNotFoundException("Client with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/clientbyphone/{phone}", method = RequestMethod.GET)
    public ResponseEntity<?> getClientbyPhone(@PathVariable("phone") long phone) throws ClientNotFoundException{
        logger.info("Fetching Client with phone {}", phone);
        Client client = clientServiceRepository.findByPhone(phone);
        if ( client == null ) {
            logger.error("Client with phone {} not found.", phone);
            return new ResponseEntity(new ClientNotFoundException("Client with phone " + phone
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/clientbyname/{firstname}", method = RequestMethod.GET)
    public ResponseEntity<?> getClientbyFirstName(@PathVariable("firstname") String firstname) throws ClientNotFoundException {
        logger.info("Fetching Client with first named {}", firstname);
        Client client = clientServiceRepository.findByFirstName(firstname);
        if ( client == null ) {
            logger.error("Client with first name {} not found.", firstname);
            return new ResponseEntity(new ClientNotFoundException("Client with first " + firstname
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }


    @RequestMapping(value = "/Createclient/", method = RequestMethod.POST)
    public ResponseEntity<?> createClient(@RequestBody Client client, UriComponentsBuilder ucBuilder) throws ClientNotFoundException {
        logger.info("Creating Client : {}", client);

        if ( clientServiceRepository.isClientExist(client) ) {
            logger.error("Unable to create. A Client with name {} already exist", client.getFName());
            return new ResponseEntity(new ClientNotFoundException("Unable to create. A Client with name " +
                    client.getFName() + " already exist."), HttpStatus.CONFLICT);
        }
        clientServiceRepository.saveClient(client);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/Createclient/{id}").buildAndExpand(client.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateclient/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateClient(@PathVariable("id") long id, @RequestBody Client client) throws ClientNotFoundException {
        logger.info("Updating Client with id {}", id);

        Client currentClient = clientServiceRepository.findById(id);

        if ( currentClient == null ) {
            logger.error("Unable to update. Client with id {} not found.", id);
            return new ResponseEntity(new ClientNotFoundException("Unable to upate. Client with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        clientServiceRepository.updateClient(id, currentClient);
        return new ResponseEntity<>(currentClient, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteclient/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClient(@PathVariable("id") long id) throws ClientNotFoundException {
        logger.info("Fetching & Deleting Client with id {}", id);

        Client client = clientServiceRepository.findById(id);
        if ( client == null ) {
            logger.error("Unable to delete. Client with id {} not found.", id);
            return new ResponseEntity(new ClientNotFoundException("Unable to delete. Client with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        clientServiceRepository.deleteClientById(id);
        return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/deleteallclient/", method = RequestMethod.DELETE)
    public ResponseEntity<Client> deleteAllClients() {
        logger.info("Deleting All Clients");

        clientServiceRepository.deleteAllClients();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
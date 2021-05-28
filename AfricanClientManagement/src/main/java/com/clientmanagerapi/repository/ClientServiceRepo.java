package com.clientmanagerapi.repository;

/*
  @author Utkarsh Awasthi

 */

import com.clientmanagerapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientServiceRepo extends JpaRepository<Client, Long> {


     Client findByFirstname(String firstname);
     Client  findByPhone(long phone);

}
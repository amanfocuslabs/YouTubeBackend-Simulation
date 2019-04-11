package com.mpp.youtubesimulationbackend.dao;

import com.mpp.youtubesimulationbackend.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long>{
    //Account findByUsernameAndPassword(String username, String password);
}
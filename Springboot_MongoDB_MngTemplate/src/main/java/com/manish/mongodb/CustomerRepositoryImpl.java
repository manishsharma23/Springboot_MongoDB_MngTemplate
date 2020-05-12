package com.manish.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;

public class CustomerRepositoryImpl implements CustomerRepositoryCUSTM{

	 @Autowired
	 MongoTemplate mongoTemplate;
	@Override
	public int updateByFirstName(String firstName, int age) {
        Query query = new Query(Criteria.where("firstName").is(firstName));
        Update update = new Update();
        update.set("Age", age);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Customer.class);

        if(result!=null)
            return (int) result.getModifiedCount();
        else
            return 0;

    }
	
	
	
}

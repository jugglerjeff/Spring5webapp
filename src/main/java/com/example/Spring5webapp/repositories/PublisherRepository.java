package com.example.Spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.Spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}

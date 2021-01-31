package com.urlshtrn.app.dao;

import com.urlshtrn.app.entity.Url;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepo extends CrudRepository<Url,Long> {
    Url findByNewName(String name);
}

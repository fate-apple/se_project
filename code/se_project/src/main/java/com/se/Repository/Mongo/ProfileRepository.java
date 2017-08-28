package com.se.Repository.Mongo;

import com.se.Domain.Business.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, Long> {
}

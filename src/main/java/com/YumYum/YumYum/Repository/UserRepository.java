package com.YumYum.YumYum.Repository;

import com.YumYum.YumYum.Models.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>{
    Optional<User> findUserByEmail(String email);

}
//
//    List<User> findAll();
//}

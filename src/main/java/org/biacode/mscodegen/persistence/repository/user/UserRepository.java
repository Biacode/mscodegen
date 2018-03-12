package org.biacode.mscodegen.persistence.repository.user;

import org.biacode.mscodegen.service.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Arthur Asatryan.
 * Date: 3/12/18
 * Time: 4:27 PM
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUuid(final String uuid);
}

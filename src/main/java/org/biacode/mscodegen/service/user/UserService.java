package org.biacode.mscodegen.service.user;

import org.biacode.mscodegen.service.user.dto.CreateUserDto;
import org.biacode.mscodegen.service.user.dto.UpdateUserDto;
import org.biacode.mscodegen.service.user.model.User;

/**
 * Created by Arthur Asatryan.
 * Date: 3/12/18
 * Time: 4:02 PM
 */
public interface UserService {
    User create(final CreateUserDto dto);

    User update(final UpdateUserDto dto);

    User getByUuid(final String uuid);

    User markAsRemoved(final String uuid);
}

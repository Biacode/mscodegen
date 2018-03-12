package org.biacode.mscodegen.service.user.impl;

import org.biacode.mscodegen.persistence.repository.user.UserRepository;
import org.biacode.mscodegen.service.user.UserService;
import org.biacode.mscodegen.service.user.dto.CreateUserDto;
import org.biacode.mscodegen.service.user.dto.UpdateUserDto;
import org.biacode.mscodegen.service.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

/**
 * Created by Arthur Asatryan.
 * Date: 3/12/18
 * Time: 4:24 PM
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    //region Dependencies
    @Autowired
    private UserRepository userRepository;
    //endregion

    //region Constructors
    public UserServiceImpl() {
        LOGGER.debug("Initializing - {}", getClass().getCanonicalName());
    }
    //endregion

    //region Public methods
    @Override
    public User create(final CreateUserDto dto) {
        assertCreateUserDto(dto);
        return userRepository.save(buildUserFromCreateUserDto(dto));
    }

    @Override
    public User update(final UpdateUserDto dto) {
        return userRepository.save(buildUserFromUpdateUserDto(dto));
    }

    @Override
    public User getByUuid(final String uuid) {
        Assert.notNull(uuid, "The user uuid should not be null");
        return userRepository.findByUuid(uuid);
    }

    @Override
    public User markAsRemoved(final String uuid) {
        Assert.notNull(uuid, "The user uuid should not be null");
        final User user = getByUuid(uuid);
        user.setRemoved(LocalDateTime.now());
        return userRepository.save(user);
    }
    //endregion

    //region Utility methods
    private void assertCreateUserDto(final CreateUserDto dto) {
    }

    private User buildUserFromCreateUserDto(final CreateUserDto dto) {
        return new User();
    }

    private User buildUserFromUpdateUserDto(final UpdateUserDto dto) {
        final User user = getByUuid(dto.getUuid());
        return user;
    }
    //endregion
}

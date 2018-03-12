package ${project.base.package}.service.${class.package.name}.impl;

import ${project.base.package}.persistence.repository.${class.package.name}.${class.name}Repository;
import ${project.base.package}.service.${class.package.name}.${class.name}Service;
import ${project.base.package}.service.${class.package.name}.dto.Create${class.name}Dto;
import ${project.base.package}.service.${class.package.name}.dto.Update${class.name}Dto;
import ${project.base.package}.service.${class.package.name}.model.${class.name};
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
public class ${class.name}ServiceImpl implements ${class.name}Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(${class.name}ServiceImpl.class);

    //region Dependencies
    @Autowired
    private ${class.name}Repository ${class.package.name}Repository;
    //endregion

    //region Constructors
    public ${class.name}ServiceImpl() {
        LOGGER.debug("Initializing - {}", getClass().getCanonicalName());
    }
    //endregion

    //region Public methods
    @Override
    public ${class.name} create(final Create${class.name}Dto dto) {
        assertCreate${class.name}Dto(dto);
        return ${class.package.name}Repository.save(build${class.name}FromCreate${class.name}Dto(dto));
    }

    @Override
    public ${class.name} update(final Update${class.name}Dto dto) {
        return ${class.package.name}Repository.save(build${class.name}FromUpdate${class.name}Dto(dto));
    }

    @Override
    public ${class.name} getByUuid(final String uuid) {
        Assert.notNull(uuid, "The ${class.package.name} uuid should not be null");
        return ${class.package.name}Repository.findByUuid(uuid);
    }

    @Override
    public ${class.name} markAsRemoved(final String uuid) {
        Assert.notNull(uuid, "The ${class.package.name} uuid should not be null");
        final ${class.name} ${class.package.name} = getByUuid(uuid);
        ${class.package.name}.setRemoved(LocalDateTime.now());
        return ${class.package.name}Repository.save(${class.package.name});
    }
    //endregion

    //region Utility methods
    private void assertCreate${class.name}Dto(final Create${class.name}Dto dto) {
    }

    private ${class.name} build${class.name}FromCreateUserDto(final Create${class.name}Dto dto) {
        return new ${class.name}();
    }

    private ${class.name} build${class.name}FromUpdate${class.name}Dto(final Update${class.name}Dto dto) {
        final ${class.name} ${class.package.name} = getByUuid(dto.getUuid());
        return ${class.package.name};
    }
    //endregion
}
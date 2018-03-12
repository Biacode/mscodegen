package ${project.base.package}.service.${class.package.name};

import ${project.base.package}.service.${class.package.name}.dto.Create${class.name}Dto;
import ${project.base.package}.service.${class.package.name}.dto.Update${class.name}Dto;
import ${project.base.package}.service.${class.package.name}.model.${class.name};

/**
 * Created by ${user.first_name} ${user.last_name}.
 * Date: ${class.created.date}
 * Time: ${class.created.time} PM
 */
public interface ${class.name}Service {
    ${class.name} create(final Create${class.name}Dto dto);

    ${class.name} update(final Update${class.name}Dto dto);

    ${class.name} getByUuid(final String uuid);

    ${class.name} markAsRemoved(final String uuid);
}
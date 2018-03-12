package ${project.base.package}.persistence.repository.${class.package.name};

import ${project.base.package}.service.user.model.${class.name};
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ${user.first_name} ${user.last_name}.
 * Date: ${class.created.date}
 * Time: ${class.created.time} PM
 */
@Repository
public interface ${class.name}Repository extends CrudRepository<${class.name}, Long> {
    ${class.name} findByUuid(final String uuid);
}
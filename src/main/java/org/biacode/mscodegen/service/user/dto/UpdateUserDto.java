package org.biacode.mscodegen.service.user.dto;

/**
 * Created by Arthur Asatryan.
 * Date: 3/12/18
 * Time: 4:06 PM
 */
public class UpdateUserDto {

    //region Properties
    private String uuid;
    //endregion

    //region Constructors
    public UpdateUserDto() {
        // Default constructor
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }
    //endregion

}

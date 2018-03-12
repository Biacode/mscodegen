package org.biacode.mscodegen.service.user.model;

import java.time.LocalDateTime;

/**
 * Created by Arthur Asatryan.
 * Date: 3/12/18
 * Time: 4:03 PM
 */
public class User {

    //region Properties
    private LocalDateTime removed;
    //endregion

    //region Constructors
    public User() {
        // Default constructor
    }

    public User(final String uuid) {
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    public LocalDateTime getRemoved() {
        return removed;
    }

    public void setRemoved(final LocalDateTime removed) {
        this.removed = removed;
    }
    //endregion

}

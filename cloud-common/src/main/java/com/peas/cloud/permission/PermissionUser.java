package com.peas.cloud.permission;

import java.io.Serializable;
import java.util.Set;

//@MappedSuperclass
public interface PermissionUser extends Serializable {
    Set<String> permissions();
}

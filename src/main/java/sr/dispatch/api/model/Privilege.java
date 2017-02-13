package sr.dispatch.api.model;

import javax.persistence.*;
import java.util.Collection;

/*
 * @author catmosoerodjo
*/

@Entity
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Module module;
    private String component;
    private String description;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean deleted;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean canCreate = false;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean canRead = false;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean canUpdate = false;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean canDelete = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCanCreate() {
        return canCreate;
    }

    public void setCanCreate(boolean canCreate) {
        this.canCreate = canCreate;
    }

    public boolean isCanRead() {
        return canRead;
    }

    public void setCanRead(boolean canRead) {
        this.canRead = canRead;
    }

    public boolean isCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}

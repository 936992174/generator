package com.peas.cloud.bean;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.lang.annotation.Annotation;
import java.util.Date;


@MappedSuperclass
public class UUIDEntity implements Entity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Version
    @Column(name = "version")
    private Integer version;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time", updatable = false)
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime;

    protected UUIDEntity() {
        super();
    }

    public UUIDEntity(String name) {
        super();
    }

    @PrePersist
    protected void prePersist() {
        if (createTime == null) {
            createTime = new Date();
        }
        if (version == null) {
            version = 1;
        }
        updateTime = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        updateTime = new Date();
    }

    @PostUpdate
    protected void postUpdate(){
        afterUpdate();
    }

    /**
     * 更新操作事务提交之后触发
     * 子类根据需求自己实现
     */
    protected void afterUpdate(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * (Optional) The entity name. Defaults to the unqualified
     * name of the entity class. This name is used to refer to the
     * entity in queries. The name must not be a reserved literal
     * in the Java Persistence query language.
     */
    @Override
    public String name() {
        return null;
    }

    /**
     * Returns the annotation type of this annotation.
     *
     * @return the annotation type of this annotation
     */
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}

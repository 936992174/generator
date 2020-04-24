package com.tor.project.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "task_cron_job")
public class TaskCronJob {
    /**
     * 任务ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * cron执行表达式
     */
    private String cron;

    /**
     * Job名称
     */
    @Column(name = "job_name")
    private String jobName;

    /**
     * Job相关的类全名
     */
    @Column(name = "job_class_name")
    private String jobClassName;

    /**
     * Job描述
     */
    @Column(name = "job_desc")
    private String jobDesc;

    /**
     * Job编号
     */
    @Column(name = "job_number")
    private String jobNumber;

    /**
     * Job是否启用
     */
    private Boolean enabled;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 获取任务ID
     *
     * @return id - 任务ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置任务ID
     *
     * @param id 任务ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取cron执行表达式
     *
     * @return cron - cron执行表达式
     */
    public String getCron() {
        return cron;
    }

    /**
     * 设置cron执行表达式
     *
     * @param cron cron执行表达式
     */
    public void setCron(String cron) {
        this.cron = cron;
    }

    /**
     * 获取Job名称
     *
     * @return job_name - Job名称
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置Job名称
     *
     * @param jobName Job名称
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 获取Job相关的类全名
     *
     * @return job_class_name - Job相关的类全名
     */
    public String getJobClassName() {
        return jobClassName;
    }

    /**
     * 设置Job相关的类全名
     *
     * @param jobClassName Job相关的类全名
     */
    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    /**
     * 获取Job描述
     *
     * @return job_desc - Job描述
     */
    public String getJobDesc() {
        return jobDesc;
    }

    /**
     * 设置Job描述
     *
     * @param jobDesc Job描述
     */
    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    /**
     * 获取Job编号
     *
     * @return job_number - Job编号
     */
    public String getJobNumber() {
        return jobNumber;
    }

    /**
     * 设置Job编号
     *
     * @param jobNumber Job编号
     */
    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    /**
     * 获取Job是否启用
     *
     * @return enabled - Job是否启用
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 设置Job是否启用
     *
     * @param enabled Job是否启用
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注信息
     *
     * @return remark - 备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息
     *
     * @param remark 备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
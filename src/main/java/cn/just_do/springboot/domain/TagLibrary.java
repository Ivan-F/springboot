package cn.just_do.springboot.domain;

import java.util.Date;

public class TagLibrary {

	private Integer id;
	private String name;
	private String description;
	private Integer sort;
	private Integer userId;
	private Date CreateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	@Override
	public String toString() {
		return "TagLibrary [id=" + id + ", name=" + name + ", description=" + description + ", sort=" + sort
				+ ", userId=" + userId + ", CreateDate=" + CreateDate + "]";
	}
}

package com.ppxia.billing.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreeNode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String text;//树节点名称
	private String iconCls;//图标
	private Boolean checked=false;//是否选中
	private Map<String,	Object> attributes;//其他参数
	private List<TreeNode> children=new ArrayList<TreeNode>();//子节点
	private String state="close";//是否选中
	private String num;
	
	public TreeNode() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String string) {
		this.num = string;
	}

	@Override
	public String toString() {
		return "TreeNode [id=" + id + ", text=" + text + ", iconCls=" + iconCls + ", checked=" + checked
				+ ", attributes=" + attributes + ", children=" + children + ", state=" + state + ", num=" + num + "]";
	}


	
	
	
	
}

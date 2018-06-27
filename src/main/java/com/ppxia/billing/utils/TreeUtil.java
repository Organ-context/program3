package com.ppxia.billing.utils;


import java.util.ArrayList;
import java.util.List;

import com.ppxia.billing.beans.AuthorityBean;
import com.ppxia.billing.beans.TreeNode;

public class TreeUtil {
    public static List<TreeNode> tree(List<TreeNode> nodes) {
        //递归转化为树形
         List<TreeNode> tree=new ArrayList<TreeNode>();
          for(int i=0;i<nodes.size();i++) {
        	  for(int j=0;j<nodes.size();j++) {
        		  if(nodes.get(j).getNum().startsWith(nodes.get(i).getNum())&&(nodes.get(j).getNum().length()-2)==nodes.get(i).getNum().length()) {
        			  nodes.get(i).getChildren().add(nodes.get(j));	  
        		  }  
        	  } 
          }
          for (TreeNode treeNode : nodes) {
			if(treeNode.getNum().length()==1) {
				tree.add(treeNode);
			}
		}       
               
                  
            
            return tree;
    }  
    
    //转化为TreeNode节点
    public static TreeNode toNode(AuthorityBean menu){
        TreeNode node=new TreeNode();
        node.setId(menu.getId());
        node.setText(menu.getAuthorityName());
        node.setNum(menu.getAuthorityNum());
        return node;
    }
    public static List<TreeNode>toListNode(List<AuthorityBean>menus){
        List<TreeNode>nodes=new ArrayList<TreeNode>();
        for(AuthorityBean menu:menus){
            nodes.add(toNode(menu));
        }
        return nodes;
    }
}

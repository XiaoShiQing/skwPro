package com.action;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TDianpuDAO;
import com.dao.TGoodsDAO;
import com.model.TGoods;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
	private TGoodsDAO goodsDAO;
	private TDianpuDAO dianpuDAO;
	
	
	public String index()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		
		
		String sql="from TGoods where goodsDel='no' and goodsIsnottejia='no' order by goodsId desc";
		List goodsNoTejiaList=goodsDAO.getHibernateTemplate().find(sql);
		if(goodsNoTejiaList.size()>12)
		{
			goodsNoTejiaList=goodsNoTejiaList.subList(0, 12);
		}
		request.put("goodsNoTejiaList", goodsNoTejiaList);
		
		
		
		sql="from TDianpu where zt='ÉóºËÍ¨¹ý' and del='no'";
		List dianpuList=dianpuDAO.getHibernateTemplate().find(sql);
		session.put("dianpuList", dianpuList);
		
		return ActionSupport.SUCCESS;
	}
	

	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}

	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}


	
	public TDianpuDAO getDianpuDAO()
	{
		return dianpuDAO;
	}


	public void setDianpuDAO(TDianpuDAO dianpuDAO)
	{
		this.dianpuDAO = dianpuDAO;
	}

}

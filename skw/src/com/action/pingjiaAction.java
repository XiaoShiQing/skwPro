package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TDianpuDAO;
import com.dao.TPingjiaDAO;
import com.model.TDianpu;
import com.model.TPingjia;
import com.opensymphony.xwork2.ActionSupport;

public class pingjiaAction extends ActionSupport
{
	private Integer id;
	private String neirong;
	private String goodsId;
	private String shijian;
	
	private TPingjiaDAO pingjiaDAO;
	
	
	public String pingjiaAdd()
	{
		TPingjia pingjia=new TPingjia();
		
		//pingjia.setId(id);
		pingjia.setGoodsId(goodsId);
		pingjia.setNeirong(neirong);
		pingjia.setShijian(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		
		pingjiaDAO.save(pingjia);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加完毕");
		return "msg";
	}
	
	public String pingjiaAll()
	{
		String sql="from TPingjia where goodsId="+goodsId;
		List pingjiaList=pingjiaDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("pingjiaList", pingjiaList);
		return ActionSupport.SUCCESS;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNeirong()
	{
		return neirong;
	}

	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}

	public String getGoodsId()
	{
		return goodsId;
	}

	public void setGoodsId(String goodsId)
	{
		this.goodsId = goodsId;
	}

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	public TPingjiaDAO getPingjiaDAO()
	{
		return pingjiaDAO;
	}

	public void setPingjiaDAO(TPingjiaDAO pingjiaDAO)
	{
		this.pingjiaDAO = pingjiaDAO;
	}
	
}

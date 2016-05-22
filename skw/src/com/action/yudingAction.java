package com.action;

import java.util.List;
import java.util.Map;


import org.apache.struts2.ServletActionContext;

import com.dao.TYudingDAO;
import com.model.TDianpu;
import com.model.TUser;
import com.model.TYuding;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class yudingAction extends ActionSupport
{
	private Integer id;
	private Integer dianpuId;
	private String riqi;
	private String kehuming;
	
	private String dianhua;
	private String beizhu;
	private Integer userId;
	
	private TYudingDAO yudingDAO;
	
	
	public String yudingAdd()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		
		TYuding yuding=new TYuding();
		
		yuding.setId(id);
		yuding.setRiqi(riqi);
		yuding.setDianpuId(dianpuId);
		yuding.setKehuming(kehuming);
		
		yuding.setDianhua(dianhua);
		yuding.setBeizhu(beizhu);
		yuding.setUserId(user.getUserId());
			
		yudingDAO.save(yuding);
		
		
		
		String userType=user.getUserType();
		if(userType.equals("vip会员"))
		{
			request.put("msg", "预约信息添加成功,您是vip会员，享受80%折扣");
		}
		else
		{
			request.put("msg", "预约信息添加成功");
		}
		
		return "msg";
	}
	
	
	public String yudingMine()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql="from TYuding where userId="+user.getUserId();
		List yudingList=yudingDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<yudingList.size();i++)
		{
			TYuding yuding=(TYuding)yudingList.get(i);
			
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("yudingList", yudingList);
		return ActionSupport.SUCCESS;
	}
	
	public String yudingMana()
	{
		Map session=ActionContext.getContext().getSession();
		TDianpu dianpu=(TDianpu)session.get("dianpu");
		
		String sql="from TYuding where dianpuId="+dianpu.getId();
		List yudingList=yudingDAO.getHibernateTemplate().find(sql);
		
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("yudingList", yudingList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String yudingDel()
	{
		
		TYuding yuding=yudingDAO.findById(id);
		yudingDAO.delete(yuding);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	

	public String getBeizhu()
	{
		return beizhu;
	}

	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}

	public String getDianhua()
	{
		return dianhua;
	}

	public void setDianhua(String dianhua)
	{
		this.dianhua = dianhua;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}



	public Integer getDianpuId()
	{
		return dianpuId;
	}


	public void setDianpuId(Integer dianpuId)
	{
		this.dianpuId = dianpuId;
	}


	public String getKehuming()
	{
		return kehuming;
	}

	public void setKehuming(String kehuming)
	{
		this.kehuming = kehuming;
	}

	public TYudingDAO getYudingDAO()
	{
		return yudingDAO;
	}

	public void setYudingDAO(TYudingDAO yudingDAO)
	{
		this.yudingDAO = yudingDAO;
	}


	public String getRiqi()
	{
		return riqi;
	}


	public void setRiqi(String riqi)
	{
		this.riqi = riqi;
	}


	public Integer getUserId()
	{
		return userId;
	}


	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	
	
}

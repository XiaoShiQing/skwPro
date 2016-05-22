package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TDianpuDAO;
import com.dao.TGoodsDAO;
import com.model.TDianpu;
import com.model.TGoods;
import com.opensymphony.xwork2.ActionSupport;

public class dianpuAction extends ActionSupport
{
	private Integer id;
	private String loginname;
	private String loginpw;
	private String mingcheng;
	
	private String lianxiren;
	private String dianhua;
	private String dizhi;
	private String jieshao;
	
	private String zt;//审核中--审核通过
	private String del;
	
	private String message;
	private String path;
	
	private TDianpuDAO dianpuDAO;
	private TGoodsDAO goodsDAO;
	
	
	public String dianpuReg()
	{
		TDianpu dianpu=new TDianpu();

		dianpu.setLoginname(loginname);
		dianpu.setLoginpw(loginpw);
		dianpu.setMingcheng(mingcheng);
		
		dianpu.setLianxiren(lianxiren);
		dianpu.setDianhua(dianhua);
		dianpu.setDizhi(dizhi);
		dianpu.setJieshao(jieshao);
		
		dianpu.setZt("审核中");
		dianpu.setDel("no");
		
		dianpuDAO.save(dianpu);

		
		this.setMessage("注册成功，等待管理员审核");
		this.setPath("qiantai/default.jsp");
		return "succeed";
	}
	
	public String dianpuMana()
	{
		String sql="from TDianpu where del='no'";
		List dianpuList=dianpuDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("dianpuList", dianpuList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String dianpuDel()
	{
		TDianpu dianpu=dianpuDAO.findById(id);
		dianpu.setDel("yes");
		dianpuDAO.attachDirty(dianpu);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除完毕");
		return "msg";
	}
	
	
	public String dianpuShenhe()
	{
		TDianpu dianpu=dianpuDAO.findById(id);
		dianpu.setZt("审核通过");
		dianpuDAO.attachDirty(dianpu);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息审核完毕");
		return "msg";
	}
	
	
	
	
	
	public String dianpuDetailQian()
	{
		TDianpu dianpu=dianpuDAO.findById(id);
		
		String sql="from TGoods where goodsDel='no' and goodsIsnottejia='no' and dianpuId="+dianpu.getId();
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		
		dianpu.setGoodsList(goodsList);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("dianpu", dianpu);
		return ActionSupport.SUCCESS;
	}
	

	public String getDianhua()
	{
		return dianhua;
	}



	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}

	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}

	public void setDianhua(String dianhua)
	{
		this.dianhua = dianhua;
	}



	public TDianpuDAO getDianpuDAO()
	{
		return dianpuDAO;
	}



	public void setDianpuDAO(TDianpuDAO dianpuDAO)
	{
		this.dianpuDAO = dianpuDAO;
	}



	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public String getZt()
	{
		return zt;
	}

	public void setZt(String zt)
	{
		this.zt = zt;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public Integer getId()
	{
		return id;
	}



	public String getDizhi()
	{
		return dizhi;
	}

	public void setDizhi(String dizhi)
	{
		this.dizhi = dizhi;
	}

	public String getJieshao()
	{
		return jieshao;
	}

	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}



	public String getLianxiren()
	{
		return lianxiren;
	}



	public void setLianxiren(String lianxiren)
	{
		this.lianxiren = lianxiren;
	}



	public String getLoginname()
	{
		return loginname;
	}



	public String getDel()
	{
		return del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}



	public String getLoginpw()
	{
		return loginpw;
	}



	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}




	public String getMingcheng()
	{
		return mingcheng;
	}



	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}

	
}

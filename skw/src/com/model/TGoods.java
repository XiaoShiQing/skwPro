package com.model;

/**
 * TGoods generated by MyEclipse Persistence Tools
 */

public class TGoods implements java.io.Serializable
{

	private Integer goodsId;
	private Integer dianpuId;
	private String goodsName;
	private String goodsMiaoshu;

	private String fujian;
	private Integer goodsShichangjia;
	private Integer goodsTejia;
	private String goodsIsnottejia;
	
	private String goodsDel;
	
	private TDianpu dianpu;
	
	public Integer getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
	}
	public Integer getDianpuId()
	{
		return dianpuId;
	}
	public void setDianpuId(Integer dianpuId)
	{
		this.dianpuId = dianpuId;
	}
	public String getGoodsName()
	{
		return goodsName;
	}
	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}
	public String getGoodsMiaoshu()
	{
		return goodsMiaoshu;
	}
	public void setGoodsMiaoshu(String goodsMiaoshu)
	{
		this.goodsMiaoshu = goodsMiaoshu;
	}
	
	public String getFujian()
	{
		return fujian;
	}
	
	public TDianpu getDianpu()
	{
		return dianpu;
	}
	public void setDianpu(TDianpu dianpu)
	{
		this.dianpu = dianpu;
	}
	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}
	public Integer getGoodsShichangjia()
	{
		return goodsShichangjia;
	}
	public void setGoodsShichangjia(Integer goodsShichangjia)
	{
		this.goodsShichangjia = goodsShichangjia;
	}
	public Integer getGoodsTejia()
	{
		return goodsTejia;
	}
	public void setGoodsTejia(Integer goodsTejia)
	{
		this.goodsTejia = goodsTejia;
	}
	public String getGoodsIsnottejia()
	{
		return goodsIsnottejia;
	}
	public void setGoodsIsnottejia(String goodsIsnottejia)
	{
		this.goodsIsnottejia = goodsIsnottejia;
	}
	
	public String getGoodsDel()
	{
		return goodsDel;
	}
	public void setGoodsDel(String goodsDel)
	{
		this.goodsDel = goodsDel;
	}
	
}
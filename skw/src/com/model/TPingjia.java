package com.model;

/**
 * TPingjia entity. @author MyEclipse Persistence Tools
 */

public class TPingjia implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String neirong;
	private String goodsId;
	private String shijian;

	// Constructors

	/** default constructor */
	public TPingjia()
	{
	}

	/** full constructor */
	public TPingjia(String neirong, String goodsId, String shijian)
	{
		this.neirong = neirong;
		this.goodsId = goodsId;
		this.shijian = shijian;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNeirong()
	{
		return this.neirong;
	}

	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}

	public String getGoodsId()
	{
		return this.goodsId;
	}

	public void setGoodsId(String goodsId)
	{
		this.goodsId = goodsId;
	}

	public String getShijian()
	{
		return this.shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

}
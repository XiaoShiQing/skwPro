package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TDianpuDAO;
import com.dao.TGoodsDAO;
import com.model.TDianpu;
import com.model.TGoods;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class goodsAction extends ActionSupport {
	private Integer goodsId;
	private Integer dianpuId;
	private String goodsName;
	private String goodsMiaoshu;

	private String fujian;
	private Integer goodsShichangjia;
	private Integer goodsTejia;
	private String goodsIsnottejia;

	private String goodsDel;

	private String message;
	private String path;

	private TGoodsDAO goodsDAO;
	private TDianpuDAO dianpuDAO;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String goodsAdd() {
		Map session = ActionContext.getContext().getSession();
		TDianpu dianpu = (TDianpu) session.get("dianpu");

		TGoods goods = new TGoods();

		// goods.setGoodsId(0);
		goods.setDianpuId(dianpu.getId());
		goods.setGoodsName(goodsName);

		goods.setGoodsMiaoshu(goodsMiaoshu);
		goods.setFujian(fujian);
		goods.setGoodsShichangjia(goodsShichangjia);
		goods.setGoodsTejia(goodsShichangjia);

		goods.setGoodsIsnottejia("no");
		goods.setGoodsDel("no");

		goodsDAO.save(goods);

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("msg", "菜品发布完毕");
		return "msg";

	}

	public String goodsMine() {
		Map session = ActionContext.getContext().getSession();
		TDianpu dianpu = (TDianpu) session.get("dianpu");

		String sql = "from TGoods where goodsDel='no' and goodsIsnottejia='no' and dianpuId=" + dianpu.getId();
		List goodsList = goodsDAO.getHibernateTemplate().find(sql);

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}

	public String goodsDel() {
		TGoods goods = goodsDAO.findById(goodsId);
		goods.setGoodsDel("yes");
		goodsDAO.attachDirty(goods);

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("msg", "删除完毕");
		return "msg";
	}

	public String toModify() {
		TGoods good = goodsDAO.findById(goodsId);
		JSONObject json = new JSONObject();
		json.accumulate("success", false);
		json.accumulate("tomodifyGood", good);
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("msg", json.toString());
		return "msg";
	}
	
	public String modify(){
		TGoods rec = goodsDAO.findById(goodsId);
		rec.setFujian(fujian);
		rec.setGoodsName(goodsName);
		rec.setGoodsShichangjia(goodsShichangjia);
		rec.setGoodsMiaoshu(goodsMiaoshu);
		Map request = (Map) ServletActionContext.getContext().get("request");
		String msg;
		try {
			goodsDAO.merge(rec);
			msg = "修改成功";
		} catch (Exception e) {
			msg = "修改失败";
		}
		request.put("msg", msg);
		return "msg";
	}

	public String goodsMana() {
		String sql = "from TGoods where goodsDel='no' and goodsIsnottejia='no' order by dianpuId";
		List goodsList = goodsDAO.getHibernateTemplate().find(sql);
		for (int i = 0; i < goodsList.size(); i++) {
			TGoods goods = (TGoods) goodsList.get(i);
			goods.setDianpu(dianpuDAO.findById(goods.getDianpuId()));
		}

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}

	public String goodsDetailHou() {
		Map request = (Map) ServletActionContext.getContext().get("request");

		TGoods goods = goodsDAO.findById(goodsId);
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}

	public String goodsAllNoTejia() {
		Map request = (Map) ServletActionContext.getContext().get("request");

		String sql = "from TGoods where goodsDel='no' and goodsIsnottejia='no'";
		List goodsList = goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}

	public String goodsDetailQian() {
		Map request = (Map) ServletActionContext.getContext().get("request");

		TGoods goods = goodsDAO.findById(goodsId);
		goods.setDianpu(dianpuDAO.findById(goods.getDianpuId()));
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getDianpuId() {
		return dianpuId;
	}

	public void setDianpuId(Integer dianpuId) {
		this.dianpuId = dianpuId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsMiaoshu() {
		return goodsMiaoshu;
	}

	public void setGoodsMiaoshu(String goodsMiaoshu) {
		this.goodsMiaoshu = goodsMiaoshu;
	}

	public String getFujian() {
		return fujian;
	}

	public void setFujian(String fujian) {
		this.fujian = fujian;
	}

	public Integer getGoodsShichangjia() {
		return goodsShichangjia;
	}

	public void setGoodsShichangjia(Integer goodsShichangjia) {
		this.goodsShichangjia = goodsShichangjia;
	}

	public Integer getGoodsTejia() {
		return goodsTejia;
	}

	public void setGoodsTejia(Integer goodsTejia) {
		this.goodsTejia = goodsTejia;
	}

	public String getGoodsIsnottejia() {
		return goodsIsnottejia;
	}

	public void setGoodsIsnottejia(String goodsIsnottejia) {
		this.goodsIsnottejia = goodsIsnottejia;
	}

	public String getGoodsDel() {
		return goodsDel;
	}

	public void setGoodsDel(String goodsDel) {
		this.goodsDel = goodsDel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public TGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(TGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	public TDianpuDAO getDianpuDAO() {
		return dianpuDAO;
	}

	public void setDianpuDAO(TDianpuDAO dianpuDAO) {
		this.dianpuDAO = dianpuDAO;
	}

}

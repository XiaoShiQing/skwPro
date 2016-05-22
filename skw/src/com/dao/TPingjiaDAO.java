package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TPingjia;

/**
 * A data access object (DAO) providing persistence and search support for
 * TPingjia entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TPingjia
 * @author MyEclipse Persistence Tools
 */

public class TPingjiaDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TPingjiaDAO.class);
	// property constants
	public static final String NEIRONG = "neirong";
	public static final String GOODS_ID = "goodsId";
	public static final String SHIJIAN = "shijian";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TPingjia transientInstance)
	{
		log.debug("saving TPingjia instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TPingjia persistentInstance)
	{
		log.debug("deleting TPingjia instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TPingjia findById(java.lang.Integer id)
	{
		log.debug("getting TPingjia instance with id: " + id);
		try
		{
			TPingjia instance = (TPingjia) getHibernateTemplate().get(
					"com.model.TPingjia", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPingjia instance)
	{
		log.debug("finding TPingjia instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TPingjia instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TPingjia as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNeirong(Object neirong)
	{
		return findByProperty(NEIRONG, neirong);
	}

	public List findByGoodsId(Object goodsId)
	{
		return findByProperty(GOODS_ID, goodsId);
	}

	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
	}

	public List findAll()
	{
		log.debug("finding all TPingjia instances");
		try
		{
			String queryString = "from TPingjia";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TPingjia merge(TPingjia detachedInstance)
	{
		log.debug("merging TPingjia instance");
		try
		{
			TPingjia result = (TPingjia) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPingjia instance)
	{
		log.debug("attaching dirty TPingjia instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TPingjia instance)
	{
		log.debug("attaching clean TPingjia instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TPingjiaDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TPingjiaDAO) ctx.getBean("TPingjiaDAO");
	}
}
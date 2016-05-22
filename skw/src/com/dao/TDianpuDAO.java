package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TDianpu;

/**
 * Data access object (DAO) for domain model class TDianpu.
 * 
 * @see com.model.TDianpu
 * @author MyEclipse Persistence Tools
 */

public class TDianpuDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TDianpuDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TDianpu transientInstance)
	{
		log.debug("saving TDianpu instance");
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

	public void delete(TDianpu persistentInstance)
	{
		log.debug("deleting TDianpu instance");
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

	public TDianpu findById(java.lang.Integer id)
	{
		log.debug("getting TDianpu instance with id: " + id);
		try
		{
			TDianpu instance = (TDianpu) getHibernateTemplate().get(
					"com.model.TDianpu", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDianpu instance)
	{
		log.debug("finding TDianpu instance by example");
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
		log.debug("finding TDianpu instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TDianpu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()
	{
		log.debug("finding all TDianpu instances");
		try
		{
			String queryString = "from TDianpu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDianpu merge(TDianpu detachedInstance)
	{
		log.debug("merging TDianpu instance");
		try
		{
			TDianpu result = (TDianpu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDianpu instance)
	{
		log.debug("attaching dirty TDianpu instance");
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

	public void attachClean(TDianpu instance)
	{
		log.debug("attaching clean TDianpu instance");
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

	public static TDianpuDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TDianpuDAO) ctx.getBean("TDianpuDAO");
	}
}
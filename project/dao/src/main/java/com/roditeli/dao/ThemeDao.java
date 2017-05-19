package com.roditeli.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roditeli.api.dao.IThemeDao;
import com.roditeli.model.Theme;

@Repository
public class ThemeDao extends BaseDao<Theme> implements IThemeDao{

	public ThemeDao() {
		super(Theme.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Theme> getThemeCurrentRubric(int rubricId) throws Exception{
		List<Theme> list = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
		list = criteria.add(Restrictions.eq("rubric.id", rubricId)).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Theme> getThemeRubricForUser(int userId, int rubricId) throws Exception{
		List<Theme> list = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
		list = criteria.createCriteria("author", JoinType.RIGHT_OUTER_JOIN).add(Restrictions.eq("user.id", userId)).add(Restrictions.eq("rubric_fk", rubricId)).list();
		return list;
	}

}

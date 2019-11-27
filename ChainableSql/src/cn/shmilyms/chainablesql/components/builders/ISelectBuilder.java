package cn.shmilyms.chainablesql.components.builders;

import cn.shmilyms.chainablesql.components.IComponent;
import cn.shmilyms.chainablesql.util.Utilities.SqlOrders;

public interface ISelectBuilder extends IComponent{

	public ISelectBuilder select(String column);
	public ISelectBuilder select(String...columns);
	public ISelectBuilder alias(String alias);
	public ISelectBuilder select(String column,String alias);
	public ISelectBuilder from(String table);
	public ISelectBuilder from(ISelectBuilder builder);
	
	public ISelectBuilder where(String condition);
	public ISelectBuilder and(String...conditions);
	public ISelectBuilder or(String...conditions);
	public ISelectBuilder and(IBooleanBuilder...conditions);
	public ISelectBuilder or(IBooleanBuilder...conditions);
	
	public ISelectBuilder orderBy(String column);
	public ISelectBuilder orderBy(String...columns);
	public ISelectBuilder orderBy(String column,SqlOrders order);
	
	//public ISelectBuilder join(SqlJoinTypes type,String table);
	//public ISelectBuilder join(SqlJoinTypes type,String table,String alias);
	//public ISelectBuilder on(String condition);
	//public ISelectBuilder on(String...conditions);
}

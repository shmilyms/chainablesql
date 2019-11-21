package cn.shmilyms.chainablesql.components.builders;

import cn.shmilyms.chainablesql.components.IComponent;

public interface IConditionBuilder extends IComponent{
	public IConditionBuilder and(String...conditions);
	public IConditionBuilder or(String...conditions);
	
	public IConditionBuilder and(IBooleanBuilder...conditions);
	public IConditionBuilder or(IBooleanBuilder...conditions);
}

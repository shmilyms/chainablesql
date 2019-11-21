package cn.shmilyms.chainablesql.components.builders;

import cn.shmilyms.chainablesql.components.IComponent;

public interface ISqlBuilder extends IComponent {
	public ISelectBuilder select(String column);
	public ISelectBuilder select(String...columns);
	
	
}

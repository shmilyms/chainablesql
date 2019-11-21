package cn.shmilyms.chainablesql.components.builders;

import cn.shmilyms.chainablesql.components.IComponent;
import cn.shmilyms.chainablesql.util.Utilities.SqlOrders;

public interface IOrderBuilder extends IComponent {
	public IOrderBuilder orderBy(String column);
	public IOrderBuilder orderBy(String...columns);
	public IOrderBuilder orderBy(String column,SqlOrders order);
}

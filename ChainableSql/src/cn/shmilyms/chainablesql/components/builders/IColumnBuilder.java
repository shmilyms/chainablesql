package cn.shmilyms.chainablesql.components.builders;

import cn.shmilyms.chainablesql.components.Column;
import cn.shmilyms.chainablesql.components.IComponent;

public interface IColumnBuilder extends IComponent,IAliasListener{
	public IColumnBuilder column(String column);
	public IColumnBuilder alias(String alias);
	public IColumnBuilder column(String column,String alias);
	public IColumnBuilder columns(String...columns);
	public IColumnBuilder deleteColumn(String column);
	public Column getColumn(String column);
}

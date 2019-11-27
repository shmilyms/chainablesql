package cn.shmilyms.chainablesql.components.builders.impl;

import cn.shmilyms.chainablesql.components.IComponent;
import cn.shmilyms.chainablesql.components.builders.ISelectBuilder;
import cn.shmilyms.chainablesql.components.builders.ISqlBuilder;

public class SqlBuilderImpl implements ISqlBuilder {
	IComponent last;
	@Override
	public ISelectBuilder select(String column) {
		// TODO Auto-generated method stub
		return (ISelectBuilder) (last = new SelectBuilderImpl().select(column));
	}

	@Override
	public ISelectBuilder select(String... columns) {
		// TODO Auto-generated method stub
		return (ISelectBuilder) (last = new SelectBuilderImpl().select(columns));
	}

	@Override
	public void appendToBuilder(StringBuilder sb) {
		// TODO Auto-generated method stub
		last.appendToBuilder(sb);
	}
	


}

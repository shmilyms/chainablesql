package cn.shmilyms.chainablesql.components.builders.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.shmilyms.chainablesql.components.Column;
import cn.shmilyms.chainablesql.components.builders.IColumnBuilder;

public class ColumnBuilderImpl implements IColumnBuilder {
	private List<Column> columns;
	
	
	@Override
	public void appendToBuilder(StringBuilder sb) {
		// TODO Auto-generated method stub
		int count = 0;
		int size = columns.size();
		for (Column col : columns) {
			count += 1;
			col.appendToBuilder(sb);
			if (count<size)
				sb.append(", ");
		}
	}
	
	@Override
	public IColumnBuilder column(String column) {
		// TODO Auto-generated method stub
		if (columns==null)
			columns=new ArrayList<>();
		columns.add(new Column(column));
		return this;
	}

	@Override
	public IColumnBuilder alias(String alias) {
		// TODO Auto-generated method stub
		if (columns!=null)
			columns.get(columns.size()-1).setAlias(alias);
		return this;
	}
	@Override
	public IColumnBuilder column(String column, String alias) {
		// TODO Auto-generated method stub
		if (columns==null)
			columns=new ArrayList<>();
		columns.add(new Column(column,alias));
		return this;
	}
	@Override
	public IColumnBuilder columns(String... columns) {
		// TODO Auto-generated method stub
		if (this.columns==null)
			this.columns=new ArrayList<>();
		for (String column:columns) {
			this.columns.add(new Column(column));
		}
		return this;
	}

	@Override
	public IColumnBuilder deleteColumn(String column) {
		// TODO Auto-generated method stub
		columns.removeAll(Arrays.asList(new Column(column)));
		return this;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Column getColumn(String column) {
		// TODO Auto-generated method stub
		return columns.get(columns.indexOf(column));
	}

	@Override
	public void listen(String alias) {
		// TODO Auto-generated method stub
		this.alias(alias);
	}



}

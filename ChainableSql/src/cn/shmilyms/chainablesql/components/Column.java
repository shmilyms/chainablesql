package cn.shmilyms.chainablesql.components;

public class Column implements IComponent {
	private String column;
	private String alias = FLAG_NO_ALIAS;
	private static final String FLAG_NO_ALIAS = null;
	public Column(String column) {
		this(column,FLAG_NO_ALIAS);
	}
	public Column(String column,String alias) {
		this.column=column;
		this.alias=alias;
	}
	@Override
	public StringBuilder toSql(StringBuilder sb) {
		// TODO Auto-generated method stub
		return sb.append(column);
	}
	public String toSqlWithAlias() {
		return alias!=FLAG_NO_ALIAS ? column+" AS "+alias : column;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public boolean hasAlias() {
		return alias!=FLAG_NO_ALIAS;
	}
	@Override
	public boolean equals(Object object) {
		return ((object instanceof Column) && ((Column)object).getColumn()==this.getColumn()) || ((object instanceof String) && object==this.getColumn());
	}

}

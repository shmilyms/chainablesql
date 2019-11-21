package cn.shmilyms.chainablesql.components;

public interface IComponent {

	
	public StringBuilder toSql(StringBuilder sb);
	
	public default String toSql() {
		return toSql(new StringBuilder()).toString();
	}
	public default String finishSql() {
		return toSql(new StringBuilder()).append(";").toString();
	}
}

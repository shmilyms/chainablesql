package cn.shmilyms.chainablesql.components.builders;

import cn.shmilyms.chainablesql.components.IAliasListener;
import cn.shmilyms.chainablesql.util.Utilities.JoinTypes;

public interface IJoinBuilder extends IAliasListener{
	IJoinBuilder join(String table,JoinTypes type);
	IJoinBuilder join(ISelectBuilder builder,JoinTypes type);
	IJoinBuilder join(String table,String alias,JoinTypes type);
	IJoinBuilder join(ISelectBuilder builder,String alias,JoinTypes type);
	IJoinBuilder alias(String alias);
	
	IJoinBuilder on(String...conditions);
	IJoinBuilder on(IConditionBuilder...conditions);
	
	IJoinBuilder left_join(String table);
	IJoinBuilder left_join(String table,String alias);
	IJoinBuilder left_join(ISelectBuilder builder);
	IJoinBuilder left_join(ISelectBuilder builder,String alias);
	
	IJoinBuilder right_join(String table);
	IJoinBuilder right_join(String table,String alias);
	IJoinBuilder right_join(ISelectBuilder builder);
	IJoinBuilder right_join(ISelectBuilder builder,String alias);
	
	IJoinBuilder inner_join(String table);
	IJoinBuilder inner_join(String table,String alias);
	IJoinBuilder inner_join(ISelectBuilder builder);
	IJoinBuilder inner_join(ISelectBuilder builder,String alias);
	
	IJoinBuilder outer_join(String table);
	IJoinBuilder outer_join(String table,String alias);
	IJoinBuilder outer_join(ISelectBuilder builder);
	IJoinBuilder outer_join(ISelectBuilder builder,String alias);
	
}

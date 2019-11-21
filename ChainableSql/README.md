README
===========================
Chainable sql - turn sql into chainable functions. Currently working in progress.

Code Example: 

		ISqlBuilder sb = new SqlBuilderImpl();
		String sql = sb
				.select("user")
				.select("DOB").alias("birthday")
				.from(sb
						.select("user")
						.select("DOB")
						.from("users")
						.where("VIP = 1")
						.and(not("ISNULL(DOB)"))
						.and(expr(CompOperator.GE,"sales","10000000"),not(expr(CompOperator.EQ,"vipExpired","1"))))
				.orderBy("birthday", SqlOrders.DESC)
				.orderBy("user")
				.finishSql();

		System.out.println(sql);
		
		//SELECT user, DOB AS birthday FROM (SELECT user, DOB FROM users WHERE (VIP = 1) AND (NOT(ISNULL(DOB))) AND (sales >= 10000000) AND (NOT(vipExpired = 1))) ORDER BY birthday DESC, user ASC;

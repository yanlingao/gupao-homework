官方自定义TypeHandler参考资料：
http://www.mybatis.org/mybatis-3/configuration.html#typeHandlers 


官方自定义plugin参考资料：
http://www.mybatis.org/mybatis-3/configuration.html#plugins


Methods that be allowed mybatis plugin to intercept:

    Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
     
    ParameterHandler (getParameterObject, setParameters) 
    
    ResultSetHandler (handleResultSets, handleOutputParameters) 
    
    StatementHandler (prepare, parameterize, batch, update, query) 
    
plugin使用指责链模式实现。当有多个plugin时将按照配置文件中的声明顺序执行。
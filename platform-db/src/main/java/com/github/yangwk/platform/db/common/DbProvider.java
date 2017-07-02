package com.github.yangwk.platform.db.common;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;

public class DbProvider extends BaseInsertProvider {
	
    public DbProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }
    
}

package com.pp.test.config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
/**
 * 配置Mapper的扫描包路径
 */
@Configuration
@MapperScan("com.pp.test.mapper")
public class MybatisScanConfiguration{
	
}
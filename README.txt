platform各模块依赖关系：

log
	->	common
		->	bean
			->	jta
				->	mq
				->	storage
					->	session(task)
				->	db
					->	service
						->	aop
							->	controller(session)
						->	task


soa
soa-api
	->	soa-provider(service)
		->	soa-test
	->	soa-consumer
		->	soa-test-consumer



关于Nothing接口：
此接口无意义，只是为了让maven生成jar包（如果模块没有任何类，maven不会生成jar包）
使能*.xml可以被加载到classpath


启动web项目
platform-controller
需要开启服务：mysql、activemq、redis


soa需要服务：zookeeper

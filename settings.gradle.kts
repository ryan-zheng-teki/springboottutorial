/*
 * This file was generated by the Gradle 'init' task.
 */

rootProject.name = "springboottutorial"
include("springbootcassandra")
include("springbootredis")
include("springbootrabbitmq")
include("springbootwebsocket")
include("springbootmessaging")
include("springdroolstutorial")
include("RMITutorial")
include("springwebfluxtutorial")
include("springkafkatutorial")
include("springcoretutorial")
include("springjpatutorial")
include("springkafkatutorial:warehouseservice")
include("springkafkatutorial:accountingservice")
include("springkafkatutorial:deliveryservice")
include("springkafkatutorial:orderservice")
include("springkafkatutorial:csvproducer")
include("qsol-data-r2dbc")
include("qsol-coding-guideline")
include("qsol-data-reactive-spring-boot-starter")
include("qsol-data-reactive-spring-boot-autoconfigure")
include("qsol-jni-programming")
include("ERPService")
include("springkafkatutorial:erpapigateway")
findProject(":springkafkatutorial:erpapigateway")?.name = "erpapigateway"
include("springkafkatutorial:erpservice")
findProject(":springkafkatutorial:erpservice")?.name = "erpservice"
include("springkafkatutorial:erpapigateway:erpapiadator")
findProject(":springkafkatutorial:erpapigateway:erpapiadator")?.name = "erpapiadator"

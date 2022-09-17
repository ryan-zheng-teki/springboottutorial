println("hello root")
pluginManagement {
    repositories {
        gradlePluginPortal() // this needs to be added as well, otherwise other dependencies don't resolve
        maven { setUrl("https://repo.spring.io/snapshot") }
    }
}


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
include("springbootcache")
include("qsol-chatapp")
include("jgroup-cluster")
include("springkafkatutorial:erpapigateway")
include("springkafkatutorial:erpservice")
include("springkafkatutorial:erpapigateway:erpapiadator")
include("springcoretutorial:javaagenttutorial")
include("springnativetutorial")
include("springkafkatutorial:event-core")
include("springkafkatutorial:analysis-service")
findProject(":springkafkatutorial:event-core")?.name = "event-core"
include("springkafkatutorial:config-server")
findProject(":springkafkatutorial:config-server")?.name = "config-server"
include("springkafkatutorial:orchestration")
findProject(":springkafkatutorial:orchestration")?.name = "orchestration"

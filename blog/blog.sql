/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.5.23 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `blog` */

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` longtext NOT NULL,
  `typeName` char(20) NOT NULL,
  `time` date NOT NULL,
  `image` varchar(255) NOT NULL,
  `conIntroduction` varchar(255) NOT NULL COMMENT '内容简介',
  `user_name` char(15) DEFAULT NULL,
  `labelName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `blog` */

insert  into `blog`(`id`,`title`,`content`,`typeName`,`time`,`image`,`conIntroduction`,`user_name`,`labelName`) values (2,'22222233333','邢唷??','歌曲','2020-06-24','https://picsum.photos/id/1056/200/300','爱你你是我的玫瑰花','useradmin','jsp'),(9,'1111111','#一级标题\r\n---\r\n##二级标题\r\n---\r\n###三级标题\r\n---\r\n####四级标题','日记','2018-11-13','https://picsum.photos/id/1054/200/300','hhhhhhhhhhhhuzi牛逼','admin1111','jsp'),(13,'5555555555','#学习没有捷径，对不起让你失望了','学习资料','2020-07-09','https://picsum.photos/id/1044/200/300','深入谈谈学习都有哪些捷径','蔡晓峰','jsp'),(14,'7777777777','白日梦啊，多美好','歌曲','2020-07-09','https://picsum.photos/id/1073/200/300','无','useradmin','jsp'),(16,'666666666666','# maven中静态资源的过滤\r\n\r\npom.xml文件中加入下面配置\r\n\r\n### 可以过滤java和resources文件夹里面所有的的.properties和.xml文件\r\n**directory：指定资源所在的目录，目录的路径是相对于pom.xml文件的\r\nincludes：指定要包含哪些文件**\r\n**filtering标签中：false表示不过滤，true表示过滤**\r\n\r\n```java\r\n    <build>\r\n        <resources>\r\n            <resource>\r\n                <directory>src/main/java</directory>\r\n                <includes>\r\n                    <include>**/*.properties</include>\r\n                    <include>**/*.xml</include>\r\n                </includes>\r\n                <filtering>false</filtering>\r\n            </resource>\r\n            <resource>\r\n                <directory>src/main/resources</directory>\r\n                <includes>\r\n                    <include>**/*.properties</include>\r\n                    <include>**/*.xml</include>\r\n                </includes>\r\n                <filtering>false</filtering>\r\n            </resource>\r\n        </resources>\r\n    </build>\r\n```\r\n','笔记','2020-07-09','https://picsum.photos/id/1037/200/300','pom.xml文件中加入下面配置 可以过滤java和resources文件夹里面所有的的.properties和.xml文件','111','jsp'),(19,'666666666667777777','## 模板引擎\r\n\r\n简介：模板引擎(这里特指用于Web开发的模板引擎)是为了使用户界面与业务数据(内容)分离而产生的,它可以生成特定格式的文档，用于网站的模板引擎就会生成一个标准的HTML文档。\r\n模板引擎的思想：\r\n![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMuY25ibG9ncy5jb20vY25ibG9nc19jb20venltMTk5OS8xNjQ1NDE2L29fMjAwMjExMDk1OTQxMTQucG5n?x-oss-process=image/format,png)\r\nThymeleaf就是SpringBoot给我们推荐的一种模板引擎！\r\n\r\n## Thymeleaf模板引擎\r\n\r\n#### 1.使用Thymeleaf之前的步骤\r\n\r\n 1. Thymeleaf 官网：https://www.thymeleaf.org/\r\n 2. springboot项目直接引入依赖：\r\n```java\r\n<dependency>\r\n   <groupId>org.springframework.boot</groupId>\r\n   <artifactId>spring-boot-starter-thymeleaf</artifactId>\r\n</dependency>\r\n```\r\n3.非springboot项目直接引入依赖：\r\n\r\n```java\r\n<dependency>\r\n    <groupId>org.thymeleaf</groupId>\r\n    <artifactId>thymeleaf</artifactId>\r\n    <version>2.1.4</version>\r\n</dependency>\r\n```\r\n  4.在thymeleaf的配置类ThymeleafProperties中我们可以发现：thymeleaf配置的默认前缀为：\"classpath:/templates/\"，默认后缀为：\".html\"，只要把html页面放在这个路径下，\r\n\r\nthymeleaf就可以帮我们自动渲染。\r\n\r\n```java\r\npublic class ThymeleafProperties {\r\n    private static final Charset DEFAULT_ENCODING;\r\n    public static final String DEFAULT_PREFIX = \"classpath:/templates/\";\r\n    public static final String DEFAULT_SUFFIX = \".html\";\r\n    private boolean checkTemplate = true;\r\n    private boolean checkTemplateLocation = true;\r\n    private String prefix = \"classpath:/templates/\";\r\n    private String suffix = \".html\";\r\n    private String mode = \"HTML\";\r\n...\r\n}\r\n```\r\n如图为用idea创建的springboot的项目结构：将html页面放在resources/templates中即可。\r\n![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMuY25ibG9ncy5jb20vY25ibG9nc19jb20venltMTk5OS8xNjQ1NDE2L29fMjAwMjExMDk1OTExMTMucG5n?x-oss-process=image/format,png)\r\n#### 2.Thymeleaf语法简单使用（th:text, th:utext, th:each）\r\n编写一个controller实现跳转到一个html页面，通过Model对象携带数据\r\n\r\n```java\r\n@Controller\r\npublic class HelloController {\r\n\r\n    @RequestMapping(\"/success\")\r\n    public String success(Model model){\r\n        //存入数据\r\n        model.addAttribute(\"msg\",\"<h1>Hello</h1>\");\r\n        model.addAttribute(\"users\", Arrays.asList(\"小红\", \"小米\",\"小白\"));\r\n        //classpath:/templates/success.html\r\n        return \"success\";\r\n    }\r\n}\r\n```\r\nsuccess.html\r\n\r\n```java\r\n<!DOCTYPE html>\r\n<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <title>Title</title>\r\n</head>\r\n<body>\r\n    <h1>success</h1>\r\n\r\n    <!--Thymeleaf语法：th:text就是将div中的内容设置为它指定的值-->\r\n\r\n    <div th:text=\"${msg}\">你好</div>\r\n    <!--utext：会解析html，显示相应的效果-->\r\n    <div th:utext=\"${msg}\">你好</div>\r\n    <!--each：遍历-->\r\n    <h3 th:each=\"user:${users}\" th:text=\"${user}\"></h3>\r\n\r\n</body>\r\n</html>\r\n```\r\n通过http://localhost:8080/success路径访问到success.html页面，同时成功显示数据：![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMuY25ibG9ncy5jb20vY25ibG9nc19jb20venltMTk5OS8xNjQ1NDE2L29fMjAwMjExMTEyOTE3MTUucG5n?x-oss-process=image/format,png)\r\n#### 3.Thymeleaf基本语法（属性和表达式）\r\n**Thymeleaf标准表达式**\r\n   \r\n\r\n 1. 变量表达式：**${ }**：用于前端获取后端传递的变量值\r\n\r\n   \r\n\r\n 1. 选择表达式：***{ }**：用于绑定一个对象的属性\r\n\r\n   \r\n\r\n 1. URL链接表达式：**@{ }**：用于链接\r\n\r\n    \r\n\r\n 1. 条件表达式：**三目运算符（表达式 ？值（then）：值（else））**\r\n\r\n    \r\n\r\n\r\n    \r\n**Thymeleaf属性标签：**\r\n![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMuY25ibG9ncy5jb20vY25ibG9nc19jb20venltMTk5OS8xNjQ1NDE2L29fMjAwMjExMTEzMTAxMTYucG5n?x-oss-process=image/format,png)\r\n\r\n \r\n\r\n','博客','2020-07-09','https://picsum.photos/id/1025/200/300','简介：模板引擎(这里特指用于Web开发的模板引擎)是为了使用户界面与业务数据(内容)分离而产生的,它可以生成特定格式的文档，用于网站的模板引擎就会生成一个标准的HTML文档。Thymeleaf就是SpringBoot给我们推荐的一种模板引擎！','admin1111','jsp'),(20,'22222222','### Set集合特点:\r\n#### ①     一次只存一个元素,\r\n\r\n#### ②     不能存储重复的元素\r\n\r\n#### ③     存储顺序和取出来的顺序不一定一致不能存储重复的元素\r\n\r\n可以利用②这一特点，完成去重的功能。\r\n#### 一：Set集合去掉List集合中重复元素\r\n\r\n```java\r\npublic static void main(String[] args) {\r\n	\r\n	//利用set集合 去除ArrayList集合中的重复元素\r\n	ArrayList<String> list = new ArrayList<>();\r\n	list.add(\"1\");\r\n    list.add(\"1\");\r\n    list.add(\"2\");\r\n    list.add(\"2\");\r\n    list.add(\"3\");\r\n    list.add(\"3\");\r\n    list.add(\"4\");\r\n    list.add(\"4\");\r\n    System.out.println(\"去重前的List集合：\"+list);\r\n    \r\n	Set<String> set = new HashSet<>();\r\n	set.addAll(list);\r\n	System.out.println(\"Set集合：\"+set);\r\n	\r\n	list.clear();            // 清空原有元素 放入被list去重后的元素\r\n	list.addAll(set);\r\n	System.out.println(\"去重后的List集合：\"+list);\r\n}\r\n```\r\n运行结果：\r\n\r\n```java\r\n去重前的List集合：[1, 1, 2, 2, 3, 3, 4, 4]\r\nSet集合：[1, 2, 3, 4]\r\n去重后的List集合：[1, 2, 3, 4]\r\n```\r\n\r\n#### 二：Set集合去掉字符串中重复子串\r\n\r\n```java\r\npublic static void main(String[] args) {\r\n	String str = \"aaab\";\r\n	System.out.println(\"字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个\");\r\n	\r\n	Set<String> set = new HashSet<String>();\r\n	for (int step = 0; step <= str.length() - 1; step++) {\r\n		//扫描全部子串\r\n		for (int begin = 0, end = 1 + step; end <= str.length(); begin++, end++) {     \r\n			String kid = str.substring(begin, end);   //截取字符串子串\r\n			set.add(kid);			//将子串放入set集合，完成去重\r\n		}\r\n	}\r\n	System.out.println(\"去除重复子串后的全部子串有：\"+set.size()+\"个\");\r\n	System.out.println(\"分别是：\" + set);\r\n}\r\n```\r\n运行结果：\r\n```java\r\n字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个\r\n去除重复子串后的全部子串有：7个\r\n分别是：[aa, aaa, a, ab, b, aab, aaab]\r\n```\r\n\r\n','博客','2020-07-09','https://picsum.photos/id/1067/200/300','Set集合特点: ① 一次只存一个元素, ② 不能存储重复的元素 ③ 存储顺序和取出来的顺序不一定一致不能存储重复的元素','admin1111','jsp'),(21,'88888888888','### 方法：\r\n\r\n#### 1.查询日期，返回日期字符串\r\n```handlebars\r\n//查询所有博客对应的年份，返回一个集合\r\nList<String> findGroupYear();  \r\n```\r\n#### 2.根据日期查询\r\n```handlebars\r\n//根据年份查询博客信息\r\nList<Blog> findByYear(@Param(\"year\") String year);  \r\n```\r\n\r\n\r\n### mybatis映射:\r\n\r\n\r\n```java\r\n<select id=\"findGroupYear\" resultType=\"String\">\r\n    select DATE_FORMAT(b.update_time, \'%Y\') from t_blog b\r\n</select>\r\n\r\n\r\n<select id=\"findByYear\" resultType=\"Blog\">\r\n    select b.title, b.update_time, b.id, b.flag\r\n    from t_blog b\r\n    where DATE_FORMAT(b.update_time, \'%Y\') = #{year}\r\n</select>\r\n```\r\n\r\n## 总结：\r\n**DATE_FORMAT(date,format)：date表示日期，format表示显示的格式。**\r\n**该方法可以把date类型转换为String类型的字符串**\r\n','笔记','2020-07-09','https://picsum.photos/id/101/200/300','mybatis根据日期查询、查询日期并返回 方法： 1.查询日期，返回日期字符串','admin1111','jsp'),(22,'3333333333','## 试题 基础练习 01字串\r\n  \r\n### 资源限制\r\n时间限制：1.0s   内存限制：256.0MB\r\n### 问题描述\r\n对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：\r\n\r\n00000\r\n\r\n00001\r\n\r\n00010\r\n\r\n00011\r\n\r\n00100\r\n\r\n请按从小到大的顺序输出这32种01串。\r\n\r\n### 输入格式\r\n本试题没有输入。\r\n### 输出格式\r\n输出32行，按从小到大的顺序每行一个长度为5的01串。\r\n### 样例输出\r\n00000\r\n00001\r\n00010\r\n00011\r\n<以下部分省略>\r\n\r\n#### 思路：\r\n**使用Integer.toBinaryString()将十进制整数转换为二进制字符串，再判断长度是否能整除5，在前面加0输出**\r\n\r\n```java\r\npublic class 字串01 {\r\n	public static void main(String[] args) {\r\n		\r\n		for(int i = 0; i <= 31; i++) {\r\n			String s = Integer.toBinaryString(i);\r\n			int len = s.length();\r\n			switch(len % 5) {\r\n			case 1: s = \"0000\" + s;break;\r\n			case 2: s = \"000\" + s;break;\r\n			case 3: s = \"00\" + s;break;\r\n			case 4: s = \"0\" + s;break;\r\n			case 0: break;\r\n			}\r\n			System.out.println(s);\r\n		}\r\n	}\r\n}\r\n```\r\n\r\n**另一种方法，不用判断加0，也可以直接使用printf输出指定格式的整数：**\r\n```java\r\npublic class 字串01 {\r\n	public static void main(String[] args) {\r\n		\r\n		for(int i = 0; i <= 31; i++) {\r\n			String s = Integer.toBinaryString(i);\r\n			int n = Integer.parseInt(s);\r\n			System.out.printf(\"%05d\\n\",n);\r\n		}\r\n	}\r\n}\r\n```\r\n\r\n','学习资料','2020-07-09','https://picsum.photos/id/102/200/300','问题描述  对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：  00000  00001  00010  00011  00100  请按从小到大的顺序输出这32种01串。','111','jsp'),(23,'444444444','我怕你说话，我怕你沉默。 \r\n我怕你来到，我怕你离开。 \r\n我怕抓紧你，我怕放走你。 \r\n我怕你看到我，我怕你无视我。 \r\n我怕你想念我，我怕你忘记我。 \r\n我怕你过于依赖我，我怕你不再需要我。 \r\n我怕你爱我，我怕你不爱我。 \r\n我怕你太爱我，我怕你不够爱我。\r\n\r\n不管昨夜经历了怎样的泣不成声 早晨醒来这个城市依然车水马龙\r\n\r\n不要让那个喜欢你的人 撕心裂肺地为你哭那么一次 因为 你能把他伤害到那个样子的机会 只有一次 那一次以后 你就从不可或缺的人变成可有可无的人了 即使他还爱你 可是 总有一些东西真的改变了\r\n\r\n应该趁着年轻 和喜欢的人一起 制造些比夏天还要温暖的事\r\n\r\n风不懂云的漂泊。天不懂雨的落魄。眼不懂泪的懦弱。所以你不懂我的选择。也可以不懂我的难过。不是每一个人都一定要快乐。不是每一种痛都一定要诉说\r\n\r\n后来，我终于能接受，我们不会再在一起这个实事。我想我唯一能做的就是，继承那些，你拥有的让我着迷的品质，好好地生活下去。\r\n\r\n如果你喜欢的人不喜欢你，那么就算全世界的人都喜欢你，还是会觉得孤独吧。If the person you like doesn\'t like you ,wouldn\'t it still be lonely even if the whole world loves you.\r\n\r\n那些 我们一直惴惴不安 又充满好奇的未来 会在心里隐隐约约地觉得它们是明亮的\r\n\r\n人生，总会有不期而遇的温暖，和生生不息的希望。\r\n\r\n其实我一直相信 等你出现的时候我就知道是你\r\n\r\n我谈过最长的恋爱，就是自恋，我爱自己，没有情敌。\r\n\r\n不知道如何爱你，看着你，是我唯一的方式。I don\'t know how to love you ,looking at you is the only way i know\r\n\r\n我所知道的关于你的事情 就只有天气预报了\r\n\r\n我觉得 我们俩之间就像喝酒 我干杯 你随意\r\n\r\n玫瑰当然爱小王子 \r\n不过当你真的喜欢一个人的时候 就会想很多 会很容易办蠢事 说傻话 \r\n更别说 那个人像小王子那么可爱 \r\n玫瑰很温柔 其实她只是不知所措罢了 \r\n至于小王子 他还太小了 不明白玫瑰的温柔 \r\n他的离开也许并不是坏事\r\n\r\n最喜欢早上，好像什么都可以重新开始，中午的时候就开始觉得忧伤，晚上最难度过。\r\n\r\nI know that one day I will forgot you. \r\nI don\'t have anticipation. \r\nI don\'t feel sad. \r\nI just know, that\'s all.\r\n\r\n长大了 总有那么一两次机会 你会为了喜欢的人 跑那么一跑 因为 如果是对的人的话 走路真的来不及\r\n\r\n很久以后，那些好极了和糟透了的时刻我们都会忘记，唯一真实和难忘的是，我们抬头挺胸走过的人生。\r\n\r\n不论是我的世界车水马龙繁华盛世 还是它们都瞬间消失化为须臾 我都会坚定地走向你 不慌张 不犹豫','原创','2020-07-09','https://picsum.photos/id/1027/200/300','不论是我的世界车水马龙繁华盛世  还是它们都瞬间消失化为须臾  我都会坚定地走向你 不慌张 不犹豫','useradmin','jsp');

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` char(10) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`type_id`,`type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`type_id`,`type_name`,`time`) values (1,'歌曲','2019-12-11'),(2,'笔记','2020-06-11'),(3,'日记','2020-03-04'),(4,'博客','2020-05-20'),(7,'学习资料','2020-06-26'),(11,'原创','2020-06-27'),(14,'asdd','2020-07-08');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` char(15) NOT NULL,
  `password` char(15) NOT NULL,
  `email` char(40) NOT NULL,
  `phone` char(11) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`id`,`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`user_name`,`password`,`email`,`phone`,`time`) values (7,'useradmin','11111111','1958253402@qq.com','11111111111','2020-06-26'),(8,'520520520','222222222','lisi@qq.com','18580566944','2020-06-26'),(9,'sjhduwfg','12345678','155@155.cm','12345678910','2020-06-26'),(10,'10086111','123456789','lisi@qq.com','11111111111','2020-06-27'),(11,'ddhdhdhdhddh','123456789','21554@qqq.cssd','12345678910','2020-06-27'),(12,'admin1111222','11111111','1958253402@qq.com','11111111111','2020-07-01'),(13,'cxhtgr11','13714735606cai','2153343603@qq.com','13714735606','2020-07-01'),(14,'12345678','12345678','115@dd','11111111111','2020-07-01'),(15,'admin1111','11111111','1958253402@qq.com','11111111111','2020-07-06'),(17,'11155555','11111111','1958253402@qq.com','11111111111','2020-07-07'),(18,'lzc123','123456','1958253402@qq.com','18580566944','2020-12-25'),(19,'lzc222','123456','1958253402@qq.com','11111111111','2020-12-25');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

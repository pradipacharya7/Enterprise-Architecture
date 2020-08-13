Spring MVC version of Product4aJSP- 

Change <servlet-mapping> to map all requests to the DispatcherServlet

    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <!-- map all requests to the DispatcherServlet -->
        <url-pattern>/</url-pattern>
    </servlet-mapping>

"Configured" Spring MVC in spring-config.xml

- Use @Controller, there is now only one controller class , app04a.ProductController

		 * NOTICE use of DI on Constructor in ProductRepositoryImpl

 
 
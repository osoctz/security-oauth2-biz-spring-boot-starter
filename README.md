## jwt JKS密钥文件
```
keytool -genkey -alias jwt -keyalg RSA -keysize 2048 -keystore jwt.jks -validity 36500 -storepass admin123 -keypass admin123
```

## 客户端集成
```
spring.  security.oauth2.resourceserver.jwt.jwk-set-uri: 'http://localhost:8002/oauth/token_key'
```

## jwtTokenStore  token失效方案
```
https://www.jianshu.com/p/2f8b6591a09d

还是吃回头草用redisTokenStore , ^^
```

## 客户端client1请求,首次登录并成功访问接口index
```
************************************************************

Request received for GET '/oauth/authorize?client_id=client2&redirect_uri=http://localhost:10003/sso2/login&response_type=code&state=DxEikH':

org.apache.catalina.connector.RequestFacade@758b9e54

servletPath:/oauth/authorize
pathInfo:null
headers: 
host: localhost:7002
connection: keep-alive
upgrade-insecure-requests: 1
user-agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36
accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
sec-fetch-site: none
sec-fetch-mode: navigate
sec-fetch-user: ?1
sec-fetch-dest: document
accept-encoding: gzip, deflate, br
accept-language: en-US,en;q=0.9


Security filter chain: [
  WebAsyncManagerIntegrationFilter
  SecurityContextPersistenceFilter
  HeaderWriterFilter
  LogoutFilter
  UsernamePasswordAuthenticationFilter
  RequestCacheAwareFilter
  SecurityContextHolderAwareRequestFilter
  AnonymousAuthenticationFilter
  SessionManagementFilter
  ExceptionTranslationFilter
  FilterSecurityInterceptor
]


************************************************************


2020-11-25 09:33:50.095  INFO 5022 --- [nio-7002-exec-1] Spring Security Debugger                 : 

************************************************************

New HTTP session created: 8CA5EE20E5AD6DAA085DD37432D467FD

Call stack: 

	at org.springframework.security.web.debug.Logger.info(Logger.java:46)
	at org.springframework.security.web.debug.DebugFilter$DebugRequestWrapper.getSession(DebugFilter.java:167)
	at javax.servlet.http.HttpServletRequestWrapper.getSession(HttpServletRequestWrapper.java:253)
	at javax.servlet.http.HttpServletRequestWrapper.getSession(HttpServletRequestWrapper.java:253)
	at javax.servlet.http.HttpServletRequestWrapper.getSession(HttpServletRequestWrapper.java:253)
	at javax.servlet.http.HttpServletRequestWrapper.getSession(HttpServletRequestWrapper.java:253)
	at org.springframework.security.web.savedrequest.HttpSessionRequestCache.saveRequest(HttpSessionRequestCache.java:73)
	at org.springframework.security.web.access.ExceptionTranslationFilter.sendStartAuthentication(ExceptionTranslationFilter.java:210)
	at org.springframework.security.web.access.ExceptionTranslationFilter.handleAccessDeniedException(ExceptionTranslationFilter.java:190)
	at org.springframework.security.web.access.ExceptionTranslationFilter.handleSpringSecurityException(ExceptionTranslationFilter.java:171)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:140)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:113)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:126)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:81)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:105)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:149)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:218)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:212)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:103)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:89)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)
	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:110)
	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:80)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:55)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:211)
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:183)
	at org.springframework.security.web.debug.DebugFilter.invokeWithWrappedRequest(DebugFilter.java:90)
	at org.springframework.security.web.debug.DebugFilter.doFilter(DebugFilter.java:78)
	at org.springframework.security.web.debug.DebugFilter.doFilter(DebugFilter.java:67)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:358)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:271)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
	at org.springframework.boot.actuate.metrics.web.servlet.WebMvcMetricsFilter.doFilterInternal(WebMvcMetricsFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:374)
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1590)
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.base/java.lang.Thread.run(Thread.java:834)


************************************************************


2020-11-25 09:33:50.108  INFO 5022 --- [nio-7002-exec-2] Spring Security Debugger                 : 

************************************************************

Request received for GET '/login':

org.apache.catalina.connector.RequestFacade@758b9e54

servletPath:/login
pathInfo:null
headers: 
host: localhost:7002
connection: keep-alive
upgrade-insecure-requests: 1
user-agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36
accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
sec-fetch-site: none
sec-fetch-mode: navigate
sec-fetch-user: ?1
sec-fetch-dest: document
accept-encoding: gzip, deflate, br
accept-language: en-US,en;q=0.9
cookie: JSESSIONID=8CA5EE20E5AD6DAA085DD37432D467FD


Security filter chain: [
  WebAsyncManagerIntegrationFilter
  SecurityContextPersistenceFilter
  HeaderWriterFilter
  LogoutFilter
  UsernamePasswordAuthenticationFilter
  RequestCacheAwareFilter
  SecurityContextHolderAwareRequestFilter
  AnonymousAuthenticationFilter
  SessionManagementFilter
  ExceptionTranslationFilter
  FilterSecurityInterceptor
]


************************************************************


2020-11-25 09:33:50.111 DEBUG 5022 --- [nio-7002-exec-2] o.s.web.servlet.DispatcherServlet        : GET "/login", parameters={}
2020-11-25 09:33:50.114 DEBUG 5022 --- [nio-7002-exec-2] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to cn.metaq.uaa.web.LoginController#login()
2020-11-25 09:33:50.141 DEBUG 5022 --- [nio-7002-exec-2] o.s.w.s.v.ContentNegotiatingViewResolver : Selected 'text/html' given [text/html, application/xhtml+xml, image/avif, image/webp, image/apng, application/xml;q=0.9, application/signed-exchange;v=b3;q=0.9, */*;q=0.8]
2020-11-25 09:33:50.319 DEBUG 5022 --- [nio-7002-exec-2] o.s.web.servlet.DispatcherServlet        : Completed 200 OK
2020-11-25 09:33:52.058  INFO 5022 --- [nio-7002-exec-3] Spring Security Debugger                 : 

************************************************************

Request received for GET '/favicon.ico':

org.apache.catalina.connector.RequestFacade@758b9e54

servletPath:/favicon.ico
pathInfo:null
headers: 
host: localhost:7002
connection: keep-alive
user-agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36
accept: image/avif,image/webp,image/apng,image/*,*/*;q=0.8
sec-fetch-site: same-origin
sec-fetch-mode: no-cors
sec-fetch-dest: image
referer: http://localhost:7002/login
accept-encoding: gzip, deflate, br
accept-language: en-US,en;q=0.9
cookie: JSESSIONID=8CA5EE20E5AD6DAA085DD37432D467FD


Security filter chain: no match


************************************************************


2020-11-25 09:33:52.059 DEBUG 5022 --- [nio-7002-exec-3] o.s.web.servlet.DispatcherServlet        : GET "/favicon.ico", parameters={}
2020-11-25 09:33:52.061 DEBUG 5022 --- [nio-7002-exec-3] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped to ResourceHttpRequestHandler ["classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/", "/"]
2020-11-25 09:33:52.065 DEBUG 5022 --- [nio-7002-exec-3] o.s.w.s.r.ResourceHttpRequestHandler     : Resource not found
2020-11-25 09:33:52.065 DEBUG 5022 --- [nio-7002-exec-3] o.s.web.servlet.DispatcherServlet        : Completed 404 NOT_FOUND
2020-11-25 09:33:52.068  INFO 5022 --- [nio-7002-exec-3] Spring Security Debugger                 : 

************************************************************

Request received for GET '/error':

org.apache.catalina.core.ApplicationHttpRequest@7ee8a7e9

servletPath:/error
pathInfo:null
headers: 
host: localhost:7002
connection: keep-alive
user-agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36
accept: image/avif,image/webp,image/apng,image/*,*/*;q=0.8
sec-fetch-site: same-origin
sec-fetch-mode: no-cors
sec-fetch-dest: image
referer: http://localhost:7002/login
accept-encoding: gzip, deflate, br
accept-language: en-US,en;q=0.9
cookie: JSESSIONID=8CA5EE20E5AD6DAA085DD37432D467FD


Security filter chain: no match


************************************************************


2020-11-25 09:33:52.068 DEBUG 5022 --- [nio-7002-exec-3] o.s.web.servlet.DispatcherServlet        : "ERROR" dispatch for GET "/error", parameters={}
2020-11-25 09:33:52.070 DEBUG 5022 --- [nio-7002-exec-3] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController#error(HttpServletRequest)
2020-11-25 09:33:52.082 DEBUG 5022 --- [nio-7002-exec-3] o.s.w.s.m.m.a.HttpEntityMethodProcessor  : Using 'application/json;q=0.8', given [image/avif, image/webp, image/apng, image/*, */*;q=0.8] and supported [application/json, application/*+json, application/json, application/*+json]
2020-11-25 09:33:52.083 DEBUG 5022 --- [nio-7002-exec-3] o.s.w.s.m.m.a.HttpEntityMethodProcessor  : Writing [{timestamp=Wed Nov 25 09:33:52 CST 2020, status=404, error=Not Found, message=, path=/favicon.ico}]
2020-11-25 09:33:52.108 DEBUG 5022 --- [nio-7002-exec-3] o.s.web.servlet.DispatcherServlet        : Exiting from "ERROR" dispatch, status 404
2020-11-25 09:39:41.253  INFO 5022 --- [nio-7002-exec-5] Spring Security Debugger                 : 

************************************************************

Request received for POST '/login':

org.apache.catalina.connector.RequestFacade@758b9e54

servletPath:/login
pathInfo:null
headers: 
host: localhost:7002
connection: keep-alive
content-length: 29
cache-control: max-age=0
upgrade-insecure-requests: 1
origin: http://localhost:7002
content-type: application/x-www-form-urlencoded
user-agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36
accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
sec-fetch-site: same-origin
sec-fetch-mode: navigate
sec-fetch-user: ?1
sec-fetch-dest: document
referer: http://localhost:7002/login
accept-encoding: gzip, deflate, br
accept-language: en-US,en;q=0.9
cookie: JSESSIONID=8CA5EE20E5AD6DAA085DD37432D467FD


Security filter chain: [
  WebAsyncManagerIntegrationFilter
  SecurityContextPersistenceFilter
  HeaderWriterFilter
  LogoutFilter
  UsernamePasswordAuthenticationFilter
  RequestCacheAwareFilter
  SecurityContextHolderAwareRequestFilter
  AnonymousAuthenticationFilter
  SessionManagementFilter
  ExceptionTranslationFilter
  FilterSecurityInterceptor
]


************************************************************


2020-11-25 09:39:41.482  INFO 5022 --- [nio-7002-exec-6] Spring Security Debugger                 : 

************************************************************

Request received for GET '/oauth/authorize?client_id=client2&redirect_uri=http://localhost:10003/sso2/login&response_type=code&state=DxEikH':

org.apache.catalina.connector.RequestFacade@758b9e54

servletPath:/oauth/authorize
pathInfo:null
headers: 
host: localhost:7002
connection: keep-alive
cache-control: max-age=0
upgrade-insecure-requests: 1
user-agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36
accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
sec-fetch-site: same-origin
sec-fetch-mode: navigate
sec-fetch-user: ?1
sec-fetch-dest: document
referer: http://localhost:7002/login
accept-encoding: gzip, deflate, br
accept-language: en-US,en;q=0.9
cookie: JSESSIONID=AFAA7830EF8EA0DD8F661B03F90D25C2


Security filter chain: [
  WebAsyncManagerIntegrationFilter
  SecurityContextPersistenceFilter
  HeaderWriterFilter
  LogoutFilter
  UsernamePasswordAuthenticationFilter
  RequestCacheAwareFilter
  SecurityContextHolderAwareRequestFilter
  AnonymousAuthenticationFilter
  SessionManagementFilter
  ExceptionTranslationFilter
  FilterSecurityInterceptor
]


************************************************************


2020-11-25 09:39:41.484 DEBUG 5022 --- [nio-7002-exec-6] o.s.web.servlet.DispatcherServlet        : GET "/oauth/authorize?client_id=client2&redirect_uri=http://localhost:10003/sso2/login&response_type=code&state=DxEikH", parameters={masked}
2020-11-25 09:39:41.603 DEBUG 5022 --- [nio-7002-exec-6] org.hibernate.SQL                        : select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
Hibernate: select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
2020-11-25 09:39:41.639 DEBUG 5022 --- [nio-7002-exec-6] org.hibernate.SQL                        : select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
Hibernate: select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
2020-11-25 09:39:41.643 DEBUG 5022 --- [nio-7002-exec-6] org.hibernate.SQL                        : select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
Hibernate: select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
2020-11-25 09:39:41.651 DEBUG 5022 --- [nio-7002-exec-6] org.hibernate.SQL                        : select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
Hibernate: select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
2020-11-25 09:39:41.687 DEBUG 5022 --- [nio-7002-exec-6] o.s.web.servlet.view.RedirectView        : View [RedirectView], model {}
2020-11-25 09:39:41.687 DEBUG 5022 --- [nio-7002-exec-6] o.s.web.servlet.DispatcherServlet        : Completed 303 SEE_OTHER
2020-11-25 09:39:41.720  INFO 5022 --- [nio-7002-exec-7] Spring Security Debugger                 : 

************************************************************

Request received for POST '/oauth/token':

org.apache.catalina.connector.RequestFacade@758b9e54

servletPath:/oauth/token
pathInfo:null
headers: 
authorization: Basic Y2xpZW50MjpjbGllbnQy
accept: application/json, application/x-www-form-urlencoded
content-type: application/x-www-form-urlencoded;charset=UTF-8
cache-control: no-cache
pragma: no-cache
user-agent: Java/11.0.9.1
host: localhost:7002
connection: keep-alive
content-length: 100


Security filter chain: [
  WebAsyncManagerIntegrationFilter
  SecurityContextPersistenceFilter
  HeaderWriterFilter
  LogoutFilter
  ClientCredentialsTokenEndpointFilter
  BasicAuthenticationFilter
  RequestCacheAwareFilter
  SecurityContextHolderAwareRequestFilter
  AnonymousAuthenticationFilter
  SessionManagementFilter
  ExceptionTranslationFilter
  FilterSecurityInterceptor
]


************************************************************


2020-11-25 09:39:41.817 DEBUG 5022 --- [nio-7002-exec-7] org.hibernate.SQL                        : select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
Hibernate: select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
2020-11-25 09:39:41.910 DEBUG 5022 --- [nio-7002-exec-7] o.s.web.servlet.DispatcherServlet        : POST "/oauth/token", parameters={masked}
2020-11-25 09:39:41.913 DEBUG 5022 --- [nio-7002-exec-7] org.hibernate.SQL                        : select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
Hibernate: select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
2020-11-25 09:39:41.917 DEBUG 5022 --- [nio-7002-exec-7] org.hibernate.SQL                        : select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
Hibernate: select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
2020-11-25 09:39:41.925 DEBUG 5022 --- [nio-7002-exec-7] org.hibernate.SQL                        : select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
Hibernate: select clientdeta0_.id as id1_1_, clientdeta0_.access_token_validity_seconds as access_t2_1_, clientdeta0_.additional_information as addition3_1_, clientdeta0_.authorities as authorit4_1_, clientdeta0_.authorized_grant_types as authoriz5_1_, clientdeta0_.auto_approve_scopes as auto_app6_1_, clientdeta0_.client_id as client_i7_1_, clientdeta0_.client_secret as client_s8_1_, clientdeta0_.refresh_token_validity_seconds as refresh_9_1_, clientdeta0_.resource_ids as resourc10_1_, clientdeta0_.scope as scope11_1_, clientdeta0_.web_server_redirect_uri as web_ser12_1_ from sys_client_details clientdeta0_ where clientdeta0_.client_id=?
2020-11-25 09:39:41.954 DEBUG 5022 --- [nio-7002-exec-7] o.s.w.s.m.m.a.HttpEntityMethodProcessor  : Found 'Content-Type:application/json;charset=UTF-8' in response
2020-11-25 09:39:41.961 DEBUG 5022 --- [nio-7002-exec-7] o.s.w.s.m.m.a.HttpEntityMethodProcessor  : Writing [eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwcm92aWRlciI6IlphbiBUYW5nIiwidXNlcl9uYW1lIjoiYWRtaW4iLCJzY29 (truncated)...]
2020-11-25 09:39:41.963 DEBUG 5022 --- [nio-7002-exec-7] o.s.web.servlet.DispatcherServlet        : Completed 200 OK
2020-11-25 09:39:41.994  INFO 5022 --- [nio-7002-exec-8] Spring Security Debugger                 : 

************************************************************

Request received for GET '/user':

org.apache.catalina.connector.RequestFacade@758b9e54

servletPath:/user
pathInfo:null
headers: 
authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwcm92aWRlciI6IlphbiBUYW5nIiwidXNlcl9uYW1lIjoiYWRtaW4iLCJzY29wZSI6WyJhbGwiXSwiZXhwIjoxNjA2MzAxMDQwLCJhdXRob3JpdGllcyI6WyJkZW1vOmxpc3QiXSwianRpIjoiZEpqT0l0LUZvbkx4M1BtLWY5alhLcjBYaUJBIiwiY2xpZW50X2lkIjoiY2xpZW50MiJ9.RamBuk55V85z5sM5LsY247u0pVMFnuHpKXABSvoPB5Wh2xuzZHe9EAhwu6soo7w9v7PEU9Yhu_G1ysa2UeNreSmt5akbniFjUWV4qVQoiG80zCLcUoWaMDCkRtTwqjsEcuq8NoGPLH3KIisnTgrXm9BGvo5wsMQRFPqRW2ma8VhwaH6fmGMpII-ayjXg7lWoxx2xTgoBjyj0iG35ALp0mn0mxrV2Y9yGl6nIQ-N0fI5y4fRJCrC5tqnljcayZadyzJlTity_Tj33SojqmGS0REfqjOPUrd_RiFh4nzMBGJdKoDxJ-cqOSecRrpe8wazfQYW_UfZkfloRbqkyVDSYIw
accept: application/json
user-agent: Java/11.0.9.1
host: localhost:7002
connection: keep-alive


Security filter chain: [
  WebAsyncManagerIntegrationFilter
  SecurityContextPersistenceFilter
  HeaderWriterFilter
  LogoutFilter
  OAuth2AuthenticationProcessingFilter
  RequestCacheAwareFilter
  SecurityContextHolderAwareRequestFilter
  AnonymousAuthenticationFilter
  SessionManagementFilter
  ExceptionTranslationFilter
  FilterSecurityInterceptor
]


************************************************************


2020-11-25 09:39:42.003 DEBUG 5022 --- [nio-7002-exec-8] o.s.web.servlet.DispatcherServlet        : GET "/user", parameters={}
2020-11-25 09:39:42.004 DEBUG 5022 --- [nio-7002-exec-8] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to cn.metaq.uaa.web.LoginController#user(Principal)
2020-11-25 09:39:42.006 DEBUG 5022 --- [nio-7002-exec-8] m.m.a.RequestResponseBodyMethodProcessor : Using 'application/json', given [application/json] and supported [application/json, application/*+json, application/json, application/*+json]
2020-11-25 09:39:42.006 DEBUG 5022 --- [nio-7002-exec-8] m.m.a.RequestResponseBodyMethodProcessor : Writing [cn.metaq.common.web.dto.Result@463e23e1]
2020-11-25 09:39:42.018 DEBUG 5022 --- [nio-7002-exec-8] o.s.web.servlet.DispatcherServlet        : Completed 200 OK
```
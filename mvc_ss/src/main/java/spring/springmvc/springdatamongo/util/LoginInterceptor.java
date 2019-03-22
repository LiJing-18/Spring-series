package spring.springmvc.springdatamongo.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import spring.springmvc.springdatamongo.model.User;


/**
 * 登陆拦截器
 * @author 开发
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//获取session的user
		User user = (User) request.getSession().getAttribute("user");
		String requestType = request.getHeader("X-Requested-With");
		//如果user为空，说明没有登陆，则重定向到首页，返回false
		if(user==null){
			//如果是ajax输入标志位
			if (requestType != null && requestType.equals("XMLHttpRequest")) {
				//用response的流进行输出。
				response.getWriter().print("logout");
			}else{
				//正常通过浏览器，a连接程序的window.location.href调整的地址就直接返回到首页
				response.sendRedirect(request.getContextPath());//首页居多
			}
			return false;
		}else{
			return true;
		}
	}
	
	

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}

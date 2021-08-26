package com.miujoke.auth9001.filter;

/**
 * @Description: TODO 用户登录的时候检查校验码，并且记录用户的登录流水。
 *
 * 这里的重点在于将这两个逻辑代码切入到过滤器中，我们知道表单方式的身份检查过滤器是AuthenticationProcessingFilter，
 * 所以这里我们需要继承其并重写其中的attemptAuthentication(HttpServletRequest request)方法。已达到我们的目的。

 * @Author: miujoke
 * @DateTime: 2021/6/21 11:13
 */
public class AuthenticationFilter   {
}

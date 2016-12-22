package fr.pizzeria.admin.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ManipFilter
 */
@WebFilter("/ManipFilter")
public class ManipFilter implements Filter {

	/*
	private FilterConfig config = null;
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		
		this.config = config;
		config.getServletContext().log("TimerFilter initialized");
		// TODO Auto-generated method stub
	}*/
	
    /**
     * Default constructor. 
     */
    public ManipFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


		
	    
		HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        System.out.println(session.getAttribute("email"));
        Object login = session.getAttribute("email");
        
        if(login != null || req.getRequestURI().contains("/login")) {
        	// connect�
        	 chain.doFilter(request, response);
        } else {
        	// non connect�
        
        	((HttpServletResponse) response).sendRedirect(req.getContextPath() + "/login");
        	
        }
       
		/*
        long before = System.currentTimeMillis();

        chain.doFilter(req, response);

        long after = System.currentTimeMillis();

        String path = ((HttpServletRequest) req).getRequestURI();

        config.getServletContext().log(path + " : " + (after - before));
		*/
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	


public void init(FilterConfig fConfig) throws ServletException {
	
	
	// TODO Auto-generated method stub
}

}
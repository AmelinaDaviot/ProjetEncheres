package fr.eni.projetencheres.filtre;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AccesFiltre
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = { "/*" })
public class AccesFiltre implements Filter {
	
	private String encoding = "utf-8";
	
	/**
	 * Default constructor.
	 */
	public AccesFiltre() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		req.getSession(false);
		if (req.getSession().getAttribute("utilisateur") == null) {	
			
			request.getRequestDispatcher("/accueillir").forward(request,response);

		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String encodingParam = fConfig.getInitParameter("encoding");
		if (encodingParam != null) {
		this.encoding = encodingParam;
		}

	}

}

package lind.springdemo.config.clientshop;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class TransmitTokenFilter implements Filter {

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
    this.initToken((HttpServletRequest) request);
    chain.doFilter(request, response);
  }

  /**
   * 初始化token.
   *
   * @param request 请求参数
   */
  private void initToken(HttpServletRequest request) {
    String tokenJson = request.getHeader("userId");
    if (StringUtils.isNotBlank(tokenJson)) {
      logger.info("获取到的token对应的json字符串:" + tokenJson);
    }
  }

  @Override
  public void destroy() {
  }
}

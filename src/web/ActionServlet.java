package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import bean.Stock;

public class ActionServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		if("/quoto".equals(action)){
			//返回几支股票的信息
			Random r = new Random();
			List<Stock> stocks = 
				new ArrayList<Stock>();
			for(int i = 0 ;i < 8;i ++){
				Stock s = new Stock();
				s.setCode("60001" + r.nextInt(10));
				s.setName("山东高速" + r.nextInt(10));
				s.setPrice(r.nextInt(100));
				stocks.add(s);
			}
			JSONArray obj = JSONArray.fromObject(stocks);
			String jsonStr = obj.toString();
			System.out.println(jsonStr);
			out.println(jsonStr);
		}
		out.close();
	}

}

package com.ramkumar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ramkumar.model.Employee;

@WebServlet("/welcome.do")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("ACTION");
		String ip = request.getParameter("ip");
		PrintWriter out = response.getWriter();

		System.out.println("ACTION :" + action);
		System.out.println("IP : " + ip);

		List<Employee> emplList = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("Ram Kumar Basak");
		emp1.setRole("Sr. Java Developer");

		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("Krishna Kumar Basak");
		emp2.setRole("Sr. Web Developer");

		emplList.add(emp1);
		emplList.add(emp2);
		request.setAttribute("empList", emplList);

		List<List<String>> myList = new ArrayList<>();
		List<String> col = new ArrayList<>();
		List<String> row = new ArrayList<>();

		col.add("ID");
		col.add("NAME");
		col.add("ADDRESS");
		col.add("EMAIL");
		row.add("1");
		row.add("Ram Kumar Basak");
		row.add("Maligaon gate no 3");
		row.add("ram.kumar.basak@gmail.com");
		row.add("2");
		row.add("Krishna Kumar Basak");
		row.add("Maligaon gate no 3");
		row.add("krishna.kumar.basak@gmail.com");
		row.add("3");
		row.add("Sampa Basak");
		row.add("Maligaon gate no 3");
		row.add("sampa.basak@gmail.com");
		row.add("4");
		row.add("Jharna Basak");
		row.add("Maligaon gate no 3");
		row.add("jharna.basak@gmail.com");
		row.add("5");
		row.add("Tarun Kumar Basak");
		row.add("Maligaon gate no 3");
		row.add("tarun.kumar.basak@gmail.com");

		myList.add(col);
		myList.add(row);

		if ("FETCH_RECORD".equals(action)) {

			List<List<String>> list = myList;
			List<String> myCol = list.get(0);
			List<String> myRow = list.get(1);

			int i = 0;
			int rowCount = myRow.size() / myCol.size();
			int startRow = 0;

			while (i < rowCount) {

				startRow = i * myCol.size();

				out.print("<div class=\"header clearfix\">\n" + "      	<h5 class=\"left-side pull-left\">"
						+ myRow.get(startRow) + "</h5>\n" + "      	<h5 class=\"right-side pull-right\">"
						+ myRow.get(startRow + 1) + "</h5>\n" + "      </div>\n" + "      ");
				out.print("<p>" + myRow.get(startRow + 2) + " " + myRow.get(startRow + 3) + "</p>");
				out.print(" <div class=\"modal-footer1 clearfix\" >\n" + "        <a data-toggle=\"modal\" data-id=\""
						+ myRow.get(startRow)
						+ "\" class=\"btn btn-warning edit-doctor-rec pull-left\" href=\"#editModal\">edit</a>\n"
						+ "        <a data-toggle=\"modal\" data-id=\"" + myRow.get(startRow)
						+ "\" class=\"btn btn-primary delete-doctor-rec pull-right\" href=\"#deleteModal\">delete</a>\n"
						+ "      </div>");

				i++;
			}

		} else if ("DELETE_RECORD".equals(action)) {

			switch (ip) {
			case "1":
				System.out.println("1");
				row.remove("1");
				row.remove("Ram Kumar Basak");
				row.remove("Maligaon gate no 3");
				row.remove("ram.kumar.basak@gmail.com");
				break;
			case "2":
				System.out.println("2");
				row.add("2");
				row.add("Krishna Kumar Basak");
				row.add("Maligaon gate no 3");
				row.add("krishna.kumar.basak@gmail.com");
				break;
			case "3":
				System.out.println("3");
				row.remove("3");
				row.remove("Sampa Basak");
				row.remove("Maligaon gate no 3");
				row.remove("sampa.basak@gmail.com");
				break;
			case "4":
				System.out.println("4");
				row.remove("4");
				row.remove("Jharna Basak");
				row.remove("Maligaon gate no 3");
				row.remove("jharna.basak@gmail.com");
				break;
			case "5":
				System.out.println("5");
				row.remove("5");
				row.remove("Tarun Kumar Basak");
				row.remove("Maligaon gate no 3");
				row.remove("tarun.kumar.basak@gmail.com");
				break;
			}
			
			out.println("SUCCESS");

		} else {

			request.setAttribute("myList", myList);

			request.setAttribute("htmlTagData", "<br/> creates a new line.");
			request.setAttribute("url", "https://www.rkb.com");

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

}

<%@page import="model.bean.History" %>
	<%@page import="java.util.ArrayList" %>
		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
			<% String name="" ; ArrayList<History> his = new ArrayList<History>();
					ArrayList<History> his1 = new ArrayList<History>(); //k qua giai thua
							ArrayList<History> his2 = new ArrayList<History>(); // k qua luy thua
									try {
									if (session.getAttribute("id") == null) {
									response.sendRedirect("/CK_LTM/Login");
									}
									name = session.getAttribute("user").toString();
									his = (ArrayList<History>) session.getAttribute("his");
										for (History i : his) {
										if (i.getInput2() == 0)
										his2.add(i);
										else
										his1.add(i);
										}
										} catch (Exception e) {
										System.out.println(e);
										response.sendRedirect("/CK_LTM/Login");
										}
										session.removeAttribute("his");
										%>
										<!DOCTYPE html>
										<html>

										<head>
											<meta charset="UTF-8">
											<title>Trang chủ</title>
											<link rel="stylesheet" href="css/Home.css">
										</head>

										<body>
											<header>
												Chào,
												<%=name%>
													<!-- lấy tên nè -->
													<a href="Logout">Đăng xuất</a>
											</header>
											<section>
												<a href="/CK_LTM/Homepage">
													<< Về trang chủ</a>
														<div class="history-show">
															<h2>Lịch sử đã nhập</h2>
															<div class="search">
																<form action="Search">
																	Tìm kiếm: <select
																		class="mode-box">
																		<option>Giai
																			thừa
																		</option>
																		<option>Luỹ
																			thừa
																		</option>
																	</select> <input
																		type="text"
																		name="txtSearch"
																		class="form-input"
																		style="height: 20px;"
																		placeholder="Nhập số để tìm">
																	<input type="submit"
																		name="btnSearch"
																		class="btn-important"
																		style="height: 24px;"
																		value="Tìm">
																</form>
															</div>
															<table>
																<tr>
																	<th>Số</th>
																	<th>Giai thừa</th>
																	<th>Xoá</th>
																</tr>
																<% for (History i :
																	his2) { %>
																	<tr>
																		<td>
																			<%=i.getInput()%>
																		</td>
																		<% if (i.getOutput()
																			!=null)
																			{ %>
																			<td><a href="/CK_LTM/HistoryDetail?num1=<%=i.getInput()%>&num2=0">Xem</a>
																			</td>
																			<% } else
																				{
																				%>
																				<td>Đang
																					xử
																					lí...
																				</td>
																				<% }
																					%>
																					<td><a href="">Xoá</a>
																					</td>
																	</tr>
																	<% } %>
															</table>

															<table>
																<tr>
																	<th>Cơ số</th>
																	<th>Số mũ</th>
																	<th>Luỹ thừa</th>
																	<th>Xoá</th>
																</tr>
																<% for (History i :
																	his1) { %>
																	<tr>
																		<td>
																			<%=i.getInput()%>
																		</td>
																		<td>
																			<%=i.getInput2()%>
																		</td>
																		<% if (i.getOutput()
																			!=null)
																			{ %>
																			<td><a href="/CK_LTM/HistoryDetail?num1=<%=i.getInput()%>&num2=<%=i.getInput2()%>>">Xem</a>
																			</td>
																			<% } else
																				{
																				%>
																				<td>Đang
																					xử
																					lí...
																				</td>
																				<% }
																					%>
																					<td><a href="">Xoá</a>
																					</td>
																	</tr>
																	<% } %>
															</table>
														</div>
											</section>
										</body>

										</html>
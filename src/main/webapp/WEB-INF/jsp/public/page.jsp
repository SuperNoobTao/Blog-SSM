<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div>
			当前第[${page.pagenum }]页
			&nbsp;&nbsp;
			<a href="javascript:submit('1')">首页</a>
			&nbsp;
			<c:if test="${page.pagenum>1 }">
				<a href="javascript:submit('${page.pagenum-1}')">上一页</a>
			</c:if>
			
			<c:forEach begin="${page.startpage}" end="${page.endpage}" var="pagenum">
				[<a href="javascript:submit('${pagenum}')">${pagenum }</a>]
			</c:forEach>
			&nbsp;
			<c:if test="${page.pagenum<page.totalpage }">
				<a href="javascript:submit('${page.pagenum+1}')">下一页</a>
			</c:if>
			&nbsp;
			<a href="javascript:submit('${page.totalpage}')">尾页</a>
			&nbsp;&nbsp;
			共 [${page.totalpage }]页，共[${page.totalrecord }]条记录

			&nbsp;
			<input type="text" id="pagenum" style="width: 30px">
			&nbsp;
			<input type="button" style="width: 40px" onclick="goWitch(document.getElementById('pagenum'))" value=" GO ">
</div>
			<script type="text/javascript">
				function submit(pagenum){
					var form = document.createElement("form");
					form.action = '${page.url}';
					form.method = "post";
					form.style.display = "none";

					var cidEle = document.createElement("input");
					cidEle.name = "cid";
					cidEle.value = '${cid}';
					form.appendChild(cidEle);

					var gidEle = document.createElement("input");
					gidEle.name = "gid";
					gidEle.value = '${gid}';
					form.appendChild(gidEle);

					var keyEle = document.createElement("input");
					keyEle.name = "key";
					keyEle.value = '${key}';
					form.appendChild(keyEle);

					var pagenumEle = document.createElement("input");
					pagenumEle.name = "pagenum";
					pagenumEle.value = pagenum;
					form.appendChild(pagenumEle);

					document.body.appendChild(form);
					form.submit();
				}
				function goWitch(input){
					var pagenum = input.value;
					if(pagenum==null||pagenum==""){
						alert("请输入页码！！！");
						return;
					}
					if(!pagenum.match("\\d+")){
						alert("请输入数字！！！");
						return;
					}
					if(pagenum<1 || pagenum > ${page.totalpage } ){
						alert("无效的页码！！！");
						input.value="";
						return;
					}

					submit(pagenum);
				}
			</script>
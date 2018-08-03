<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%> 
    <%@ page trimDirectiveWhitespaces="true" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
    <%@ taglib uri="/struts-tags" prefix="s"  %>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<jsp:include page="/WEB-INF/jsp/ui/uphead.jsp"></jsp:include>
<title>日志编辑</title>
</head>  
<body >
<script src="${ pageContext.request.contextPath }/js/stackedit.js"></script>
<!--写转化函数-->
<script type="text/javascript">
	$(function(){
		

		//使用Stackedit
		$('#edit').click(function(){
			// Get the textarea.
			var el = document.querySelector("#textContent");
			var result = document.querySelector('#result');
		
			// Create the Stackedit object.
			var stackedit = new Stackedit();
			
			// Open the iframe
			stackedit.openFile({
			  name: 'Filename', // with a filename
			  content: {
			    text: el.value // and the Markdown content.
			  }
			}); 
			// Listen to StackEdit events and apply the changes to the textarea.
			stackedit.on('fileChange', (file) => {
			  el.value = file.content.text;
			  result.innerHTML = file.content.html;
			});
			
			
			
		});
		//实时预览
		$('#textContent').blur(function(){
		
			
			// Get the textarea.
			var el = document.querySelector("#textContent");
			var result = document.querySelector('#result');
		
			// Create the Stackedit object.
			var stackedit = new Stackedit();
			
			// Open the iframe
			stackedit.openFile({
			  name: 'Filename', // with a filename
			  content: {
			    text: el.value // and the Markdown content.
			  }
			}, true/* silent mode */); 
			// Listen to StackEdit events and apply the changes to the textarea.
			stackedit.on('fileChange', (file) => {
			  el.value = file.content.text;
			  result.innerHTML = file.content.html;
			});
			

		});
		
		
		//添加文章表单
		$("#addArticleform").submit(function(){
			
				
				
				var formElement = document.querySelector("#addArticleform");
				var formData = new FormData(formElement);
							 				 	
			 	$.ajax({ 
		            type: "POST",
		            url:'${pageContext.request.contextPath}/Admin/addArticle',
		            contentType : "application/x-www-form-urlencoded; charset=utf-8",
		            data:formData,
		            async: false,
		            cache: false,
		            processData: false,
		            contentType: false,	
		            success: function (data) {
		            	if(1==data){
		            		alert("添加成功");
		            		$("#addArticleform .form-control").val("");
		            	}else{
		            		alert(data);
		            		alert("添加失败");
		            	}
	
		            },
		            error: function () {
		            	alert("提交失败");
		            }
		        });
			 	
			
			return false;
		});
		
	 
	});
</script>


	<div class="container">
	    
	<div class="col-xs-6 col-md-6 col-lg-6">
			<form id="addArticleform">
			
				<div class="form-group">
					<label for="title">日志标题</label> 
					<input type="text"	name="article.title" class="form-control" id="title">
				</div>
				<div class="form-group">
					<label for="author">作者</label> 
					<input type="text"	name="article.author" class="form-control" id="author">
				</div>
				<div class="form-group">
					<label for="textContent">正文</label>								
					<textarea id="textContent" class="form-control"  name="article.textContent"></textarea>
				</div>
				
				
				<button type="submit" class="btn btn-default" >保存</button>
			</form>
			<button class="btn btn-primary btn-sm" id="edit">打开编辑器</button>
	</div>
	<!--设置展示的div添加id-->
	<div class="col-xs-6 col-md-6 col-lg-6"  id="result"  ></div>
	</div>



</body>
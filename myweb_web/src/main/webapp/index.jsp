<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>Markdown.js</title>
    <meta charset="UTF-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="${ pageContext.request.contextPath }/js/jquery-1.11.0.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    
    <!-- MakeDown -->
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/css/md.css"> 
    <!-- Bootstrap -->
    <link href="${ pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet" media="screen">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../docs-assets/js/html5shiv.js"></script>
      <script src="../../docs-assets/js/respond.min.js"></script>
    <![endif]-->

<script src="${ pageContext.request.contextPath }/js/stackedit.js"></script>

<!--写转化函数-->
<script type="text/javascript">
	$(function(){
		

		//使用Stackedit
		$('#edit').click(function(){
			// Get the textarea.
			var el = $("#textarea");
			var result = document.querySelector('#result');
		
			// Create the Stackedit object.
			var stackedit = new Stackedit();
			
			// Open the iframe
			stackedit.openFile({
			  name: 'Filename', // with a filename
			  content: {
			    text: el.val() // and the Markdown content.
			  }
			}); 
			// Listen to StackEdit events and apply the changes to the textarea.
			stackedit.on('fileChange', (file) => {
			  el.value = file.content.text;
			  result.innerHTML = file.content.html;
			});
			
			
			
		});
		//实时预览
		$('#textarea').keyup(function(){
		
			
			// Get the textarea.
			var el = $("#textarea");
			var result = document.querySelector('#result');
		
			// Create the Stackedit object.
			var stackedit = new Stackedit();
			
			// Open the iframe
			stackedit.openFile({
			  name: 'Filename', // with a filename
			  content: {
			    text: el.val() // and the Markdown content.
			  }
			}, true/* silent mode */); 
			// Listen to StackEdit events and apply the changes to the textarea.
			stackedit.on('fileChange', (file) => {
			  el.value = file.content.text;
			  result.innerHTML = file.content.html;
			});
			

		});
		
	 
	});
</script>
</head>


<body>
<button class="btn btn-primary btn-sm" id="edit">编辑</button>
<div>
    
    <textarea id="textarea" style="height:400px;width:600px;"></textarea>


</div>
<!--设置展示的div添加id-->
<div id="result"></div>


</body>